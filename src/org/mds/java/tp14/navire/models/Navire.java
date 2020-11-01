package org.mds.java.tp14.navire.models;

// D'utiliser un héritage pour représenter les "Navire" 
public class Navire {
	
	public int direction;
	public int id;  // l'identifiant de bateau
	public int taille;  // taille de bateau
	
	public Navire(int id, int taille) {
		this.id = id;
		this.taille = taille;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	@Override
	public String toString() {
		return "Navire [id=" + id + ", taille=" + taille + "]";
	}	
}
