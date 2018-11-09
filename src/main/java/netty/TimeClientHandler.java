package netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import java.nio.charset.StandardCharsets;

/**
 * @author ： fjl
 * @date ： 2018/11/9/009 11:22
 */
public class TimeClientHandler extends ChannelHandlerAdapter {
    private ByteBuf message;
    private int counter;
    private byte[] req;

    public TimeClientHandler() {
        String property = System.getProperty("line.separator");
        req = "QUERY_ORDER".concat(property).getBytes();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        for (int i = 0; i < 100; i++) {
            message = Unpooled.buffer(req.length);
            message.writeBytes(req);
            ctx.writeAndFlush(message);
        }
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        String body = (String) msg;
//        byte[] res = new byte[buf.readableBytes()];
//        buf.readBytes(res);
//        String body = new String(res, StandardCharsets.UTF_8);

        System.out.println("this time is:" + body + "count:" + ++counter);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
