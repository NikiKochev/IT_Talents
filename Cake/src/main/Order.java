package main;

import main.cake.Cake;
import main.person.Client;
import main.util.RandomMethods;
import main.util.Validator;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Order {

    private Client client;
    private double price;
    private String deliveryAddress;
    private ArrayList<Cake> orderedCake = new ArrayList<>();
    private LocalDateTime date;

    public Order(Client client, double price, String deliveryAddress, ArrayList<Cake> orderedCake) {
        this.client = client;
        this.price = price;
        if(Validator.validString(deliveryAddress)) {
            this.deliveryAddress = deliveryAddress;
        }
        else {
            this.deliveryAddress = RandomMethods.randomAddress();
        }
        this.orderedCake .addAll(orderedCake);
    }
}
