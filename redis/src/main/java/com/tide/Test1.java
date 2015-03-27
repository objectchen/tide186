package com.tide;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class Test1 {

	public static void main(String[] args) {
		//Jedis jedis = new Jedis("192.168.40.211");
		
		// 池基本配置
//		JedisPoolConfig config = new JedisPoolConfig();
//		//config.setMaxActive(20);
//		config.setMaxTotal(30);
//		config.setMaxIdle(30);
//		config.setMaxWaitMillis(2000);
//		config.setTestOnBorrow(false);
//
//		JedisPool jedisPool = new JedisPool(config, "192.168.40.211", 6379);
		//System.out.println(jedisPool.isClosed());
//		Jedis jedis1=JedisPools.getJedis();
//		System.out.println(jedis1.isConnected());
//		Jedis jedis2=JedisPools.getJedis();
//		System.out.println(jedis2.isConnected());
		Jedis jedis=null;
		try{
			jedis=JedisPools.getJedis();
		}catch(Exception e){
			System.out.println("////");
		}finally{
			if(jedis!=null){
				jedis.close();
			}
		}
		System.out.println(jedis.isConnected());
		
		String str=null;
		long start=System.currentTimeMillis();
		for(int i=0;i<1000000;i++){
			str=i+"-2d059bae-e5f1-4736-aebf-69d978d22e56b86486e6-82dd-42f2-81c2-abafe3faab06";
			//System.out.println(str);
			jedis.set(str, "tenantid"+i);
			System.out.println(i+"-"+jedis.get(str));
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		//System.out.println(jedis.get("sss919909-2d059bae-e5f1-4736-aebf-69d978d22e56b86486e6-82dd-42f2-81c2-abafe3faab06")==null);
		long end=System.currentTimeMillis();
		System.out.println((end-start)/1000/60);
		
		
	}

}
