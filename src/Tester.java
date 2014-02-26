//***********************************
 //* 
 //* This is the tester class for a 
 //* a Black Jack Game
 //*
 //* Written by Amy Ho 
 //* (UNI: ah2703)
 //*********************************

public class Tester {

	public static void main(String[] args) {
		
		System.out.println("Let's play Black Jack");
		Money moneyObject = new Money();		
		moneyObject.buyCoins();
		
		Game g = new Game();
		g.play();
		
	}

}