package io.spring.learning;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
public interface IngredientRepository extends CrudRepository<Ingredient, String> {
}
