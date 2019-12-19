package javabasics.collections.lists;

import java.util.ArrayList;
import java.util.List;

public class GroceryList {

    private List<String> groceryList;

    public GroceryList() {
        this.groceryList = new ArrayList<>();
    }

    public void addItem(String item) {
        groceryList.add(item);
    }

    public void modifyItem(int index, String item) {
        groceryList.set(index, item);
    }

    public List<String> getGroceryList() {
        return groceryList;
    }

    public void removeItem(int index) {
        groceryList.remove(index);
    }

    public int findItem(String item) {
        return groceryList.indexOf(item);
    }

    public void printItems() {
        System.out.println(groceryList.toString());
    }
}
