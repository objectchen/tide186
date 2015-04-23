package com.tide.rmi.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TideService extends Remote {

	public String runTide(String val)throws RemoteException;
}
