package org.food.dosacloud;

import lombok.Data;

import java.util.List;

@Data
public class Dosa {
    private String name;
    private List<Ingredient> ingredients;

}
