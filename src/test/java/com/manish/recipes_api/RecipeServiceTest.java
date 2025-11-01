package com.manish.recipes_api;


import com.manish.recipes_api.entity.Recipe;
import com.manish.recipes_api.exception.RecipeNotFoundException;
import com.manish.recipes_api.repository.RecipeRepository;
import com.manish.recipes_api.service.RecipeService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class RecipeServiceTest {

    @Mock
    RecipeRepository recipeRepository;

    @InjectMocks
    RecipeService recipeService;

    public RecipeServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetRecipeById_found() {
        Recipe recipe = new Recipe();
        recipe.setId(1L);
        recipe.setName("Pasta");

        when(recipeRepository.findById(1L)).thenReturn(Optional.of(recipe));

        Recipe result = recipeService.getRecipeById(1L);

        assertEquals("Pasta", result.getName());
    }

    @Test
    void testGetRecipeById_notFound() {
        when(recipeRepository.findById(2L)).thenReturn(Optional.empty());

        assertThrows(RecipeNotFoundException.class, () -> recipeService.getRecipeById(2L));
    }

    @Test
    void testSearchByRecipeNameOrCuisine_found() {
        Recipe r1 = new Recipe();
        r1.setName("Pasta");

        when(recipeRepository.findByNameContainingIgnoreCaseOrCuisineContainingIgnoreCase("pasta", "pasta"))
                .thenReturn(List.of(r1));

        List<Recipe> result = recipeService.searchByRecipeNameOrCuisne("pasta");

        assertEquals(1, result.size());
    }

    @Test
    void testSearchByRecipeNameOrCuisine_notFound() {
        when(recipeRepository.findByNameContainingIgnoreCaseOrCuisineContainingIgnoreCase("xyz", "xyz"))
                .thenReturn(List.of());

        assertThrows(RecipeNotFoundException.class, () -> recipeService.searchByRecipeNameOrCuisne("xyz"));
    }
}
