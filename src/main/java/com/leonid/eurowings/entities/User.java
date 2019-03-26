package com.leonid.eurowings.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

/**
 * This is just a representation of the db table *
 */

@Entity
public class User {

    @Id
    private Long userid;
    private String username;
    private boolean status;
    private LocalDate subscriptiondate;

    public LocalDate getSubscriptiondate() {
        return subscriptiondate;
    }

    public void setSubscriptiondate(LocalDate subscriptiondate) {
        this.subscriptiondate = subscriptiondate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
