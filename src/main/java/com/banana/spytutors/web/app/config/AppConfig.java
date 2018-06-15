package com.banana.spytutors.web.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.banana.spytutors.data.service.TutorDataService;
import com.banana.spytutors.data.service.TutorDataServiceImpl;
import com.banana.spytutors.web.common.FacesMessagesDelegate;
import com.banana.spytutors.web.common.FileUploadBean;
import com.banana.spytutors.web.common.NavigationBean;
import com.banana.spytutors.web.service.RefDataService;
import com.banana.spytutors.web.service.RefDataServiceImpl;

import com.banana.spytutors.web.service.TutorService;
import com.banana.spytutors.web.service.TutorServiceImpl;



@Configuration
@ComponentScan({"com.banana.spytutors.web","com.banana.spytutors.data"})
@EnableMongoRepositories({"com.banana.spytutors.web.app.config"}) 
@Import({MongoDBConfig.class})
public class AppConfig {
	
	
	@Bean
	public RefDataService refDataService(){
		return new RefDataServiceImpl();
	}
	
	@Bean
	public TutorDataService tutorDataService() {
	    return new TutorDataServiceImpl();	
	}
	
	@Bean
	public TutorService tutorService() {
	    return new TutorServiceImpl();	
	}
	
	@Bean
	public FacesMessagesDelegate messagesDelegate(){
		return new FacesMessagesDelegate();
	}
	
	@Bean
	public FileUploadBean fileUploadBean(){
		return new FileUploadBean();
	}
	
	@Bean
	public  NavigationBean navBean(){
		return new NavigationBean();
	}
	
}
