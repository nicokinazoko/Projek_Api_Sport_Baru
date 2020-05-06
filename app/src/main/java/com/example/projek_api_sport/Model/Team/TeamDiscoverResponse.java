package com.example.projek_api_sport.Model.Team;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class TeamDiscoverResponse{

	@SerializedName("teams")
	private ArrayList<TeamsDiscoverResultItem> teams;

	public void setTeams(ArrayList<TeamsDiscoverResultItem> teams){
		this.teams = teams;
	}

	public ArrayList<TeamsDiscoverResultItem> getTeams(){
		return teams;
	}

	@Override
 	public String toString(){
		return 
			"TeamDiscoverResponse{" + 
			"teams = '" + teams + '\'' + 
			"}";
		}
}