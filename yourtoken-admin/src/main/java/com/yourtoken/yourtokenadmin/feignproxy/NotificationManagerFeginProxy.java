package com.yourtoken.yourtokenadmin.feignproxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.yourtoken.yourtokenadmin.model.SimpleMailContent;

@FeignClient(name="notification-manager", url = "http://localhost:8081")
public interface NotificationManagerFeginProxy {
	
	// feign client able to invoke other api
	//this method able to invoke sendmail api of notification-manger 
	//we no need to implement it spring will automatically do it for us
	@PostMapping("/sendmail")
	public void sendMail(@RequestBody SimpleMailContent simpleMailContent); 
}
