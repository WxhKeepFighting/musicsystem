package Server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient02 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",65000);
        OutputStream outputStream = socket.getOutputStream();
        InputStream inputStream = socket.getInputStream();
        outputStream.write(new String("Client02").getBytes());
        byte buff [] = new byte[1024];
        int ch = inputStream.read(buff);
        String content = new String(buff,0,ch);
        System.out.println(content);
        inputStream.close();
        outputStream.close();
        socket.close();
    }
}
