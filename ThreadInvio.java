package com.example.ChatClient.ChatClient;

import java.io.IOException;
import  java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ThreadInvio implements Runnable{
    private Scanner sc;
     private PrintWriter out; 
     public ThreadInvio (Socket socket) throws I0Exception { 
        sc = new Scanner(System.in); 
        out = new PrintWriter(socket.getOutputStream()); 
     }
        @Override
        public void run() {
            String message;
            boolean primo=true;
            while(!Thread.interrupted()){
                if (primo) {
                    System.err.println("Dimmi il nome utente");
                }
                message = sc.nextLine();
                out.println(message);
                out.flush();
                if (primo){
                    System.err.println("Utente acquisito, scrivi messaggio");
                    primo=false;
                }
            }
        }
    }