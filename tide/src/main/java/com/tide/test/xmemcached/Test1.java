package com.tide.test.xmemcached;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.TimeoutException;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import net.rubyeye.xmemcached.exception.MemcachedException;
import net.rubyeye.xmemcached.utils.AddrUtil;

public class Test1 {

	public static void main(String[] args) {
		MemcachedClientBuilder builder = new XMemcachedClientBuilder(
				AddrUtil.getAddresses("localhost:11211"));
		MemcachedClient memcachedClient=null;
		try {
			builder.setConnectionPoolSize(15);
			memcachedClient = builder.build();
		} catch (IOException e1) {
			e1.printStackTrace();
			return;
		}
		try {
//			memcachedClient.set("hello", 0, "Hello,xmemcached");
//			String value = memcachedClient.get("hello");
//			System.out.println("hello=" + value);
//			memcachedClient.delete("hello");
//			value = memcachedClient.get("hello");
//			System.out.println("hello=" + value);
			
			String str=null;
			long start=System.currentTimeMillis();
			for(int i=0;i<1000000;i++){
				str=i+"-2d059bae-e5f1-4736-aebf-69d978d22e56b86486e6-82dd-42f2-81c2-abafe3faab06";
				//System.out.println(str);
				//memcachedClient.set(str, 0, "tenantid"+i);
				System.out.println(i+"-"+memcachedClient.get(str));
			}
			long end=System.currentTimeMillis();
			System.out.println((end-start)/1000/60);
			
		} catch (MemcachedException e) {
			System.err.println("MemcachedClient operation fail");
			e.printStackTrace();
		} catch (TimeoutException e) {
			System.err.println("MemcachedClient operation timeout");
			e.printStackTrace();
		} catch (InterruptedException e) {
			// ignore
		}
		try {
			// close memcached client
			memcachedClient.shutdown();
		} catch (IOException e) {
			System.err.println("Shutdown MemcachedClient fail");
			e.printStackTrace();
		}

	}

}
