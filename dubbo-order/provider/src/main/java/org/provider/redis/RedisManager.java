/**
 * All rights Reserved, Designed By MyCompany
 * @Title:  RedisManager.java
 * @Package org.provider.redis
 * @Copyright: 2018 All rights reserved.
 */
package org.provider.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @ClassName: RedisManager
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: 吴停
 * @date: 2018年4月19日 下午12:28:58
 */
public class RedisManager {

	private static JedisPool jedisPool;

	static {
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		jedisPoolConfig.setMaxTotal(20);
		jedisPoolConfig.setMaxIdle(10);
		jedisPool = new JedisPool(jedisPoolConfig, "192.168.10.131", 6379);
	}

	public static Jedis getJedis() throws Exception {
		Jedis jedis = null;
		try {
			if (null != jedisPool) {
				System.out.println("获取链接成功!!!");
				jedis = jedisPool.getResource();
			}
		} catch (Exception e) {
			throw new Exception("Jedis pool was not init!!!");
		} finally {
			//jedisPool.close();
		}
		return jedis;
	}

	public static void main(String[] args) throws Exception {
		getJedis();
	}

}
