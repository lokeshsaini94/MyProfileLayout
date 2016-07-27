package lokeshsaini.profilelayout;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class TabFragment extends Fragment {
    public final String ITEMS = "items";

    private String itemName;
    private int itemCounter;

    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;

    private DatabaseReference mRootRef;
    private DatabaseReference mconditionRef;
    private FirebaseRecyclerAdapter<ItemData, ItemViewHolder> firebaseRecyclerAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_tab, container, false);

        recyclerView = (RecyclerView) root.findViewById(R.id.recyclerView);

        linearLayoutManager = new LinearLayoutManager(getActivity());

        mRootRef = FirebaseDatabase.getInstance().getReference();
        mconditionRef = mRootRef.child("items");

        firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<ItemData, ItemViewHolder>(
                ItemData.class,
                R.layout.cards_layout,
                ItemViewHolder.class,
                mconditionRef
        ) {
            @Override
            protected void populateViewHolder(ItemViewHolder viewHolder, ItemData model, int position) {
                viewHolder.mtext.setText(model.getItem());
            }
        };

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(firebaseRecyclerAdapter);

        return root;
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView mtext;

        public ItemViewHolder(View itemView) {
            super(itemView);
            mtext = (TextView) itemView.findViewById(R.id.card_content);
        }
    }
}
