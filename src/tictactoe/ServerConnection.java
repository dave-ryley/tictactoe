/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.io.*;
import java.net.*;

/**
 *
 * @author davidryley
 */
public class ServerConnection implements Runnable {
    Socket server;
    String input, line;
    public ServerConnection(Socket server)
    {
        this.server = server;
    }

    @Override
    public void run () {

        input="";
        
        try {
            // Get input from the client
            DataInputStream in = new DataInputStream(server.getInputStream());
            DataOutputStream out = new DataOutputStream(server.getOutputStream());
            boolean running = true;
            while(running)
            {
                // Reading From Client
                switch(in.readInt())
                {
                    case Action.LOGIN:
                        System.out.println("Login action started");
                        TicTacToeServer.handleLogin(in, out);
                        break;
                    case Action.REGISTER:
                        break;
                    default:
                        System.out.println("Could not determine operation");
                }
//                while((line = in.readUTF()) != null && !line.equals("."))
//                {
//                    input=input + line;
//                }
//
//                // Writing to client
//                out.println("Overall message is:" + input);
            }

            server.close();
        }   catch (IOException ioe) {
            System.out.println("IOException on socket listen: " + ioe);
            ioe.printStackTrace();
        }
    }
}
