package com.example.projek_api_sport.Service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiMain {
    private Retrofit retrofit;


    public TeamRepository getApiTeam()
    {
        String BASE_URL                                     =   "https://www.thesportsdb.com/";
        if(retrofit == null)
        {
            retrofit                                        =
                    new Retrofit
                            .Builder()
                            .baseUrl(BASE_URL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
        }
        return retrofit.create(TeamRepository.class);
    }


    public PersonRepository getApiSport()
    {
        String BASE_URL                                     =   "https://www.thesportsdb.com/";
        if(retrofit == null)
        {
            retrofit                                        =
                    new Retrofit
                            .Builder()
                            .baseUrl(BASE_URL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
        }

        return retrofit.create(PersonRepository.class);
    }
}
