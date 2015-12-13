package com.tide;

import java.util.Iterator;
import java.util.Set;

import redis.clients.jedis.Jedis;

public class Test2 {

	public static void main(String[] args) {
		Jedis jedis=JedisPools.getJedis();
		
//		jedis.set("rankingKey","0");
//		Long key=null;
//		for(int i=0;i<56;i++){
//			key=jedis.incrBy("rankingKey", 1);
//			jedis.zadd("rankingLog", key, key+"?");
//		}
		
//		System.out.println(jedis.get("rankingKey"));
//		
//		
//		
		//System.out.println("xxx:"+jedis.zremrangeByRank("rankingLog", 0,500));
//		
		System.out.println("zcard="+jedis.zcard("rankingLog"));
//		
//		Set<String> set=jedis.zrange("rankingLog", 0, -1);
//		for (String obj :set ) {
//			System.out.println(obj);
//		}
		
		
		Long count=jedis.zcard("rankingLog");
		Long start=0L;
		Long end=9L;
		for(int i=0;i<count;){
			start+=i;
			end+=i;
			if(end>count)end=count;
			System.out.println("start="+start+"---end="+end);
			Set<String> set=jedis.zrange("rankingLog", 0+i, 9+i);
			for (String obj :set ) {
				System.out.println(obj);
			}
			System.out.println("/////");
			i+=10;
		}
		
		System.out.println("xxx:"+jedis.zremrangeByRank("rankingLog", 0,count));
		System.out.println("zcard="+jedis.zcard("rankingLog"));

	}

}
