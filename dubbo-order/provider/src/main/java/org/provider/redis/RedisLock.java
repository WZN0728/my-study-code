/**
 * All rights Reserved, Designed By MyCompany
 * @Title:  RedisLock.java
 * @Package org.provider.redis
 * @Copyright: 2018 All rights reserved.
 */
package org.provider.redis;

import java.util.List;
import java.util.UUID;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

/**
 * @ClassName: RedisLock
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: 吴停
 * @date: 2018年4月19日 下午12:37:01
 */
public class RedisLock {

	public static String getLock(String key, int timeout) throws Exception {
		Jedis jedis = RedisManager.getJedis();
		String value = UUID.randomUUID().toString();
		long endTimeout = System.currentTimeMillis() + timeout;
		while (System.currentTimeMillis() < endTimeout) {
			if (jedis.setnx(key, value) == 1) {
				// 设置过期时间
				jedis.expire(key, timeout);
				// 设置锁成功
				return "设置锁成功";
			}
			// 检测过期时间，在大于0时证明时间正在倒计时，如果小于0，证明没有设置超时时间
			if (jedis.ttl(key) == -1) {
				jedis.expire(key, timeout);
			}
		}
		return "设置锁失败";
	}

	public static boolean relaseLock(String key, String value) throws Exception {
		try {
			Jedis jedis = RedisManager.getJedis();
			while (true) {
				jedis.watch(key);// 监听当前的key,如果这个key一旦被修改或者删除，那么下面的事务就不执行了
				if (value.equals(jedis.get(key))) {// 判断当前的value与redis中的锁是同一个
					// 开启事务
					Transaction transaction = jedis.multi();
					// 删除事务中的key
					transaction.del(key);
					// 执行事务
					// reids里边执行事务是在一个队列里边按照来时的顺序挨个执行，所以事物返回的类型时list
					List<Object> list = transaction.exec();
					if (null == list) {
						continue;
					}
					return true;
				}
				jedis.unwatch();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static void main(String[] args) throws Exception {
		String lockMessage = RedisLock.getLock("abc", 5000);
		System.out.println(lockMessage);
	}

}
