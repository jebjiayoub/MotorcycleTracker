package com.moby.motorcycletracker;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HistoryFragment extends Fragment {

    ListView listView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_history, container, false);
        String[] menuItems = {" Date : 20/07/2020\n Location"," Date : 21/07/2020\n Location"," Date : 22/07/2020\n Location"," Date : 23/07/2020\n Location"," Date : 24/07/2020\n Location"," Date : 25/07/2020\n Location"," Date : 26/07/2020\n Location"};
        listView = (ListView) view.findViewById(R.id.list_view);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                getActivity(),
                R.layout.textitem,
                menuItems
        );
        listView.setAdapter(arrayAdapter);
        Button b = (Button) view.findViewById(R.id.buttonmn);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
            }
        });
        return view;
    }
}
