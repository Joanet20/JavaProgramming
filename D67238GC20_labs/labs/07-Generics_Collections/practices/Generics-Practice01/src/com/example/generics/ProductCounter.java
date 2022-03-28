package com.example.generics;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class ProductCounter {
    // Create a Counting Map
    private Map<String, Long> productCountMap = new HashMap<>();
    // Create a Name Mapping Map
    private Map<String, String> productNames = new TreeMap<>();

    public static void main(String[] args) {

        // List of part data
        String[] parts = new String[]{"1S01", "1S01", "1S01", "1S01", "1S01", "1S02", "1S02", "1S02", "1H01", "1H01", "1S02", "1S01", "1S01", "1H01", "1H01", "1H01", "1S02", "1S02", "1M02", "1M02", "1M02"};

        // Create Product Name Part Number map
        Map<String, String> productNames = new TreeMap<>();
        productNames.put("1S01", "Blue Polo Shirt");
        productNames.put("1S02", "Black Polo Shirt");
        productNames.put("1H01", "Red Ball Cap");
        productNames.put("1M02", "Duke Mug   ");

        // Create Product Counter Object and process data
        ProductCounter pc = new ProductCounter(productNames);
        pc.processList(parts);
        pc.printReport();
    }

    public ProductCounter(Map productNames) {
        this.productNames = productNames;
    }

    public void processList(String[] list) {

        long valorActual = 0;

        for (String item : list){

            if (productCountMap.containsKey(item)){
                valorActual = productCountMap.get(item);
                valorActual++;
                productCountMap.put(item, new Long(valorActual));
            } else {
                productCountMap.put(item, new Long(1));
            }
        }
    }

    public void printReport() {

        for (String product : productNames.keySet()){
            System.out.println("Key: " + product);
            System.out.println("Nom: " + productCountMap.get(product));
        }
    }
}
