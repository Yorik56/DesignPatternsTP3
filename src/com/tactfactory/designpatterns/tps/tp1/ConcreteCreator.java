package com.tactfactory.designpatterns.tps.tp1;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.tactfactory.designpatterns.tps.tp1.utils.ClassUtils;

public class ConcreteCreator {
	
	public static  List<Building>  createProduct(String criteria) throws ClassNotFoundException, IOException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {

	    List<Building> buildings = new ArrayList<>();
	    List<Building> result = null;
	    
	    for (Class<?> klazz :  ClassUtils.getClasses("com.tactfactory.designpatterns.tps.tp1")) {
			  if(klazz.getInterfaces().length > 0 && klazz.getInterfaces()[0].getName().equals(Building.class.getName())) {
				  buildings.add((Building) klazz.getConstructor().newInstance());
			  }		  
	    }
	    
	    switch (criteria) {
	    case "randoms":
	    	 result = randomTown(buildings);
	      break;
	      
	    case "allTown":
	    	result = allTown(buildings);	
		      break;

	    default:
	    	 result =  manualTown(buildings, "House");
	      break;
	    }

	    return result;
	  }
	
	private static List<Building> manualTown(List<Building> buildings, String simpleName) {
		List<Building> result = new ArrayList<>();
		  System.out.println("manual: ");
		  for(Building building : buildings) {
			  if(building.getClass().getSimpleName().equals(simpleName)) {
				 switch (building.getClass().getSimpleName()) {
				    case "CityHall":
				    	Building newBuildCityHall = new CityHall();
				    	result.add(newBuildCityHall);
				      break;
				      
				    case "FireDepartment":
				    	Building newBuildFireDepartment = new FireDepartment();
				    	result.add(newBuildFireDepartment);
					      break;
					      
				    case "House":
				    	Building newBuildHouse = new House();
				    	result.add(newBuildHouse);
					      break;
					      
				    case "Market":
				    	Building newBuildMarket = new Market();
				    	result.add(newBuildMarket);
					      break;
				    case "PowerPlant":
				    	Building newBuildPowerPlant = new PowerPlant();
				    	result.add(newBuildPowerPlant);
					      break;
					      
				    case "School":
				    	Building newBuildSchool = new School();
				    	result.add(newBuildSchool);
					      break;
					      
				    case "WaterTower":
				    	Building newBuildWaterTower = new WaterTower();
				    	result.add(newBuildWaterTower);
					      break;

				    default:
				      break;				      

				   }
			  }
			  
		  }
		return result;
	  }

	  private static List<Building> randomTown(List<Building> buildings) throws ClassNotFoundException, IOException {
		  List<Building> result = new ArrayList<>();
		  System.out.println("randoms: ");
		  for (int i = 0; i < 20; i++) {
			  Random randInt= new Random();
			  int numb = randInt.nextInt(buildings.size());
			  switch ( buildings.get(numb).getClass().getSimpleName()) {
			    case "CityHall":
			    	Building newBuildCityHall = new CityHall();
			    	result.add(newBuildCityHall);
			      break;
			      
			    case "FireDepartment":
			    	Building newBuildFireDepartment = new FireDepartment();
			    	result.add(newBuildFireDepartment);
				      break;
				      
			    case "House":
			    	Building newBuildHouse = new House();
			    	result.add(newBuildHouse);
				      break;
				      
			    case "Market":
			    	Building newBuildMarket = new Market();
			    	result.add(newBuildMarket);
				      break;
			    case "PowerPlant":
			    	Building newBuildPowerPlant = new PowerPlant();
			    	result.add(newBuildPowerPlant);
				      break;
				      
			    case "School":
			    	Building newBuildSchool = new School();
			    	result.add(newBuildSchool);
				      break;
				      
			    case "WaterTower":
			    	Building newBuildWaterTower = new WaterTower();
			    	result.add(newBuildWaterTower);
				      break;

			    default:
			      break;				      

			   }
		  }
		return result;  
	  }
	  
	  private static List<Building> allTown(List<Building> buildings) {
		  List<Building> result = new ArrayList<>();
		  System.out.println("all: ");
		  for(Building building : buildings) {
			 switch ( building.getClass().getSimpleName()) {
			    case "CityHall":
			    	Building newBuildCityHall = new CityHall();
			    	result.add(newBuildCityHall);
			      break;
			      
			    case "FireDepartment":
			    	Building newBuildFireDepartment = new FireDepartment();
			    	result.add(newBuildFireDepartment);
				      break;
				      
			    case "House":
			    	Building newBuildHouse = new House();
			    	result.add(newBuildHouse);
				      break;
				      
			    case "Market":
			    	Building newBuildMarket = new Market();
			    	result.add(newBuildMarket);
				      break;
			    case "PowerPlant":
			    	Building newBuildPowerPlant = new PowerPlant();
			    	result.add(newBuildPowerPlant);
				      break;
				      
			    case "School":
			    	Building newBuildSchool = new School();
			    	result.add(newBuildSchool);
				      break;
				      
			    case "WaterTower":
			    	Building newBuildWaterTower = new WaterTower();
			    	result.add(newBuildWaterTower);
				      break;

			    default:
			      break;				      

			   }
		  }
		  return result; 
	  }
}
