package main.person;

import main.util.Validator;

public abstract class Person {

    private String name;
    private String phone;
    private double money;

    public Person(String name, String phone,double money) {
        if(Validator.validAddress(name)){
            this.name = name;
        }
       else {
           this.name = "Gogo";
        }
        this.phone = Validator.validPhone(phone);
       this.money = money;
    }

    public double getMoney() {
       return this.money;
    }
// за тестване дали работи правиклно
    @Override
    public String toString() {
        return this.name+" has "+ this.money + " and his phone number is:" + this.phone ;
    }

    protected void makePayment(double payment) {
        this.money -= payment;
    }

    public void takePayment(double payment) {
        this.money += payment;
    }
}
