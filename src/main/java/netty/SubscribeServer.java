package netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import marshalling.MarshallingFactory;

/**
 * @author ： fjl
 * @date ： 2018/11/13/013 14:44
 */
public class SubscribeServer {

    public void bind(int port) {
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        NioEventLoopGroup workGroup = new NioEventLoopGroup();
        ServerBootstrap b = new ServerBootstrap();
        b.group(bossGroup, workGroup)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG, 100)
                .handler(new LoggingHandler(LogLevel.INFO))
                .childHandler(new ChannelInitializer<SocketChannel>() {

                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        //protobuf 序列化
//                        ch.pipeline().addLast(new ProtobufVarint32FrameDecoder());
//                        ch.pipeline().addLast(new ProtobufDecoder(SubscribeReqProto.SubscribeReq.getDefaultInstance()));
//                        ch.pipeline().addLast(new ProtobufVarint32LengthFieldPrepender());
//                        ch.pipeline().addLast(new ProtobufEncoder());
                        //jboss序列化
                        ch.pipeline().addLast(MarshallingFactory.buildMarshallingDecoder());
                        ch.pipeline().addLast(MarshallingFactory.buildMarshallingEncoder());
                        ch.pipeline().addLast(new SubscribeServerHandler());
                    }
                });
        try {
            ChannelFuture f = b.bind(port).sync();
            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        new SubscribeServer().bind(8080);
    }
}
