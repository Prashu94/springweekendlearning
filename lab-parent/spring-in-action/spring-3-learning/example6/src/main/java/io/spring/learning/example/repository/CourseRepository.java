package io.spring.learning.example.repository;

import io.spring.learning.example.model.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryRestResource(path = "courses")
public interface CourseRepository extends JpaRepository<Courses, Integer> {

    List<Courses> findByOrderByNameDesc();
    List<Courses> findByOrderByName();
}
