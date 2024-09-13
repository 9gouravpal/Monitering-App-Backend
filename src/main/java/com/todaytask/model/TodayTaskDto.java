package com.todaytask.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TodayTaskDto {

	private String name;
	private String empId;

	private String projectName;
	private String assigen;

	private String task;
//	private LocalDate date;

	private String status;
}
