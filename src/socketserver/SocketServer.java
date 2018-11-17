/*
 Test 3 Socket Programming (Server)
 */
package socketserver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {

   private static final long MEGABYTE = 1048576; 

    public static long bytesToMegabytes(long memory) {
        return memory / MEGABYTE;
    }
    
    public static void main(String[] args) {
        
        try
        {
            ServerSocket ser = new ServerSocket(8080);
            Socket sock = ser.accept();
            
           BufferedReader ed = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            String tmp = ed.readLine();
            System.out.print("I Received :"+tmp);
            
              Runtime runtime = Runtime.getRuntime();
    
        runtime.gc();
        
        // Memory Calculation
        long memory = runtime.totalMemory() - runtime.freeMemory();
            PrintStream pr = new PrintStream(sock.getOutputStream());
            String str = "Memory Used:"+memory+" bytes";
            pr.println(str);
           
        }catch(Exception ex){}
                        
    }
    
}
