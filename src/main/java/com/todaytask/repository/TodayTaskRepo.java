package com.todaytask.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

import com.todaytask.entity.TodayTask;

@RestController
public interface TodayTaskRepo extends JpaRepository<TodayTask, Long> {

	List<TodayTask> findByEmpId(String empId);

	List<TodayTask> findByEmpIdAndDate(String empId, LocalDate now);

	List<TodayTask> findByDate(LocalDate now);

}
