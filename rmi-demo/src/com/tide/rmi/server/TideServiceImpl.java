package com.tide.rmi.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class TideServiceImpl extends UnicastRemoteObject implements TideService{

	protected TideServiceImpl() throws RemoteException {
		super();
	}

	@Override
	public String runTide(String val) {
		System.out.println("server==="+val);
		return "myserver test tide";
	}

}
