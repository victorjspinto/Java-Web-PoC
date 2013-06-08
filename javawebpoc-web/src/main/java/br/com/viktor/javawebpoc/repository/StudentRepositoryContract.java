package br.com.viktor.javawebpoc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.viktor.javawebpoc.entity.Student;

public interface StudentRepositoryContract extends JpaRepository<Student, Long> {

}
