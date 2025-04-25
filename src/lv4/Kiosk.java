package lv4;

import java.util.*;


public class Kiosk {

    Menu menu;

    Kiosk(Menu menu) {
        this.menu = menu;
    }


    void start() {

        Scanner sc = new Scanner(System.in);
        int customerInput = -1;

        List<String> categories = new ArrayList<>(menu.menuMap.keySet());

        do {
            //메인 메뉴
            System.out.println("\n[ MAIN MENU ]");
            menu.showCategoryItem(categories);
            System.out.println("0. 종료");

            try {
                customerInput = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력해 주세요.");
                continue;
            }
            if (customerInput < 0 || customerInput > categories.size()) {
                System.out.println("잘못된 카테고리 번호입니다.");
                continue;

            }
            if (customerInput == 0) {
                break;
            }

            //카테고리 별 메뉴
            int itemInput = -1;
            while (itemInput != 0) {
                String selectedCategory = categories.get(customerInput - 1);
                List<MenuItem> selectedList = menu.menuMap.get(selectedCategory);

                System.out.println("\n[ " + selectedCategory.toUpperCase() + " MENU ]");
                menu.showMenuItem(selectedList);
                System.out.println("0. 뒤로가기");


                try {
                    itemInput = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("숫자만 입력해 주세요.");
                    continue;
                }
                if (itemInput == 0) {
                    continue;
                }
                if (itemInput >= 1 && itemInput <= selectedList.size()) {
                    MenuItem chosenItem = selectedList.get(itemInput - 1);
                    System.out.println("\n선택한 메뉴: " + chosenItem);
                } else {
                    System.out.println("잘못된 메뉴 번호입니다.");
                }
            }

        } while (customerInput != 0);
        System.out.println("프로그램을 종료합니다.");
    }
}

