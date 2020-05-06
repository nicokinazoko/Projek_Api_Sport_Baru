package com.example.projek_api_sport.ViewModel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.projek_api_sport.Model.Person.PersonDiscoverResponse;
import com.example.projek_api_sport.Model.Team.TeamDiscoverResponse;
import com.example.projek_api_sport.Model.TeamSpain.TeamSpainDiscoverResponse;
import com.example.projek_api_sport.Model.TeamSpain.TeamSpainDiscoverResultItem;
import com.example.projek_api_sport.Service.ApiMain;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PersonViewModel extends ViewModel {

    private ApiMain apiMain;

    private MutableLiveData<ArrayList<TeamSpainDiscoverResultItem>> listDiscoverPersonItem       =   new MutableLiveData<>();

    public void setPersonDiscover() {
        if (this.apiMain == null) {
            apiMain = new ApiMain();
        }

        apiMain.getApiSport().getPersonDiscover().enqueue(new Callback<TeamSpainDiscoverResponse>() {

            @Override
            public void onResponse(Call<TeamSpainDiscoverResponse> call, Response<TeamSpainDiscoverResponse> response) {
                TeamSpainDiscoverResponse teamSpainDiscoverResponse = response.body();

                if (teamSpainDiscoverResponse != null && teamSpainDiscoverResponse.getTeams() != null) {
                    ArrayList<TeamSpainDiscoverResultItem> teamSpainDiscoverResultItems = teamSpainDiscoverResponse.getTeams();
                    listDiscoverPersonItem.postValue(teamSpainDiscoverResultItems);
                }
            }

            @Override
            public void onFailure(Call<TeamSpainDiscoverResponse> call, Throwable t) {
                t.getMessage();
                Log.e("Error", t.getMessage());
            }
        });

    }
    public LiveData<ArrayList<TeamSpainDiscoverResultItem>> getPersonDiscover()
    {
        return listDiscoverPersonItem;
    }

}
