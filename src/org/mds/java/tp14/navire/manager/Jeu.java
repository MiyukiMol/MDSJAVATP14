package org.mds.java.tp14.navire.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.mds.java.tp14.navire.models.Case;
import org.mds.java.tp14.navire.models.Joueur;
import org.mds.java.tp14.navire.models.Navire;



public class Jeu {

	/**
	   * Gestion des couleurs
	   */
	  public static final String ANSI_RESET = "\u001B[0m";
	  public static final String ANSI_BLACK = "\u001B[30m";
	  public static final String ANSI_RED = "\u001B[31m";
	  public static final String ANSI_GREEN = "\u001B[32m";
	  public static final String ANSI_YELLOW = "\u001B[33m";
	  public static final String ANSI_BLUE = "\u001B[34m";
	  public static final String ANSI_PURPLE = "\u001B[35m";
	  public static final String ANSI_CYAN = "\u001B[36m";
	  public static final String ANSI_WHITE = "\u001B[37m";
	  
	  
	  private static int MAP_X = 5;
	  private static int MAP_Y =2;

	  private static int JOUEURS = 2;
	  

	  /**
	   * Création d'un objet pour faire de l'aléatoire.
	   */
	  private static Random rand = new Random();
	  
	  private List<Joueur> listJoueur = new ArrayList<Joueur>();
	  
	  public Jeu(int JOUEURS, int MAP_X, int MAP_Y) {
		  this.JOUEURS = JOUEURS;
		  this.MAP_X = MAP_X;
		  this.MAP_Y = MAP_Y;
	  }

	  /**
	   * Contient le nom du joueur gagnant.
	   */
	  private static String gagnant;
	  
	  

	  static List<Navire> listNavire = new ArrayList<Navire>();
	  static List<Case> listCase = new ArrayList<Case>();

	/**
	   * Place tous les bateaux pour tous les joueurs.
	   */

	  public static void placeToutBateau() {
		    // Pour chaque joueur.
		  	
		    for (int i = 0; i < mapsTout.getJOUEURS(); i++) {
		      // Pour chaque navire.
		      for (Navire navire : listNavire) {
		        for (int j = 0; j < mapsTout.getMAP_X(); j++) {
		          Joueur classJoueur = new Joueur(j, j, j);
		          classJoueur.placeBateau(i, navire);
		  
		        }
		      }

		      // Affiche la carte avec les bateaux placé pour le joueur courant.
		      afficheCartePlacement(i);
		      System.out.println();
		    }

		    System.out.println("Début du combat");
		  }
	  
	  

	  public static Case mapsTout = new Case(JOUEURS, MAP_X, MAP_Y);

	public static void afficheCartePlacement(int i) {
		// TODO Auto-generated method stub
	    for (int i = 0; i < mapsTout.getJOUEURS(); i++) {
		      for (int j = 0; j < mapsTout.getMAP_X(); j++) {
		        StringBuilder result = new StringBuilder();
		        switch (listCase(JOUEURS, i, j)) {
		        case 8:
		          result.append(ANSI_YELLOW);
		          break;
		        case 9:
		          result.append(ANSI_RED);
		          break;
		        case 1:
		        case 2:
		        case 3:
		        case 4:
		          result.append(ANSI_PURPLE);
		          break;
		        default:
		          result.append(ANSI_BLUE);
		          break;
		        }
		        result.append(listCase(JOUEURS, i, j));
		        result.append(" ");
		        result.append(ANSI_RESET);
		        System.out.print(result.toString());
		      }
		      System.out.println();
		    }
	}


	/**
	   * Indique si le joueur  l'indice joueur est encore considéré comme vivant.
	   * @param joueur indice du joueur dans le tableau de jeu.
	   * @return
	   */
	  public static boolean estVivant(int joueur) {
	    boolean result = false;

	    for (int i = 0; i < mapsTout.getJOUEURS(); i++) {
	    	
	      for (int j = 0; j < mapsTout.getMAP_X(); j++) {
	    	  
	        if (listCase(JOUEURS, i, j) != 0 && listCase(JOUEURS, i, j) != 8 && listCase(JOUEURS, i, j) != 9) {
	          result = true;
	        }
	      }
	    }

	    return result;
	  }
	  
	  /**
	   * Trouve la prochaine cible en vie.
	   * @param attaquant l'indice de l'attaquant.
	   * @return l'adversaire suivant.
	   */
	  public static int trouveCible(int attaquant) {
	    int adversaire = -1;
	    boolean flag = true;
	    int i = attaquant;

	    do {
	      // Vérification de l'indice pour ne pas sortir du tableau
	      if (i + 1 == mapsTout.getJOUEURS()) {
	        i = 0;
	      } else {
	        i++;
	      }

	      if (estVivant(i)) {
	        adversaire = i;
	        flag = false;
	      }
	    } while (flag && i != attaquant);

	    if (i == attaquant) {
	      adversaire = -1;
	    }

	    return adversaire;
	  }
	  
	  /**
	   * Tire sur le joueur ciblé
	   * @param joueurCible indice du joueur ciblé
	   */
	  public static void tire(int cible) {
		// TODO Auto-generated method stub
		// Tirage aléatoire de x et y;
		    int x = -1;
		    int y = -1;

		    do {
		      x = rand.nextInt(MAP_X) % MAP_X;
		      y = rand.nextInt(MAP_Y) % MAP_Y;
		      

		      if (listCase(JOUEURS, x, y) == 0) {
		    	  listCase(JOUEURS, x, y) = 8;
		      } else if (listCase(JOUEURS, x, y) == 1 || listCase(JOUEURS, x, y) == 2 || listCase(JOUEURS, x, y) == 3
		          || listCase(JOUEURS, x, y) == 4) {
		    	  listCase(JOUEURS, x, y) = 9;
		      }
		    } while (listCase(JOUEURS, x, y) != 8 && listCase(JOUEURS, x, y) != 9);
	}

	public static Random getRand() {
		return rand;
	}

	public static void setRand(Random rand) {
		Jeu.rand = rand;
	}

	public List<Joueur> getListJoueur() {
		return listJoueur;
	}

	public void setListJoueur(List<Joueur> listJoueur) {
		this.listJoueur = listJoueur;
	}


}
