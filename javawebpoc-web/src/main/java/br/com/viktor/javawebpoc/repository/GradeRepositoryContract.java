package br.com.viktor.javawebpoc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.viktor.javawebpoc.entity.Grade;
import br.com.viktor.javawebpoc.entity.Student;

@Repository
public interface GradeRepositoryContract extends JpaRepository<Grade, Long> {
	public List<Grade> findAllByStudent(Student student);
}
