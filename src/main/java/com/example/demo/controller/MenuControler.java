package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/menu")

public class MenuControler {

	// http://localhost:8080/menu/botones
	@GetMapping("/botones")
	public String vistaMenu() {
		return "vistaMenuGeneral";
	}

}
