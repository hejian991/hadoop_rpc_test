package EdisonChou;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * Created by hj on 15/6/20.
 */

public class MyClient {

    public static void main(String[] args) {
        InetSocketAddress inetSocketAddress = new InetSocketAddress(
                MyServer.IPAddress, MyServer.PORT);

        try {
            // 注意：这里传入的版本号需要与代理保持一致
            IProxyProtocol proxy = (IProxyProtocol) RPC.waitForProxy(
                    IProxyProtocol.class, IProxyProtocol.versionID, inetSocketAddress,
                    new Configuration());

//            EdisonChou.IProxyProtocol proxy = (EdisonChou.IProxyProtocol)RPC.getProxy(
//                    EdisonChou.IProxyProtocol.class, EdisonChou.IProxyProtocol.versionID, inetSocketAddress, new Configuration());
            int result = proxy.Add(10, 25);
            System.out.println("10+25=" + result);

            RPC.stopProxy(proxy);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}