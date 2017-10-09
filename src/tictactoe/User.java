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
public class User {
    private int id;
    private String email;
    private String username;
    private String password;
    
    public User(String userString)
    {
        String [] stringSplit = userString.split(Action.SEPERATOR);
        id = Integer.parseInt(stringSplit[0]);
        email = stringSplit[1];
        username = stringSplit[2];
        password = stringSplit[3];
    }
    
    public User(int id, String email, String username, String password)
    {
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
    }
    
    @Override
    public String toString()
    {
        String result = "";
        result += id + Action.SEPERATOR;
        result += email + Action.SEPERATOR;
        result += username + Action.SEPERATOR;
        result += password;
        return result;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    boolean isValid() {
        return id != 0;
    }
    
    
}
