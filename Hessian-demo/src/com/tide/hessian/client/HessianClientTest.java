package com.tide.hessian.client;

import java.net.MalformedURLException;

import com.caucho.hessian.client.HessianProxyFactory;
import com.tide.hessian.server.HessianService;

public class HessianClientTest {

	public static void main(String[] args) {
		
		HessianProxyFactory hpf=new HessianProxyFactory();
		try {
			HessianService hs=(HessianService)hpf.create(HessianService.class, "http://localhost:8080/Hessian-demo/aa");
			hs.runHession("hessian client test..t");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
