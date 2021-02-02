package com.tactfactory.designpatterns.tps.tp1;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;


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
	  List<Building> list1 = ConcreteCreator.createProduct("randoms");
	  for(Building building : list1) {
		  building.doSmt();
	  }
	  List<Building> list2 = ConcreteCreator.createProduct("allTown");
	  for(Building building : list2) {
		  building.doSmt();
	  }
	  List<Building> list3 = ConcreteCreator.createProduct("House");
	  for(Building building : list3) {
		  building.doSmt();
	  }

  }

}
