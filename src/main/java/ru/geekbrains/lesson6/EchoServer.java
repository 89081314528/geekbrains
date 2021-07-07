package ru.geekbrains.lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {
    public static void main(String[] args) {
        System.out.println("Сервер запущен, ожидаем подключения...");
        try (ServerSocket serverSocket = new ServerSocket(8189);
             Socket socket = serverSocket.accept();
             DataInputStream in = new DataInputStream(socket.getInputStream());
             DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        ) {
            System.out.println("Клиент подключился");
            new Thread(new Runnable() {
                @Override
                public void run() {
                        while (true) {
                            Scanner scanner = new Scanner(System.in); // не надо убрать из цикла?
                            String strOut = scanner.nextLine();
                            if (!strOut.isEmpty()) {
                                try {
                                    out.writeUTF(strOut);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                }
            }).start();

            while (true) {
                String strIn = in.readUTF();
                if (strIn.equals("/end")) {
                    break;
                }
                System.out.println("Клиент:" + strIn);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


