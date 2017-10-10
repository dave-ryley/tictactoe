
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
public class ClientController 
{
    private LoginController loginController;
    private LobbyController lobbyController;
    private static Socket socket;
    private static DataInputStream in;
    private static DataOutputStream out;
    
    public ClientController()
    {
        loginController = new LoginController(this);
        lobbyController = new LobbyController(this);
    }
    
    public void listenSocket() 
    {
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
        loginController.setup(in, out);
        loginController.view();
    }
    
    public void openLobby(User user) 
    {
        lobbyController.setup(in, out, user);
        lobbyController.view();
    }
    
    public void run()
    {
        listenSocket();
        openLogin();
    }

}
