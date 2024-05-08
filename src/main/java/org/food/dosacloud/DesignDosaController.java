package org.food.dosacloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("DosaOrder")
public class DesignDosaController {

    @ModelAttribute
    public void addIngredientToModel(Model model) {
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("PD","Plain Dosa", Ingredient.Type.PLAIN),
                new Ingredient("KPD","KARAM Plain Dosa", Ingredient.Type.PLAIN),
                new Ingredient("CPD","Chitti Plain Dosa", Ingredient.Type.PLAIN),
                new Ingredient("EGGPD","EGG Plain Dosa", Ingredient.Type.EGG),
                new Ingredient("KEGGPD","Karam EGG Plain Dosa", Ingredient.Type.EGG),
                new Ingredient("MD","Masala Dosa", Ingredient.Type.MASALA),
                new Ingredient("MDS","Spicy Masala Dosa", Ingredient.Type.MASALA),
                new Ingredient("SD","Set Dosa", Ingredient.Type.SET),
                new Ingredient("RSD","Ravva Dosa", Ingredient.Type.SET),
                new Ingredient("CHPD", "Chesse Dosa", Ingredient.Type.CHEESE),
                new Ingredient("CHUPD", "Chesse Utappam Dosa", Ingredient.Type.CHEESE),
                new Ingredient("UTD","Utappam Dosa", Ingredient.Type.UTAPPAM),
                new Ingredient("TUTP","Tomato Utappam Dosa", Ingredient.Type.UTAPPAM)
                );

        Ingredient.Type[] types = Ingredient.Type.values();
        for (Ingredient.Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
            filterByType(ingredients,type));
        }
    }

    @ModelAttribute(name = "DosaOrder")
    public DosaOrder order(){
        return new DosaOrder();
    }

    @ModelAttribute(name = "dosa")
    public Dosa dosa(){
        return new Dosa();
    }

    @GetMapping
    public String showDesignForm() {
        return "design";
    }

    @PostMapping
    public String handlePostReqDosaForm(Dosa dosa, @ModelAttribute DosaOrder dosaOrder ){
        dosaOrder.addDosa(dosa);
        log.info("Processing Dosa: {}",dosa);
        return "redirect:/orders/current";
    }

    private Iterable<Ingredient> filterByType(List<Ingredient> ingredients, Ingredient.Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());

    }

}
