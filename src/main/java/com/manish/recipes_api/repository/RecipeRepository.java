package com.manish.recipes_api.repository;

import com.manish.recipes_api.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    public List<Recipe> findByNameContainingIgnoreCaseOrCuisineContainingIgnoreCase(String name, String cuisine);
}
