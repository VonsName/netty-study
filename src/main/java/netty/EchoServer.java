package netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.FixedLengthFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

/**
 * @author ： fjl
 * @date ： 2018/11/9/009 15:05
 */
public class EchoServer {


    public void bind(int port) {
        NioEventLoopGroup group = new NioEventLoopGroup();
        NioEventLoopGroup workGroup = new NioEventLoopGroup();
        ServerBootstrap b = new ServerBootstrap();
        b.group(group, workGroup)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG, 88889)
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 3000)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel sc) throws Exception {

//                        ByteBuf buf = Unpooled.copiedBuffer("$_".getBytes());
                        //定长解码器
//                        sc.pipeline().addLast(new FixedLengthFrameDecoder(20));
//                        sc.pipeline().addLast(new DelimiterBasedFrameDecoder(1024, buf));
//                        sc.pipeline().addLast(new StringDecoder());
                        sc.pipeline().addLast("msgPack decoder",new MsgPackDecoder());
                        sc.pipeline().addLast("msgPack encoder",new MsgPackEncoder());
                        sc.pipeline().addLast(new EchoServerHandler());
                    }
                });
        try {
            ChannelFuture f = b.bind(port).sync();
            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        new EchoServer().bind(8080);
    }
}


