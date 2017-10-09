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
    private static DataInputStream in;
    private static DataOutputStream out;
    
    public static void listenSocket() {
        //Create socket connection
        try {
            socket = new Socket("127.0.0.1", 4444);
            out = new DataOutputStream(socket.getOutputStream());
            in = new DataInputStream(socket.getInputStream());
        } catch (UnknownHostException e) {
            System.out.println("Unknown host:");
            System.exit(1);
        } catch  (IOException e) {
            System.out.println("No I/O");
            System.exit(1);
        }
    }
    
    public static void launchClient()
    {
        LoginController controller = new LoginController();
        controller.setup(socket, in, out);
    }

    public static void main(String [] args)
    {
//        Player p1 = new Player(1, "player 1");
//        Game game = new Game(p1);
//        GameUI gameUI = new GameUI();
//        gameUI.setGame(game);
//        gameUI.setVisible(true);
        
        listenSocket();
        launchClient();
//        try {
//            
//            
//            out.writeInt(Action.LOGIN);
//            out.writeUTF("1@ttt.com\npassword1");
//            out.writeUTF(Action.MESSAGE_END);
//            String line;
//            System.out.println("Attempting to write" + in.readInt());
//            
//            while(!(line = in.readUTF()).equals(Action.MESSAGE_END))
//            {
//                System.out.println("Printing from Server...");
//                System.out.print(line);
//            }
//        } catch (IOException e) {
//            System.out.println("Read failed");
//            System.exit(1);
//        }
    }
    
}
