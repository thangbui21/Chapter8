/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Thắng
 */


public interface RMIInterface extends Remote {
    public String cong(int x, int y) throws RemoteException;
    public String tru(int x, int y) throws RemoteException;
    public String nhan(int x, int y) throws RemoteException;
    public String chia(int x, int y) throws RemoteException;
    public String ucln(int x, int y) throws RemoteException;
    public void end() throws RemoteException;
}