package lv5;

import java.util.*;



public class Menu {

    // MenuItem 클래스를 List로 관리
    private final Map<String, List<MenuItem>> menuMap = new LinkedHashMap<>();


    public Menu(){

        menuMap.put("Burgers", new ArrayList<>());
        menuMap.put("Drinks", new ArrayList<>());
        menuMap.put("Desserts", new ArrayList<>());
    }

    //카테고리, 아이템 접근용 메서드
    public Set<String> getCategories(){
        return menuMap.keySet();}
    public List<MenuItem> getItems(String category){
        return menuMap.get(category);
    }
    public void addItem(String category,MenuItem item){
        menuMap.get(category).add(item);
    }


    // List에 들어있는 MenuItem을 순차적으로 보여주는 함수
    void showMenuItem(List<MenuItem> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i));
        }
    }

    //카테고리 메뉴 출력
    void showCategoryItem(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i));
        }
    }

    // List를 리턴하는 함수
    List<MenuItem> returnList(List<MenuItem> list) {
        return list;
    }

    // 구조에 맞게 함수를 선언해놓고 가져다 사용하세요.
}
