package games;
import java.util.*;

public class Sudoku {

	public static void main(String[] args) {
		iniciarGame();
	}
	
	public static void iniciarGame() {
		imprimir(gerarMatriz());
	}
	
	//GERANDO A MATRIZ COM OS NÚMEROS DEFAULT
	public static int[][] gerarMatriz(){
		int[][] matriz = new int[9][9];
		Random rd = new Random();
		int l= 0, c=0;
		
		for (int i = 0; i < 10; i++) {
			l = rd.nextInt(9);
			c = rd.nextInt(9);
			matriz[l][c] = rd.nextInt(8)+1;
		}
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				
					if (matriz[i][j] == 0) {
						matriz[i][j] = 0;
					}
				}
			}
		return matriz;
	}
	
	//INTERAÇÃO DO USUÁRIO NO GAME
	public static int[][] solicitarNumeros(int[][] array){
		int[][] num = new int [9][9];
		Scanner sc = new Scanner(System.in);
		boolean fim = false;
		
		System.out.println("INFORME A LINHA: ");
		int lin = sc.nextInt();
		System.out.println("INFORME A COLUNA: ");
		int col = sc.nextInt();
		System.out.println("INFORME O VALOR DE 1 A 9:");
		num[lin][col] = sc.nextInt();
		
		for (int x = 0; x < num[0].length; x++) {
			//VERIFICA SE NÚMERO ESTÁ SE REPETINDO NA LINHA DA POSIÇÃO CORRESPONDENTE À ENTRADA DO USER
			if (num[lin][col] == num[lin][x]) {
				System.out.println("OPS, ESTE NÚMERO JÁ ESTÁ NA LINHA ATUAL!");
				System.out.println("INFORME A LINHA: ");
				lin = sc.nextInt();
				System.out.println("INFORME A x: ");
				col = sc.nextInt();
				System.out.println("INFORME O VALOR DE 1 A 9:");
				num[lin][col] = sc.nextInt();
			
			//VERIFICA SE NÚMERO ESTÁ SE REPETINDO NA COLUNA DA POSIÇÃO CORRESPONDENTE À ENTRADA DO USER
			}else if (num[lin][col] == num[x][col]) {
				System.out.println("OPS, ESTE NÚMERO JÁ ESTÁ NA COLUNA ATUAL!");
				System.out.println("INFORME A LINHA: ");
				lin = sc.nextInt();
				System.out.println("INFORME A x: ");
				col = sc.nextInt();
				System.out.println("INFORME O VALOR DE 1 A 9:");
				num[lin][col] = sc.nextInt();
			}
		}		
		return num;
	}
	
	
	public static void imprimir(int[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.print(matriz[i][j]);
				if (j == 2 || j == 5) {
					System.out.print("  ");
				}
			}
			System.out.println();
			if (i==2 || i ==5) {
				System.out.println();
			}
		}
	}
	
	
}
