/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package irc_client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import java.util.Scanner;

/**
 *
 * @author normie
 */
public class Client {
    
        Scanner readme = new Scanner(System.in);
        boolean run = true;
        String server;
        String nick;
        String login;
        String channel;
    
    public void Power_on() throws IOException{
        
        while(run){
            System.out.println("1. Connect to IRC server \n");
            switch(readme.nextInt()){
                case 1 : Connect_to_chat();
                    
                    
            
            }
            
            
            
        }
        
        
        // The server to connect to and our details.
       /* String server = "irc.freenode.net";
        String nick = "zydas";
        String login = "zydas";

        // The channel which the bot will join.
        String channel = "#wikipedia-en-help";*/
        
        // Connect directly to the IRC server.
        Socket socket = new Socket(server, 6667);
        BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(socket.getOutputStream( )));
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(socket.getInputStream( )));
        
        // Log on to the server.
        writer.write("NICK " + nick + "\r\n");
        writer.write("USER " + login + " 8 * : Java IRC Hacks Bot\r\n");
        writer.flush( );
        
        // Read lines from the server until it tells us we have connected.
        String line = null;
        while ((line = reader.readLine( )) != null) {
            if (line.indexOf("004") >= 0) {
                // We are now logged in.
                break;
            }
            else if (line.indexOf("433") >= 0) {
                System.out.println("Nickname is already in use.");
                return;
            }
        }
        
        // Join the channel.
        writer.write("JOIN " + channel + "\r\n");
        writer.flush( );
        
        // Keep reading lines from the server.
        while ((line = reader.readLine( )) != null) {
            if (line.toLowerCase( ).startsWith("PING ")) {
                // We must respond to PINGs to avoid being disconnected.
                writer.write("PONG " + line.substring(5) + "\r\n");
                writer.write("PRIVMSG " + channel + " :I got pinged!\r\n");
                writer.flush( );
            }
            else {
                // Print the raw line received by the bot.
                System.out.println(line);
            }
        }
    
    }
    
    //Connection Registration
    
    public void Connect_to_chat(){
        System.out.println("Enter your nickname: ");
        Nick_message(readme.nextLine());
    
    }
    
    public void Password_message(){
    
    }
    
    public void Nick_message(String nickname, int mode){
        nick = "NICK " + nickname;
    
    }
    
    public void User_message(){
    
    }
    
    public void Oper_message(){
    
    }
    
    public void User_mode_message(){
    
    }
    
    public void Service_message(){
    
    }
    
    public void Quit(){
    
    }
    
    public void Squit(){
    
    }
    
    //Channel operations
    
    public void Join_message(){
    
    }
    
    public void Part_message(){
    
    }
    
    public void Channel_mode_message(){
    
    }
    
    public void Topic_message(){
    
    }
    
    public void Names_message(){
    
    }
    
    public void List_message(){
    
    }
    
    public void Invite_message(){
    
    }
    
    public void Kick_command(){
    
    }
    
    //Sending message
    
    public void Private_message(){
    
    }
    
    public void Notice(){
    
    }
    
    //Server queries and commands
    
    public void Motd_message(){
    
    }
    
    public void Lusers_message(){
    
    }
    
    public void Version_message(){
    
    }
    
    public void Stats_message(){
    
    }
    
    public void Links_message(){
    
    }
    
    public void Time_message(){
    
    }
    
    public void Connect_message(){
    
    }
    
    public void Trace_message(){
    
    }
    
    public void Admin_command(){
    
    }
    
    public void Info_command(){
    
    }
    
    //Service Query and Commands
    
    public void Servlist_message(){
    
    }
    
    public void Squery(){
    
    }
    
    //User based queries
    
    public void Who_query(){
    
    }
    
    public void Whois_query(){
    
    }
    
    public void Whowas(){
    
    }
    
    //Miscellaneous messages
    
    public void Kill_message(){
    
    }
    
    public void Ping_message(){
    
    }
    
    public void Pong_message(){
    
    }
    
    public void Error(){
    
    }
    
    //Optional features
    
    public void Away(){
    
    }
    
    public void Rehash_message(){
    
    }
    
    public void Restart_message(){
    
    }
    
    public void Summon_message(){
    
    }
    
    public void Users(){
    
    }
    
    public void Operwall_message(){
    
    }
    
    public void Userhost_message(){
    
    }
    
    public void Ison_message(){
    }
    
    
}
