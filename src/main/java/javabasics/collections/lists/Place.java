package javabasics.collections.lists;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Place {

    private List<String> places;

    public Place() {
        this.places = new LinkedList<>();
    }

    public Place(List<String> places) {
        this.places = places;
    }

    public void addItem(String item) {
        places.add(item);
    }

    public void removeItemByIndex(int index) {
        places.remove(index);
    }

    public void removeItemByObject(String item) {
        places.remove(item);
    }

    public void pringItemsUsingIterator() {
        Iterator iterator = places.listIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public void printItemsUsingListIterator() {
        ListIterator listIterator = places.listIterator();
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }
    }

    /*
        Nice article illustrates the difference between Iterator and ListIterator. (https://blog.csdn.net/longshengguoji/article/details/41551491)
     */
    public boolean addInOrder(String item) {
        ListIterator iterator = places.listIterator();
        while (iterator.hasNext()) {
            int compareRes = item.compareTo(iterator.next().toString());
            if (compareRes == 0) {
                System.out.println("Item:" + item + " already exists. ");
                return false;
            } else if (compareRes == -1) {
                /*
                    If the new item is smaller than current iterated item, then we need to insert the new item before
                    the current item. Since we already call next() which moved the current iterator behind the current item,
                    we need to move the iterator back front of the current item.
                    Java implemented LinkedList as a Doubly Linked List which store both forward reference and backward reference.
                 */
                iterator.previous();
                iterator.add(item);
                return true;
            } else {

            }
        }
        iterator.add(item);
        return true;
    }
}
