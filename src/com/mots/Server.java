package com.mots;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Server {

    private static List<Socket> apps = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) {
        startServerForApp();
        startServerForFakeData();
    }

    private static void startServerForFakeData() {
        try {
            ServerSocket serverForFakeData = new ServerSocket(12580);
            while (true) {
                Socket fakeClient = serverForFakeData.accept();
                broadcastFakeData(fakeClient);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void broadcastFakeData(Socket fakeClient) {
        new Thread(() -> {
            try {
                while (true) {
                    InputStream in = fakeClient.getInputStream();
                    int messageSize = 0;
                    byte[] receiveBuf = new byte[1024];
                    while ((messageSize = in.read(receiveBuf)) != -1) {
                        for (Socket app : apps) {
                            OutputStream out = app.getOutputStream();
                            out.write(receiveBuf, 0, messageSize);
                            out.flush();
                        }
                    }
                    Thread.sleep(1000);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }

    private static void startServerForApp() {
        new Thread(() -> {
            try {
                ServerSocket serverForApp = new ServerSocket(25269);
                while (true) {
                    final Socket app = serverForApp.accept();
                    apps.add(app);
                    startReadingThreadForEachApp(app);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private static void startReadingThreadForEachApp(Socket app) {
        new Thread(() -> {
            try {
                while (true) {
                    InputStream inputStream = app.getInputStream();
                    byte[] receiveBuf = new byte[1024];
                    int size = 0;
                    while ((size = inputStream.read(receiveBuf))!= -1) {
                        System.out.println(new String(receiveBuf, 0, size));
                    }
                    Thread.sleep(100);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}
