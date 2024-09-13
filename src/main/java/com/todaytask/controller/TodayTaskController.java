package com.todaytask.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.todaytask.model.TodayTaskDto;
import com.todaytask.services.TodayTaskServices;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("task")
@Tag(name = "Task-API")
public class TodayTaskController {

	private final TodayTaskServices services;

	public TodayTaskController(TodayTaskServices services) {
		super();
		this.services = services;
	}

	@PostMapping("/createTask")
	@Operation(summary = "to add your task ", description = "this api is basically to add employee new task")
	public ResponseEntity<Object> creatTask(@RequestBody TodayTaskDto taskDto) {
//		System.out.print(taskDto);
		TodayTaskDto tskDto = services.saveTask(taskDto);
//		System.out.print(taskDto);
		if (taskDto != null) {
			return new ResponseEntity<Object>(tskDto, HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>("task not saved !", HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/getByEmpId")
	@Operation(summary = "to get your task ", description = "this api is basically to get employee all task")
	public ResponseEntity<Object> getTask(@RequestParam("empId") String empId) {
		List<TodayTaskDto> result = services.getAlltaskofByempId(empId);
		if (result.isEmpty()) {
			return new ResponseEntity<Object>("error in getting task", HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<Object>(result, HttpStatus.OK);
		}
	}

	@GetMapping("/getByEmpID/todayDate")
	@Operation(summary = "to get your task of today", description = "this api is basically to get employee today task")
	public ResponseEntity<Object> getAlltaskByEmpIdAndTodayDate(@RequestParam("empId") String empId) {
		List<TodayTaskDto> dtos = services.getAlltaskByEmpIdAndTodayDate(empId);
		if (dtos.isEmpty()) {
			return new ResponseEntity<Object>("task not found!", HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<Object>(dtos, HttpStatus.OK);
		}
	}

	@GetMapping("/getByEmpId/gateBydate")
	@Operation(summary = "to get your task by date", description = "this api is basically get employee task ")
	public ResponseEntity<Object> getAlltaskofByempIdAndDate(@RequestParam("empId") String empId,
			@RequestParam("date") LocalDate date) {
		List<TodayTaskDto> dtos = services.getAlltaskofByempIdAndDate(empId, date);
		if (dtos.isEmpty()) {
			return new ResponseEntity<Object>("task not found!", HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<Object>(dtos, HttpStatus.OK);
		}
	}

	@GetMapping("/getTask/today")
	@Operation(summary = "to get your task by date", description = "this api is basically get employee task ")
	public ResponseEntity<Object> getAllTaskByToday() {
		List<TodayTaskDto> dtos = services.getAllTodayTask();
		if (dtos.isEmpty()) {
			return new ResponseEntity<>("task not found!", HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(dtos, HttpStatus.OK);
		}
	}
}
