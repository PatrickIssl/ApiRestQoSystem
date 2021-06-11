package com.issler.patrick.QoSystem.metodos;

import java.util.Random;

public class GerarMfa {

	public static String gerarMfa() {
		
		Random gerador = new Random();
		String mfa = "";

		String lista[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
				"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
//		36
		for(int i = 0; i < 5 ; i++) {
			mfa = mfa + lista[gerador.nextInt(lista.length)];
		}
		
		
		
		return mfa;
	}
	
}
