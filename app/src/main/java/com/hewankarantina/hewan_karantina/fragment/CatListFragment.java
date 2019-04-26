package com.hewankarantina.hewan_karantina.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hewankarantina.hewan_karantina.R;
import com.hewankarantina.hewan_karantina.adapter.RecyclerCatListAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class CatListFragment extends Fragment {

    RecyclerView recyclerView;
    RecyclerCatListAdapter adapter;

    public CatListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cat_list, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.cat_recycler);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        adapter = new RecyclerCatListAdapter(getActivity());
        recyclerView.setAdapter(adapter);

        return view;
    }

}
