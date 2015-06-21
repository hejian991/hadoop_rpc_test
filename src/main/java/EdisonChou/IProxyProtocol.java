package EdisonChou;

import org.apache.hadoop.ipc.VersionedProtocol;

/**
 * Created by hj on 15/6/20.
 */
public interface IProxyProtocol extends VersionedProtocol {
    public static final long versionID = 1L; //版本号，默认情况下，不同版本号的RPC Client和Server之间不能相互通信
    int Add(int number1,int number2);
}