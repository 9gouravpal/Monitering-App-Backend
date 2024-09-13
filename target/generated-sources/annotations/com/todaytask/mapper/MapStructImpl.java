package com.todaytask.mapper;

import com.todaytask.entity.SignUp;
import com.todaytask.entity.TodayTask;
import com.todaytask.model.LoginResponse;
import com.todaytask.model.SignUpDto;
import com.todaytask.model.TodayTaskDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-13T12:06:11+0530",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.38.0.v20240524-2033, environment: Java 21.0.3 (Eclipse Adoptium)"
)
@Component
public class MapStructImpl implements MapStruct {

    @Override
    public SignUp convertToEntity(SignUpDto dto) {
        if ( dto == null ) {
            return null;
        }

        SignUp signUp = new SignUp();

        signUp.setEmail( dto.getEmail() );
        signUp.setMobileNo( dto.getMobileNo() );
        signUp.setName( dto.getName() );
        signUp.setPassword( dto.getPassword() );
        signUp.setRole( dto.getRole() );

        return signUp;
    }

    @Override
    public SignUpDto convertToDto(SignUp entitySignUp) {
        if ( entitySignUp == null ) {
            return null;
        }

        SignUpDto signUpDto = new SignUpDto();

        signUpDto.setEmail( entitySignUp.getEmail() );
        signUpDto.setMobileNo( entitySignUp.getMobileNo() );
        signUpDto.setName( entitySignUp.getName() );
        signUpDto.setPassword( entitySignUp.getPassword() );
        signUpDto.setRole( entitySignUp.getRole() );

        return signUpDto;
    }

    @Override
    public TodayTask convertToEntity(TodayTaskDto dto) {
        if ( dto == null ) {
            return null;
        }

        TodayTask todayTask = new TodayTask();

        todayTask.setAssigen( dto.getAssigen() );
        todayTask.setEmpId( dto.getEmpId() );
        todayTask.setName( dto.getName() );
        todayTask.setProjectName( dto.getProjectName() );
        todayTask.setStatus( dto.getStatus() );
        todayTask.setTask( dto.getTask() );

        return todayTask;
    }

    @Override
    public TodayTaskDto convertToDto(TodayTask task) {
        if ( task == null ) {
            return null;
        }

        TodayTaskDto todayTaskDto = new TodayTaskDto();

        todayTaskDto.setAssigen( task.getAssigen() );
        todayTaskDto.setEmpId( task.getEmpId() );
        todayTaskDto.setName( task.getName() );
        todayTaskDto.setProjectName( task.getProjectName() );
        todayTaskDto.setStatus( task.getStatus() );
        todayTaskDto.setTask( task.getTask() );

        return todayTaskDto;
    }

    @Override
    public LoginResponse SignUpToLoginResponseDTO(SignUp responseDataSignUp) {
        if ( responseDataSignUp == null ) {
            return null;
        }

        LoginResponse loginResponse = new LoginResponse();

        loginResponse.setEmail( responseDataSignUp.getEmail() );
        loginResponse.setEmpId( responseDataSignUp.getEmpId() );

        return loginResponse;
    }

    @Override
    public List<TodayTaskDto> convertToDtoList(List<TodayTask> dataList) {
        if ( dataList == null ) {
            return null;
        }

        List<TodayTaskDto> list = new ArrayList<TodayTaskDto>( dataList.size() );
        for ( TodayTask todayTask : dataList ) {
            list.add( convertToDto( todayTask ) );
        }

        return list;
    }
}
