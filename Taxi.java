package SA_2;

import java.util.Scanner;

public class Taxi extends Main {
    int inPeople = 0;
    int maxPeople = 4;

    int basicDistance = 1;
    int finalDistance;

    int basicCost = 3000;
    int cost = 1000;
    int currentCost = 0;
    int busNum = 1;
    int fuel;
    int speed;

    String destination = "";
    String state = "일반";

    Taxi(int fuel, int speed) {
        this.fuel = fuel;
        this.speed = speed;
    }

    public void taxi1() {
    }

    public void taxi2(String str) {
        this.state = str;
    }

    public void taxi3(int i) {
        if (this.maxPeople - i >= 0) {
            this.inPeople += i;
            this.maxPeople -= i;
            this.currentCost = cost * i;
            if ( this.inPeople >= 1) {
                this.state = "운행중";
            }
        } else {
            System.out.println("최대 승객 수 초과");
            this.state = "탑승 불가";
        }
    }

    public void taxi4(int i) {
        this.speed += i;
    }

    public void taxi5(int i) {
        if (this.fuel + i >= 0) {
            this.fuel += i;
            if (this.fuel < 10) {
                System.out.println("주유량이 10미만 입니다. 주유가 필요합니다.\n운행이 불가합니다.");
                this.state = "운행 불가";
            }
        } else {
            System.out.println("기름이 부족합니다.");
        }
    }

    public void taxi6(String str) {
        this.destination = str;
    }

    public void taxi7(int i) {
        this.finalDistance = i;
        if ( i <= basicDistance ) {
            this.currentCost = this.basicCost;
        } else {
            currentCost = this.cost * (i - this.basicDistance) + this.basicCost;
        }
    }

    public void taxi() {
        Scanner scan = new Scanner(System.in);

        int i;
        int choose = 2;
        String str;

        while (choose != 0) {
            System.out.println("\n\n1. 상태 확인\n2. 상태 변경\n3. 승객 탑승\n4. 목적지 명 설정\n5. 목적지까지 거리 설정\n6. 속도 변경\n7. 주유\n0. 종료");
            i = scan.nextInt();
            switch (i) {
                case 1:
                    System.out.println("\n\n탑승 승객수 : " + inPeople);
                    System.out.println("잔여 승객 수 : " + maxPeople);
                    System.out.println("목적지 : " + destination);
                    System.out.println("목적지까지 거리 : " + finalDistance + " km");
                    System.out.println("기본 요금 : " + basicCost);
                    System.out.println("지불할 요금 : " + currentCost);
                    System.out.println("상태 : " + state);
                    System.out.println("현재 속도 : " + speed);
                    System.out.println("주유량 : " + fuel + "\n");
                    break;
                case 2:
                    System.out.print("상태 변경 : ( 일반 or 운행중 or 탑승 불가 or 운행 불가 설정하세요. )  ");
                    str = scan.next();
                    taxi2(str);
                    break;
                case 3:
                    if (state.equals("일반") || state.equals("운행중")) {
                        System.out.print("승객 탑승 : ");
                        i = scan.nextInt();
                        taxi3(i);
                    } else {
                        System.out.println("운행중이 아닙니다.");
                    }
                    break;
                case 4:
                    System.out.print("목적지 설정 : ");
                    str = scan.next();
                    taxi6(str);
                    break;
                case 5:
                    System.out.print("목적지까지 거리 : ");
                    i = scan.nextInt();
                    taxi7(i);
                    break;
                case 6:
                    System.out.print("속도 변경 : ( 올리려면 +, 늦추려면 - 를 붙여주세요 )  ");
                    i = scan.nextInt();
                    taxi4(i);
                    break;
                case 7:
                    System.out.print("주유량 = ( 더하려면 +, 빼려면 - 를 붙여주세요 )  ");
                    i = scan.nextInt();
                    taxi5(i);
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
