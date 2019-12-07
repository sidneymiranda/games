package games;

import java.util.Scanner;
import java.util.Random;

public class CampoMinado {

	public static void main(String[] args) {
		iniciar();
	}
	
	static void iniciar() {
		imprimir(gerarTabuleiro());
	}
	
	
	
	static String[][] gerarTabuleiro() {
		String[][] tabuleiro = new String[16][16];
		Random random = new Random();
		int lin,col;
		
		//GERA AS POSIÇÕES DAS BOMBAS
		for (int i = 0; i < 16; ) {
	
			lin = random.nextInt((15));
			col = random.nextInt((15));
			
			//0 indica bomba
			if(tabuleiro[lin][col] == "|__0__|") {
				gerarTabuleiro();
			}else {
				tabuleiro[lin][col] = "|__0__|";
				i++;
			}
							
		}
		
		//COMPLETA AS POSIÇÕES QUE NÃO TEM BOMBA
		for (int i = 0; i < tabuleiro.length; i++) {
			for (int j = 0; j < tabuleiro[i].length; j++) {		
				if (tabuleiro[i][j] != "|__0__|") {
					tabuleiro[i][j] = "|_____|";
				}				
			}
		}
		return tabuleiro;
	}
	

	static String[][] prepararGame(String[][] tabuleiro){
		String[][] numero = new String[16][16];
		Random ent = new Random();
		int bombas = 0, l=0,c=0;
		
		
		for (int i = 0; i < numero.length; i++) {
			for (int j = 0; j < numero[i].length; j++) {
				//ATRIBUINDO AS BOMBAS AS POSIÇÕES DO TABULEIRO
				numero[i][j] = tabuleiro[i][j];
				
				//VERIFICANDO SE NA POSIÇÃO TEM BOMBA E ALIMENTA O CONTADOR EM CASO POSITIVO
				if (numero[i][j] == "__0__") {
					bombas++;
				}
			}
		}
		
		
		//USUARIO ABRINDO AS POSIÇÕES DO TABULEIRO
		while(bombas > 0) {
			System.out.println("ENTRE COM A POSIÇÃO DA LINHA:");
			l = ent.nextInt();
			System.out.println("ENTRE COM A POSIÇÃO DA COLUNA:");
			c = ent.nextInt();
			
			if (numero[l][c] == "__0__") {
				System.out.print("VOCÊ PERDEU!");
				bombas = 0;
			}else {
				
			}
		}		
		return numero;
	}
	
	
	
	
	static void imprimir(String[][] tabuleiro){
		for (int i = 0; i < tabuleiro.length; i++) {
			if (i<9) 
				System.out.print("      "+(i+1));
			else
				System.out.print("     "+(i+1));
			
		}
		System.out.println();
		for (int i = 0; i < tabuleiro.length; i++) {
			if (i<9) 
				System.out.print(" "+(i+1)+" ");
			else
				System.out.print((i+1)+" ");			
			for (int j = 0; j < tabuleiro[i].length; j++) {
				System.out.print(tabuleiro[i][j]);
			}
			System.out.println();
		}
	}
		
	static void imprimir(String[] dados) {
		for (int i = 0; i < 1; i++) {
			System.out.println(dados[0]);
			System.out.println(dados[1]);
		}
		
	}
	 

}
