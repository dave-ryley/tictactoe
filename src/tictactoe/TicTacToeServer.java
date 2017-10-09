package tictactoe;

/**
 *
 * @author davidryley
 */

import java.io.*;
import java.net.*;

public class TicTacToeServer {
    
    private static final int PORT=4444, MAX_CONNECTIONS=0;
    
    static String parseDataStreamAsString(DataInputStream in)
    {
        String input = "";
        try {
            String line;
            while(!(line = in.readUTF()).equals(Action.MESSAGE_END))
            {
                input += line + Action.SEPERATOR;
            }
            
        } catch(IOException e) {
            System.out.println("IOException on socket listen: " + e);
        }
        return input;
    }

    static void handleLogin(DataInputStream in, DataOutputStream out) throws IOException
    {
        String input = parseDataStreamAsString(in);
        System.out.println(input);
        String [] inputArray = input.split(Action.SEPERATOR);
        User user = findUser( inputArray[0], inputArray[1] );
        if(user.isValid())
        {
            out.writeInt(Action.LOGIN_RESPONSE);
            out.writeUTF(user.toString());
        }
        else
        {
            out.writeInt(Action.ERROR);
        }
//        out.writeUTF(Action.MESSAGE_END);
    }

    private synchronized static User findUser(String email, String password)
    {
        // TODO: change this to check a database
        for (User user : users) 
        {
            if (user.getEmail().equals(email)) 
            {
                if (user.getPassword().equals(password)) 
                {
                    return user;
                }
                break;
            }
        }
        return new User(0,"","","");
    }
    
    private static final User [] users = {
        new User(1, "1@ttt.com", "user1", "password1"),
        new User(2, "2@ttt.com", "user2", "password2"),
    };
    
    public static void openConnections()
    {
        int i=0;

        try{
          ServerSocket listener = new ServerSocket(PORT);
          Socket server;

          while((i++ < MAX_CONNECTIONS) || (MAX_CONNECTIONS == 0)){

            server = listener.accept();
            ServerConnection connection = new ServerConnection(server);
            Thread t = new Thread(connection);
            t.start();
          }
        } catch (IOException ioe) {
          System.out.println("IOException on socket listen: " + ioe);
        }
    }
    
    public static void main(String [] args)
    {
        openConnections();
    }
}
