package com.todaytask.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SignUpDto {

	private String name;
	private String mobileNo;
	private String email;
	private String password;
	private String role;

}
