package netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import marshalling.MarshallingFactory;

/**
 * @author ： fjl
 * @date ： 2018/11/13/013 14:59
 */
public class SubscribeClient {

    public void connect(String host, int port) {
        NioEventLoopGroup group = new NioEventLoopGroup();
        Bootstrap b = new Bootstrap();
        b.group(group)
                .channel(NioSocketChannel.class)
                .option(ChannelOption.TCP_NODELAY, true)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        //protobuf
//                        ch.pipeline().addLast(new ProtobufVarint32FrameDecoder());
//                        ch.pipeline().addLast(new ProtobufDecoder(SubscribeResqProto.SubscribeResq.getDefaultInstance()));
//                        ch.pipeline().addLast(new ProtobufVarint32LengthFieldPrepender());
//                        ch.pipeline().addLast(new ProtobufEncoder());
                        //jboss
                        ch.pipeline().addLast(MarshallingFactory.buildMarshallingDecoder());
                        ch.pipeline().addLast(MarshallingFactory.buildMarshallingEncoder());
                        ch.pipeline().addLast(new SubscribeClentHandler());
                    }
                });
        try {
            ChannelFuture f = b.connect(host, port).sync();
            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        new SubscribeClient().connect("127.0.0.1", 8080);
    }
}
