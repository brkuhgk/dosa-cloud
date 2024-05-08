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
@SessionAttributes("dosaOrder")
public class DesignDosaController {

    @ModelAttribute
    public void addIngredientToModel(Model model) {
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("PD","Plain Dosa", Ingredient.Type.PLAIN),
                new Ingredient("KPD","Uttapam Dosa", Ingredient.Type.PLAIN),
                new Ingredient("CPD","Ravva Plain Dosa", Ingredient.Type.PLAIN),
                new Ingredient("EGGPD","EGG Plain Dosa", Ingredient.Type.EGG),
                new Ingredient("KEGGPD","Karam EGG Dosa", Ingredient.Type.EGG),
                new Ingredient("MD","Alu Masala", Ingredient.Type.MASALA),
                new Ingredient("MDS","Channa Masala Dosa", Ingredient.Type.MASALA),
                new Ingredient("SD","Palli Chetni", Ingredient.Type.SIDES),
                new Ingredient("RSD","Sambar", Ingredient.Type.SIDES),
                new Ingredient("SDES","Karam Chetni", Ingredient.Type.SIDES),
                new Ingredient("CHPD", "Chesse", Ingredient.Type.CHEESE),
                new Ingredient("CHUPD", "Butter", Ingredient.Type.CHEESE),
                new Ingredient("UTD","Cone", Ingredient.Type.SHAPE),
                new Ingredient("TUTP","Rolls", Ingredient.Type.SHAPE)
                );

        Ingredient.Type[] types = Ingredient.Type.values();
        for (Ingredient.Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
            filterByType(ingredients,type));
        }
    }

    @ModelAttribute(name = "dosaOrder")
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
