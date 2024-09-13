package com.todaytask.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todaytask.model.LoginResponse;
import com.todaytask.model.SignUpDto;
import com.todaytask.model.UserLoginDto;
import com.todaytask.services.SignUpServices;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("user")
@Tag(name = "Signup-API")
public class SignUpController {

	private final SignUpServices services;

	public SignUpController(SignUpServices services) {
		super();
		this.services = services;
	}

	@PostMapping("/signup")
	@Operation(summary = "to signup user ", description = "this api is basically to register new user")
	public ResponseEntity<Object> singUp(@RequestBody SignUpDto dto) {
		SignUpDto dto2 = services.signUp(dto);
		if (dto2 != null) {
			return new ResponseEntity<>(dto2, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("invalid email", HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/login")
	@Operation(summary = "to login user ", description = "this api is basically to login user ")

	public ResponseEntity<Object> userLogin(@RequestBody UserLoginDto dto) {
		LoginResponse dtoResponse = services.login(dto);
		if (dtoResponse != null) {
			return new ResponseEntity<Object>(dtoResponse, HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>("Email or password not matched!", HttpStatus.BAD_REQUEST);
		}
	}

}
