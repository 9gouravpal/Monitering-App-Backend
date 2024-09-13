package com.todaytask.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "singup")
public class SignUp {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_seq")
	@SequenceGenerator(name = "id_seq", sequenceName = "signup_sequence", allocationSize = 1)
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "mobile_no")
	private String mobileNo;

	@Column(unique = true)
	@Email
	@NotEmpty
	private String email;

	@Column(name = "password")
	private String password;

	@Column(name = "employee_id")
	private String empId;

	@CreationTimestamp
	@Column(name = "created_at")
	private LocalDate createAt;

	@UpdateTimestamp
	@Column(name = "modified_at")
	private LocalDate modifiedAt;

	@Column(name = "role")
	private String role;
}
