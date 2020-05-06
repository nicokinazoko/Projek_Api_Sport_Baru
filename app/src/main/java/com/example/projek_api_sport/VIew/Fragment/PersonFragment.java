package com.example.projek_api_sport.VIew.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projek_api_sport.Adapter.PersonDiscoverAdapter;
import com.example.projek_api_sport.Model.Person.PersonDiscoverResultSportsItem;
import com.example.projek_api_sport.Model.TeamSpain.TeamSpainDiscoverResultItem;
import com.example.projek_api_sport.R;
import com.example.projek_api_sport.ViewModel.PersonViewModel;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class PersonFragment extends Fragment {

    private PersonDiscoverAdapter personDiscoverAdapter;
    private RecyclerView recyclerViewPersonDiscover;
    private PersonViewModel personViewModel;
    public PersonFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_person, container, false);
    }

    @SuppressLint("FragmentLiveDataObserve")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        personDiscoverAdapter                                                       =   new PersonDiscoverAdapter(getContext());
        personDiscoverAdapter.notifyDataSetChanged();

        recyclerViewPersonDiscover                                                  =   view.findViewById(R.id.fragmem_person_rv);
        recyclerViewPersonDiscover.setLayoutManager(new GridLayoutManager(getContext(),2));

        personViewModel                                                             =   new ViewModelProvider(this).get(PersonViewModel.class);

        personViewModel.setPersonDiscover();
        personViewModel.getPersonDiscover().observe(this,getPersonDiscover);

        recyclerViewPersonDiscover.setAdapter(personDiscoverAdapter);

    }

    private Observer<ArrayList<TeamSpainDiscoverResultItem>>getPersonDiscover   =    new Observer<ArrayList<TeamSpainDiscoverResultItem>>() {
        @Override
        public void onChanged(ArrayList<TeamSpainDiscoverResultItem> teamSpainDiscoverResultItems) {
            if(teamSpainDiscoverResultItems != null)
            {
                personDiscoverAdapter.setData(teamSpainDiscoverResultItems);
            }
        }
    };
}
