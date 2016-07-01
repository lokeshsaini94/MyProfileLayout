package lokeshsaini.profilelayout;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class TabFragment extends Fragment {
    ArrayList<Item> items;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_tab, container, false);
        // Lookup the recyclerview in activity layout
        RecyclerView rvItems = (RecyclerView) root.findViewById(R.id.rvItems);

        // Initialize items
        items = Item.createItemsList(10);
        // Create adapter passing in the sample user data
        ItemsAdapter adapter = new ItemsAdapter(getContext(), items);

//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//        rvItems.setLayoutManager(layoutManager);

        // Attach the adapter to the recyclerview to populate items
        rvItems.setAdapter(adapter);
        // Set layout manager to position the items
        rvItems.setLayoutManager(new LinearLayoutManager(getActivity()));

        // Inflate the layout for this fragment
        return root;
    }

}
