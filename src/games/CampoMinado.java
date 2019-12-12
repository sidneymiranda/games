package games;
import java.util.Random;
import java.util.Scanner;


public class CampoMinado {
	
	public static CampoMinado painel;
	public static int[][] matriz = new int [16][16]; 
	public static int[][] matriz2 = new int [16][16]; 
	public static int[] xy = new int [2];
	public static int numLinhas, numColunas;
	public static int numRodadas = 0;	
	public static boolean sairJogo = false;
	public static boolean fimPartida = false;

	// MÉTODO RESPONSÁVEL POR EXECUTAR O JOGO;
	public static void main(String[] args) {
        Jogar();
	}

	
	
	// MÉTODOS RESPONSÁVEIS POR INICIAR O JOGO.

    public static void Jogar() {
        painel = new CampoMinado();
        iniciarJogo(painel);
    }
    
    public static void iniciarJogo (CampoMinado painel){
        do{
        	numRodadas++;
            System.out.println("Rodada "+ numRodadas);
            CampoMinado.matrizCasca();
            fimPartida = CampoMinado.obterPosicao();
            
            if(!fimPartida){
            	CampoMinado.mostrarVizinhos();
            	fimPartida = CampoMinado.ganharPartida();
            }
            
        }while(!fimPartida);
        
        if(!CampoMinado.ganharPartida()){
            System.out.println("Você perdeu!");
            CampoMinado.mostrarMinas();
        } else {
            System.out.println("Parabéns, você venceu o jogo!");
            CampoMinado.mostrarMinas();
        }
    }
    
	
	// MÉTODOS RESPONSÁVEIS EM CONTROLAR O TABULEIRO.
		
	
	// matrizCasca: Responsável por montar a matriz na linha e coluna.
	
	public static void matrizCasca () {
		System.out.println("\n     Linhas\n");
		for (int i = 0; i < 16; i++) {
				System.out.print("      "+ (i+1) + "   ");			
			for (int j = 0; j < 16; j++) {
				System.out.print("   "+ matriz[i][j]);
			}
			System.out.println();
		}	
		System.out.println("\nColunas\t    1   2   3   4   5   6   7   8   9   10   11   12   13   14   15   16" );
		
	}
	
	// matrizLinhas: responsável por adicionar o underline nas posições.
	
	public static void matrizLinhas () {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				matriz[i][j] = '_';
			}
		}
	}	
	
	//criarMinas: responsável por aplicar na matriz2 o valor 0.
	
	public static void criarMinas () {
		for (int i = 0; i < matriz2.length; i++) {
			for (int j = 0; j < matriz2.length; j++) {
				matriz[i][j] = 0;
			}
		}
	}
		
	// aplicarMinas: Preenche aleatoriamente a mina '-1' na matriz.
	public static void aplicarMinas () {
		Random rd = new Random();

		boolean posicao = false;
		int lin, col;
		
		for (int i = 0; i < 40; i++) {
			
			do {
				lin = rd.nextInt(16) + 1;
				col = rd.nextInt(16) + 1;
				
				if(matriz2[lin][col] == -1) {
					posicao = true;
				} else {
					posicao = false;
				}
			} while (posicao);
			matriz2[lin][col] = -1;
		}
	}

	// mostrarMinas: Substitui o -1 por *.
	public static void mostrarMinas () {
		for(int i=1 ; i < 17; i++)
			for(int j=1 ; j < 17 ; j++)
				if(matriz2[i][j] == -1)
					matriz[i][j]='*';
		
		matrizCasca();
	}
	
	// aplicarVizinho:  Preenche as dicas nas casas da matriz.
	public static void aplicarVizinhos () {
		for (int line = 1; line < 17; line++)
			for (int column = 1; column < 17; column++) {

				for (int i = -1; i <= 1; i++)
					for (int j = -1; j <= 1; j++)
						if (matriz2[line][column] != -1)
							if (matriz2[line + i][column + j] == -1)
								matriz2[line][column]++;

			}
	}
	
	// mostrarVizinhos: 
	public static void mostrarVizinhos() {
		for(int i=-1 ; i<2 ; i++) {
			for(int j=-1 ; j<2 ; j++) {
				if( (matriz2[numLinhas+i][numColunas+j] != -1) && (numLinhas != 0 && numLinhas != 17 && numColunas != 0 && numColunas != 17) ){
					matriz[numLinhas+i][numColunas+j]=Character.forDigit(matriz2[numLinhas+i][numColunas+j], 10);
				}
			}
		}
	}

	// obterPosicao: Controla as entradas do jogo.
	public static boolean obterPosicao () {
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.print("\nLinha: "); 
			numLinhas = sc.nextInt();
			System.out.print("Coluna: "); 
			numColunas = sc.nextInt();

			if( (matriz[numLinhas][numColunas] != '_') && ((numLinhas < 17 && numLinhas > 0) && (numColunas < 17 && numColunas > 0)))
				System.out.println("Essa posição já foi escolhida.");

			if( numLinhas < 1 || numLinhas > 16 || numColunas < 1 || numColunas > 16)
				System.out.println("Digite números entre 1 a 16.");

		}while((numLinhas < 1 && numLinhas > 16) && (numColunas < 1 && numColunas > 16) || (matriz[numLinhas][numColunas] != '_') );

		if(matriz2[numLinhas][numColunas]== -1)
			return true;
		else
			return false;
	}
	
	
	
	//ganharPartida: responsável por setar o underline na matriz.
	public static boolean ganharPartida () {
		int count = 0;
		for (int i = 1; i < 17; i++) {
			for (int j = 1; j < 17; j++) {
				if(matriz[i][j] == '_');
				count++;
			}
		}
			
			if (count == 18) {
				return true;
			} else {
				return false;
			}

	}
}