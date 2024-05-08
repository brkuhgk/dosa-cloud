package org.food.dosacloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;


@Slf4j
@RequestMapping("/orders")
@Controller
@SessionAttributes("dosaOrder")
public class OrderController {

    @GetMapping("/current")
    public String orderForm(){
        return "orderForm";
    }
    @PostMapping
    public String processOrder(DosaOrder dosaOrder, SessionStatus sessionStatus){
        log.info("Order Submitted: {}",dosaOrder);
        sessionStatus.setComplete();
        return "redirect:/";
    }
}
