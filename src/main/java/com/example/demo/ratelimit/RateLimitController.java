package com.example.demo.ratelimit;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ratelimit.annotation.MyLimiter;
import com.google.common.util.concurrent.RateLimiter;

@RestController
@RequestMapping("ratelimit")
public class RateLimitController {
	
	//final RateLimiter limiter = RateLimiter.create(2d);
	
	@RequestMapping("pay")
	@MyLimiter(key = "paylimit", times = 10, expire = 3)
	public String pay() {
/*		if (!limiter.tryAcquire()) {
			System.out.println("pay limit");
			return "pay limit";
		}
		System.out.println("pay start");
*/		return "pay start";
	}
}
