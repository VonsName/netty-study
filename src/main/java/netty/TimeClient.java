package netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

/**
 * @author ： fjl
 * @date ： 2018/11/9/009 11:19
 */
public class TimeClient {

    public void connect(String host, int port) {
        NioEventLoopGroup loopGroup = new NioEventLoopGroup();
        Bootstrap b = new Bootstrap();
        b.group(loopGroup).channel(NioSocketChannel.class)
                .option(ChannelOption.TCP_NODELAY, true)
                .handler(new ChildChannelHandler());
        try {
            //发起异步连接
            ChannelFuture future = b.connect(host, port).sync();
            //等待客户端链路关闭
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            loopGroup.shutdownGracefully();
        }
    }

    private class ChildChannelHandler extends ChannelInitializer<SocketChannel> {
        @Override
        protected void initChannel(SocketChannel sc) {
            sc.pipeline().addLast(new LineBasedFrameDecoder(1024));
            sc.pipeline().addLast(new StringDecoder());
            sc.pipeline().addLast(new TimeClientHandler());
        }
    }

    public static void main(String[] args) {
        TimeClient timeClient = new TimeClient();
        timeClient.connect("127.0.0.1", 8080);
    }
}
