package com.yourtoken.yourtokenadmin.feignproxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "yourtoken-admin",url = "http://localhost:8087")
public interface YtAdminFeginProxy {

	@PostMapping("otp")
	public void otpGeneration(@RequestParam String emailId);
}
