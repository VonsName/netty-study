package nettyhttp;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.TextHeaders;
import io.netty.handler.codec.http.*;
import io.netty.handler.stream.ChunkedFile;

import java.io.File;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ： fjl
 * @date ： 2018/11/14/014 11:07
 */
public class HttpFileServerHandler extends SimpleChannelInboundHandler<FullHttpRequest> {

    private String url;
    private static final Pattern PATTERN = Pattern.compile("[A-Za-z0-9][-_A-Za-z0-9\\.]*");

    public HttpFileServerHandler(String url) {
        this.url = url;
    }

    @Override
    protected void messageReceived(ChannelHandlerContext ctx, FullHttpRequest httpRequest) throws Exception {

        if (!httpRequest.decoderResult().isSuccess()) {
            System.out.println("1");
            ctx.writeAndFlush(HttpResponseStatus.NOT_FOUND);
            return;
        }
        if (httpRequest.method().compareTo(HttpMethod.GET) != 0) {
            System.out.println("2");
            ctx.writeAndFlush(HttpResponseStatus.BAD_REQUEST);
            return;
        }
        String uri = httpRequest.uri();
        System.out.println(uri);
        String path = urlDecode(uri);
        if (path == null) {
            ctx.writeAndFlush(HttpResponseStatus.FORBIDDEN);
            return;
        }
        File file = new File(path);
        if (file.isHidden()||!file.exists()){
            ctx.writeAndFlush(HttpResponseStatus.NOT_FOUND);
            return;
        }
        if (!file.isFile()){
            ctx.writeAndFlush(HttpResponseStatus.FORBIDDEN);
            return;
        }

        RandomAccessFile r = new RandomAccessFile(file, "r");

        long length = r.length();
        DefaultHttpResponse response = new DefaultHttpResponse(HttpVersion.HTTP_1_1,HttpResponseStatus.OK);
        ctx.write(response);
        ChannelFuture future = ctx.write(new ChunkedFile(r, 0, length, 8192), ctx.newProgressivePromise());
        future.addListener((c)->{

        });

    }

    private String urlDecode(String uri) throws UnsupportedEncodingException {
        try {
            uri = URLDecoder.decode(uri, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            try {
                uri = URLDecoder.decode(uri, "ISO-8859-1");
            } catch (UnsupportedEncodingException e1) {
                throw e;
            }
        }
        uri = uri.replace('/', File.separatorChar);
        if (uri.contains(File.separator + ".") || uri.contains("." + File.separator)) {
            return null;
        }
        return System.getProperty("user.dir" + File.separator + uri);
    }

    private static void sendListing(ChannelHandlerContext context, File dir) {
        DefaultFullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK);
        response.headers().set("content-Type", "text/html;charset=utf-8");
        StringBuffer sb = new StringBuffer();
        sb.append("<li>连接：<a href=\"../\">..</a></li>\r\n");
        for (File f : dir.listFiles()
        ) {
            sb.append("<li>连接：<a href=\">+"+f+"</a>");
        }
        sb.append("</ul></body></html>\r\n");
        ByteBuf buf = Unpooled.copiedBuffer(sb, StandardCharsets.UTF_8);
        response.content().writeBytes(buf);
        buf.release();
        context.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);
    }
}
