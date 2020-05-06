package com.example.projek_api_sport.Service;

import com.example.projek_api_sport.Model.Person.PersonDiscoverResponse;
import com.example.projek_api_sport.Model.Team.TeamDiscoverResponse;
import com.example.projek_api_sport.Model.TeamSpain.TeamSpainDiscoverResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PersonRepository {

//    @GET("api/v1/json/1/all_sports.php")
//    Call<PersonDiscoverResponse>getPersonDiscover();

    @GET("api/v1/json/1/search_all_teams.php?s=Soccer&c=Spain")
    Call<TeamSpainDiscoverResponse>getPersonDiscover();
}
