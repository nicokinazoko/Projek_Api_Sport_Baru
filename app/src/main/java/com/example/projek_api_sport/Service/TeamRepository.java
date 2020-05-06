package com.example.projek_api_sport.Service;

import com.example.projek_api_sport.Model.Team.TeamDiscoverResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TeamRepository {

    @GET("api/v1/json/1/lookup_all_teams.php?id=4328")
    Call<TeamDiscoverResponse>getTeamDiscover();



}
