package com.msgexm.demo_my_controller;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import javax.websocket.server.PathParam;
import javax.xml.crypto.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.msgexm.demo_my_model.StudentData;
import com.msgexm.demo_my_repositry.StudentDataRepository;
import com.msgexm.demo_my_service.StudentDataService;
import com.msgexm.res_payload.ResModel;

@RestController
@RequestMapping("/mystudent/")
public class StudentDataController {
	
	@Autowired
	private StudentDataService studentDataService; 



@PostMapping("addStudent")
public ResponseEntity<Object> addNewStudentData(@RequestBody StudentData studentData)
{
	return studentDataService.addNewStudent(studentData);
}

@GetMapping("all_student_data_list")
public ResponseEntity<Object> getAllStudentDataList()
{
	return studentDataService.getAllStydentDataList();
}



@GetMapping("student_data_by_id")
public ResponseEntity<Object> getStudentDataById(@RequestParam("id") Long id)
{
	return studentDataService.getStudentDataById(id);
}


@DeleteMapping("student_delete_by_id")
public ResponseEntity<Object>  getStudentDataDeleteById(@RequestParam Long id) {
 return studentDataService.getStudentDataDeleteById(id);
}

@PutMapping("update_student_data")
public ResponseEntity<Object> updateStudentDataById(@RequestBody StudentData studentData)
{
	return studentDataService.updateStudent( studentData);
}

@PostMapping("login_student")
public ResponseEntity<Object> studentLogin(@RequestParam String sEmail,@RequestParam String sPassword)
{
	return studentDataService.studentLogin( sEmail,sPassword);
}


@PostMapping("student_data_list")
public ResponseEntity<Object> studentDataList(@RequestParam String sNm)
{
	return studentDataService.fetachStudentDataByNm(sNm);
}


@GetMapping("current_date")
public ResponseEntity<Object>  fetchResult() {
	
    return studentDataService.getCurrentDateTime();
}
//@PostMapping("uploadFile")
//public ResponseEntity<Object> uploadFile(@RequestParam("file") MultipartFile file) {
////	return studentDataService.save(file);
//
//  String message = "";
//  try {
//	  studentDataService.save(file);
//    message = "Uploaded file successfully: " + file.getOriginalFilename();
////    return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
//    
//	return ResModel.generateResponse(message, HttpStatus.OK, "");
//
//  } catch (Exception e) {
//    message = "Could not upload the file: " + file.getOriginalFilename() + "!";
//	return ResModel.generateResponse(message, HttpStatus.OK, "");
//  }
//}



}
