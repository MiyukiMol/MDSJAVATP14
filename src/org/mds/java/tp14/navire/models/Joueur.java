package org.mds.java.tp14.navire.models;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Joueur {

	// Joueur : poss�de les diff�rents bateau � utiliser et les cases
	// Utiliser des listes pour repr�senter les cases et les bateaux
	List<Navire> listNavire = new ArrayList<Navire>();
	List<Case> listCase = new ArrayList<Case>();
	
	// Utiliser une "Map" pour repr�senter les tires effectu� sur les cases des diff�rents joueurs
	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	
	
	public int id;
	public  int map_x;
	public  int map_y;
	
	public Joueur(int id, int map_x, int map_y) {
		this.id = id;
		this.map_x = map_x;
		this.map_y = map_y;
		
		Corvette corvette = new Corvette(1, 1);
		Destroyer destroyer = new Destroyer(2, 3);
		Croiseur croiseur = new Croiseur(3, 4);
		PorteAvion porteavion = new PorteAvion(4, 6);
		
		placeBateau(id, corvette);
		placeBateau(id, destroyer);
		placeBateau(id, croiseur);
		placeBateau(id, porteavion);
		
	}
	
	// getter et setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMap_x() {
		return map_x;
	}

	public void setMap_x(int map_x) {
		this.map_x = map_x;
	}

	public int getMap_y() {
		return map_y;
	}

	public void setMap_y(int map_y) {
		this.map_y = map_y;
	}

	/**
	   * Place un bateau pour un joueur.
	   * @param joueur l'indice du joueur dans le tableau.
	   * @param navire le tableau repr�sentant le type de bateau � placer.
	   */
	  public void placeBateau(int joueur, Navire navire) {
	    // Cr�ation d'un objet pour faire de l'al�atoire.
	    Random rand = new Random();
	    
	    map_x = this.getMap_x();
	    map_y = this.getMap_y();

	    // Tirage al�atoire de x et y;
	    int x = rand.nextInt(map_x) % map_x;
	    int y = rand.nextInt(map_y) % map_y;
	    int direction = rand.nextInt(2) % 2;

	    // Bateau placable aux coordonn�es.
	    if (estPlacable(joueur, navire, x, y, direction)) {
	      placeBateauDansCarte(joueur, navire, x, y, direction);
	    } else {
	      placeBateau(joueur, navire);
	    }
	  }


	/**
	   * Indique si un bateau peut �re plac� aux coordonn�es x, y dans une direction donn�e, pour un joueur donn�
	   * @param joueur l'indice du joueur dans le tableau
	   * @param navire le tableau repr�sentant le type de navire
	   * @param x coordonn�e X
	   * @param y coordonn�e Y
	   * @param direction verticale ou horizontale
	   * @return
	   */
	private boolean estPlacable(int joueur, Navire navire, int x, int y, int direction) {
		// TODO Auto-generated method stub
		// return false;
		
		boolean result = true;

	    switch (direction) {
	    case 0:
	      // Verticale.
	      for (int i = 0; i < navire.getTaille(); i++) {
	        // Si hors de la carte.
	        if (x + i >= map_x) {
	          result = false;
	        } else
	        // Si la case contient d�j� un bateau.
	        if (((Case) listCase).getMAP_X() != 0) {
	          result = false;
	        }
	      }
	      break;

	    case 1:
	      // Horizontale.
	      for (int i = 0; i < navire.getTaille(); i++) {
	        // Si hors de la carte.
	        if (y + i >= map_y) {
	          result = false;
	        } else
	        // Si la case contient d�j� un bateau.
	        if (((Case) listCase).getMAP_Y() != 0) {
	          result = false;
	        }
	      }
	      break;
	    }
	    return result;
	}
	
	/**
	   * Place r�ellement le bateau sur la carte du joueur.
	   * @param joueur l'indice du joueur dans le tableau
	   * @param navire le tableau repr�entant le type de navire
	   * @param x coordonn�e X
	   * @param y coordonn�e Y
	   * @param direction verticale ou horizontale
	   */
	private void placeBateauDansCarte(int joueur, Navire navire, int x, int y, int direction) {
		// TODO Auto-generated method stub
		
		switch (direction) {
	    case 0:
	      // Verticale.
	      for (int i = 0; i < navire.getTaille(); i++) {
	    	  Case maps = new Case(navire.getId(), x+i,y);
	    	  this.listCase.add(maps);
	        //System.out.println("x:" + x + " y:" + y + " i:" + i);
	      }
	      break;

	    case 1:
	      // Horizontale.
	      for (int i = 0; i < navire.getTaille(); i++) {
	    	  Case maps = new Case(navire.getId(), x,y+i);
	    	  this.listCase.add(maps);
	      }
	      break;
	    }
	}

}
