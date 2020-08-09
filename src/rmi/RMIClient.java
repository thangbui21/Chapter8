/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

/**
 *
 * @author Thắng
 */
public class RMIClient {

    RMIInterface rmiServer;
    Registry registry;

    public RMIClient(String address, int port) {
        try {
            registry = LocateRegistry.getRegistry(address, port);
            rmiServer = (RMIInterface) (registry.lookup("rmiServer"));
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }

    public String cong(int x, int y) {
        try {
            return rmiServer.cong(x, y);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return "Không có dữ liệu";
    }

    public String tru(int x, int y) {
        try {
            return rmiServer.tru(x, y);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return "Không có dữ liệu";
    }

    public String Nhan(int x, int y) {
        try {
            return rmiServer.nhan(x, y);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return "Không có dữ liệu";
    }

    public String chia(int x, int y) {
        try {
            return rmiServer.chia(x, y);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return "Không có dữ liệu";
    }

    public String ucln(int x, int y) {
        try {
            return rmiServer.ucln(x, y);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return "Không có dữ liệu";
    }

    public void theEnd() {
        try {
            rmiServer.end();
        } catch (RemoteException e) {
            //e.printStackTrace();
        }

    }

    public static void main(String args[]) {
        RMIClient client = new RMIClient("localhost", 3232);
        Scanner scan = new Scanner(System.in);
        System.out.println("Nhap a: ");
        int a = scan.nextInt();
        System.out.println("Nhap b: ");
        int b = scan.nextInt();

        int c = 0;

        while (c != 6) {

            System.out.println("----------------MENU----------------");
            System.out.println("1. Cong.");
            System.out.println("2. Tru");
            System.out.println("3. Nhan");
            System.out.println("4. Chia");
            System.out.println("5. UCLN");
            System.out.print("Bạn chọn: ");
            c = scan.nextInt();
            switch (c) {
                case 1:
                    System.out.println(client.cong(a, b));
                    break;
                case 2:
                    System.out.println(client.tru(a, b));
                    break;
                case 3:
                    System.out.println(client.Nhan(a, b));
                    break;
                case 4:
                    System.out.println(client.chia(a, b));
                    break;
                case 5:
                    System.out.println(client.ucln(a, b));
                    break;
                default:
                    System.out.println("Bạn nhập chưa đúng");
            }
        }
    }
}
