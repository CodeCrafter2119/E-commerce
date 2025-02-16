package com.DKB.springboot.Secondwebapp.welcome;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FlipRepository extends JpaRepository<FlipItems, Integer>{
 
	 List<FlipItems> findByUsername(String username);
}
