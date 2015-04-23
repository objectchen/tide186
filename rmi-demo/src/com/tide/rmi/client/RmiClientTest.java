package com.tide.rmi.client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import com.tide.rmi.server.TideService;

public class RmiClientTest {

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		TideService ts=(TideService)Naming.lookup("rmi://localhost:8088/tide");
		System.out.println(ts.runTide("client test.t"));
	}

}
