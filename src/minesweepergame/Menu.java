package minesweepergame;

import java.util.Scanner;
import minesweepergame.CampoMinado;


public class Menu {

	public static void main(String[] args) {
		iniciar();		
	}	
	public static String[] dados = new String[2];
	public static void iniciar() {
		if (cadastrarUsuario()) {
			switch (exibirMenu()) {
			case 1:
				CampoMinado.main(null);
				break;
			case 2: 
				Sudoku.main(null);
				break;
			default:
				System.out.println("Opção inválida!");
			}		
		}
	}
	
	static boolean cadastrarUsuario(){
		//String[] dados = new String[2];
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		boolean continua = false;
			
		System.out.println("\t\t\t\tLPA GAME\n");
			System.out.println("Nome do jogador: ");
			dados[0] = sc.next();
			
			System.out.println("Olá " + dados[0] + "! Informe a sua matrícula:" );
			dados[1] = sc.next();
			
			if ((dados[0] != " ") && (dados[1] != " ")) {
				continua = true;
			}else {
				continua = false;
			}
		return continua;
	}
	
	public static String Usuario() {

		
	return dados[0];
	}
	
	
	
	
	public static int exibirMenu(){
		Scanner sc = new Scanner(System.in);
		System.out.println("=============================================================");
		System.out.println("\t\t\tEscolha o Jogo");
		System.out.println("=============================================================\n");
		System.out.println("(1) Campo Minado\t\t\t (2) Sudoku");
		int num = sc.nextInt();

		return num;
		
	}

	public static void limparTela() {
	        for (int i = 0; i < 30; i++) {
				System.out.println();
			}
	}
}
