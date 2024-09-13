package com.todaytask.services;

import org.springframework.stereotype.Service;

import com.todaytask.entity.SignUp;
import com.todaytask.mapper.MapStruct;
import com.todaytask.model.LoginResponse;
import com.todaytask.model.SignUpDto;
import com.todaytask.model.UserLoginDto;
import com.todaytask.repository.SignUpRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j

public class SignUpServices {

	private final SignUpRepo repo;
	private final MapStruct mapper;

	public SignUpServices(SignUpRepo repo, MapStruct mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}

	public SignUpDto signUp(SignUpDto dto) {
		try {
			SignUp entity = mapper.convertToEntity(dto);
			entity.setEmpId(generateId(entity.getName()));
			entity = repo.saveAndFlush(entity);

			return mapper.convertToDto(entity);
		} catch (Exception e) {
			log.error("error in saving data {}", e.getMessage());
			return null;
		}
	}

	public String generateId(String name) {
		return name.toUpperCase() + repo.count();
	}

	public LoginResponse login(UserLoginDto dto) {
		try {
			SignUp responseDataSignUp = this.repo.findByEmail(dto.getEmail());
			if (responseDataSignUp == null) {
				throw new IllegalArgumentException("Eroor| unable to find Email");
			}
			if (!dto.getPassword().equals(responseDataSignUp.getPassword())) {
				throw new IllegalArgumentException("Eroor| password not match");
			}
			return this.mapper.SignUpToLoginResponseDTO(responseDataSignUp);
		} catch (Exception e) {
			throw new IllegalArgumentException("Error| Invalid email");
		}
	}
}
