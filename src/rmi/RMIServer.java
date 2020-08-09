/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author Thắng
 */
public class RMIServer extends UnicastRemoteObject implements RMIInterface  {

    int thisPort = 3232;
    String thisAddress;
    Registry registry;

    public RMIServer() throws RemoteException {
        try {
            registry = LocateRegistry.createRegistry(thisPort);
            registry.rebind("rmiServer", this);
        } catch (RemoteException e) {
            throw e;
        }
    }


    public void stop(String str) throws Exception {
        System.out.println("Stopping rmi server.");
        UnicastRemoteObject.unexportObject(registry, true);
        System.exit(0);
    }

    public static void main(String args[]) throws RemoteException, Exception {
        new RMIServer();
    }

    @Override
    public void end() throws RemoteException {
        System.out.println("Stopping rmi server.");
        UnicastRemoteObject.unexportObject(registry, true);
        System.exit(0);
    }

    @Override
    public String cong(int x, int y) throws RemoteException {
        return x + " - " + y + " = " + (x + y);
    }

    @Override
    public String tru(int x, int y) throws RemoteException {
        return x + " - " + y + " = " + (x - y);
    }

    @Override
    public String nhan(int x, int y) throws RemoteException {
        return x + " - " + y + " = " + (x * y);
    }

    @Override
    public String chia(int x, int y) throws RemoteException {
        return x + " - " + y + " = " + (x / y);
    }

    @Override
    public String ucln(int x, int y) throws RemoteException {
        int uc = 1;
        for (int i = 1; i <= x && i <= y; i++) {
            if ((x%i == 0) && (y%i==0)) {
                uc = i;
            }
        }
        
        return "UCLN: "+uc;
    }

}