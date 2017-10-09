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
public class TicTacToeClient {
    
    private static Socket socket;
    private static PrintWriter out;
    private static BufferedReader in;
    
    public static void listenSocket() {
        //Create socket connection
        try {
            socket = new Socket("127.0.0.1", 4444);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (UnknownHostException e) {
            System.out.println("Unknown host:");
            System.exit(1);
        } catch  (IOException e) {
            System.out.println("No I/O");
            System.exit(1);
        }
    }

    public static void main(String [] args)
    {
//        Player p1 = new Player(1, "player 1");
//        Game game = new Game(p1);
//        GameUI gameUI = new GameUI();
//        gameUI.setGame(game);
//        gameUI.setVisible(true);
        
        System.out.println("Attempt to access socket");
        listenSocket();
        out.println(Action.LOGIN);
        System.out.println("Connected, Printing " + Action.LOGIN);
        out.println("1@ttt.com\npassword1");
        try {
            String line;
            while((line = in.readLine()) != null)
            {
                System.out.print(line);
            }
        } catch (IOException e) {
            System.out.println("Read failed");
            System.exit(1);
        }
    }
    
}
