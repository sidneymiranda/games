package games;

import java.util.Scanner;
import java.util.Random;

public class CampoMinado {

	public static void main(String[] args) {
		exibirMenu();
	}
	
	static String[] cadastrarUsuario() {
		String[] dados = new String[2];
		Scanner ent = new Scanner(System.in);
		
			System.out.println("INFORME O SEU NOME:");
			dados[0] = ent.next();
			System.out.println("INFORME A SUA MATRÍCULA:");
			dados[1] = ent.next();

		return dados;
	}
	
	static int exibirMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("=============================");
		System.out.println("       MENU - GAMES       ");
		System.out.println("=============================");
		System.out.println("(1) Campo Minado          ");
		System.out.println();
		System.out.println("(2) Sudoku - Logic Problem");
		int num = sc.nextInt();
		
		return num;
	}

	static String[][] gerarTabuleiro() {
		String[][] tabuleiro = new String[16][16];
		int lin,col;
		boolean sorteado = true;
		Random random = new Random();
		
		for (int i = 0; i < tabuleiro.length; i++) {
			for (int j = 0; j < tabuleiro[i].length; j++) {
				tabuleiro[i][j] = "|_____|";
			}
		}
		return tabuleiro;
	}
	
	static int[][] criarBombas() {
		int[][] linha = new int[16][16];
		int lin,col;
		boolean sorteado = true;
		Random random = new Random();
		
			for (int i = 0; i < 8; ) {
				while(sorteado) {
					lin = random.nextInt((15));
					col = random.nextInt((15));
					
					//-1 indica bomba
					if(linha[lin][col] == -1) {
						sorteado = true;
					}else {
						linha[lin][col] = -1;
						i++;
						if (i == 8) {
							sorteado=false;
						}
						/*System.out.print("linha = "+lin+" ");
						System.out.print("coluna = "+col+" ");
						System.out.print(linha[lin][col] +" ");
						System.out.println();*/
					}
				}				
			}
			return linha;
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
