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

/**
 *
 * @author davidryley
 */
public class LoginController {
    
    private ClientController client;
    private LoginUI ui;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    
    public LoginController(ClientController client)
    {
        this.client = client;
        ui = new LoginUI(this);
    }

    void setup(Socket socket, DataInputStream in, DataOutputStream out) {
        this.socket = socket;
        this.in = in;
        this.out = out;
    }

    void attemptLogin(String email, String password) {
        try
        {
            out.writeInt(Action.LOGIN);
            out.writeUTF(email);
            out.writeUTF(password);
            out.writeUTF(Action.MESSAGE_END);
            if(in.readInt() == Action.LOGIN_RESPONSE)
            {
                ui.setMessageText("Login Successful!");
                User user = new User(in.readUTF());
                // Continue here to switch to lobby...
                hide();
                client.openLobby(user);
            }
            else
            {
                ui.setMessageText("Login Failed!");
            }
        } catch (IOException e) {
            System.out.println("Read failed");
            System.exit(1);
        }
    }
    
    public void view()
    {
        ui.setVisible(true);
        ui.setMessageText("Welcome To Tic-Tac-Toe!");
    }
    
    public void hide()
    {
        ui.setVisible(false);
    }
}
