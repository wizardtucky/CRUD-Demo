package com.example.demo.student.repositories;

import com.example.demo.student.model.President;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassPresidentRepository extends JpaRepository<President, Long> {

}
