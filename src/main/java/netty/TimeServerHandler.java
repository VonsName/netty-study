package netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import java.nio.charset.StandardCharsets;
import java.util.Date;

/**
 * @author ： fjl
 * @date ： 2018/11/9/009 10:01
 */
public class TimeServerHandler extends ChannelHandlerAdapter {

    private int counter;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        String body = (String) msg;
//        byte[] bytes = new byte[buf.readableBytes()];
//        buf.readBytes(bytes);
//        String body = new String(bytes, StandardCharsets.UTF_8);

        System.out.println("this order is:" + body + "-count:" + ++counter);
        String property = System.getProperty("line.separator");
        String currentTime = "QUERY_ORDER".equalsIgnoreCase(body) ? new Date(System.currentTimeMillis()).toString() : "BAD_ORDER";
        currentTime = currentTime + property;
        ByteBuf res = Unpooled.copiedBuffer(currentTime.getBytes());
        ctx.writeAndFlush(res);
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
