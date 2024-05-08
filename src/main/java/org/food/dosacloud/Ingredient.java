package org.food.dosacloud;

import lombok.Data;

@Data
public class Ingredient {
    private final String id;
    private final String name;
    private final Type type;

    public enum Type {
            PLAIN, MASALA, MYSORE_MASALA, SIDES, CHEESE, SHAPE, EGG
    }
}

