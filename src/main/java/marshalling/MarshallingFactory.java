package marshalling;

import io.netty.handler.codec.marshalling.DefaultMarshallerProvider;
import io.netty.handler.codec.marshalling.DefaultUnmarshallerProvider;
import io.netty.handler.codec.marshalling.MarshallingDecoder;
import io.netty.handler.codec.marshalling.MarshallingEncoder;
import org.jboss.marshalling.MarshallerFactory;
import org.jboss.marshalling.Marshalling;
import org.jboss.marshalling.MarshallingConfiguration;

/**
 * @author ： fjl
 * @date ： 2018/11/13/013 16:49
 * jboss序列化
 */
public class MarshallingFactory {
    /**
     * jboss 编码序列化
     * @return
     */
    public static MarshallingEncoder buildMarshallingEncoder() {
        MarshallerFactory serial = Marshalling.getProvidedMarshallerFactory("serial");
        MarshallingConfiguration conf = new MarshallingConfiguration();
        conf.setVersion(5);
        DefaultMarshallerProvider provider = new DefaultMarshallerProvider(serial, conf);
        MarshallingEncoder encoder = new MarshallingEncoder(provider);
        return encoder;
    }

    /**
     * jboss 解码 序列化
     * @return
     */
    public static MarshallingDecoder buildMarshallingDecoder() {
        MarshallerFactory serial = Marshalling.getProvidedMarshallerFactory("serial");
        MarshallingConfiguration conf = new MarshallingConfiguration();
        conf.setVersion(5);
        DefaultUnmarshallerProvider provider = new DefaultUnmarshallerProvider(serial, conf);
        MarshallingDecoder decoder = new MarshallingDecoder(provider);
        return decoder;
    }
}
