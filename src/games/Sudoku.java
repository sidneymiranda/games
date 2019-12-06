package games;
import java.util.*;

public class Sudoku {

	public static void main(String[] args) {
		imprimir(gerarMatriz());
	}
	public static int[][] gerarMatriz(){
		int[][] matriz = new int[9][9];
		
		int n = 0;
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				matriz[i][j] = 0;
			}
		}
		return matriz;
	}
	
	public static String[][] preencherMatriz(int[][] array){
		String[][] num = new String [9][9];
		Scanner sc = new Scanner(System.in);

			System.out.println("INFORME A LINHA: ");
			int a = sc.nextInt();
			System.out.println("INFORME A COLUNA: ");
			int b = sc.nextInt();
			System.out.println("INFORME O VALOR DE 1 A 9:");
			num[a][b] = sc.next();
			
		return num;
	}

	public static boolean verificarJogo(int[][] matriz) {
		boolean resp=false;
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				//VERIFICANDO SE NUMERO É DIFERENTE NA LINHA ATUAL DO LAÇO
				int k = 0, l = 0;
				for (; k < matriz[j].length; k++,l++) {
					if (matriz[i][j] == matriz[k][l]) {
						resp = false;
					}else {
						resp = true;
					}
				}
			}
		}
		return resp;
	}
	
	
	public static void imprimir(int[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.print(matriz[i][j]);
				if ((j+1) % 3 == 0) {
					System.out.print(" | ");
				}
			}
			System.out.println();
			if ((i+1) % 3 == 0) {
				System.out.println("-----------------");
			}
		}
	}
	
	
}
