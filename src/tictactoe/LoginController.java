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
    
    private LoginUI ui;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    
    public LoginController()
    {
        ui = new LoginUI(this);
        ui.setVisible(true);
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
                user.isValid();
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
}
