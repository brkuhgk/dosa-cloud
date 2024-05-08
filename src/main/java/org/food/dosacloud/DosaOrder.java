package org.food.dosacloud;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DosaOrder {
    private String orderId;
    private String deliveryName;
    private String deliveryStreetAddress;
    private String deliveryCity;
    private String deliveryState;
    private String deliveryZip;
    private String ccNumber;
    private String ccExpiryDate;
    private String ccCVV;

    private List<Dosa> dosas = new ArrayList<Dosa>();

    public void addDosa(Dosa dosa) {
        this.dosas.add(dosa);
    }
}
