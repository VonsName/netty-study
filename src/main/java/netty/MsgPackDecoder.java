package netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import org.msgpack.MessagePack;

import java.util.List;

/**
 * @author ： fjl
 * @date ： 2018/11/9/009 16:22
 */
public class MsgPackDecoder extends MessageToMessageDecoder<ByteBuf> {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf byteBuf, List<Object> list) throws Exception {
        int length = byteBuf.readableBytes();
        byte[] bytes = new byte[length];
        byteBuf.getBytes(byteBuf.readerIndex(), bytes, 0, length);
        MessagePack pack = new MessagePack();
        list.add(pack.read(bytes));
    }
}
