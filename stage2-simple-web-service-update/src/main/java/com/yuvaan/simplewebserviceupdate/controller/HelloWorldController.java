package com.yuvaan.simplewebserviceupdate.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/hello")
public class HelloWorldController {

	@GetMapping
	public String getMessage() {
		return "Executing GET : Hello World from SpringBoot";
	}

	@PostMapping
	public String postMessage() {
		return "Executing POST : Hello World from SpringBoot";
	}

	@PutMapping
	public String putMessage() {
		return "Executing PUT : Hello World from SpringBoot";
	}

	@DeleteMapping
	public String deleteMessage() {
		return "Executing DELETE : Hello World from SpringBoot";
	}

	@PatchMapping
	public String patchMessage() {
		return "Executing PATCH : Hello World from SpringBoot";
	}

}
