package netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

/**
 * @author ： fjl
 * @date ： 2018/11/9/009 9:45
 */
public class TimeServer {
    public void bind(int port) {
        NioEventLoopGroup loopGroup = new NioEventLoopGroup();
        NioEventLoopGroup workGroup = new NioEventLoopGroup();
        ServerBootstrap b = new ServerBootstrap();
        b.group(loopGroup, workGroup)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG, 1024)
                .childHandler(new ChildChannelHandler());
        try {
            //绑定端口并等待连接成功
            ChannelFuture future = b.bind(port).sync();
            //监听端口关闭
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            loopGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
    }

    private static class ChildChannelHandler extends ChannelInitializer<SocketChannel> {

        @Override
        protected void initChannel(SocketChannel ch) throws Exception {
            ch.pipeline().addLast(new LineBasedFrameDecoder(1024));
            ch.pipeline().addLast(new StringDecoder());
            ch.pipeline().addLast(new TimeServerHandler());
        }
    }

    public static void main(String[] args) {
        TimeServer timeServer = new TimeServer();
        timeServer.bind(8080);
    }
}
