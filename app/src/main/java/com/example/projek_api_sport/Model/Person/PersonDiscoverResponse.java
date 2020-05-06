package com.example.projek_api_sport.Model.Person;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class PersonDiscoverResponse{

	@SerializedName("sports")
	private ArrayList<PersonDiscoverResultSportsItem> sports;

	public ArrayList<PersonDiscoverResultSportsItem> getSports(){
		return sports;
	}
}