package games;

import java.util.Scanner;

public class Jogar {

	public static void main(String[] args) {
		iniciar();
	}	
	
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
				System.out.println("Opção inválida!!!");
			}		
		}
	}
	
	static boolean cadastrarUsuario(){
		String[] dados = new String[2];
		Scanner ent = new Scanner(System.in);
		boolean continua = false;
		
			System.out.println("INFORME O SEU NOME:");
			dados[0] = ent.next();
			System.out.println("INFORME A SUA MATRÍCULA:");
			dados[1] = ent.next();
			
			if ((dados[0] != "") && (dados[1] != "")) {
				continua = true;
			}else {
				continua = false;
			}
		return continua;
	}
	
	static int exibirMenu(){
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

}
