package minesweepergame;
import java.util.*;

public class Sudoku {
	//public int lin,col;
	public static int [][] matriz = {{1,5,0,6,0,3,0,2,0},
	   		   						 {0,0,0,0,4,0,3,7,8},
	   		   						 {3,0,0,0,0,8,0,0,0},
	   		   						 {5,1,0,0,0,0,9,0,0},
	   		   						 {0,0,2,0,0,0,6,1,0},
	   		   						 {0,0,4,3,0,0,2,0,0},
	   		   						 {7,3,5,8,0,0,0,0,6},
	   		   						 {0,8,0,0,0,0,0,4,0},
	   		   						 {0,6,9,0,0,0,8,0,0}};

	public static void main(String[] args) {	
		InserirNumero();
	}
		
	public static boolean checarLinha(int lin, int num) {
		for (int j = 0; j < 9; j++) {
			if (matriz[lin][j] == num) { 
				return true;
			}
		}
		return false;
		
	}
	
	public static boolean checarColuna(int col, int num) { 
		for (int i = 0; i < 9; i++) {
			if (matriz[i][col] == num) { 
				return true;
			}
		}
		return false;
	}
	
	public static boolean checarQuadrante(int lin, int col, int num ) {
		  int r = lin - lin %  3 ;
	        int c = col - col %  3 ;
	        for ( int i = r; i < r +  3 ; i ++ )
	            for ( int j = c; j < c +  3 ; j ++ )
	                if (matriz[i][j] == num) {
	                    return  true;
	                }
	        return false;
	    }
		
	public static void InserirNumero () {
		int lin,col; 
		while(fimJogo(matriz) == false){
			imprimir(matriz);
			System.out.println();
		Scanner sc = new Scanner(System.in); 
		System.out.println("\nINFORME A LINHA: ");
		 lin = sc.nextInt()-1;
		System.out.println("\nINFORME A COLUNA: ");
		 col = sc.nextInt()-1;
		System.out.println("\nINFORME O NÚMERO: ");
		int num = sc.nextInt();
			
		if((lin == 0 && col == 0)|| (lin == 0 && col == 1) || (lin == 0 && col == 3) || (lin == 0 && col == 5) || (lin == 0 && col == 7)||
				(lin == 1 && col == 4) || (lin == 1 && col == 6) || (lin == 1 && col == 7) || (lin == 1 && col == 8) || 
				(lin == 2 && col == 0) || (lin == 2 && col == 5) || 
				(lin == 3 && col == 0) || (lin == 3 && col == 1) || (lin == 3 && col == 6) || 
				(lin == 4 && col == 2) || (lin == 4 && col == 6) || (lin == 4 && col == 7) ||
				(lin == 5 && col == 2) || (lin == 5 && col == 3) || (lin == 5 && col == 6) ||
				(lin == 6 && col == 0) || (lin == 6 && col == 1) || (lin == 6 && col == 2) || (lin == 6 && col == 3) || (lin == 6 && col == 8) ||
				(lin == 7 && col == 1) || (lin == 7 && col == 7) || (lin == 8 && col == 1) || (lin == 8 && col == 2) ||
				(lin == 8 && col == 6)){
			System.out.println("Não é possível alterar o número dessa posição.");
			System.out.println();
		} else if ((checarLinha(lin,num) || checarColuna(col,num)) || checarQuadrante(lin,col,num) == true){
				System.out.println("O número informado já existe na mesma linha/coluna/quadrante 3x3, preste atenção!");
				System.out.println();
			}else {
				matriz[lin][col] = num;
				}
		System.out.println("=============================");
		
		if (fimJogo(matriz) == true) {
			System.out.println("PARABÉNS, "+Menu.Usuario() +"você concluiu o Sudoku!!!");
		}
	}
}

	public static boolean fimJogo(int[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if (matriz[i][j] == 0) {
					return false;
				} 
			}
		}
		return true;
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
 