package lv2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // List 선언 및 초기화
        List<MenuItem> menuItems = new ArrayList<>();
        List<MenuItem> selectedItems = new ArrayList<>();

        // add 함수를 통해 new MenuItem(이름, 가격, 설명) List에 삽입
        // (add 보다 더 좋은 방법이 있다면 그렇게 해도 됩니다!)
        menuItems.add(new MenuItem("ShackBurger", 6900, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("SmokeShack", 8900, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Cheeseburger", 6900, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Hamburger", 5400, "비프패티를 기반으로 야채가 들어간 기본버거"));

        // Scanner 선언
        Scanner sc = new Scanner(System.in);
        int customerInput;
        do {
            // 반복문을 활용해 List 안에 있는 MenuItem을 하나씩 출력
            for (int i = 0; i < menuItems.size(); i++) {
                MenuItem item = menuItems.get(i);
                System.out.println((i + 1) + ". " + item);
            }
            System.out.println("0. 종료 | 종료");

            // 숫자를 입력 받기
            customerInput = Integer.parseInt(sc.nextLine());

            // 입력된 숫자에 따른 처리
            if (customerInput >= 1 && customerInput <= menuItems.size()) {
                MenuItem selectedItem = menuItems.get(customerInput - 1);
                selectedItems.add(selectedItem);
                System.out.println(selectedItem.name + "를 선택하셨습니다.");
            } else if (customerInput != 0) {
                System.out.println("잘못된 입력입니다.");
            }
        } while (customerInput != 0);

        // 프로그램을 종료
        System.out.println("프로그램을 종료합니다.");
        // 선택한 메뉴 : 이름, 가격, 설명
        System.out.print("선택한 메뉴: ");
        for (MenuItem item : selectedItems) {
            System.out.println("- " + item);
        }

    }
}
