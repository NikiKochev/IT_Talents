package main.person;

import main.Agency;

public abstract class Client extends Person{

    public Client(String name, String phone, double money) {
        super(name, phone, money);
    }

    public abstract void registration(Agency agency);
}
