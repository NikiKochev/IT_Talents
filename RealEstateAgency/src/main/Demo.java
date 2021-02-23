package main;

import main.person.Buyer;
import main.person.Seller;
import main.util.Validator;

public class Demo {
    public static void main(String[] args) {
// 1. Да се създаде агенция „Таланти Естейтс“ с пет агента с произволни имена
        Agency talanti = new Agency("talanti", "0899987789","sofia");

//2. Да се създадат 30 продавача на имоти. За всеки продавач да се създаде имот на
//произволен принцип – 33% шанс да е апартамент, 33% шанс да е къща и 33% шанс за
//парцел. Останалите характеристики също да са на произволен принцип. Цените на
//имотите да варират – за къщите между 50 000 и 80 000 евро, за апартаментите – между
//70 000 и 150 000 евро; за парцелите – между 30 000 и 85 000 евро.

        Seller[] sellers = new Seller[30];
        for (int i = 0; i < sellers.length; i++) {
            sellers[i] = new Seller(Validator.randomName(),Validator.randomPhone(),Validator.randomProperty(),0);
        }

//3. Всички продавачи да регистрират имотите си за продажба в агенцията;
        for (int i = 0; i < sellers.length; i++) {
            sellers[i].registration(talanti);
        }
//тест дали работи

//        TreeSet<Property> properties = new TreeSet<>();
//        properties.addAll(talanti.getProperties());
//        for (Property p: properties.descendingSet()
//             ) {
//            System.out.println(p);
//        }

//4. Да се създадат 10 купувача на произволен принцип с бюджети между 30 000 и 150 000
//евро;
        Buyer[] buyers = new Buyer[10];
        for (int i = 0; i < buyers.length; i++) {
            buyers[i] = new Buyer(Validator.randomName(),Validator.randomPhone(),Validator.randomInt(100000,200000));
//тест дали работи

//            System.out.println(buyers[i]);
        }

//5. Всички купувачи да регистрират заявки за търсене на имот към агенцията;
        for (int i = 0; i < buyers.length; i++) {
            buyers[i].registration(talanti);
        }
// 6. Всеки купувач да заяви 3 огледа на произволни имоти от агенцията;
        for (int i = 0; i < buyers.length; i++) {
            int counter = 0;
            while (counter < 3){
                if(buyers[i].inspectionView(talanti.randomPropertyFromCataloge())){
                    counter++;
                }
            }
        }
//тест дали работи

//        for (int i = 0; i < buyers.length; i++) {
//            System.out.println(buyers[i].getInspection());
//        }

//7. Всеки купувач да заявки покупка на някой от огледаните от него имоти на произволен
//принцип;
        for (int i = 0; i < buyers.length; i++) {
            buyers[i].buyProperty(buyers[i].randomProperty(), talanti);
        }

//8. Да се изпише на екрана паричния баланс на агенцията след продажбата на имотите;
        System.out.println(talanti.getMoneyBalance());

//9. Да се изпише на екрана паричния баланс на всеки агент от агенцията след продажбата
//на имотите, като агентите са сортирани от най-богатия към този с най-малко печалби.
        talanti.getMoneyBalanceForAgents();
    }
}
