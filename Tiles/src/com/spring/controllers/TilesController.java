package com.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TilesController {
	
	@RequestMapping(value="/apacheTilesDemo", method=RequestMethod.GET)
	public String tilesDemo(){
		
		return "tiles";
	}
	
}
