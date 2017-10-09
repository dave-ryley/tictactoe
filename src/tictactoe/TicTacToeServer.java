package tictactoe;

/**
 *
 * @author davidryley
 */

import java.io.*;
import java.net.*;
import java.security.*;

public class TicTacToeServer {
    
    private static final int PORT=4444, MAX_CONNECTIONS=0;
    
    static String parseDataStreamAsString(DataInputStream in)
    {
        String input = "";
        try {
            String line;
            while((line = in.readUTF()) != null)
            {
                input += line + "\n";
                System.out.println(line);
            }
            
        } catch(IOException e) {
            System.out.println("IOException on socket listen: " + e);
        }
        System.out.println("Finished reading");
        return input;
    }

    static void handleLogin(DataInputStream in, DataOutputStream out) throws IOException
    {
        String input = parseDataStreamAsString(in);
        String [] inputArray = input.split("\n");
        User user = findUser( inputArray[0], inputArray[1] );
        out.writeInt(Action.LOGIN_RESPONSE);
        out.writeUTF(user.toString());
    }

    private synchronized static User findUser(String email, String password)
    {
        // TODO: change this to check a database
        for(int i = 0; i < users.length; i++)
        {
            if( users[i].getEmail().equals(email) )
            {
                if( users[i].getPassword().equals(password) )
                {
                    return users[i];
                }
                break;
            }
        }
        return new User(0,"","","");
    }
    
    private static User [] users = {
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
