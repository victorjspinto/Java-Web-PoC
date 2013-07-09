package br.com.viktor.javawebpoc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.viktor.javawebpoc.entity.Student;

@Repository
public interface StudentRepositoryContract extends JpaRepository<Student, Long> {
	
//	@Query("select * from student")
//	public Student findByCPF(String cpf);
	
	public Student findByName(String name);
}
