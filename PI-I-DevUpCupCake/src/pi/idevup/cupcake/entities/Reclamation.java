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
public class Reclamation {
    private String description;
    private Date claimdate;
    private String userclaimed;
    private String userclaimer;

    public Reclamation() {
    }

    public Reclamation(String description, Date claimdate, String userclaimed, String userclaimer) {
        this.description = description;
        this.claimdate = claimdate;
        this.userclaimed = userclaimed;
        this.userclaimer = userclaimer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getClaimdate() {
        return claimdate;
    }

    public void setClaimdate(Date claimdate) {
        this.claimdate = claimdate;
    }

    public String getUserclaimed() {
        return userclaimed;
    }

    public void setUserclaimed(String userclaimed) {
        this.userclaimed = userclaimed;
    }

    public String getUserclaimer() {
        return userclaimer;
    }

    public void setUserclaimer(String userclaimer) {
        this.userclaimer = userclaimer;
    }

    @Override
    public String toString() {
        return "Reclamation{" + "description=" + description + ", claimdate=" + claimdate + ", userclaimed=" + userclaimed + ", userclaimer=" + userclaimer + '}';
    }
    
    
    
    
}
