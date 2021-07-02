package ru.geekbrains.lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

// нельзя делать 2 потока - для принятия и отправки сообщений, так как программа завершится. надо объявлять их демонами
public class EchoClient {
    private final String SERVER_ADDR = "localhost";
    private final int SERVER_PORT = 8189;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;//если изменить переменную в методе, она изменится здесь
    private Scanner scanner;

    public static void main(String[] args) {
        EchoClient echoClient = new EchoClient();
        echoClient.openConnection();//потом вызываем startReadMessages, потом sendMessages(), так как там бесконечный цикл
    }

    public EchoClient() {
        scanner = new Scanner(System.in);
        openConnection();
        while (true) {               //лучше вызывать сдесь и поместить в отдельный метод sendMessages();
            sendMessage();           // нельзя вызывать бесконечный цикл в конструкторе
        }
    }

    public void openConnection() {
        try {
            socket = new Socket(SERVER_ADDR, SERVER_PORT);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());// не должна ли эта строка быть в методе sendMessage()?нет
            new Thread(new Runnable() { // нет, так как каждый раз при вызове sendMessage(); будет создаваться новый объект
                @Override
                public void run() { //startReadMessages назвать метод
                    try {
                        while (true) {
                            String strIn = in.readUTF();
                            System.out.println("Сервер:" + strIn);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        closeConnection();
                    }
                }
            }).start();

        } catch (Exception e) {
            e.printStackTrace();
            closeConnection();//!!!!!!!
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
        } // здесь не нужен closeConnection(), так как сообщение пишет пользователь и он может сделать ошибку и может отправить сообщение еще раз
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



