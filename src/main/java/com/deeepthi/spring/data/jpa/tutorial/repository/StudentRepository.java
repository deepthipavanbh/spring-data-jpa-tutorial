package com.deeepthi.spring.data.jpa.tutorial.repository;

import com.deeepthi.spring.data.jpa.tutorial.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface StudentRepository  extends JpaRepository<Student,Long> {
    public List<Student> findByFirstName(String firstName);

    public List<Student> findByFirstNameContaining(String name);

    public List<Student> findByLastNameNotNull();

    public List<Student> findByGuardianName(String guardianName);

    public List<Student> findByFirstNameAndLastName(String firstName, String lastName);

    //JPQL(JpQl querries are based on the classes that we created not on the table
    @Query("select s.firstName from Student s where s.emailId=?1")
    public String getStudentFirstNameByEmailAddress(String emailId);

    //Native Querry
    @Query(
            value = "select * from tbl_student s where s.email_address = ?1",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNative(String emailId);


    //Native Named Param
    @Query(
            value = "select * from tbl_student s where s.email_address = :emailId",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNativeParam(@Param("emailId") String emailId);

    @Modifying
    @Transactional
    @Query(
            value = "update tbl_student set first_name= ?1 where email_address=?2",
            nativeQuery = true
    )
    int updateStudentNameByEmailId(String firstName, String emailId);

}


