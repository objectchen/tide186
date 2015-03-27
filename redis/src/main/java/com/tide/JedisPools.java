package com.tide;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisPools {
	
	private static JedisPool jedisPool=null;
	
	static{
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxIdle(5);
		config.setMaxWaitMillis(2000);
		config.setTestOnBorrow(false);
		jedisPool = new JedisPool(config, "192.168.40.211", 6379);
	}
	
	public static Jedis getJedis(){
		return jedisPool.getResource();
	}
	
	
}
