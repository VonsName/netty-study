package netty;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import protobuf.SubscribeReqProto;

import java.util.ArrayList;

/**
 * @author ： fjl
 * @date ： 2018/11/13/013 15:02
 */
public class SubscribeClentHandler extends ChannelHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        for (int i = 0; i < 1000; i++) {
            ctx.write(subSeq(i));
        }
        ctx.flush();
    }

    private SubscribeReqProto.SubscribeReq subSeq(int i) {
        SubscribeReqProto.SubscribeReq.Builder builder = SubscribeReqProto.SubscribeReq.newBuilder();
        builder.setSubReqID(i);
        builder.setUserName("lisi");
        builder.setProductName("sanguoyanyi");
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("beijing");
        arrayList.add("chongqing");
        arrayList.add("shenzhen");
        builder.addAllAddress(arrayList);
        return builder.build();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("receive server marshalling  response:[" + msg + "]");
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
}
