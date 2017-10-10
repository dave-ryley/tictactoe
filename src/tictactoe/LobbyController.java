/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.io.DataInputStream;
import java.io.DataOutputStream;

/**
 *
 * @author davidryley
 */
public class LobbyController {
    
    private ClientController client;
    private LobbyUI ui;
    private DataInputStream in;
    private DataOutputStream out;
    private User user;

    LobbyController(ClientController client) 
    {
        this.client = client;
        ui = new LobbyUI(this);
    }

    void setup(DataInputStream in, DataOutputStream out, User user) 
    {
        this.in = in;
        this.out = out;
        this.user = user;
    }

    void view() 
    {
        ui.setVisible(true);
        ui.setMessageText("Welcome, " + user.getUsername());
    }
    
    public void hide()
    {
        ui.setVisible(false);
    }
}
