package com.banana.spytutors.web.app.config;


import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.mongodb.core.MongoOperations;

import com.banana.spytutors.data.entity.Tutor;



//@Component

public class MongoTest {
	


	public static void main(String[] args) {
		
		MongoOperations mongoOperations = MongoDBContextOperations.getMongoOperations();
		List<Tutor> allTutorList =  mongoOperations.findAll(Tutor.class);
		List<Tutor> tutorListForCity = new ArrayList<Tutor>(0);
		/*for (Tutor tutor  : allTutorList) {
			String cityFromDB = tutor.getAddress().getCity().getName();
			if(StringUtils.equals("Guntur", cityFromDB)){
				tutorListForCity.add(tutor);
			}
		}
		for (Tutor tutor : tutorListForCity) {
			System.out.println(tutor.getAddress().getCity().getName());
		}
		*/
		//MongoTest mongotest = new MongoTest();		
		
		
		
	/*	
		
		MongoOperations mongoOperations = MongoDBContextOperations.getMongoOperations();
		DBCollection tutorsCollection = mongoOperations.getCollection("tutors");
		
		 @SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		 String cityName;
		 System.out.println("Enter city:");
		 cityName = (scanner.nextLine());
		 
		 
		DBCursor tutorCursor=tutorsCollection.find();
		for(DBObject tutorObject:tutorCursor){
			 DBRef addressRef = (DBRef) tutorObject.get("address");	
			 Object addressId = addressRef.getId();
			 DBCollection addressCollection = mongoOperations.getCollection(addressRef.getCollectionName());
			 DBCursor addressCursor = addressCollection.find();
			 for (DBObject addressObject : addressCursor) {
				 if(addressId.equals(addressObject.get("_id"))){
					 DBRef cityRef = (DBRef) addressObject.get("city");
						Object cityId = cityRef.getId();
						DBCollection cityCollection = mongoOperations.getCollection(cityRef.getCollectionName());
						DBCursor cityCursor = cityCollection.find(); 
						for (DBObject cityObject : cityCursor) {
							if((StringUtils.equalsIgnoreCase(cityObject.get("fcode").toString(), "PPL")) && (StringUtils.equalsIgnoreCase(cityObject.get("toponymName").toString(),cityName)) && cityId.equals(cityObject.get("_id"))) {
								DBCollection userCollection = mongoOperations.getCollection("user");
								DBCursor userCursor = userCollection.find();
								for (DBObject userObject : userCursor) {
									DBRef userRef = (DBRef) tutorObject.get("user");
									Object userId = userRef.getId();
									if(userId.equals(userObject.get("_id"))){
									DBCollection subjectCollection = mongoOperations.getCollection("subject");
										DBCursor subjectCursor = subjectCollection.find();
										for (DBObject subjectObject : subjectCursor) {
											List<DBRef> subjectList = (List<DBRef>) tutorObject.get("subjectList");
											for (DBRef subjectIdList :  subjectList) {
												if(subjectIdList.getId().equals(subjectObject.get("_id")))
												
												//System.out.println(subjectObject.get("name"));
												System.out.println("Tutorname:"+userObject.get("userName")+"----->\n"+cityObject.get("toponymName")+"----->"+tutorObject.get("experience")+
														"----->"+tutorObject.get("qualification")+"----->"+tutorObject.get("availableDayAndTimeList")+"----->"+userObject.get("phoneNumber")
														+"----->"+userObject.get("email")+"----->"+tutorObject.get("priceRangePerHour")+"----->"+subjectObject.get("name"));
											
										}
											
														
											Object subjectId = subjectRef.get(key);
											if (subjectId.equals(subjectObject.get("_id"))){
												System.out.println(userObject.get("userName")+"----->"+cityObject.get("toponymName")+"----->"+subjectObject.get("name"));
											}
										System.out.println("Tutorname:"+userObject.get("userName")+"----->\n"+cityObject.get("toponymName")+"----->"+tutorObject.get("experience")+
												"----->"+tutorObject.get("qualification")+"----->"+tutorObject.get("availableDayAndTimeList")+"----->"+userObject.get("phoneNumber")
												+"----->"+userObject.get("email")+"----->"+tutorObject.get("priceRangePerHour"));
										}
										
										 
									}
								}
							}
							
								
				 }
				
					Object cityName = cityObject.get("toponymName");
						
				}
			}
			 
			
			
			 
		}
		
		//List<CountryDTO> countryDTOList = geonamesClientService.getAllCountryList("srikanthankem");
		
		//List<Country>  countryList = GeonamesClientConverter.transferCountryDTOList(countryDTOList);
		
		//mongoOperation.insertAll(countryList);
		
		//List<Country> fetchedCountryList = mongoOperation.findAll(Country.class, "geonames");
		
		//System.out.println(fetchedCountryList.size());
		
		
	//	Country country = new Country();
		
		

		//User user = new User("srikanth6666", "srikanth7777");

		// save
		//mongoOperation.save(user);
		
		// DBCollection table = mongoOperation.getCollection("user");

		//BasicDBObject searchQuery = new BasicDBObject();
		//searchQuery.put("filed_name", "value");

		//DBCursor cursor = mongoOperation.getCollection("tutors").find();

		while (cursor.hasNext()) {
			System.out.println(cursor.next());
		}
		DBCursor cursor1=mongoOperation.getCollection("tutors").find();
		System.out.println( cursor1.count());
		//System.out.println(mongoOperation.getCollection("tutors").findOne());
		
		DBCursor tutorCurosor = mongoOperation.getCollection("tutors").find();
		while(tutorCurosor.hasNext()){
			DBObject tutorObject = tutorCurosor.next();
			
		}
		
		
		BasicDBObject searchQuery1 = new BasicDBObject("toponymName", new BasicDBObject("$regex","kanigiri").append("$options", "i"));
		
		DBCursor a = mongoOperation.getCollection("subregion").find(searchQuery1) ; 
		for(DBObject a1 : a){
			BasicDBObject searchQuery2 = new BasicDBObject("city.$id", a1.get("_id"));
			DBObject b=  mongoOperation.getCollection("address").findOne(searchQuery2);
			BasicDBObject searchQuery3 = new BasicDBObject("address.$id", b.get("_id"));
			DBObject c=mongoOperation.getCollection("tutors").findOne(searchQuery3);
			
			
			BasicDBObject searchQuery4 = new BasicDBObject("_id", c.get("user.$id"));
			DBObject d=mongoOperation.getCollection("user").findOne(searchQuery4);
			System.out.println(searchQuery4);
			
		  }
		
		for(DBObject a:cursor){
			
			System.out.println(a);
			
		}*/
		
	}
}




