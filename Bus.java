package SA_2;

import java.util.Scanner;

public class Bus extends Main {
    int inPeople = 0;
    int maxPeople = 30;
    int cost = 1000;
    int currentCost = 0;
    int busNum = 1;
    int fuel;
    int speed;
    String state = "운행중";

    Bus(int fuel, int speed) {
        this.fuel = fuel;
        this.speed = speed;
    }

    public void bus1() {
    }

    public void bus2(String str) {
        this.state = str;
    }

    public void bus3(int i) {
        if (this.maxPeople - i >= 0) {
            this.inPeople += i;
            this.maxPeople -= i;
            this.currentCost = cost * i;
        } else {
            System.out.println("최대 승객 수 초과");
        }
    }

    public void bus4(int i) {
        this.speed += i;
    }

    public void bus5(int i) {
        if (this.fuel + i >= 0) {
            this.fuel += i;
            if (this.fuel < 10) {
                System.out.println("주유량이 10미만 입니다. 주유가 필요합니다.\n차고지로 향합니다.");
                this.state = "차고지행";
            }
        } else {
            System.out.println("기름이 부족합니다.");
        }
    }

    public void bus() {
        Scanner scan = new Scanner(System.in);

        int i;
        int choose = 1;
        String str;

        while (choose != 0) {
            System.out.println("\n\n1. 상태 확인\n2. 상태 변경\n3. 승객 탑승\n4. 속도 변경\n5. 주유\n0. 종료");
            i = scan.nextInt();
            switch (i) {
                case 1:
                    System.out.println("\n\n탑승 승객수 : " + inPeople);
                    System.out.println("잔여 승객 수 : " + maxPeople);
                    System.out.println("요금 확인 : " + currentCost);
                    System.out.println("상태 : " + state);
                    System.out.println("현재 속도 : " + speed);
                    System.out.println("주유량 : " + fuel + "\n");
                    break;
                case 2:
                    System.out.print("상태 변경 : ( 운행중 or 차고지행 설정하세요. )  ");
                    str = scan.next();
                    bus2(str);
                    break;
                case 3:
                    if (state.equals("운행중")) {
                        System.out.print("승객 탑승 : ");
                        i = scan.nextInt();
                        bus3(i);
                    } else {
                        System.out.println("운행중이 아닙니다.");
                    }
                    break;
                case 4:
                    System.out.print("속도 변경 : ( 올리려면 +, 늦추려면 - 를 붙여주세요 )  ");
                    i = scan.nextInt();
                    bus4(i);
                    break;
                case 5:
                    System.out.print("주유량 = ( 더하려면 +, 빼려면 - 를 붙여주세요 )  ");
                    i = scan.nextInt();
                    bus5(i);
                    break;
                case 0:
                    choose = 0;
                    break;
                default:
                    System.out.println("0부터 5까지의 수를 입력하세요.");
                    break;
            }
        }
    }
}
