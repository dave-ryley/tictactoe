/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

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
        
        System.out.println("Connection opened");
        String testString;
        int testInt;

        try {
            // Get input from the client
            BufferedReader in = new BufferedReader(new InputStreamReader(server.getInputStream()));
            PrintStream out = new PrintStream(server.getOutputStream());
            boolean running = true;
            while(running)
            {
                // Reading From Client
                System.out.println("Attempting to read...");
                System.out.println(in.readLine());
//                switch(testInt)
//                {
//                    case Action.LOGIN:
//                        System.out.println("Login action started");
//                        TicTacToeServer.handleLogin(in, out);
//                        break;
//                    case Action.REGISTER:
//                        break;
//                    default:
//                        System.out.println("Could not determine operation");
//                }
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
