package EdisonChou;

import org.apache.hadoop.ipc.ProtocolSignature;

import java.io.IOException;

/**
 * Created by hj on 15/6/20.
 */
public class MyProxy implements IProxyProtocol {
    public int Add(int number1,int number2) {
        System.out.println("我被调用了!");
        int result = number1+number2;
        return result;
    }

    public long getProtocolVersion(String protocol, long clientVersion)
            throws IOException {
        System.out.println("EdisonChou.MyProxy.ProtocolVersion=" + versionID);
        // 注意：这里返回的版本号与客户端提供的版本号需保持一致
        return versionID;
    }

    @Override
    public ProtocolSignature getProtocolSignature(String protocol, long clientVersion, int clientMethodsHash) throws IOException {
        return new ProtocolSignature(versionID, null);
    }


}