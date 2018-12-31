package com.example.demo.lua;

import javax.annotation.PostConstruct;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scripting.support.ResourceScriptSource;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class LuaDemo {
	private static DefaultRedisScript<Long> getRedisScript;
	static {
		getRedisScript = new DefaultRedisScript<Long>();
		getRedisScript.setResultType(Long.class);
		getRedisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("luademo.lua")));
	}
	
	public static void main(String[] args) {
		Jedis jedis = new Jedis("127.0.0.1", 6379);

		Object result = jedis.eval(getRedisScript.getScriptAsString());
		System.out.println("result : " + result);
		// 连接释放
	}
}
