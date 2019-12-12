package minesweepergame;

import java.util.Random;
import java.util.Scanner;

public class Tabuleiro {
    private char[][] matriz;
    private int[][] matriz2;
    private int linha, coluna;
    Random rd = new Random();
    Scanner sc = new Scanner(System.in);   
    
    public Tabuleiro(){
        matriz = new char[18][18];
        matriz2 = new int[18][18];
        criarMinas(); // Responsável por aplicar na matriz2 o valor 0
        aplicarMinas(); //Preenche aleatoriamente a mina '-1' na matriz.
        aplicarVizinho();//Preenche as dicas nas casas da matriz onde pode ter minas próximas.
        matrizLinhas();//Responsável por adicionar o underline nas posições.
        
    }  

    
    // matrizCasca
    public void matrizCasca(){
		System.out.println("\n     Linhas\n");
		for (int i = 1; i < 17; i++) {
			if (i<10) {
				System.out.print("       "+ i + "  ");
			}else {
				System.out.print("       "+ i + " ");
			}
			for (int j = 1; j < 17; j++) {
				System.out.print("   "+ matriz[i][j]);
			}
			System.out.println();
		}	
		System.out.println("\nColunas\t     1   2   3   4   5   6   7   8   9  10  11  12  13  14  15  16" );

    }
    

    //matrizLinhas
    public void matrizLinhas(){
        for(int i=1 ; i<matriz2.length ; i++) {
            for(int j=1 ; j<matriz2.length ; j++) {
                matriz[i][j]= '_';
            }
        }
    }
    
    //criarMinas
    public void criarMinas(){
		for (int i = 0; i < matriz2.length; i++) {
			for (int j = 0; j < matriz2.length; j++) {
                matriz2[i][j]=0;
			}
		}
    } 
    
    //aplicarMinas
    public void aplicarMinas(){
        boolean posicao;
       // int linha, coluna;
		for (int i = 0; i < 40; i++) {
            
            do{
                linha = rd.nextInt(16) + 1;
                coluna = rd.nextInt(16) + 1;
                
                if(matriz2[linha][coluna] == -1)
                	posicao=true;
                else
                	posicao = false;
            }while(posicao);
            
            matriz2[linha][coluna] = -1;
        }
    }
    
    //mostrarMinas
    public void mostrarMinas(){
		for (int i = 1; i < 17; i++) {
			for (int j = 1; j < 17; j++) {
                if (matriz2[i][j] == -1) {
                    matriz[i][j] = '*';
                }
			}
		}
        matrizCasca();
    }
    
    //aplicarVizinho    
    public void aplicarVizinho(){
		for (int i = 1; i < 17; i++) {
			for (int j = 1; j < 17; j++) {

				for (int k = -1; k <= 1; k++) {
					for (int l = -1; l <= 1; l++) {
						if (matriz2[i][j] != -1) {
							if (matriz2[i + k][j + l] == -1) {
								matriz2[i][j]++;
							}
						}
					}
				}
			}
		}
    }

  
    //mostrarVizinhos: Converter char para dígito. (?)
    public void mostrarVizinhos(){
		for (int i = -1; i < 2; i++) {
			for (int j = -1; j < 2; j++) {
				if ((matriz2[linha + i][coluna + j] != -1)
						&& (linha != 0 && linha != 17 && coluna != 0 && coluna != 17)) {
					matriz[linha + i][coluna + j] = Character.forDigit(matriz2[linha + i][coluna + j], 10);
				}
			}
		}
    }

        
    //Novo método
    
    public int obterPosicao(int linha, int coluna){
        return matriz2[linha][coluna];
    }
    
    //obterPosicao
    public boolean tratarPosicao(){
        
        do{
            System.out.print("\nLinha: "); 
            linha = sc.nextInt();
            System.out.print("Coluna: "); 
            coluna = sc.nextInt();
            
            if((matriz[linha][coluna] != '_') && ((linha < 17 && linha > 0) && (coluna < 17 && coluna > 0))) {
                System.out.println("A posição informada já está sendo mostrada no tabuleiro.");
            	System.out.println("Informe uma nova posição: ");
            }
            if( linha < 1 || linha > 16 || coluna < 1 || coluna > 16) {
                System.out.println("Informe valores de 1 a 16.");
            }
        } while((linha < 1 && linha > 16) && (coluna < 1 && coluna > 16) || (matriz[linha][coluna] != '_'));
        
        if(obterPosicao(linha, coluna) == -1) {
            return true;
        } else {
            return false;
        }
    }
        

    //ganharPartida

    public boolean ganharPartida(){
		int count = 0;
		for (int i = 1; i < 17; i++) 
			for (int j = 1; j < 17; j++) 
				if (matriz[i][j] == '_') 
					count++;

		if (count == 40) 
			return true; 
		else 
			return false;
		}   
}