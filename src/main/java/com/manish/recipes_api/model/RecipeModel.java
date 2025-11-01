package com.manish.recipes_api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class RecipeModel {

    String id;
    String name;
    List<String> ingredients;
    List<String> instructions;
    String prepTimeMinutes;
    String cookTimeMinutes;
    String servings;
    String difficulty;
    String cuisine;
    String caloriesPerServing;
    List<String> tags;
    String userId;
    String image;
    String rating;
    String reviewCount;
    List<String> mealType;
}
