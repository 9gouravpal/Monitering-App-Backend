package com.todaytask.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.todaytask.entity.SignUp;
import com.todaytask.entity.TodayTask;
import com.todaytask.model.LoginResponse;
import com.todaytask.model.SignUpDto;
import com.todaytask.model.TodayTaskDto;

@Mapper(componentModel = "Spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface MapStruct {

	SignUp convertToEntity(SignUpDto dto);

	SignUpDto convertToDto(SignUp entitySignUp);

	TodayTask convertToEntity(TodayTaskDto dto);

	TodayTaskDto convertToDto(TodayTask task);

	LoginResponse SignUpToLoginResponseDTO(SignUp responseDataSignUp);

	List<TodayTaskDto> convertToDtoList(List<TodayTask> dataList);

}
