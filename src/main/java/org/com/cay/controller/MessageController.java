package org.com.cay.controller;

import org.com.cay.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/message")
public class MessageController {

	@Autowired
	private IMessageService messageService;

	@RequestMapping("/send")
	@ResponseBody
	public String sendMessage(String message) {

		for (int i = 1; i <= 100; ++i) {
			messageService.sendMessage(message + " ========> " + i);
		}
		return message;
	}
}
