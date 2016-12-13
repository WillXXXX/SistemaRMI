/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Interface.MessengerInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author paulin
 */
public final class Manager extends UnicastRemoteObject implements MessengerInterface{
    
    private static MessengerInterface instance = null;
    private static final long serialVersionUID = 1L;
    private List<Account> accounts;
    
    private Manager() throws RemoteException{
        this.accounts = new ArrayList<Account>();
    }
    
    @Override
    public boolean createAccount(String name, int account) throws RemoteException {
       for(Account a : accounts){
            if(a.getAccount() == account)
                return false;
        }
        Account newAccount = new Account(name, account);
        accounts.add(newAccount);
        return true;
    }

    @Override
    public boolean removeAccount(int account) throws RemoteException {
      for(Account a : accounts){
            if(a.getAccount() == account){
                accounts.remove(a);
                return true;
            }
        }        
        return false;
    }

    @Override
    public boolean withdraw(int account, double value) throws RemoteException {
       for(Account a : accounts){
            if(a.getAccount() == account)
                return a.withdraw(value);          
        }        
        return false; 
    }

    @Override
    public boolean tranfer(int account1, int account2, double value) throws RemoteException {
      for(Account a : accounts){
            if(a.getAccount() == account1){
                //if(a.getBalance() > value){
                    for(Account a2 : accounts){
                        if(a2.getAccount() == account2)
                            return a.tranfer(value, a2);
                    }
                //}
            }    
       }
        return false;
    }

    @Override
    public boolean deposit(int account, double value) throws RemoteException {
        for(Account a : accounts){
            if(a.getAccount() == account){
                a.deposit(value);
                return true;
            }
        }        
        return false; 
    }
    
    public static MessengerInterface getInstance() throws RemoteException{
        if(instance == null){
            instance = new Manager();
        }
        return instance;
    }
}
