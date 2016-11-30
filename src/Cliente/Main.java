/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import Interface.MessengerInterface;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

/**
 *
 * @author paulin
 */
public class Main {
    
    
    public static void displayMenu(){
        System.out.println("1- Create Account");
        System.out.println("2- Remove Account");
        System.out.println("3- Deposit");
        System.out.println("4- withdraw money in account");
        System.out.println("5- Tranfer");
        System.out.println("0- Sair");
        System.out.println("Opção: ");
    }
    
    public static void main(String[] args) throws RemoteException, NotBoundException{
        Registry registry = LocateRegistry.getRegistry(1234);
        MessengerInterface manager = (MessengerInterface) registry.lookup("manager");
        Scanner sc = new Scanner(System.in);
        String name;
        int account, account1, account2;
        double value;
        String op = "1";
        while(!op.equals("0")){
            displayMenu();
            op = sc.next();
            switch(op){
                case "1":
                    System.out.println("Create account");
                    System.out.println("Report name:");
                    name = sc.next();
                    System.out.println("Number account: ");
                    account1 = sc.nextInt();
                    if(manager.createAccount(name, account1)){
                        System.out.println("Create account success");
                    }else
                        System.out.println("Number account already exists");
                    break;
                case "2":
                    System.out.println("Remove account");
                    System.out.println("Report name ");
                    account = sc.nextInt();
                    if( manager.removeAccount(account)){
                        System.out.println("Account remove success");
                    }else
                        System.out.println("not Already exists number account");
                    break;
                case "3":
                    System.out.println("Deposit account");
                    System.out.println("Report account: ");
                    account = sc.nextInt();
                    System.out.println("Value deposit ? ");
                    value = sc.nextInt();
                    if(manager.deposit(account, value))
                        System.out.println("Deposit success");
                    else
                        System.out.println("not already exists account deposit" + "try again ! ");
                    break;
                case "4":
                    System.out.println("Sake account");
                    System.out.println("Report account: ");
                    account = sc.nextInt();
                    System.out.println("value sake: ");
                    value = sc.nextInt();
                    if(manager.withdraw(account, value))
                        System.out.println("Deposit success");
                    else
                        System.out.println("not already exists balance for withdraw in account" + ", try again");
                    break;
                case "5":
                    System.out.println("Transfer");
                    System.out.println("sake account?: ");
                    account1 = sc.nextInt();
                    System.out.println("tranfer account?");
                    account2 = sc.nextInt();
                    System.out.println("Value tranfer: ");
                    value = sc.nextInt();
                    if(manager.tranfer(account1, account2, value))
                        System.out.println("Tranfer sucess");
                    else
                        System.out.println("not already exists balance for tranfer account");
                    break;                    
            }            
        }
        System.out.println("Sistema Encerrado");
    }
}
