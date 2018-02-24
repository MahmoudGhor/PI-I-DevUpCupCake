/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.idevup.cupcake.entities;

/**
 *
 * @author Amine Sboui
 */
public class Reply {
    private String message;
    private String username;
    private int seen;

    public Reply() {
    }

    public Reply(String message, String username, int seen) {
        this.message = message;
        this.username = username;
        this.seen = seen;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getSeen() {
        return seen;
    }

    public void setSeen(int seen) {
        this.seen = seen;
    }
    
}
