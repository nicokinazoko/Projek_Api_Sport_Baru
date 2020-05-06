package com.example.projek_api_sport.Model.Person;

import com.google.gson.annotations.SerializedName;

public class PersonDiscoverResultSportsItem {

	@SerializedName("idSport")
	private String idSport;

	@SerializedName("strFormat")
	private String strFormat;

	@SerializedName("strSport")
	private String strSport;

	@SerializedName("strSportThumb")
	private String strSportThumb;

	@SerializedName("strSportThumbGreen")
	private String strSportThumbGreen;

	@SerializedName("strSportDescription")
	private String strSportDescription;

	public String getIdSport(){
		return idSport;
	}

	public String getStrFormat(){
		return strFormat;
	}

	public String getStrSport(){
		return strSport;
	}

	public String getStrSportThumb(){
		return strSportThumb;
	}

	public String getStrSportThumbGreen(){
		return strSportThumbGreen;
	}

	public String getStrSportDescription(){
		return strSportDescription;
	}
}