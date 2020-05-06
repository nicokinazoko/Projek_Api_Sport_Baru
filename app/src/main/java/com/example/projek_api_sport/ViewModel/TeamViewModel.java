package com.example.projek_api_sport.ViewModel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.projek_api_sport.Model.Team.TeamDiscoverResponse;
import com.example.projek_api_sport.Model.Team.TeamsDiscoverResultItem;
import com.example.projek_api_sport.Service.ApiMain;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TeamViewModel extends ViewModel {
    private ApiMain apiMain;

    private MutableLiveData<ArrayList<TeamsDiscoverResultItem>> listDiscoverTeam                =   new MutableLiveData<>();

    public void setTeamDiscover()
    {
        if (this.apiMain == null)
        {
            apiMain                                                                             =   new ApiMain();
        }

        apiMain.getApiTeam().getTeamDiscover().enqueue(new Callback<TeamDiscoverResponse>() {
            @Override
            public void onResponse(Call<TeamDiscoverResponse> call, Response<TeamDiscoverResponse> response) {
                TeamDiscoverResponse teamDiscoverResponse                                       =   response.body();

                if(teamDiscoverResponse != null && teamDiscoverResponse.getTeams() != null)
                {
                    ArrayList<TeamsDiscoverResultItem> teamsDiscoverResultItems                 =   teamDiscoverResponse.getTeams();
                    listDiscoverTeam.postValue(teamsDiscoverResultItems);
                }

            }

            @Override
            public void onFailure(Call<TeamDiscoverResponse> call, Throwable t) {
                t.getMessage();
                Log.e("Error", t.getMessage());
            }
        });
    }

    public LiveData<ArrayList<TeamsDiscoverResultItem>> getTeamDiscover()
    {
        return listDiscoverTeam;
    }

}
