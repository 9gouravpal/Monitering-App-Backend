package com.todaytask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todaytask.entity.SignUp;

@Repository
public interface SignUpRepo extends JpaRepository<SignUp, Long> {

	SignUp findByEmail(String string);

	SignUp findByEmpId(String empId);

}
