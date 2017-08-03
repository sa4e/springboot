package cn.sa4e.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.sa4e.properties.GirlProperties;

@RestController
public class cupSizeController {

	@Autowired
	private GirlProperties girlProperties;
	
	//@RequestMapping(value= {"/hello","/hi"})
	@GetMapping("/say")
	public String say(@RequestParam(value="id",required=false,defaultValue="0") Integer myid) {
		return girlProperties.getCupSize() + "  " + myid;
	}
}
