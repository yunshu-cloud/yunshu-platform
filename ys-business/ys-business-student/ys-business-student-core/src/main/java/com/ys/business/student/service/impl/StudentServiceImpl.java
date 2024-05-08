package com.ys.business.student.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ys.business.student.service.StudentService;
import com.ys.data.entity.Student;
import com.ys.data.mapper.StudentDao;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl extends ServiceImpl<StudentDao, Student> implements StudentService {

}
