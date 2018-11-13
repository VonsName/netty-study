package protobuf.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.SubscribeReqProto;

import java.util.ArrayList;

/**
 * @author ： fjl
 * @date ： 2018/11/13/013 14:15
 */
public class ProtobufTest {
    public static void main(String[] args) throws InvalidProtocolBufferException {
        SubscribeReqProto.SubscribeReq req = createSubscribeReq();
        System.out.println("before encode:\n"+req.toString());
        SubscribeReqProto.SubscribeReq decode = decode(encode(req));
        System.out.println("after decode:\n"+decode.toString());
        System.out.println(decode.equals(req));
    }

    private static byte[] encode(SubscribeReqProto.SubscribeReq req) {
        return req.toByteArray();
    }

    private static SubscribeReqProto.SubscribeReq decode(byte[] bytes) throws InvalidProtocolBufferException {
        return SubscribeReqProto.SubscribeReq.parseFrom(bytes);
    }

    private static SubscribeReqProto.SubscribeReq createSubscribeReq() {
        SubscribeReqProto.SubscribeReq.Builder builder = SubscribeReqProto.SubscribeReq.newBuilder();
        builder.setSubReqID(1);
        builder.setUserName("zhangfei");
        builder.setProductName("shouji");
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("beijing");
        arrayList.add("chongqing");
        arrayList.add("shenzhen");
        builder.addAllAddress(arrayList);
        return builder.build();
    }
}
