package lokeshsaini.profilelayout;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


public class TabFragment extends Fragment {
    String itemName;
    int itemCounter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_tab, container, false);

        itemName = "Item ";
        itemCounter = 1;

        // 1. get a reference to recyclerView
        final RecyclerView recyclerView = (RecyclerView) root.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        // this is data for recycler view
        final ItemData itemsData[] = {
                new ItemData(itemName + itemCounter++),
                new ItemData(itemName + itemCounter++),
                new ItemData(itemName + itemCounter++),
                new ItemData(itemName + itemCounter++),
                new ItemData(itemName + itemCounter++),
                new ItemData(itemName + itemCounter++),
                new ItemData(itemName + itemCounter++),
                new ItemData(itemName + itemCounter++),
                new ItemData(itemName + itemCounter++),
                new ItemData(itemName + itemCounter++),
                new ItemData(itemName + itemCounter++),
                new ItemData(itemName + itemCounter++),
                new ItemData(itemName + itemCounter++),
                new ItemData(itemName + itemCounter++),
                new ItemData(itemName + itemCounter++)
        };

        // 2. set layoutManger
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        // 3. create an adapter
        MyAdapter mAdapter = new MyAdapter(itemsData);
        // 4. set adapter
        recyclerView.setAdapter(mAdapter);
        // 5. set item animator to DefaultAnimator
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        // 6. on Item touch listener
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getContext(), new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        int x = position + 1;
                        String item = itemName + x;
                        Toast.makeText(getActivity(), item,
                                Toast.LENGTH_SHORT).show();
                    }
                })
        );

        // Inflate the layout for this fragment
        return root;
    }

}
