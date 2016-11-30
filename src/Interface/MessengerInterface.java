/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author paulin
 */
public interface MessengerInterface extends Remote{
    
    boolean createAccount(String name, int account) throws RemoteException;
    boolean removeAccount(int account) throws RemoteException;
    boolean withdraw(int account, double value) throws RemoteException;
    boolean tranfer(int account1, int account2, double value) throws RemoteException;
    boolean deposit(int account, double value) throws RemoteException;
 }
