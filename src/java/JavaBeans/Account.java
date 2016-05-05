/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaBeans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Account {

    public enum AccountType {

        Checking, Savings
    }
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;
    private double balance;
    private String username;
    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private AccountType type;

    public Account() {
    }

    ;
    
    public AccountType getAccountType() {
        return type;
    }

    public void setAccountType(AccountType typeOfAccount) {
        this.type = typeOfAccount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double amt) {
        this.balance = amt;
    }

    public String getUsername() {
        return username;
    }

    public Account(double balance, String username, AccountType typeOfAccount) {
        this.balance = balance;
        this.username = username;
        this.type = typeOfAccount;
    }

    public void credit(double amt) {
        this.balance += amt;
    }

    public void debit(double amt) {

        if (this.balance - amt > 0) {
            this.balance -= amt;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Account(int id, AccountType type, double balance, String user) {
        this.id = id;
        this.type = type;
        this.balance = balance;
        this.username = user;
    }

}
