package lamqtaSpaska;

import java.util.Scanner;

public class GameOn {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the name of your heroes");
        Heroes player = new Heroes(sc.next());
        System.out.println("you are start this game. You must chose a way every time so ....");
        while (!player.isWin()){
            Scanner m = new Scanner(System.in);
            System.out.println();
            System.out.println(" натисни 1 да отидеш в гората и да се биеш с заек ");
            System.out.println(" натисни 2 да отидеш в бара да си починеш");
            System.out.println(" натисни 3 да се биеш  с Ламята Спаска");
            System.out.println(" натисни 4 за статуса си");
            char enter = m.next().charAt(0);
            player.movment(enter);
        }
        System.out.println("You are winner");
    }
}
