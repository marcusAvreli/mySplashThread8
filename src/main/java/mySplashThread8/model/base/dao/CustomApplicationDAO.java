package mySplashThread8.model.base.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.ProcessingException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javassist.bytecode.analysis.Util;
import mySplashThread8.model.base.entity.CustomApplication;
import mySplashThread8.model.base.entity.ErrorDTO;




public class CustomApplicationDAO {
	private static final Logger logger = LoggerFactory.getLogger(CustomApplicationDAO.class);

	private String baseUrl;
	
	public CustomApplicationDAO(String baseUrl) {
		this.baseUrl = baseUrl;
	}
	public  List<CustomApplication> getData() {	
		
		String baseURL = this.baseUrl+"/customApplication";		
		//logger.info("result url:"+baseURL);		
		Client client = ClientBuilder.newClient();		
		List<	CustomApplication> resultList = null;	
		Response response = (Response) client.target(baseURL).request("application/json;charset=UTF-8").accept("application/json;charset=UTF-8").get();
		try {
		    if (response.getStatus() == Response.Status.OK.getStatusCode()) {
		    	resultList = response.readEntity(new GenericType<List<CustomApplication>>() {});	
		    	if(null != resultList && !resultList.isEmpty()) {
		    	//	logger.info("result List size:"+resultList.size());
		    	}
		    }
		    else {
				//logger.info("checkpost_3");
				// if they put the custom error stuff in the entity       	
				GenericType<ErrorDTO> errorMessage = new GenericType<ErrorDTO>() {};
				ErrorDTO errorObject= response.readEntity( errorMessage) ;
				//logger.info("httpCode:"+errorObject.getHttpCode());
				//logger.info("message:"+errorObject.getMessage());				
		    }          
		}
		catch (ProcessingException ex){
			//logger.info("exception");
		}
		//logger.info("get data finish");
		return resultList;
	}
	public void deleteById(String id) {
		logger.info("START delete function to web service");
		String baseURL = this.baseUrl+"/customApplication/delete/"+id;	
		logger.info("result url:"+baseURL);
		Client client = ClientBuilder.newClient();
		 //client.target(baseURL)
		Response response = (Response) client.target(baseURL).request("application/json;charset=UTF-8").accept("application/json;charset=UTF-8").get();
        int responseCode = response.getStatus();
        logger.info("response code:"+responseCode);
        // .request(MediaType.APPLICATION_JSON).post(Entity.json(customApplication));
		 
		 logger.info("FINISH delete function to web service");
	}
	public void save(CustomApplication customApplication) {
		//logger.info("START save function to web service");
		String baseURL = this.baseUrl+"/customApplication/save";	
		//logger.info("result url:"+baseURL);
		Client client = ClientBuilder.newClient();
		 client.target(baseURL)
        
         .request(MediaType.APPLICATION_JSON).post(Entity.json(customApplication));
		 
		// logger.info("FINISH save function to web service");
	}
	public void save(int id,String name,String displayName,String description) {
		CustomApplication customApplication = new CustomApplication(id,name,displayName,description,"en_US");
		save(customApplication);
	}
	
	public CustomApplication getById(int id) {
		logger.info("get single data start");
		String baseURL = this.baseUrl+"/customApplication/"+id;
		logger.info("result url:"+baseURL);
		Client client = ClientBuilder.newClient();		
		CustomApplication customApplication = null;
		Response response = (Response) client.target(baseURL).request("application/json;charset=UTF-8").accept("application/json;charset=UTF-8").get();
		try {
		    if (response.getStatus() == Response.Status.OK.getStatusCode()) {
		    	 customApplication = response.readEntity(CustomApplication.class );	
		    	logger.info("got custom application");
		    }
		    else {
				logger.info("checkpost_3");
				// if they put the custom error stuff in the entity       	
				GenericType<ErrorDTO> errorMessage = new GenericType<ErrorDTO>() {};
				ErrorDTO errorObject= response.readEntity( errorMessage) ;
				logger.info("httpCode:"+errorObject.getHttpCode());
				logger.info("message:"+errorObject.getMessage());				
		    }          
		}
		catch (ProcessingException ex){
			logger.info("exception");
		}
		logger.info("get single data finish");
		return customApplication;
	}
}


