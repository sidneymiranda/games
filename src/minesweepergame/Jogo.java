package minesweepergame;
import minesweepergame.Tabuleiro;



 public class Jogo {
   private Tabuleiro imprimir;
    boolean encerrarJogo = false;
    boolean ganharPartida = false;
    int[] xy;
    int numRodadas=0; 
    
    public Jogo(){
    	imprimir = new Tabuleiro();
        Jogar(imprimir);
        xy = new int[2];
    }
    
    public void Jogar(Tabuleiro imprimir){
        do{
            numRodadas++;
            System.out.println("Rodada nº " + numRodadas);
            imprimir.matrizCasca();
            encerrarJogo = imprimir.tratarPosicao();
            
            if(!encerrarJogo){
                imprimir.mostrarVizinhos();
                encerrarJogo = imprimir.ganharPartida();
            }
            
        }while(!encerrarJogo);
        
        if(!imprimir.ganharPartida()){
            System.out.println("\nGAME OVER.");
            imprimir.mostrarMinas();
        } else {
            System.out.println("Parabéns, "+ Menu.Usuario() +" você concluiu o jogo em " + numRodadas + " rodadas");
            imprimir.mostrarMinas();
        }
    }
 }