package com.deeepthi.spring.data.jpa.tutorial.repository;

import com.deeepthi.spring.data.jpa.tutorial.entity.Course;
import com.deeepthi.spring.data.jpa.tutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

       @Autowired
       TeacherRepository teacherRepository;


       @Test
       public void saveTeacher(){

           Course courseJava = Course.builder()
                          .title("Java")
                          .credit(5)
                          .build();

           Course courseTesting =
                           Course.builder()
                                   .title("Testing")
                                   .credit(4)
                                   .build();

                   Teacher teacher = Teacher.builder()
                           .firstName("Rani")
                           .lastName("Mara")
                           .courseList(List.of(courseJava,courseTesting))
                           .build();
                   teacherRepository.save(teacher);
       }

}