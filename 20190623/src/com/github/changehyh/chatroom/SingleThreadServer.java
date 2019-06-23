package com.github.changehyh.chatroom;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SingleThreadServer {
    public static void main(String[] args) {
        //1、准备地址和端口号
        //127.0.0.1    6666
        int port = 6666;
        //2、ServerSocket
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("服务端启动了。运行在：" + serverSocket.getLocalSocketAddress());

            //3、等待客户端连接
            //阻塞方法，直到有客户端连接到服务器才会返回socket
            Socket socket = serverSocket.accept();

            //4、数据接收和发送
            //4.1 接收
            InputStream in = socket.getInputStream();
            Scanner scanner = new Scanner(in);
            System.out.println("客户端说：" +scanner.nextLine());
            //4.2 发送
            OutputStream out = socket.getOutputStream();
            PrintStream printStream = new PrintStream(out);
            printStream.println("欢迎，欢迎");
            printStream.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
