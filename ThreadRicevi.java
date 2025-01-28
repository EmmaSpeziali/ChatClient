package com.example.ChatClient.ChatClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ThreadRicevi implements Runnable {
    private BufferedReader in;
    private Socket socket;

    public ThreadRicevi(Socket socket) throws IOException {
        this.socket = socket;
        this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    public void run() {
        String messaggio;
        try {
            while ((messaggio = in.readLine()) != null) {
                System.out.println(messaggio);
            }
            System.out.println("Server Chiuso");
            socket.close();
        } catch (IOException e) {
            System.out.println("Errore di connessione");
        }
    }
}