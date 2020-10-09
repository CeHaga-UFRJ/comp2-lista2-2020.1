package q2.tiles.monstros;

import q2.tiles.Tile;

/**
 * Classe abstrata para representar Monstros
 * @author Carlos Bravo - cehaga@dcc.ufrj.br
 */
public abstract class Monstro extends Tile {
    private int hp;
    private int dano;

    public Monstro(int hp, int dano){
        this.hp = hp;
        this.dano = dano;
    }

    /**
     * Retorna o dano causado por um ataque
     * @return Seu dano
     */
    public int atacar(){
        return dano;
    }

    /**
     * Recebe um ataque e diminui seu hp, retornando true se estiver morto
     * @param ataque A quantidade de dano recebido
     * @return true se está morto
     */
    public boolean receberAtaque(int ataque){
        hp -= ataque;
        return (hp <= 0);
    }

    /**
     * Texto específico de morte de cada monstro
     */
    public abstract String morteTxt();
}
