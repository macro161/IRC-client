package irc_client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client { //https://webchat.freenode.net/ for testing

    Scanner readme = new Scanner(System.in);
    String line = null;
    Socket socket = null;
    BufferedWriter writer = null;
    
    BufferedReader reader = null;
    String channel = "#testers";

    public void Power_on() throws IOException {

        boolean run = true;

        String server = "shell.riftus.lt";
        String nick = "Matas";
        String login = "Matas";
        String pass = "mifzjbyd";

        socket = new Socket(server, 6667);
        writer = new BufferedWriter(
                new OutputStreamWriter(socket.getOutputStream()));
        
        PingPong pongIt = new PingPong();
        pongIt.start();
        
        reader = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
        
        

        

        writer.write("PASS " + pass + "\r\n");
        writer.flush();
        writer.write("NICK " + nick + "\r\n");
        writer.flush();
        writer.write("USER " + login + " 8 * : Hello\r\n");
        writer.flush();
        if ((line = reader.readLine()) == "ERR_ALREADYREGISTRED") {
            System.out.print("Toks nick'as jau yra");
        }

        while ((line = reader.readLine()) != null) {
            System.out.println(line);

            if (line.contains("001") || line.contains("002") || line.contains("003") || line.contains("004")) {
                System.out.println("PRISIJUNGETE SEKMINGAI");
                break;
            }
            if (line.contains("433") || line.contains("462")) {
                System.out.println("TOKS NICK JAU YRA");
                return;
            }
        }

        writer.write("JOIN " + channel + "\r\n");
        writer.flush();

        

        while (true) {

            System.out.println("1. Siusti zinute");
            System.out.println("2. Iseiti");
            System.out.println("3. Kanalo topic'as");
            System.out.println("4. Sarasas zmoniu ir kanbalu prieinamu vartotojui");
            System.out.println("5. Pakviesti vartotoja ir kanala");
            System.out.println("6. Ismesti vartotoja");
            System.out.println("7. Dienos zinute");
            System.out.println("8. Kanalo statistika");
            System.out.println("9. Serverio versija");
            System.out.println("10. Serverio laikas");

            switch (readme.nextLine()) {
                case "1":
                    System.out.print("Tavo zinute: ");
                    String message = readme.nextLine();
                    writer.flush();
                    SendThis(message);
                    writer.flush();
                    break;
                case "2":
                    writer.flush();
                    writer.write("QUIT : Bye bye everyone \r\n");
                    writer.flush();
                    return;

                case "3":
                    writer.flush();
                    writer.write("TOPIC " + channel + "\r\n");
                    writer.flush();
                    break;
                case "4":
                    writer.flush();
                    writer.write("NAMES\r\n");
                    writer.flush();
                    break;
                case "5":
                    Invite();
                    break;
                case "6":
                    Kick();
                    break;
                case "7":
                    writer.flush();
                    writer.write("MOTD \r\n");
                    writer.flush();
                    break;
                case "8":
                    writer.flush();
                    writer.write("LUSERS\r\n");
                    writer.flush();
                    break;
                case "9":
                    writer.flush();
                    writer.write("VERSION\r\n");
                    writer.flush();
                    break;
                case "10":
                    writer.flush();
                    writer.write("TIME\r\n");
                    writer.flush();
                    break;

                default:
                    System.out.println("Blogas inputas");
            }
        }
    }

    public void SendThis(String message) throws IOException {
        String send = "PRIVMSG " + channel + " :" + message + "\r\n";
        writer.write("");
        writer.flush();
        
        writer.write(send);
        writer.flush();
    }

    public void Kick() throws IOException {
        String nick;
        System.out.print("Kuri vartotoja norite is'kick'inti: ");
        nick = readme.next();
        writer.flush();
        writer.write("KICK " + channel + " " + nick + "\r\n");    
        writer.flush();
    }

    public void Invite() throws IOException {
        String nick;
        System.out.println("Iveskite nick");
        nick = readme.next();
        writer.flush();
        writer.write("INVITE " + nick + " " + channel + "\r\n"); 
        writer.flush();
    }
    
    public void JoinChannel()
    {
    
    
    }

    public class PingPong implements Runnable {

        private String threadName = "PongThread";
        private Thread t;

        public void start() {
            if (t == null) {
                t = new Thread(this, threadName);
                t.start();
            }
        }

        public void run() {
            System.out.println("HERE");

            try {
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                    if (line.startsWith("PING ")) {
                        writer.flush();
                        line = line.replaceAll("[^0-9]", "");
                        System.out.println("PONG :"+line+"\r\n");
                        writer.write("PONG :"+line+"\r\n");
                        writer.flush();

                        System.out.println("Ponged it");
                    }

                }
            } catch (IOException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
}