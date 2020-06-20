/**
 * All rights Reserved, Designed By MyCompany
 * @Title:  LuaDemo.java
 * @Package org.provider.redis
 * @Copyright: 2018 All rights reserved.
 */
package org.provider.redis;

import java.util.ArrayList;
import java.util.List;

import redis.clients.jedis.Jedis;

/**
 * @ClassName: LuaDemo
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: 吴停
 * @date: 2018年4月19日 下午4:16:49
 */
public class LuaDemo {

	public static void main(String[] args) throws Exception {
		Jedis jedis = RedisManager.getJedis();
		String lua = "local num = redis.call('incr',KEYS[1])\r\n" + "if tonumber(num) == 1 then\r\n"
				+ "        redis.call('expire',KEYS[1],ARGV[1]);\r\n" + "        return 'true';\r\n"
				+ "elseif tonumber(num)>tonumber(ARGV[2]) then\r\n" + "        return 'false';\r\n" + "else\r\n"
				+ "        return 'true';\r\n" + "end";
		// 将当前的lua脚本load到缓存中
		String luaSha = jedis.scriptLoad(lua.toString());
		List<String> keys = new ArrayList<String>();
		keys.add("ip:limit:127.0.0.1");
		List<String> argss = new ArrayList<String>();
		argss.add("6000");
		argss.add("10");
		for (int i = 1; i < 12; i++) {
			Thread.sleep(2000);
			// evalsha是生成一个lua脚本的摘要
			Object obj = jedis.evalsha(luaSha, keys, argss);
			System.out.println("第" + i + "次执行得到的结果：" + obj);
		}
	}

}
