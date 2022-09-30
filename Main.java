package SA_2;

import java.util.Scanner;

public class Main {

    int fuel = 100;
    int speed = 0;
    int choose = 1;

    public void menu() {
        Scanner scan = new Scanner(System.in);
        int i;
        while(choose!=0) {
            System.out.println("대중교통 프로그램\n 0. 종료하려면 0번을 입력하세요.\n 1. 버스를 확인하려면 1번을 입력하세요.\n 2. 택시를 확인하려면 2번을 입력하세요.");
            i = scan.nextInt();

            switch (i) {
                case 1:
                    Bus bus1 = new Bus(fuel, speed);
                    Bus bus2 = new Bus(fuel, speed);
                    Scanner scan1 = new Scanner(System.in);

                    int j;
                    int choose1 = 1;

                    while (choose1 != 0) {
                        System.out.println("\n\n1. 1번 버스\n2. 2번 버스");
                        j = scan1.nextInt();
                        switch (j) {
                            case 1:
                                bus1.bus();
                                break;
                            case 2:
                                bus2.bus();
                                break;
                        }
                    }
                case 2:
                    Taxi taxi1 = new Taxi(fuel, speed);
                    Taxi taxi2 = new Taxi(fuel, speed);
                    Scanner scan2 = new Scanner(System.in);

                    int k;
                    int choose2 = 1;

                    while (choose2 != 0) {
                        System.out.println("\n\n1. 1번 택시\n2. 2번 택시");
                        k = scan2.nextInt();
                        switch (k) {
                            case 1:
                                taxi1.taxi();
                                break;
                            case 2:
                                taxi2.taxi();
                                break;
                        }
                    }
                case 0:
                    choose = 0;
                    break;
                default:
                    System.out.println("0부터 2까지의 정수만 입력해 주세요.");
                    break;
            }
        }
    }



    public static void main(String[] args) {
        Main method = new Main();
        method.menu();
    }

}
