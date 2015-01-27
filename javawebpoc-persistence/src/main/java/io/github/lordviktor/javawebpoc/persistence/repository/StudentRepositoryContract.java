package io.github.lordviktor.javawebpoc.persistence.repository;

import io.github.lordviktor.javawebpoc.persistence.entity.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepositoryContract extends JpaRepository<Student, Long> {
	
//	@Query("select * from student")
//	public Student findByCPF(String cpf);
	
	public Student findByName(String name);
}
