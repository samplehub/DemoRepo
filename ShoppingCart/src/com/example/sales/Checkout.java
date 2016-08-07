package com.example.sales;

import java.util.Hashtable;
import java.util.Scanner;

public class Checkout {

    Hashtable<String, Integer> priceList;

    public Checkout() {
        priceList = new Hashtable<String, Integer>();
        // All prices are in p
        priceList.put("apple", 60);
        priceList.put("orange", 25);
        priceList.put("banana", 10);
    }

    @SuppressWarnings("resource")
	public static void main(String[] args) {

        Checkout checkout = new Checkout();
        int totalCost = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter list of items purchased separated by a comma: ");

        String itemsList = scanner.nextLine();

        String[] items = itemsList.split(",");
        for (String item: items) {
            if ( checkout.priceList.containsKey(item.trim()) ) {
                totalCost += (Integer) checkout.priceList.get(item.trim());
            } else {
                System.out.format("Unknown item %s entered\n", item);
            }
        }

        System.out.format("\nTotal cost of items: %d p", totalCost);

    }
}
