package org.food.dosacloud;

import lombok.Data;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class DosaOrder {

    private static final long serialversionUID = 1L;
    private long id;
    private Date placedAt;

    private String deliveryName;
    private String deliveryStreetAddress;
    private String deliveryCity;
    private String deliveryState;
    private String deliveryZip;
    private String ccNumber;
    private String ccExpiryDate;
    private String ccCVV;

    private List<Dosa> dosas = new ArrayList<>();

    public void addDosa(Dosa dosa) {
        this.dosas.add(dosa);
    }

}
