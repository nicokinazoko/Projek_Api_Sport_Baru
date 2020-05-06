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

import com.example.projek_api_sport.Adapter.TeamDiscoverAdapter;
import com.example.projek_api_sport.Model.Team.TeamsDiscoverResultItem;
import com.example.projek_api_sport.R;
import com.example.projek_api_sport.ViewModel.TeamViewModel;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class TeamFragment extends Fragment {

    private TeamDiscoverAdapter teamDiscoverAdapter;
    private RecyclerView recyclerViewTeamDiscover;
    private TeamViewModel teamViewModel;


    public TeamFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_team, container, false);
    }

    @SuppressLint("FragmentLiveDataObserve")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        teamDiscoverAdapter                                                 =   new TeamDiscoverAdapter(getContext());
        teamDiscoverAdapter.notifyDataSetChanged();

        recyclerViewTeamDiscover                                            =   view.findViewById(R.id.fragmem_team_rv);
        recyclerViewTeamDiscover.setLayoutManager(new GridLayoutManager(getContext(),2));

        teamViewModel                                                       =   new ViewModelProvider(this).get(TeamViewModel.class);

        teamViewModel.setTeamDiscover();
        teamViewModel.getTeamDiscover().observe(this,getTeamDiscover);

        recyclerViewTeamDiscover.setAdapter(teamDiscoverAdapter);
    }

    private Observer<ArrayList<TeamsDiscoverResultItem>> getTeamDiscover    =    new Observer<ArrayList<TeamsDiscoverResultItem>>() {
        @Override
        public void onChanged(ArrayList<TeamsDiscoverResultItem> teamsDiscoverResultItems) {
            if(teamsDiscoverResultItems != null)
            {
                teamDiscoverAdapter.setData(teamsDiscoverResultItems);


            }
        }
    };
}
