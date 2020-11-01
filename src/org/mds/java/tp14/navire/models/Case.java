package org.mds.java.tp14.navire.models;

public class Case {

	/**
	 * Cartes utilisé par l'ensemble des joueurs.
	 */
	//private static int[][][] maps;
	private int JOUEURS;
	private int MAP_X;
	private int MAP_Y;

	// private final static int JOUEURS = 2;
	
	public Case(int JOUEURS, int MAP_X, int MAP_Y) {
		this.setJOUEURS(JOUEURS);
		this.setMAP_X(MAP_X);
		this.setMAP_Y(MAP_Y);
	}

	public int getMAP_X() {
		return MAP_X;
	}

	public void setMAP_X(int mAP_X) {
		MAP_X = mAP_X;
	}

	public int getMAP_Y() {
		return MAP_Y;
	}

	public void setMAP_Y(int mAP_Y) {
		MAP_Y = mAP_Y;
	}

	public int getJOUEURS() {
		return JOUEURS;
	}

	public void setJOUEURS(int jOUEURS) {
		JOUEURS = jOUEURS;
	}

	
	
}
