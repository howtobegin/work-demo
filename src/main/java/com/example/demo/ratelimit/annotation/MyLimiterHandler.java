package com.example.demo.ratelimit.annotation;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.stereotype.Component;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * 切面处理类
 * 
 * @author admin
 *
 */
@Aspect
@Component
public class MyLimiterHandler {

	private DefaultRedisScript<Long> getRedisScript;

	@Autowired
	private JedisPool jedisPool;

	@PostConstruct
	public void init() {
		getRedisScript = new DefaultRedisScript<Long>();
		getRedisScript.setResultType(Long.class);
		getRedisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("limit.lua")));
	}
	
	@Around("@annotation(limiter)")
	public Object around(ProceedingJoinPoint pjp, MyLimiter limiter) throws Throwable {
		System.out.println("around");
		Jedis jedis = jedisPool.getResource();
		String limitKey = limiter.key();
		long limitTimes = limiter.times();
		long limitExpire = limiter.expire();

		List<String> keys = new ArrayList<>();
		keys.add(limitKey);
		List<String> args = new ArrayList<>();
		args.add(limitTimes + "");
		args.add(limitExpire + "");

		Long result = (Long) jedis.eval(getRedisScript.getScriptAsString(), keys, args);
		// 连接释放
		jedisPool.returnResource(jedis);
		if (result == 0D) {
			System.out.println("limit");
			return "return limit";
		}

		return pjp.proceed();
	}

}
