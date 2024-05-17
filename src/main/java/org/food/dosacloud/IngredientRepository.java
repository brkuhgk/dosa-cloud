package org.food.dosacloud;

public interface IngredientRepository {
    Iterable<Ingredient> findALl();
    Ingredient findById(String id);
    Ingredient save(Ingredient ingredient);
}
