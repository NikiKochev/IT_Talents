package main.person;

import main.util.RandomMethods;
import main.util.Validator;

public abstract class Person {

    private String name;
    private String phone;

    public Person(String name, String phone) {
        if(Validator.validString(name)){
            this.name = name;
        }
        else{
            this.name = RandomMethods.randomName();
        }
        if(Validator.validPhone(phone)){
            this.phone = phone;
        }
        else {
            this.phone = RandomMethods.randomPhoneNumber();
        }
    }

    public String getName() {
        return name;
    }
}
