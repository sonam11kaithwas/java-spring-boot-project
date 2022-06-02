package com.msgexm.demo_my_repositry;

import java.util.List;
import java.util.Optional;

//import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;



import com.msgexm.demo_my_model.StudentData;

@Repository
public interface StudentDataRepository extends JpaRepository<StudentData, Long>{

	StudentData findBysEmail(String sEmail);

	
//	StudentData findByStEmailAndStPassword(String sEmail,String sPassword);

    @Query(value = "SELECT * FROM student_data  WHERE student_data.s_nm = :sNm",
            nativeQuery=true)
     List<StudentData> findBysNm(String sNm);

	
	   @Query(value = "select * from student_data  where student_data.s_email = :sEmail"
	   		+ " and student_data.s_password = :sPassword" , nativeQuery = true)
	   StudentData login(String  sEmail,String sPassword);




//	StudentData findByEmailAndPassword(String sEmail,String sPassword);

}
