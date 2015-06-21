package dxc;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;

/**
 * Created by hj on 15/6/20.
 */
public class DxcServer {
    public static int PORT = 5432;
    public static String IPAddress = "127.0.0.1";

    public static void main(String[] args) throws Exception {
        RPC.Server server = new RPC.Builder(new Configuration()).setProtocol(ClientProtocol.class)
                .setInstance(new ClientProtocolImpl()).setBindAddress(IPAddress).setPort(PORT)
                .setNumHandlers(5).build();
        server.start();
    }
}