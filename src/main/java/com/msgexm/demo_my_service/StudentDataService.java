package com.msgexm.demo_my_service;

import java.nio.file.Path;
import java.util.Map;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.msgexm.demo_my_model.StudentData;

public interface StudentDataService {
	//ResponseEntity<User>
	public ResponseEntity<Object> addNewStudent(StudentData studentData) ;

	public ResponseEntity<Object> getAllStydentDataList();

	public ResponseEntity<Object> getStudentDataById(Long id);

	public ResponseEntity<Object> getStudentDataDeleteById(Long id);
	
	public ResponseEntity<Object> updateStudent(StudentData studentData) ;
	
	public ResponseEntity<Object> studentLogin(String sEmail,String sPassword ) ;
	
	public ResponseEntity<Object> fetachStudentDataByNm(String sNm) ;
	
	public ResponseEntity<Object> getCurrentDateTime();


//	public void init();
//	
//	public void save(MultipartFile file);
//	
//	public Resource load(String filename);
//	  
//	public void deleteAll();
//	  
//	public Stream<Path> loadAll();
}

