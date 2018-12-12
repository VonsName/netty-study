package netty;

import org.msgpack.MessagePack;
import org.msgpack.template.Template;
import org.msgpack.template.Templates;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ： fjl
 * @date ： 2018/11/9/009 16:15
 */
public class MsgPackTest {
    public static void main(String[] args) throws IOException {
        MessagePack msg = new MessagePack();
        List<String> src = new ArrayList<>();
        src.add("msgpack");
        src.add("thrift");
        src.add("protobuf");
        byte[] write = msg.write(src);
        List<String> read = msg.read(write, Templates.tList(Templates.TString));
        read.forEach(System.out::println);
    }
}
