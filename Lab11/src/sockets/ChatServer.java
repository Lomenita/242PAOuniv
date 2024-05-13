package sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/*
exemplu de utilizare
se seteaza portul 8081 , apoi enter
 */
public class ChatServer {

    public static void main(String[] sir) throws IOException {

        Scanner sc = new Scanner(System.in);
        System.out.print("Portul: ");
        int port = sc.nextInt();
        sc.nextLine();
        try(
            ServerSocket ss = new ServerSocket(port);
            Socket cs = ss.accept();
            //server-ul preia fluxurile de la/către client
            DataInputStream dis = new DataInputStream(cs.getInputStream());
            DataOutputStream dos = new DataOutputStream(cs.getOutputStream());){

            System.out.println("Serverul a pornit!");
            //server-ul așteaptă un client să se conecteze
            System.out.println("Un client s-a conectat la server!");
            //citim linia de text transmisa de către client și o afișăm,
            //după care citim o linie și o transmitem clientului
            //chat-ul se închide când clientul transmite cuvântul STOP
            while (true) {
                String linie = dis.readUTF();
                System.out.println("Mesaj receptionat: " + linie);
                if (linie.equals("STOP"))
                    break;
                System.out.print("Mesaj de trimis: ");
                linie = sc.nextLine();
                dos.writeUTF(linie);
            }
        }
    }
}



