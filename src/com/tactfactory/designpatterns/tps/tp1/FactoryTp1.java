package com.tactfactory.designpatterns.tps.tp1;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.tactfactory.designpatterns.tps.tp1.utils.ClassUtils;

/**
*
* @author tactfactory
*
* - Modifier le programme pour permettre de créer des Building au travers d'un design pattern "Factory" :
*   - 1 : Il xiste 3 façon de créer des Building*     
*     - 1 : Créer aléatoirement pour toutes les classes du package courant qui implémente "Building", qui possède un
*         constructeur vide, qui sont publiques et qui ne sont pas abstraites
*     - 2 : Créer depuis une chaine de caractère qui représente le "simpleName" de la classe à utiliser qui implémente
*         "Building", qui possède un constructeur vide, qui est publique et qui n'est pas abstraite
*     - 3 : Depuis une classe qui implémente "Building", qui possède un constructeur vide, qui est publique et qui
*         n'est pas abstraite
*         
*         
*   - 2 : Créer deux listes de building dans le point d'entré de l'application
*     - 1 : La première liste doit contenir 20 Building généré aléatoirement
*     - 2 : La deuxième doit contenir au moins une fois chaque classe qui implémente "Building", qui possède un
*         constructeur vide, qui sont publiques et qui ne sont pas abstraites. En utilisant soit les chaine de
*         caractères ou les classes
*/
public class FactoryTp1 {

  public static void main(String[] args) throws ClassNotFoundException, IOException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
	  List<Building> buildings = new ArrayList<>();

	  for (Class<?> klazz :  ClassUtils.getClasses("com.tactfactory.designpatterns.tps.tp1")) {
		  if(klazz.getInterfaces().length > 0 && klazz.getInterfaces()[0].getName().equals(Building.class.getName())) {
			  buildings.add((Building) klazz.getConstructor().newInstance());
		  }		  
	  }	  
	  
	  randomTown(buildings);
	  System.out.println("---------------------------");
	  manualTown(buildings, "House");
	  System.out.println("---------------------------");
	  allTown(buildings);
  }

  private static void manualTown(List<Building> buildings, String simpleName) {
	  System.out.println("manual: ");
	  for(Building building : buildings) {
		  if(building.getClass().getSimpleName().equals(simpleName)) {
			 System.out.println(building.getClass().getSimpleName());
		  }
	  }
  }

  private static void randomTown(List<Building> buildings) throws ClassNotFoundException, IOException {
	  System.out.println("randoms: ");
	  for (int i = 0; i < 20; i++) {
		  Random randInt= new Random();
		  int numb = randInt.nextInt(buildings.size());
		  System.out.println((i+1) + " : " + buildings.get(numb).getClass().getSimpleName());
	  }  
  }
  
  private static void allTown(List<Building> buildings) {
	  System.out.println("all: ");
	  for(Building building : buildings) {
		 System.out.println(building.getClass().getSimpleName());
	  }
  }

}
