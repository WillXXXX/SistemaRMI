/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author paulin
 */
public class Main {
    
    
    public static void main(String[] args) throws RemoteException, MalformedURLException, AlreadyBoundException{
        //Cria o cara que disponibiliza objetos informando a porta
        //System.setProperty("java.rmi.server.hostname", "192.168.1.2");
        Registry registry = LocateRegistry.createRegistry(1100);
        //Disponibiliza o objeto remoto
        registry.bind("manager", Manager.getInstance());
    }
}
