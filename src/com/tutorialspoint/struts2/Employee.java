package com.tutorialspoint.struts2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.IntRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;

@Results({ @Result(name = "success", location = "/success.jsp"), @Result(name = "input", location = "/index.jsp") })
public class Employee extends ActionSupport {
	private String name;
	private int age;

	// Logger
	private static final Logger LOGGER = LogManager.getLogger(Employee.class.getName());

	@Action(value = "/empinfo")
	@Override
	public String execute() {
		LOGGER.info("Executing employee ...");
		return SUCCESS;
	}

	@RequiredFieldValidator(message = "The name is required")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@IntRangeFieldValidator(message = "Age must be in between 28 and 65", min = "29", max = "65")
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
