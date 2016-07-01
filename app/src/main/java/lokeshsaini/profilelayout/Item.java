package lokeshsaini.profilelayout;

import java.util.ArrayList;

public class Item {
    private static int itemNumber = 1;
    private String mName;
    private boolean mOnline;

    public Item(String name) {
        mName = name;
    }

    public static ArrayList<Item> createItemsList(int numItems) {
        ArrayList<Item> items = new ArrayList<Item>();

        for (int i = 0; i < numItems; i++) {
            items.add(new Item("Item " + itemNumber++));
        }

        return items;
    }

    public String getName() {
        return mName;
    }

    public boolean isOnline() {
        return mOnline;
    }
}