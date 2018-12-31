package com.example.demo.redis.config;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
@EnableCaching
public class RedisCacheConfiguration extends CachingConfigurerSupport {
	
	private String host = "127.0.0.1";
	private int port = 6379;
	private int timeout = 10000;
	private String password = "";
	

	@Bean
	public JedisPool createJedisPool() {
		JedisPoolConfig conf = new JedisPoolConfig();
		JedisPool pool = new JedisPool(conf, host, port, timeout);
		return pool;
	}
}
