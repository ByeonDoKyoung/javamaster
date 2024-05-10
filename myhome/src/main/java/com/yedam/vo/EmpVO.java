package com.yedam.vo;

import java.util.Date;
// lombok: 이클립스에 설치, 라이브러리 필요

import lombok.Data;

// lombok: 이클립스에 설치
@Data
public class EmpVO {
	private int empNo;   // 오라클(emp_no) : 자바(empNo)
	private String empName;
	private String empPhone;
	private String email;
	private String hireDate; // 2020-05-01
	private int salary;
}
