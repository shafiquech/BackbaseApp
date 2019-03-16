package com.backbase.api.rest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/")
public class RestApiController {
	
	@RequestMapping(value = "test", method = RequestMethod.GET, produces = "application/json")
    public String test() {
        return "OK";
    }

	

}