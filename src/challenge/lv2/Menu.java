package challenge.lv2;

import java.util.*;
import java.util.stream.IntStream;

public class Menu {

    private final Map<String, List<MenuItem>> menuMap = new LinkedHashMap<>();

    public Menu() {
        menuMap.put("Burgers",  new ArrayList<>());
        menuMap.put("Drinks",   new ArrayList<>());
        menuMap.put("Desserts", new ArrayList<>());
    }

    public Set<String>         getCategories()            { return menuMap.keySet(); }
    public List<MenuItem>      getItems(String c)         { return menuMap.get(c); }
    public void addItem(String c, MenuItem item)          { menuMap.get(c).add(item); }

    //카테고리 메뉴 출력 (Stream 사용)
    public void showMenuItem(List<MenuItem> list) {
        IntStream.range(0, list.size())
                .forEach(i -> System.out.println((i+1)+". "+list.get(i)));
    }

    public void showCategoryItem(List<String> list) {
        IntStream.range(0, list.size())
                .forEach(i -> System.out.println((i+1)+". "+list.get(i)));
    }
}
