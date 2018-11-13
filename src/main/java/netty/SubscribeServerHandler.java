package netty;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import protobuf.SubscribeReqProto;
import protobuf.SubscribeResqProto;

/**
 * @author ： fjl
 * @date ： 2018/11/13/013 14:51
 */
public class SubscribeServerHandler extends ChannelHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        SubscribeReqProto.SubscribeReq req = (SubscribeReqProto.SubscribeReq) msg;
        if ("lisi".equalsIgnoreCase(req.getUserName())) {
            System.out.println("server accept marshalling client req:" + req.toString());
            ctx.writeAndFlush(resq(req.getSubReqID()));
        }
    }

    private SubscribeResqProto.SubscribeResq resq(int subReqId) {
        SubscribeResqProto.SubscribeResq.Builder builder = SubscribeResqProto.SubscribeResq.newBuilder();
        builder.setSubReqId(subReqId);
        builder.setRespCode(0);
        builder.setDesc("netty order succeed");
        return builder.build();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
