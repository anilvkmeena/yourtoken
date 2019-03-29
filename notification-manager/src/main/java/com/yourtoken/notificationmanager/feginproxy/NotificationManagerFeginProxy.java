package com.yourtoken.notificationmanager.feginproxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.yourtoken.notificationmanager.bean.SimpleMailContent;

@FeignClient(name="notification-manager", url = "http://localhost:8081")
public interface NotificationManagerFeginProxy {
	
	@PostMapping("/sendmail")
	public String sendMail(@RequestBody SimpleMailContent simpleMailContent);
}
