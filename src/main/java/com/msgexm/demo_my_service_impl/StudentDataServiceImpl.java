package com.msgexm.demo_my_service_impl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.msgexm.demo_my_model.StudentData;
import com.msgexm.demo_my_repositry.StudentDataRepository;
import com.msgexm.demo_my_service.StudentDataService;
import com.msgexm.res_payload.ResModel;
import com.msgexm.validation_req.ValidationReq;

@Service
public class StudentDataServiceImpl implements StudentDataService	  {
	  private final Path root = Paths.get("uploads");

	@Autowired 
	StudentDataRepository studentDataRepository;
	
	
	
	
	/*Add new Student Data in Data Base*/

	@Override
	public ResponseEntity<Object> getCurrentDateTime() {
		Calendar cal = Calendar.getInstance();
    	Date  date=cal.getTime();
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-DD HH:mm:ss a");
    String formattedDate=dateFormat.format(date);
	return ResModel.generateResponse("", HttpStatus.OK, formattedDate);

	}



	@Override
	public ResponseEntity<Object> addNewStudent(StudentData studentData) {
        try {
        	String msg=ValidationReq.studentValidationForReq(studentData);
        	if(msg.isEmpty()) {
     
        		
           StudentData studentExitModel = studentDataRepository.findBysEmail( studentData.getsEmail());
                if (studentExitModel==null) {
                	studentDataRepository.save(studentData);
                	return ResModel.generateResponse("Student data added Successfully!", HttpStatus.OK, studentData);
                }
            	else {
                	return ResModel.generateResponse("Record already exit", HttpStatus.OK, "");
                }
        	}else {
            	return ResModel.generateResponse(msg, HttpStatus.BAD_REQUEST, null);
        	}
        } catch (Exception e) {
            return ResModel.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, e.getMessage());
        }


	}

	
	
//	@Override
//	public void init() {
//		try {
//		      Files.createDirectory(root);
//		    } catch (IOException e) {
//		      throw new RuntimeException("Could not initialize folder for upload!");
//		    }		
//	}
//
//
//
//	@Override
//	public void save(MultipartFile file) {
//		try {
//		      Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
//		    } catch (Exception e) {
//		      throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
//		    }		
//	}
//
//
//
//	@Override
//	public Resource load(String filename) {
//		try {
//		      Path file = root.resolve(filename);
//		      Resource resource = new UrlResource(file.toUri());
//		      if (resource.exists() || resource.isReadable()) {
//		        return resource;
//		      } else {
//		        throw new RuntimeException("Could not read the file!");
//		      }
//		    } catch (MalformedURLException e) {
//		      throw new RuntimeException("Error: " + e.getMessage());
//		    }	}
//
//
//
//	@Override
//	public void deleteAll() {
//	    FileSystemUtils.deleteRecursively(root.toFile());
//		// TODO Auto-generated method stub
//		
//	}
//
//
//
//	@Override
//	public Stream<Path> loadAll() {
//		try {
//		      return Files.walk(this.root, 1).filter(path -> !path.equals(this.root)).map(this.root::relativize);
//		    } catch (IOException e) {
//		      throw new RuntimeException("Could not load the files!");
//		    }
//	}
//


	/*Get All  Student Data LIST.........*/
	@Override
	public ResponseEntity<Object> getAllStydentDataList() {
		   try {
	     
   	return ResModel.generateResponse("Student data found", HttpStatus.OK,          studentDataRepository.findAll());
	        	
	        } catch (Exception e) {
	            return ResModel.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, e.getMessage());
	        }
	}


	/*Get Student Data By Student Id.........*/
	@Override
	public ResponseEntity<Object> getStudentDataById(Long id) {
		// TODO Auto-generated method stub
        try {
        	Optional<StudentData> studentExitModel = studentDataRepository.findById(id);
            if (studentExitModel.isPresent()) {
            	return ResModel.generateResponse("Student data found", HttpStatus.OK,     
               			studentDataRepository.findById(id).get());
            }
        	else {
            	return ResModel.generateResponse("Student data not found", HttpStatus.OK, "");
            }
           	
        	 	
        	        } catch (Exception e) {
        	            return ResModel.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, e.getMessage());
        	        }
	}

	
	/*Delete Student Data By Id.........*/

	@Override
	public ResponseEntity<Object> getStudentDataDeleteById(Long id) {

try {
	Optional<StudentData> studentExitModel = studentDataRepository.findById(id);
    if (studentExitModel.isPresent()) {
    	studentDataRepository.deleteById(id);
    	return ResModel.generateResponse("Student data deleted", HttpStatus.OK, "");
    }else {
    	return ResModel.generateResponse("Student data not found", HttpStatus.OK, "");
    }

}catch (Exception e) {
	return ResModel.generateResponse(e.getMessage(),HttpStatus.MULTI_STATUS, e.getMessage());
	// TODO: handle exception
}
	}


	
	
	/*UPDATE Student Data .........*/

	@Override
	public ResponseEntity<Object> updateStudent( StudentData studentData) {
		// TODO Auto-generated method stub

	    Optional<StudentData> studentExitModel = studentDataRepository.findById(studentData.getsId());
	    if (studentExitModel.isPresent()) {    	
	  	return ResModel.generateResponse("Student data updated Successfully!", HttpStatus.OK, studentDataRepository.save(studentData));

	    } else {
		  	return ResModel.generateResponse("Student data not found", HttpStatus.OK, "");
	    }

		
	}



	@Override
	public ResponseEntity<Object> studentLogin(String sEmail, String sPassword) {
        StudentData studentExitModel = studentDataRepository.login( sEmail,sPassword);
        if (studentExitModel==null) {
        	return ResModel.generateResponse("Login data Not Found", HttpStatus.OK, "");
        }
    	else if(studentExitModel.getsEmail().equalsIgnoreCase(sEmail)&&
    			studentExitModel.getsPassword().equalsIgnoreCase(sPassword)){
        	return ResModel.generateResponse("Login Successfully.", HttpStatus.OK, "");
        }else {
		  	return ResModel.generateResponse("Login data not found", HttpStatus.OK, "");
	    }	}



	@Override
	public ResponseEntity<Object> fetachStudentDataByNm(String sNm) {
		List<StudentData>  studentModelList = studentDataRepository.findBysNm(sNm);
		if(studentModelList!=null) {
		
		String str=new Gson().toJson(studentModelList);
    	return ResModel.generateResponse("", HttpStatus.OK, studentModelList);
		}else {
		  	return ResModel.generateResponse("Data not found", HttpStatus.OK, "");

		}
	}
	
	
	
	

}
