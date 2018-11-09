package netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

/**
 * @author ： fjl
 * @date ： 2018/11/9/009 15:16
 */
public class EchoClient {

    public void connect(String host, int port) {
        NioEventLoopGroup group = new NioEventLoopGroup();
        Bootstrap b = new Bootstrap();
        b.group(group)
                .channel(NioSocketChannel.class)
                .option(ChannelOption.TCP_NODELAY, true)
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 3000)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel sc) throws Exception {
//                        ByteBuf buf = Unpooled.copiedBuffer("$_".getBytes());
//                        sc.pipeline().addLast(new DelimiterBasedFrameDecoder(1024, buf));
//                        sc.pipeline().addLast(new StringDecoder());
                        sc.pipeline().addLast("msgPack decoder", new MsgPackDecoder());
                        sc.pipeline().addLast("msgPack encoder", new MsgPackEncoder());
                        sc.pipeline().addLast(new EchoClientHandler());
                    }
                });
        try {
            ChannelFuture sync = b.connect(host, port).sync();
            sync.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        new EchoClient().connect("127.0.0.1", 8080);
    }
}
