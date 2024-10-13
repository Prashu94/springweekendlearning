package io.spring.learning.example.repository;

import io.spring.learning.example.model.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "contactRepository")
public interface ContactRepositoryJPA extends CrudRepository<Contact, Integer> {
    List<Contact> findByStatus(String status);
}
