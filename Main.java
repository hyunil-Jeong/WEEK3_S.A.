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
                    Bus bus = new Bus(fuel, speed);
                    bus.bus();
                    break;
                case 2:
                    Taxi taxi = new Taxi(fuel, speed);
                    taxi.taxi();
                    break;
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
