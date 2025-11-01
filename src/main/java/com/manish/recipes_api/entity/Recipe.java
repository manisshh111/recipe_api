package com.manish.recipes_api.entity;

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
@Entity
@Table(name = "recipes_table")
public class Recipe {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id;
        String name;
        @ElementCollection
        List<String> ingredients;
        @ElementCollection
        List<String> instructions;
        Integer prepTimeMinutes;
        Integer cookTimeMinutes;
        Integer servings;
        String difficulty;
        String cuisine;
        Integer caloriesPerServing;
        @ElementCollection
        List<String> tags;
        String userId;
        String image;
        Double rating;
        Integer reviewCount;
        @ElementCollection
        List<String> mealType;

}
