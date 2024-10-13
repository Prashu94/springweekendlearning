package io.spring.learning.example.repository;

import io.spring.learning.example.model.Holiday;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "holidaysRepository")
public interface HolidaysRepositoryJPA extends CrudRepository<Holiday, String> {
}
