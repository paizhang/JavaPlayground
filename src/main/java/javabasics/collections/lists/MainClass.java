package javabasics.collections.lists;

import java.util.ArrayList;
import java.util.List;

public class MainClass {

    public static List<String> getNewCopyUsingAddall(List<String> groceryList) {
        ArrayList<String> newList = new ArrayList<>();
        newList.addAll(groceryList);
        return newList;
    }

    public static List<String> getNewCopyUsingConstructor(List<String> groceryList) {
        return new ArrayList<>(groceryList);
    }

    public static String[] getArrayFromList(List<String> groceryList) {
        return (String[]) groceryList.toArray();
    }

    public static void main(String[] args) {
        System.out.println("Operating ArrayList:");
        GroceryList groceryList = new GroceryList();
        groceryList.addItem("First");
        groceryList.printItems();
        groceryList.addItem("Second");
        groceryList.addItem("Third");
        groceryList.printItems();
        groceryList.modifyItem(0, "Modified first");
        groceryList.removeItem(2);
        groceryList.printItems();

        System.out.println("Operating LinkedList:");
        Place place = new Place();
        place.addInOrder("A");
        place.addInOrder("C");
        place.addInOrder("B");
        place.addInOrder("e");
        place.pringItemsUsingIterator();
    }
}
