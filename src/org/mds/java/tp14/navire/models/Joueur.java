package org.mds.java.tp14.navire.models;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Joueur {

	// Joueur : possède les différents bateau à utiliser et les cases
	// Utiliser des listes pour représenter les cases et les bateaux
	List<Navire> listNavire = new ArrayList<Navire>();
	List<Case> listCase = new ArrayList<Case>();
	
	// Utiliser une "Map" pour représenter les tires effectué sur les cases des différents joueurs
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
	   * @param navire le tableau reprï¿½sentant le type de bateau ï¿½ placer.
	   */
	  public void placeBateau(int joueur, Navire navire) {
	    // Création d'un objet pour faire de l'aléatoire.
	    Random rand = new Random();
	    
	    map_x = this.getMap_x();
	    map_y = this.getMap_y();

	    // Tirage aléatoire de x et y;
	    int x = rand.nextInt(map_x) % map_x;
	    int y = rand.nextInt(map_y) % map_y;
	    int direction = rand.nextInt(2) % 2;

	    // Bateau placable aux coordonnées.
	    if (estPlacable(joueur, navire, x, y, direction)) {
	      placeBateauDansCarte(joueur, navire, x, y, direction);
	    } else {
	      placeBateau(joueur, navire);
	    }
	  }


	/**
	   * Indique si un bateau peut êre placé aux coordonnées x, y dans une direction donnée, pour un joueur donné
	   * @param joueur l'indice du joueur dans le tableau
	   * @param navire le tableau reprï¿½sentant le type de navire
	   * @param x coordonnée X
	   * @param y coordonnée Y
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
	        // Si la case contient déjà un bateau.
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
	        // Si la case contient dï¿½jï¿½ un bateau.
	        if (((Case) listCase).getMAP_Y() != 0) {
	          result = false;
	        }
	      }
	      break;
	    }
	    return result;
	}
	
	/**
	   * Place réellement le bateau sur la carte du joueur.
	   * @param joueur l'indice du joueur dans le tableau
	   * @param navire le tableau repréentant le type de navire
	   * @param x coordonnée X
	   * @param y coordonnée Y
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
