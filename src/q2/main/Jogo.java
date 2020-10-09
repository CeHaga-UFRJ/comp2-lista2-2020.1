package q2.main;

import q2.mapa.*;
import q2.tiles.*;
import q2.tiles.monstros.*;
import q2.exceptions.*;

import java.util.*;

/**
 * Classe responsável por coordenar o jogo
 * @author Carlos Bravo - cehaga@dcc.ufrj.br
 */
public class Jogo {
    private static Scanner sc;
    private static Player player;
    private static Mapa mapa;

    /**
     * Começa o jogo
     * <p>Esse método faz o processo inteiro do jogo, incluindo imprimir na saída padrão o resultado</p>
     */
    public void comecar(){
        System.out.println("Bem-vindo à Cripta Amaldiçoada! Para sair dela você deve derrotar os 8 monstros!");
        System.out.println("Você possui as seguintes ações:\n\t(f)rente\n\t(d)ireita\n\t(t)rás\n\t(e)squerda\n\t(a)tacar\n\t(fu)gir\n\nA direção para qual você está olhando importa, isto é, se virar para esquerda 4 vezes, voltará à mesma célula.\nCaso prefira, há a opção de habilitar um mapa a partir do comando 'mapa'.");
        boolean dev = false;
        int contMuro = 0;
        List<String> acoesPossiveis = Arrays.asList("frente","trás","esquerda","direita","atacar","fugir","f","t","e","d","a","fu","mapa");
        Tile tabuleiro = null;
        sc = new Scanner(System.in);
        mapa = new Mapa();
        player = mapa.getPlayer();
        System.out.println(player);
        Posicao posAntiga = player.getPos();
        System.out.println("Que comecem os jogos!");
        while(!mapa.acabou() && !player.isMorto()){
            if(dev) mapa.mostraMapa();
            String acao;
            while(true) {
                acao = sc.nextLine();
                if(acoesPossiveis.contains(acao)) break;
                System.out.println("Ação inválida...");
            }
            if(acao.equals("mapa")){
                dev = !dev;
                continue;
            }
            boolean isAtacando = acao.equals("atacar") || acao.equals("a");
            boolean isMonstro = tabuleiro instanceof Monstro;
            if(isAtacando && isMonstro){
                if(atacar((Monstro)tabuleiro)){
                    mapa.matarInimigo(player.getPos());
                    tabuleiro = null;
                    mapa.setPosPlayer();
                }
                continue;
            }
            if(isAtacando && !isMonstro){
                System.out.println("Não há monstros nesse espaço...");
                continue;
            }
            if(!isAtacando && isMonstro){
                if(acao.equals("fugir") || acao.equals("fu")){
                    System.out.println("Você consegue fugir do conflito, mas você é acertado pelo inimigo, e ele tampa o caminho que tentou percorrer.");
                    player.receberAtaque(((Monstro) tabuleiro).atacar());
                    player.setPos(posAntiga);
                    tabuleiro = mapa.andar(posAntiga);
                }else {
                    System.out.println("2 pessoas começam um combate, apenas uma sai viva. A não ser que opte por fugir.");
                }
                continue;
            }
            if(acao.equals("fugir") || acao.equals("fu")) {
                System.out.println("Não há nada do que fugir.");
                continue;
            }
            int dir = 0;
            switch (acao){
                case "frente":
                case "f":
                    dir = 0;
                    break;
                case "direita":
                case "d":
                    dir = 1;
                    break;
                case "trás":
                case "t":
                    dir = 2;
                    break;
                case "esquerda":
                case "e":
                    dir = 3;
                    break;
            }
            Posicao posAntigaExcep = posAntiga;
            try{
                posAntiga = player.getPos();
                tabuleiro = andar(dir);
            }catch(PlayerOutOfBoundsException e){
                posAntiga = posAntigaExcep;
                System.out.println("Não é possível andar para fora do mapa...");
                continue;
            }
            if(tabuleiro == null){
                mapa.setPosPlayer();
                System.out.println("Não há nada nesse espaço...");
            }
            if(tabuleiro instanceof Muro){
                posAntiga = posAntigaExcep;
                if(contMuro++ % 2 == 0) {
                    System.out.println("No meio do caminho havia um muro");
                }else{
                    System.out.println("Havia um muro no meio do caminho");
                }
                tabuleiro = null;
            }
            if(tabuleiro instanceof Monstro){
                System.out.println(tabuleiro);
            }
            if(tabuleiro instanceof Pocao){
                player.curar((Pocao)tabuleiro);
                mapa.encontrouPocao(player.getPos());
                mapa.setPosPlayer();
            }
        }
        if(player.isMorto()){
            System.out.println("Game over!");
        }else{
            System.out.println("Parabéns, você venceu todos os monstros!");
        }
    }

    private static boolean atacar(Monstro monstro){
        int atk = player.getAtk();
        if(monstro.receberAtaque(atk)){
            System.out.println(monstro.morteTxt());
            return true;
        }
        player.receberAtaque(monstro.atacar());
        return false;
    }

    private static Tile andar(int dir) throws PlayerOutOfBoundsException{
        int mapDir = (dir + player.getNorte())%4;
        int x = 0;
        int y = 0;
        Posicao pos = player.getPos();
        switch (mapDir){
            case 0:
                y = 1;
                break;
            case 1:
                x = 1;
                break;
            case 2:
                y = -1;
                break;
            case 3:
                x = -1;
                break;
        }
        player.setNorte(mapDir);
        if(pos.getX() + x < 0 || pos.getX() + x > 9 || pos.getY() + y < 0 || pos.getY() + y > 9){
            throw new PlayerOutOfBoundsException("Player fora do mapa");
        }
        Tile tabuleiro = mapa.andar(new Posicao(pos.getX() + x, pos.getY() + y));
        if(!(tabuleiro instanceof Muro)){
            player.setPos(new Posicao(pos.getX() + x, pos.getY() + y));
        }
        return tabuleiro;
    }
}
