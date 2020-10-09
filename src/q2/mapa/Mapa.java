package q2.mapa;

import q2.tiles.*;
import q2.tiles.monstros.*;

import java.util.Random;

/**
 * Classe para representar o tabuleiro do jogo
 * @author Carlos Bravo - cehaga@dcc.ufrj.br
 */
public class Mapa {
    private Tile[][] tabuleiro;
    private Random rand;
    private int qtdInimigos;
    private Player player;

    private Posicao posAntiga;

    public Mapa(){
        rand = new Random();
        tabuleiro = new Tile[10][10];

        //Inicializacao
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                tabuleiro[i][j] = null;
            }
        }

        //Muros
        for(int i = 0; i < 10; i+=2){
            int pos1 = 0, pos2 = 0;
            pos1 = rand.nextInt(10);
            pos2 = rand.nextInt(10);
            tabuleiro[i][pos1] = new Muro();
            tabuleiro[i][pos2] = new Muro();
        }

        //Inimigos
        qtdInimigos = 8;
        for(int i = 0; i < qtdInimigos; i++){
            Monstro m = null;
            if(i < 2){
                int hp = rand.nextInt(14)+1;
                m = new Zumbi(hp, 60-hp);
            }
            else if(i < 4) {
                int hp = rand.nextInt(29) + 1;
                m = new Esqueleto(hp, 60 - hp);
            }
            else if(i < 6) {
                int hp = rand.nextInt(44)+1;
                m = new Aranha(hp, 60 - hp);
            }
            else {
                int hp = rand.nextInt(59)+1;
                m = new Fantasma(hp, 60 - hp);
            }
            int x = 0, y = 0;
            while(true){
                x = rand.nextInt(10);
                y = rand.nextInt(10);
                if(tabuleiro[y][x] == null) break;
            }
            tabuleiro[y][x] = m;
        }

        //Pocao
        for(int i = 0; i < qtdInimigos/2; i++){
            int cura = rand.nextInt(80)+1;
            Pocao p = new Pocao(cura);
            int x = 0, y = 0;
            while(true){
                x = rand.nextInt(10);
                y = rand.nextInt(10);
                if(tabuleiro[y][x] == null) break;
            }
            tabuleiro[y][x] = p;
        }

        //Player
        int x = 0, y = 0;
        while(true){
            x = rand.nextInt(10);
            y = rand.nextInt(10);
            if(tabuleiro[y][x] == null) break;
        }
        this.player = new Player(new Posicao(x,y));
        posAntiga = new Posicao(x,y);
        tabuleiro[y][x] = this.player;
    }

    public Player getPlayer(){
        return player;
    }

    /**
     * Retorna o objeto de uma respectiva célula
     * @param pos Posição que deseja verificar
     * @return O objeto Tile correspondente
     */
    public Tile andar(Posicao pos){
        return tabuleiro[pos.getY()][pos.getX()];
    }

    /**
     * Verificação se o jogo acabou
     * @return Retorna true quando não há mais inimigos
     */
    public boolean acabou(){
        return qtdInimigos == 0;
    }

    /**
     * Elimina o inimigo de uma célula
     * @param pos Posição do inimigo
     */
    public void matarInimigo(Posicao pos){
        tabuleiro[pos.getY()][pos.getX()] = null;
        qtdInimigos--;
    }

    /**
     * Elimina uma poção de uma célula
     * @param pos Posição da poção
     */
    public void encontrouPocao(Posicao pos){
        tabuleiro[pos.getY()][pos.getX()] = null;
    }

    /**
     * Imprime o mapa na saída padrão
     */
    public void mostraMapa(){
        System.out.printf("%c",'\u2554');
        for(int j = 0; j < 9; j++) System.out.printf("%c%c",'\u2550','\u2566');
        System.out.printf("%c%c\n",'\u2550','\u2557');
        for(int i = 9; i > -1; i--) {
            for(int j = 0; j < 10; j++){
                Tile t = tabuleiro[i][j];
                char c = '\u2551';
                System.out.printf("%c",c);
                if(t == null){
                    System.out.print(" ");
                }
                if(t instanceof Zumbi){
                    System.out.print("Z");
                }
                if(t instanceof Esqueleto){
                    System.out.print("E");
                }
                if(t instanceof Fantasma){
                    System.out.print("F");
                }
                if(t instanceof Aranha){
                    System.out.print("A");
                }
                if(t instanceof Muro){
                    System.out.printf("%c",'\u22A0');
                }
                if(t instanceof Pocao){
                    System.out.print("+");
                }
                if(t instanceof Player){
                    int dir = ((Player) t).getNorte();
                    char p = 0;
                    switch(dir){
                        case 0:
                            p = '\u2191';
                            break;
                        case 1:
                            p = '\u2192';
                            break;
                        case 2:
                            p = '\u2193';
                            break;
                        case 3:
                            p = '\u2190';
                            break;
                    }
                    System.out.printf("%c",p);
                }
            }
            System.out.printf("%c\n", '\u2551');
            if(i != 0) {
                System.out.printf("%c", '\u2560');
                for (int j = 0; j < 9; j++) System.out.printf("%c%c", '\u2550', '\u256C');
                System.out.printf("%c%c\n", '\u2550', '\u2563');
            }
        }
        System.out.printf("%c",'\u255A');
        for(int i = 0; i < 9; i++) System.out.printf("%c%c",'\u2550','\u2569');
        System.out.printf("%c%c\n",'\u2550','\u255D');
    }

    /**
     * Modifica a posição do jogador no mapa
     */
    public void setPosPlayer(){
        tabuleiro[posAntiga.getY()][posAntiga.getX()] = null;
        tabuleiro[player.getPos().getY()][player.getPos().getX()] = player;
        posAntiga = player.getPos();
    }
}
