package com.manish.recipes_api.controller;

import com.manish.recipes_api.entity.Recipe;
import com.manish.recipes_api.model.RecipeModel;
import com.manish.recipes_api.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recipes/api")
public class RecipeController {

    @Autowired
    RecipeService recipeService;

    @GetMapping("/get/{id}")
    public ResponseEntity<Recipe> getRecipeById(@PathVariable Long id){
        Recipe recipes = recipeService.getRecipeById(id);
        return ResponseEntity.ok(recipes);
    }

    @GetMapping("/search/{text}")
    public  ResponseEntity<List<Recipe>> searchByRecipeOrCuisine(@PathVariable String text){
        List<Recipe> recipeModels = recipeService.searchByRecipeNameOrCuisne(text);
        return ResponseEntity.ok(recipeModels);
    }


}
