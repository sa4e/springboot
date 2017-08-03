package cn.sa4e.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.sa4e.enums.ResultEnum;
import cn.sa4e.exception.GirlException;
import cn.sa4e.pojo.Girl;
import cn.sa4e.repository.GirlRepository;

@Service
public class GirlService {

	@Autowired
	private GirlRepository girlRepository;

	@Transactional
	public void insertTwo() {
		Girl girlA = new Girl();
		girlA.setCupSize("A");
		girlA.setAge(18);
		girlRepository.save(girlA);
	
		Girl girlB = new Girl();
		girlB.setCupSize("B");
		girlB.setAge(19);
		girlRepository.save(girlB);
	}
	
	public void getAgeById(Integer id) throws Exception {
		Girl girl = girlRepository.findOne(id);
		Integer age = girl.getAge();
		if (age <= 10) {//code 101
			throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
		} else if (age >10 && age < 16) {// code 102
			throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
		}
	}
	
	public Girl findAgeTest(Integer id) throws Exception{
		return girlRepository.findOne(id);
	}
	
}	
	
