package mySplashThread8;

import mySplashThread8.model.base.dao.CustomApplicationDAO;

public class FactoryDAO {
	private CustomApplicationDAO affiliationDAO;
	public FactoryDAO(String baseUrl)  {

	    

	    affiliationDAO = new CustomApplicationDAO(baseUrl);
	}
	 public CustomApplicationDAO getAffiliationDAO() {
		    return affiliationDAO;
		  }
}
