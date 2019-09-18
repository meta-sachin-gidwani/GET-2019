package com.metacube.assignment.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.metacube.assignment.model.Student;

@Transactional
@Component
public class StudentDao {

	@Autowired
	private HibernateTemplate template;

	public List<Student> getAllStudent() {
		return template.loadAll(Student.class);
	}

	public void addStudent(Student student) {
		template.save(student);
	}

	public List<Student> isStudentExist(Student student) {
		return template.findByExample(student);
	}
}
