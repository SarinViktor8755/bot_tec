import java.io.IOException;
import java.net.InetAddress;

import static sun.rmi.transport.TransportConstants.Ping;

public class ping {
    public static void main(String[] args) throws IOException {
        try {
            InetAddress inetAddress = InetAddress.getByName("192.168.250.150");
            boolean isReachable = inetAddress.isReachable(5000);
            if (isReachable) {
                System.out.println("Host is reachable");
            } else {
                System.out.println("Host is not reachable");
            }
            long timeTaken = System.currentTimeMillis();
            isReachable = inetAddress.isReachable(5000);
            timeTaken = System.currentTimeMillis() - timeTaken;
            System.out.println("Time taken: " + timeTaken + "ms");
        } catch (IOException e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}
