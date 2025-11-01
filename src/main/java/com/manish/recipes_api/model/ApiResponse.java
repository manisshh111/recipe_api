package com.manish.recipes_api.model;

import com.manish.recipes_api.entity.Recipe;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {
    List<Recipe> recipes;
}
