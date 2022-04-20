import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class mClient {

    public static void main(String... args) {

        String  host = "localhost";
        int port = 8081;

        try (Socket clSocket  = new Socket(host,port);
             PrintWriter out = new PrintWriter(clSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clSocket.getInputStream()))){
            out.println("GET/HTTP/1.1\n" +
                    "Host: localhost\n\n\n");
            String resp = in.readLine();
            System.out.println(resp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
