package com.todaytask.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.todaytask.entity.SignUp;
import com.todaytask.entity.TodayTask;
import com.todaytask.mapper.MapStruct;
import com.todaytask.model.TodayTaskDto;
import com.todaytask.repository.SignUpRepo;
import com.todaytask.repository.TodayTaskRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TodayTaskServices {

	private final TodayTaskRepo repo;
	private final MapStruct mapper;
	private final SignUpRepo repo2;
	// private final SignUpRepo signUpRepo;

	public TodayTaskServices(TodayTaskRepo repo, MapStruct mapper, SignUpRepo repo2) {
		super();
		this.repo = repo;
		this.mapper = mapper;
		this.repo2 = repo2;

	}

	public TodayTaskDto saveTask(TodayTaskDto dto) {

		try {
			SignUp signUp = repo2.findByEmpId(dto.getEmpId());
			if (dto.getEmpId().equals(signUp.getEmpId())) {
				TodayTask task = mapper.convertToEntity(dto);
				task = repo.saveAndFlush(task);
				return mapper.convertToDto(task);
			} else {
				throw new IllegalArgumentException("Error|Invalid EmpId!");
			}

		} catch (Exception e) {
			log.error("error in saving task information {}", e.getMessage());
			throw new IllegalArgumentException("Error| Interanl server error");
		}

	}

	public List<TodayTaskDto> getAlltaskofByempId(String empId) {
		List<TodayTaskDto> details = new ArrayList<>();
		try {
			List<TodayTask> dataList = repo.findByEmpId(empId);
			details = mapper.convertToDtoList(dataList);
		} catch (Exception e) {
			log.error("error", e.getMessage());
		}
		return details;
	}

	public List<TodayTaskDto> getAlltaskByEmpIdAndTodayDate(String empId) {
		List<TodayTaskDto> details = new ArrayList<>();
		try {
			List<TodayTask> dataList = repo.findByEmpIdAndDate(empId, LocalDate.now());
			details = mapper.convertToDtoList(dataList);
		} catch (Exception e) {
			log.error("error", e.getMessage());
		}
		return details;
	}

	public List<TodayTaskDto> getAlltaskofByempIdAndDate(String empId, LocalDate todayDate) {
		List<TodayTaskDto> details = new ArrayList<>();
		try {
			List<TodayTask> dataList = repo.findByEmpIdAndDate(empId, todayDate);
			details = mapper.convertToDtoList(dataList);
		} catch (Exception e) {
			log.error("error", e.getMessage());
		}
		return details;
	}

	public List<TodayTaskDto> getAllTodayTask() {
		List<TodayTaskDto> task = new ArrayList<>();
		try {
			List<TodayTask> tasks = repo.findByDate(LocalDate.now());
			task = mapper.convertToDtoList(tasks);
		} catch (Exception e) {
			log.error("error in fetching data!", e.getMessage());
		}
		return task;
	}
}
