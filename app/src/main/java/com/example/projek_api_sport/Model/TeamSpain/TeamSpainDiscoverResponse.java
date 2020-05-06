package com.example.projek_api_sport.Model.TeamSpain;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class TeamSpainDiscoverResponse{

	@SerializedName("teams")
	private ArrayList<TeamSpainDiscoverResultItem> teams;

	public ArrayList<TeamSpainDiscoverResultItem> getTeams(){
		return teams;
	}
}