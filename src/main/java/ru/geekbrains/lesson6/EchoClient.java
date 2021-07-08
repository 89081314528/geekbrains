package ru.geekbrains.lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

// нельзя делать 2 потока - для принятия и отправки сообщений, так как программа завершится. надо объявить их демонами
public class EchoClient {
    private final String SERVER_ADDR = "localhost";
    private final int SERVER_PORT = 8189;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private Scanner scanner;

    public static void main(String[] args) {
        EchoClient echoClient = new EchoClient();
        echoClient.openConnection();
        echoClient.startReadMessages();
        echoClient.sendMessages();
    }

    public EchoClient() {
        scanner = new Scanner(System.in);
    }

    public void sendMessages() {
        while (true) {               //лучше поместить в отдельный метод sendMessages();, нежелательно вызывать бесконечный цикл в конструкторе
            sendMessage();
        }
    }

    public void startReadMessages() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        String strIn = in.readUTF();
                        if (strIn.equals("/end")) {
                            break;
                        }
                        System.out.println("Сервер:" + strIn);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    closeConnection();
                }
            }
        }).start();
    }
    public void openConnection() {
        try {
            socket = new Socket(SERVER_ADDR, SERVER_PORT);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());// эту строка не должна быть в методе sendMessage().так как каждый раз при вызове sendMessage(); будет создаваться новый объект
        } catch (Exception e) {
            e.printStackTrace();
            closeConnection();
            throw new RuntimeException(e);
        }
    }

    public void sendMessage() {
        String strOut = scanner.nextLine();
        if (!strOut.isEmpty()) {
            try {
                out.writeUTF(strOut);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } // здесь не нужен closeConnection(), так как сообщение пишет пользователь, он может сделать ошибку и может отправить сообщение еще раз
    }

    public void closeConnection() {
        try {
            in.close();
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
        try {
            out.close();
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
        try {
            socket.close();
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
    }

}



