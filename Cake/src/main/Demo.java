package main;

import main.person.Client;
import main.person.CorporateClient;
import main.person.Deliver;
import main.person.PrivateClient;
import main.util.RandomMethods;

import java.util.TreeSet;

public class Demo {
    public static void main(String[] args) {
        PastryShop iTalanti = new PastryShop("talanti","sdkagjldskjfh", RandomMethods.randomPhoneNumber());
        iTalanti.printCakes();
        Client [] client = new Client[10];
        for (int i = 0; i < 5; i++) {
            client[i] = new PrivateClient(RandomMethods.randomName(),RandomMethods.randomPhoneNumber(),RandomMethods.randomAddress());
        }
        for (int i = 0; i < 5; i++) {
            client[i+5] = new CorporateClient(RandomMethods.randomName(),RandomMethods.randomPhoneNumber(),RandomMethods.randomAddress());
        }
        for (int i = 0; i < client.length; i++) {
            client[i].makeAnOrder(RandomMethods.randomCakes(),iTalanti);
        }
        System.out.println("====================================================================");
        iTalanti.printCakes();
        System.out.println(iTalanti.getMoney());
        TreeSet<Deliver> x = new TreeSet<>((o1, o2) -> {
            if(o1.getMoney() == o2.getMoney()){
                return o1.getName().compareTo(o2.getName());
            }
            return Double.compare(o1.getMoney(),o2.getMoney());
        });
        x.addAll(iTalanti.getDelivers());
        System.out.println(x);
    }
}
