package com.rajeshkawali.designpattern.flyweightpattern;

import java.util.HashMap;
import java.util.Map;

// Flyweight factory
public class CoffeeFlavorFactory {
    private Map<String, Coffee> flavors = new HashMap<>();

    public Coffee getCoffeeFlavor(String flavorName) {
    	Coffee flavor = flavors.get(flavorName);

        if (flavor == null) {
            flavor = new CoffeeFlavor(flavorName);
            flavors.put(flavorName, flavor);
        }
        return flavor;
    }

    public int getNumberOfCoffeeFlavors() {
        return flavors.size();
    }
}