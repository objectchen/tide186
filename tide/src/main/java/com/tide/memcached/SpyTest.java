package com.tide.memcached;

import java.io.IOException;
import java.net.InetSocketAddress;

import net.spy.memcached.MemcachedClient;

public class SpyTest {

	public static void main(String[] args) {
		MemcachedClient c=null;
		try {
			InetSocketAddress inet=new InetSocketAddress("127.0.0.1",11211);
			c = new MemcachedClient(inet);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Store a value (async) for one hour
		c.set("someKey", 3600, "123456");
		// Retrieve a value (synchronously).
		Object myObject = c.get("someKey");
		System.out.println(myObject);

	}

}
