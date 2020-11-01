package org.mds.java.tp14;

import org.mds.java.tp14.navire.manager.Jeu;

public class Tp14 {

	  public static void main(String[] args) {

		    // Création des variable utilisé dans la fonction.
		    boolean fini = false;
		    int cible = 0;

		    Jeu.placeToutBateau();


		    // Boucle tant que le jeu n'est pas fini.
		    while (!fini) {
		      // Pour chaque joueur.
		      for (int i = 0; !fini && i < Jeu.mapsTout.getJOUEURS(); i++) {
		        cible = Jeu.trouveCible(i);

		        // Si une cible est trouvé.
		        if (cible != -1) {
		          Jeu.tire(cible);

		          Jeu.afficheCartePlacement(i);
		          System.out.println();
		        } else {
		          // Le jeu est fini.
		          fini = true;
		        }
		      }
		    }

		
			String gagnant = null;
			// Je cherche le seul joueur encore en vie.
		    for (int i = 0; i < Jeu.mapsTout.getJOUEURS(); i++) {
		      if (Jeu.estVivant(i)) {
		        gagnant = "joueur " + (i + 1);
		      }
		      Jeu.afficheCartePlacement(i);
		      System.out.println();
		    }

		    System.out.println("Le gagant est : " + gagnant);
		  }
}
