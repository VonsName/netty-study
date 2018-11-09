package netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ： fjl
 * @date ： 2018/11/9/009 15:19
 */
public class EchoClientHandler extends ChannelHandlerAdapter {

    private static String msg = "Hello this is netty.$_";
    private int count;

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
//        for (int i = 0; i < 10; i++) {
//            ByteBuf buf = Unpooled.copiedBuffer(msg.getBytes());
//            ctx.writeAndFlush(buf);
//        }
        List<UserInfo> infoList = userInfos();
        infoList.forEach(item -> {
            ByteBuf buf = Unpooled.copiedBuffer(item.toString().getBytes());
            ctx.write(buf);
        });
        ctx.flush();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println(msg);
//        ByteBuf buf = Unpooled.copiedBuffer((msg + "$_").getBytes());
//        ctx.writeAndFlush(buf);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    private List<UserInfo> userInfos() {
        List<UserInfo> infoList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            UserInfo userInfo = new UserInfo();
            userInfo.setUid(1 + i);
            userInfo.setUsername("lisi" + i);
            userInfo.setPassword("qwert" + i);
            infoList.add(userInfo);
        }
        return infoList;
    }
}
