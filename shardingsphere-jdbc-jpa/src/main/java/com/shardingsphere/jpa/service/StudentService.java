package com.shardingsphere.jpa.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.shardingsphere.common.CommonService;
import com.shardingsphere.jpa.dao.entity.Student;
import com.shardingsphere.jpa.dao.repository.StudentRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StudentService implements CommonService {

    private final StudentRepository studentRepository;

    @Override
    @Transactional
    public void initialize() {
        studentRepository.deleteAll();
    }
    
    @Override
    @Transactional
    public void testShardingInsert() {
        for (int i = 1; i <= 3; i++) {
        	try {
        		 Student student = Student.builder().id(i).age(10).name("test "+i).build();
                 studentRepository.save(student);
			} catch (Exception e) {
				e.printStackTrace();
			}
           
        }
    }
    
    @Override
    @Transactional
    public void testReadWriteSplit() {
        Student one = studentRepository.getOne(1);
        Student one2 = studentRepository.getOne(3);
        
        System.out.println("Fetch data for id : 1, "+one.toString());
        System.out.println("Fetch data for id : 3, "+one2.toString());
    }


}
