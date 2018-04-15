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

public class Client {
    
    Scanner readme = new Scanner(System.in);
    String line = null;
    Socket socket = null;
    BufferedWriter writer = null;
    BufferedReader reader = null;
    String channel = "#programming";

    public void Power_on() throws IOException {

        
        boolean run = true;

        String server = "irc.freenode.net";
        String nick = "mifasyrazjabays";
        String login = "mifasyrazjabays";
        //String pass = "mifzjbys";

        

        socket = new Socket(server, 6667);
        writer = new BufferedWriter(
                new OutputStreamWriter(socket.getOutputStream()));
        reader = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));

        PingPong pongIt = new PingPong();

       // writer.write("PASS " + pass + "\r\n");
        writer.write("NICK " + nick + "\r\n");
        writer.write("USER " + login + " 8 * : Java IRC Hacks Bot\r\n");
        writer.flush();
        
        

       
        while ((line = reader.readLine()) != null) {
            System.out.println(line);

            if (line.indexOf("004") >= 0) {

                break;
            } else if (line.indexOf("433") >= 0) {
                System.out.println("Nickname is already in use.");
                return;
            }
        }

        writer.write("JOIN " + channel + "\r\n");
        writer.flush();
        
        //writer.write("PRIVMSG " + channel + " :I got pinged!\r\n");
        
        pongIt.start();

        while (true) {
            
            
        
            System.out.println("1. Siusti zinute");
            
            switch(readme.nextInt())
            {
                case 1:
                    SendThis();
                    break;
            }
            
        }
    }
    
    public void SendThis() throws IOException
    {
        String hate = "PRIVMSG " + channel + " :PRIVMSG, but that is a public msg." + "\r\n";
        
        writer.write("sadasdasd");
    }
    public class PingPong implements Runnable {
 
        private String threadName = "PongThread";
        private Thread t;
 
        public void start (){
            if(t == null){
                t = new Thread (this, threadName);
                t.start();
            }
        }

        public void run() {
            System.out.println("HERE");
            
            try {
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                    if(line.startsWith("PING ")){
                        writer.write("PONG");
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
