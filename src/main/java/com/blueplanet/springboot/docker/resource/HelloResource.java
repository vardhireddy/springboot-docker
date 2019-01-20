package com.blueplanet.springboot.docker.resource;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloResource{

   @RequestMapping("/greeting")
   public String getMessage(){
	   return "Hello world;";
   }
}