package lokeshsaini.profilelayout;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class TabFragment extends Fragment {
    ArrayList<Contact> contacts;


    public TabFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_tab, container, false);
        // Lookup the recyclerview in activity layout
        RecyclerView rvContacts = (RecyclerView) root.findViewById(R.id.rvContacts);

        // Initialize contacts
        contacts = Contact.createContactsList(15);
        // Create adapter passing in the sample user data
        ContactsAdapter adapter = new ContactsAdapter(getContext(), contacts);

//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//        rvContacts.setLayoutManager(layoutManager);

        // Attach the adapter to the recyclerview to populate items
        rvContacts.setAdapter(adapter);
        // Set layout manager to position the items
        rvContacts.setLayoutManager(new LinearLayoutManager(getActivity()));

        // Inflate the layout for this fragment
        return root;
    }

}
