package com.tide.rmi.server;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class TideServerMain {

	public static void main(String[] args) {
		try {
			LocateRegistry.createRegistry(8088);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TideService tsi=null;
		try {
			tsi = new TideServiceImpl();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			try {
				Naming.rebind("rmi://localhost:8088/tide", tsi);
			} catch (RemoteException e) {
				e.printStackTrace();
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		System.out.println("注册完毕");
	}

}
