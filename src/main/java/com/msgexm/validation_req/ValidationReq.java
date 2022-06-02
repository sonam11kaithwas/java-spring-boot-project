package com.msgexm.validation_req;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.hibernate.validator.internal.constraintvalidators.bv.EmailValidator;

import com.msgexm.demo_my_model.StudentData;

public class ValidationReq {
	public static String studentValidationForReq(StudentData studentData) {

		if(studentData.getsNm().isEmpty())  {
        	return "Enter student name";
        }else if(!Pattern.compile("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" 
    	        + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$").matcher(studentData.getsEmail()).matches()) {
       
        	return "Enter valid Email adderess";
        }else if(studentData.getsPhone().isEmpty()) {
        	return "Enter valid phone number";
        }else {
        	return "";
        }
		
//		return "Student data added Successfully.";
	}

}
