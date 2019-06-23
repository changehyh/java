package com.github.changehyh.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class SingleThreadClient {
    public static void main(String[] args) {
        //1、准备地址和端口号
        String ip = "127.0.0.1";
        int port = 6666;
        //Socket

        try {

            Socket socket = new Socket(ip,port);
            //3、数据的传输
            //3.1 发送数据
            OutputStream out = socket.getOutputStream();
            PrintStream printStream = new PrintStream(out);
            printStream.println("服务器，我来了");
            printStream.flush();
            //3.2 接收数据
            InputStream in = socket.getInputStream();
            Scanner scanner = new Scanner(in);
            System.out.println("来自服务器的数据" + scanner.nextLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
