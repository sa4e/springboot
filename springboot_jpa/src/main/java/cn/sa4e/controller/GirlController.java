package cn.sa4e.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.sa4e.pojo.Girl;
import cn.sa4e.pojo.Result;
import cn.sa4e.repository.GirlRepository;
import cn.sa4e.service.GirlService;
import cn.sa4e.utils.ResultUtils;

/**
 * 
 * @author Administrator
 *
 */
@RestController
public class GirlController {
	
	@Autowired
	private GirlRepository girlRepository;
	@Autowired
	private GirlService girlService;
	
	@GetMapping("/girls")
	public List<Girl> getList() {
		return girlRepository.findAll();
	}
	
	@PostMapping("/girls")
	public Result<Girl> addGirl(@Valid Girl girl,BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			String message = bindingResult.getFieldError().getDefaultMessage();
			return ResultUtils.error(1, message);
		}
		
		girl.setCupSize(girl.getCupSize());
		girl.setAge(girl.getAge());
		return ResultUtils.success(girlRepository.save(girl));
	}
	
	@GetMapping("/girls/{id}")
	public Girl getGirlById(@PathVariable("id") Integer id) {
		return girlRepository.findOne(id);
	}
	
	@PutMapping("/girls/{id}")
	public Girl update(@PathVariable("id") Integer id,
					   @RequestParam("cupSize") String cupSize,
					   @RequestParam("age") Integer age) {
		Girl girl = new Girl();
		girl.setId(id);
		girl.setCupSize(cupSize);
		girl.setAge(age);
		return girlRepository.save(girl);
	}
	
	@DeleteMapping("/girls/{id}")
	public String delGirlById(@PathVariable("id") Integer id) {
		try {
			girlRepository.delete(id);
			return "删除成功!";
		} catch (Exception e) {
			return "删除失败!";
		}
	}
	
	@GetMapping("/girls/cupsize/{cupsize}")
	public List<Girl> findGirlByCupSize(@PathVariable("cupsize") String cupSize) {
		return girlRepository.findGirlByCupSize(cupSize);
	}
	
	@GetMapping("/insertTwo")
	public void insertTwo() {
		girlService.insertTwo();
	}
	
	@GetMapping("/girls/age/{id}")
	public void getAge(@PathVariable("id") Integer id) throws Exception {
		girlService.getAgeById(id);
	}
}
























