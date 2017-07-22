package com.a0000006.teacher.service;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.a0000006.teacher.dao.TeacherDAO;

@Service("teacherService")
public class TeacherServiceImpl implements TeacherService {

	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="teacherDAO")
	private TeacherDAO teacherDAO;
}
