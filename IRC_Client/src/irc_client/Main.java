
package irc_client;

import java.io.*;
import java.net.*;

//https://tools.ietf.org/html/rfc2812#section-3.4

public class Main{

    public static void main(String[] args) throws Exception {

        //User_interface();
        
        Client client = new Client();
        client.Power_on();
        

        
    }
    
    public void User_interface(){
        System.out.println("Nickname: ");
        System.out.println("Channel: ");
        System.out.println("Server: ");
        System.out.println("Port: ");
    }
    
    //Connection Registration
    
    public void Password_message(){
    
    }
    
    public void Nick_message(){
    
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
