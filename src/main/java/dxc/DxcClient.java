package dxc;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * Created by hj on 15/6/20.
 */

public class DxcClient {

    public static void main(String[] args) throws IOException {

        InetSocketAddress inetSocketAddress = new InetSocketAddress(
                DxcServer.IPAddress, DxcServer.PORT);
        ClientProtocol proxy = (ClientProtocol)RPC.getProxy(
                ClientProtocol.class, ClientProtocol.versionID, inetSocketAddress, new Configuration());
        int result = proxy.add(5, 6);
        String echoResult = proxy.echo("result");

        System.out.println(result);
        System.out.println(echoResult);
    }

}