package com.todaytask.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "today_task")
public class TodayTask {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "today_seq")
	@SequenceGenerator(name = "today_seq", sequenceName = "today_sequence", allocationSize = 1)
	@Column(name = "id")
	private Long id;
	@Column(name = "name")
	private String name;

	private String empId;

	@Column(name = "project_name")
	private String projectName;

	@Column(name = "assigen")
	private String assigen;

	@Column(name = "task")
	private String task;

	@CreationTimestamp
	private LocalDate date;

	@Column(name = "status")
	private String status;

}
