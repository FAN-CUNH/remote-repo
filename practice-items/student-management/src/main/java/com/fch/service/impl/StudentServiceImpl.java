package com.fch.service.impl;

import com.fch.dao.StudentDao;
import com.fch.domain.Student;
import com.fch.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @packageName com.fch.service.impl
 * @ClassName StudentServiceImpl
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/7/4 19:06
 * @Version 1.0
 */

@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentDao studentDao;
    @Override
    public boolean insert(Student student) {
        return studentDao.insert(student);
    }

    @Override
    public boolean delete(Integer stuId) {
        return studentDao.delete(stuId);
    }

    @Override
    public boolean update(Student student) {
        return studentDao.update(student);
    }

    @Override
    public Student findById(Integer stuId) {
        return studentDao.findById(stuId);
    }

    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }
}
