package mySplashThread8.model.base.entity;

import java.io.Serializable;

public class CustomApplication implements Serializable, Comparable<CustomApplication>, Cloneable {
	private int id;
	

	private String name;
	private String displayName;
	private String description;
	private String plgnLocale;
	

	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	

	public String getPlgnLocale() {
		return plgnLocale;
	}

	public void setPlgnLocale(String plgnLocale) {
		this.plgnLocale = plgnLocale;
	}

	public CustomApplication() {
		
	}
	
	public CustomApplication(int id, String name,String displayName,String description,String locale) {
		this.id=id;
		this.name = name;
		this.displayName = displayName;
		this.description = description;
		this.plgnLocale = locale;
	}
	
	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public int compareTo(CustomApplication arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
