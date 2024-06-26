package com.naveenautomationlabs.Browsers;

public enum CitiesInOntario {
	TORONTO("Toronto"),
	OTTAWA("Ottawa"),
	MISSISSAUGA("Mississauga"),
	BRAMPTON("Brampton"),
	HAMILTON("Hamilton"),
	LONDON("London"),
	MARKHAM("markhm"),
	VAUGHAN("varghan"),
	KITCHENER("Kitchener"),
	WINDSOR("Windsor"),
	RICHMOND_HILL("Richmond Hill"),
	BURLINGTON("Burlington"),
	OSHAWA("Oshawa"),
	SUDBURY("Greater Sudbury"),
	BARRIE("Barrie"),
	GUELPH("Guelph"),
	CAMBRIDGE("Cambridge"),
	ST_CATHERINES("St. Catharines"),
	WATERLOO("Waterloo"),
	THUNDER_BAY("Thunder Bay"),
	BARNTFORD("Brantford"),
	PICKERING("Pickering"),
	NIAGRA_FALLS("Niagara Falls"),
	PETERBOROUGH("Peterborough"),
	SAULT_STE_MARIE("Sault Ste. Marie"),
	SARNIA("Sarnia"),
	NORFOLK_COUNTY("Norfolk County"),
	WELLAND("Welland"),
	BELLEVILLE("Belleville"),
	NORTH_BAY("North Bay");
	
	String cities;

	private CitiesInOntario(String cities) {
		this.cities = cities;
	}

	public String getCities() {
		return cities;
	}


		
	}
	


