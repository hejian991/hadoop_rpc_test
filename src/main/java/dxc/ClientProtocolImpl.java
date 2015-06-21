package dxc;

import org.apache.hadoop.ipc.ProtocolSignature;

import java.io.IOException;

/**
 * Created by hj on 15/6/20.
 */
public class ClientProtocolImpl implements ClientProtocol {
    //重载的方法，用于获取自定义的协议版本号，
    public long getProtocolVersion(String protocol, long clientVersion) {
        System.out.println("EdisonChou.MyProxy.ProtocolVersion=" + ClientProtocol.versionID);
        return ClientProtocol.versionID;
    }
    //重载的方法，用于获取协议签名
    public ProtocolSignature getProtocolSignature(String protocol, long clientVersion,
                                                  int clientMethodsHash) {
        return new ProtocolSignature(ClientProtocol.versionID, null);
    }
    public String echo(String value) throws IOException {
        System.out.println("echo被调用了!");
        return value;
    }
    public int add(int v1, int v2) throws IOException {
        System.out.println("add被调用了!");
        return v1 + v2;
    }
}