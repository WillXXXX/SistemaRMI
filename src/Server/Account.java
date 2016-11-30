/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

/**
 *
 * @author paulin
 */
public class Account {
    private int account; //conta
    private double balance, sake; //saldo, saque
    private double limit; //limite
    private String name; //nome
    
    public Account(String name, int account){
        this.name = name;
        this.account = account;
        balance = 0;
    }
    
    public void extract(){
        System.out.println("EXTRACT");
        System.out.println("Name: " + this.name);
        System.out.println("Number Account: " + this.account);
        System.out.println("Current Balance:" + this.balance);
        System.out.println("Withdrawals made today" + this.sake + "\n");
    }
    
    public boolean withdraw(double value){ //metodo sacar
        if(balance > value){
            balance  = balance - value;
            sake++;
            return true;
        }
        return false;
    }
    
    public boolean tranfer(double value, Account a2){
        if(value > 0){
            this.withdraw(value);
            a2.deposit(value);
            return true;
        }
        return false;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getSake() {
        return sake;
    }

    public void setSake(double sake) {
        this.sake = sake;
    }

    public double getLimit() {
        return limit;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void deposit(double value){
        balance = balance + value;
    }
}
