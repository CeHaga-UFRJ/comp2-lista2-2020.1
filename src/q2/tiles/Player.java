package q2.tiles;

import q2.mapa.Posicao;
import java.util.Random;

/**
 * Classe para representar um jogador
 * @author Carlos Bravo - cehaga@dcc.ufrj.br
 */
public class Player extends Tile{
    private int hp;
    private int maxHp;
    private int atk;
    private int norte;
    private Posicao pos;

    /**
     * @param pos Posição de início do jogador
     */
    public Player(Posicao pos){
        this.pos = pos;
        this.norte = 0;
        Random rand = new Random();
        this.atk = rand.nextInt(30)+15;
        this.hp = 100 - this.atk;
        this.maxHp = hp;
    }

    /**
     * @param pos Posição de início do jogador
     * @param hp HP inicial do jogador
     */
    public Player(Posicao pos, int hp){
        this.pos = pos;
        this.norte = 0;
        this.hp = hp;
        this.atk = 100 - hp;
        this.maxHp = hp;
    }

    public Posicao getPos(){
        return pos;
    }

    public void setPos(Posicao pos){
        this.pos = pos;
    }

    public int getNorte(){
        return norte;
    }

    public void setNorte(int norte){
        this.norte = norte;
    }

    /**
     * Cura o jogador e imprime na saída padrão a quantidade de vida curada
     * @param p Poção utilizada na cura
     */
    public void curar(Pocao p){
        int cura = (int)(maxHp * p.getCura()/100.0);
        hp += cura;
        if(hp > maxHp) hp = maxHp;
        System.out.println("Você encontrou uma poção (HP: "+hp+"/"+maxHp+").");
    }

    /**
     * Verifica se o jogador ainda está vivo
     * @return true se seu hp é menor ou igual a 0
     */
    public boolean isMorto(){
        return hp <= 0;
    }

    public int getAtk(){
        return atk;
    }

    /**
     * Tira vida do jogador e imprime na saída padrão a quantidade de vida restante
     * @param ataque Dano recebido pelo jogador
     */
    public void receberAtaque(int ataque){
        hp -= ataque;
        if(hp < 0) hp = 0;
        System.out.println("Você foi ferido pelo ataque (HP: "+hp+"/"+maxHp+").");
    }

    /**
     * Mostra estatísticas do jogador
     * @return Uma Stringu reitro Aqui a  representando o HP e o ATK do jogador
     */
    public String toString(){
        return "HP do jogador: "+hp+"\nATK do jogador: "+atk;
    }
}
