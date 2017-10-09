/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

/**
 *
 * @author davidryley
 */
public class TicTacToeClient {

    public static void main(String [] args)
    {
        ClientController controller = new ClientController();
        controller.run();
        
//        Player p1 = new Player(1, "player 1");
//        Game game = new Game(p1);
//        GameUI gameUI = new GameUI();
//        gameUI.setGame(game);
//        gameUI.setVisible(true);
        
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
