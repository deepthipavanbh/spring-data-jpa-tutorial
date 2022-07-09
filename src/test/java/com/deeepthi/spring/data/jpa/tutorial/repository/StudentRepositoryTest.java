package com.deeepthi.spring.data.jpa.tutorial.repository;

import com.deeepthi.spring.data.jpa.tutorial.entity.Guardian;
import com.deeepthi.spring.data.jpa.tutorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest

class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
     public void saveStudent(){

         Student student= Student.builder()
                             .emailId("phanideepthi.sangani@gmail.com")
                             .firstName("Deepthi")
                             .lastName("Sangani")
                             //.guardianName("Subba Reddy")
                             //.guardianEmail("subbareddy.sangani@gmail.com")
                             //.guardianMobile("9898989898")
                             .build();
                         studentRepository.save(student);


     }
   @Test
     public void saveStudentWithGuardian(){

          Guardian guardian = Guardian.builder()
                  .email("pavan.bhimireddy@gmail.com")
                  .name("Pavan")
                 .mobile("6302687853")
                  .build();
        Student student= Student.builder()
                .firstName("Tejasvi")
                .emailId("tejasvi.bhimireddy@gmail.com")
                .lastName("Bhimi Reddy")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
     }
     @Test
     public void printAllStudents(){
           List<Student> studentList=
                   studentRepository.findAll();
           System.out.println("student List "+ studentList);


     }
     @Test
     public void printStudentByFirstName(){

       List<Student> students = studentRepository.findByFirstName("Deepthi");
        System.out.println("Students = " +students);
     }

     @Test
       public void printStudentByFirstNameContaining(){

           List<Student> students = studentRepository.findByFirstNameContaining("vi");
           System.out.println("Students = " +students);

       }
       @Test
       public void printStudentBasedOnGuardianName(){

           List<Student> students =studentRepository.findByGuardianName("Pavan");
           System.out.println("students :"+students);
       }
       @Test
       public void printStudentBasedOnFirstNameAndLastName(){

        List<Student> students = studentRepository.findByFirstNameAndLastName("Deepthi","Sangani");
        System.out.println("STudents :"+students);
       }

       @Test
       public void printNameByEmailAddress(){

        String firstName =studentRepository.getStudentFirstNameByEmailAddress("tejasvi.bhimireddy@gmail.com");
        System.out.println(firstName);
       }

       @Test
       public void printStudentByEmailAddressNative(){

         Student student = studentRepository.getStudentByEmailAddressNative("phanideepthi.sangani@gmail.com");
         System.out.println("Students .."+student);

       }


    @Test
    public void printStudentByEmailAddressNativeParam(){

        Student student = studentRepository.getStudentByEmailAddressNativeParam("phanideepthi.sangani@gmail.com");
        System.out.println("Students .."+student);

    }
    @Test
    public void updateStudentNameByEmailIdTest(){

       int test= studentRepository.updateStudentNameByEmailId(
                    "Phani Deepthi",
                     "phanideepthi.sangani@gmail.com");
       System.out.println(test);

    }
}