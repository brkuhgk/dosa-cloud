package org.food.dosacloud;


import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {

    private Map<String, Ingredient> ingredientMap = new HashMap<>();

    public IngredientByIdConverter() {

                ingredientMap.put("PD", new Ingredient("PD", "Plain Dosa", Ingredient.Type.PLAIN));
                ingredientMap.put("KPD", new Ingredient("KPD", "Uttapam Dosa", Ingredient.Type.PLAIN));
                ingredientMap.put("CPD", new Ingredient("CPD", "Ravva Plain Dosa", Ingredient.Type.PLAIN));
                ingredientMap.put("EGGPD", new Ingredient("EGGPD", "EGG Plain Dosa", Ingredient.Type.EGG));
                ingredientMap.put("KEGGPD", new Ingredient("KEGGPD", "Karam EGG Dosa", Ingredient.Type.EGG));
                ingredientMap.put("MD", new Ingredient("MD", "Alu Masala", Ingredient.Type.MASALA));
                ingredientMap.put("CMD", new Ingredient("CMD", "Channa Masala Dosa", Ingredient.Type.MASALA));
                ingredientMap.put("SD", new Ingredient("SD", "Palli Chetni", Ingredient.Type.SIDES));
                ingredientMap.put("RSD", new Ingredient("RSD", "Sambar", Ingredient.Type.SIDES));
                ingredientMap.put("SDES", new Ingredient("SDES", "Karam Chetni", Ingredient.Type.SIDES));
                ingredientMap.put("CHPD", new Ingredient("CHPD", "Chesse", Ingredient.Type.CHEESE));
                ingredientMap.put("CHUPD", new Ingredient("CHUPD", "Butter", Ingredient.Type.CHEESE));
                ingredientMap.put("UTD", new Ingredient("UTD", "Cone", Ingredient.Type.SHAPE));
                ingredientMap.put("TUTP", new Ingredient("TUTP", "Rolls", Ingredient.Type.SHAPE));
    }



    @Override
    public Ingredient convert(String id) {
        return null;
    }
}

