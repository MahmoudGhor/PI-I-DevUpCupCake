/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.idevup.cupcake.entities;

import java.sql.Date;

/**
 *
 * @author mahmo
 */
public class ContacterAdmin {
    private String description ; 
    private String username;
    private Date dateEnvoye;
    private int seen;
    private int status;

    public ContacterAdmin(String description, String username, Date dateEnvoye, int seen, int status) {
        this.description = description;
        this.username = username;
        this.dateEnvoye = dateEnvoye;
        this.seen = seen;
        this.status = status;
    }

    public ContacterAdmin() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getDateEnvoye() {
        return dateEnvoye;
    }

    public void setDateEnvoye(Date dateEnvoye) {
        this.dateEnvoye = dateEnvoye;
    }

    public int getSeen() {
        return seen;
    }

    public void setSeen(int seen) {
        this.seen = seen;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    
    
    
    
    
}
