package com.manish.recipes_api.service;

import com.manish.recipes_api.entity.Recipe;
import com.manish.recipes_api.exception.RecipeNotFoundException;
import com.manish.recipes_api.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class RecipeService {

    @Autowired
    RecipeRepository recipeRepository;

    public Recipe getRecipeById(Long id){
        Optional<Recipe> recipes =recipeRepository.findById(id);
        if(recipes.isPresent()){
           Recipe recipes1 = recipes.get();
           return recipes1;
        }
        throw new RecipeNotFoundException("recipe not found with id: "+id);
    }

    public List<Recipe> searchByRecipeNameOrCuisne(String text){
        List<Recipe> recipes= recipeRepository.findByNameContainingIgnoreCaseOrCuisineContainingIgnoreCase(text, text);
        if(recipes.isEmpty()){
            throw new RecipeNotFoundException("No result found for "+text);
        }
        return  recipes;
    }


}
