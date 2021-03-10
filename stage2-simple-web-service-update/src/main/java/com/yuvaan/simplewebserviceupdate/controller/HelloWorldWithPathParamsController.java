package com.yuvaan.simplewebserviceupdate.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v2/")
public class HelloWorldWithPathParamsController {

	@GetMapping("hello/{name}")
	public String helloMessage(@PathVariable final String name) {
		return String.format("Executing GET with @PathVariable : Hello %s from SpringBoot World!", name);
	}

	@GetMapping(value={"hello_user/user/","hello_user/user/{name}"})
	public String helloUseMessage(@PathVariable(required = false) final String name) {
		return String.format(
				"Executing GET with optional @PathVariable with name : Hello User %s from SpringBoot World!", name);
	}

	@GetMapping("welcome_locale")
	public String getLocalPersonalizedWelcomeMessage(//@RequestParam(required = false, defaultValue = "English") 
			@RequestParam("lang") String language,
			@RequestParam(required = false) String country) {
		return String.format(
				"Executing GET with optional @RequestParam with & without default value : Welcome message is displayed in %s laungage for  %s country. It can easily localized.",
				language, country);
	}

	@GetMapping("welcome/{name}")
	public String getMessage(@PathVariable String name,
			@RequestParam(defaultValue = "Have a nice day!") String customMessage) {
		return String.format("Executing GET with @PathVariable & @RequestParam: Welcome %s to SpringBoot World! \n %s",
				name, customMessage);
	}

	@GetMapping("welcome")
	public String getMessage(@RequestParam Map<String, String> allRequestParams) {
		String response;
		if (allRequestParams != null)
			response = allRequestParams.entrySet().toString();
		else
			response = null;
		return String.format("Executing GET with all @RequestParam: Request params are %s",
				response);
	}

}
