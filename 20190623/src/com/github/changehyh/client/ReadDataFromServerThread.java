package com.github.changehyh.client;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ReadDataFromServerThread extends Thread{

    private final Socket socket;

    public ReadDataFromServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try{
            InputStream in = this.socket.getInputStream();
            Scanner scanner = new Scanner(in);
            while (true){
                try{
                    String message = scanner.nextLine();
                    System.out.println("来自服务器>" + message);
                }catch (NoSuchElementException e){
                    break;
                }
            }
        }catch (IOException e){

        }
    }
}
