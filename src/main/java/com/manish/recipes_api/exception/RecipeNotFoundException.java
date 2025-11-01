package com.manish.recipes_api.exception;

public class RecipeNotFoundException extends RuntimeException{
    public RecipeNotFoundException(String message){
        super(message);
    }
}
