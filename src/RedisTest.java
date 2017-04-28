package com.redis.test;

import java.util.HashSet;
import java.util.Set;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.util.JedisClusterCRC16;

public class RedisTest {
	public static void main(String[] args) {
		String key = "1417";
	    Set<HostAndPort> jedisClusterNodes = new HashSet<HostAndPort>();
	    jedisClusterNodes.add(new HostAndPort("127.0.0.1", 7000));   
	    JedisCluster jc = new JedisCluster(jedisClusterNodes);

	    jc.setnx(key, "bar");
	    String value = jc.get(key);
	    System.out.println("key-"+key+" slot-"+JedisClusterCRC16.getSlot(key)+" value-"+value);

	    String key2 = "288";
	    jc.setnx(key2, "bar2");
	    String value2 = jc.get(key);
	    System.out.println("key-"+key2+" slot-"+JedisClusterCRC16.getSlot(key2)+" value-"+value2);
	}
}
