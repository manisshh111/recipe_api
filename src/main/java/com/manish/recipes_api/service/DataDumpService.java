package com.manish.recipes_api.service;

import com.manish.recipes_api.entity.Recipe;
import com.manish.recipes_api.model.ApiResponse;
import com.manish.recipes_api.model.RecipeModel;
import com.manish.recipes_api.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class DataDumpService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    RecipeRepository recipeRepository;


    public void dumpDataIntoDb(){

       ApiResponse apiResponse= restTemplate.getForObject("https://dummyjson.com/recipes", ApiResponse.class);

        List<Recipe> recipes= apiResponse.getRecipes();


        for(Recipe recipe: recipes){
            recipe.setId(null);
            recipeRepository.save(recipe);
            System.out.println(recipe.toString());
        }


    }


}
