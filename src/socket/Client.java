package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public static void main(String[] args)
    {
        try {
            InetAddress serverAddress = InetAddress.getByName("localhost");
            System.out.println("Server ip address: " + serverAddress.getHostAddress());



            Socket socket = new Socket(serverAddress, 9090);
            System.out.println("Connected with Server");
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println(input.readLine());
            out.println("Hello Server!");


            input.close();
            out.close();
            socket.close();
        }
        catch (UnknownHostException e1){
            System.out.println(e1);
        }
        catch (IOException e2){
            System.out.println("IOException " + e2.toString());
        }
        catch (IllegalArgumentException e3){
            System.out.println("Illegal Argument Exception " + e3.toString());
        }
        catch (Exception e4){
            System.out.println("Other Exception: " + e4.toString());
        }
    }
}
