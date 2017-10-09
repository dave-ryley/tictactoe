/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author davidryley
 */
public class ClientController {
    private LoginController loginController;
    private static Socket socket;
    private static DataInputStream in;
    private static DataOutputStream out;
    
    public ClientController()
    {
        loginController = new LoginController(this);
    }
    
    public void listenSocket() {
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
    
    public void openLogin()
    {
        loginController.setup(socket, in, out);
        loginController.view();
    }
    
    public void openLobby(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void run()
    {
        listenSocket();
        openLogin();
    }

}
