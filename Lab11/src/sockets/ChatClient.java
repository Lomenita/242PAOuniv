package sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/*
exemplu de utilizare
Adresa serverului: localhost
"Portul serverului: 8081
Mesaj de trimis: Hi
   In acest moment va raspunde serverul
   apoi se scrie un mesaj in aplicatia server
 */
public class ChatClient {

    public static void main(String[] sir) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Adresa serverului: ");
        String adresa = sc.next();
        System.out.print("Portul serverului: ");
        int port = sc.nextInt();
        sc.nextLine();
        //conectarea la server
        try(
            Socket cs = new Socket(adresa, port);
            //preluăm fluxurile de intrare/ieșire de la/către server
            DataInputStream dis = new DataInputStream(cs.getInputStream());
            DataOutputStream dos = new DataOutputStream(cs.getOutputStream());) {
            System.out.println("Conectare reusita la server!");
            //citim o linie de text de la tastatură și o transmitem server-ului,
            //după care așteptam răspunsul server-ului
            //chat-ul se închide tastând cuvântul STOP
            while (true) {
                System.out.print("Mesaj de trimis: ");
                String linie = sc.nextLine();
                dos.writeUTF(linie);
                if (linie.equals("STOP"))
                    break;
                linie = dis.readUTF();
                System.out.println("Mesaj receptionat: " + linie);
            }
        }
    }
}

