package cn.sa4e.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import cn.sa4e.pojo.Girl;

public interface GirlRepository extends JpaRepository<Girl, Integer>{
	
	List<Girl> findGirlByCupSize(String cupSize);
}
