package q2.tiles.monstros;

/**
 * Classe para representar um Zumbi
 * @author Carlos Bravo - cehaga@dcc.ufrj.br
 */
public class Zumbi extends Monstro{
    public Zumbi(int hp, int dano){
        super(hp, dano);
    }

    /**
     * Realiza um ataque, imprimindo seu aviso na saída padrão
     * @return O dano causado
     */
    public int atacar(){
        System.out.println("Zumbi atacou com Mordida.");
        return super.atacar();
    }

    /**
     * Recebe um ataque e retorna true se está morto
     * @param ataque Quantidade de dano recebido
     * @return true caso tenha morrido com esse ataque
     */
    public boolean receberAtaque(int ataque){
        System.out.println("Você bateu no Zumbi com o braço dele. Ele perdeu "+ataque+" de hp.");
        return super.receberAtaque(ataque);
    }

    /**
     * Texto de morte do Monstro
     * @return Seu texto de morte
     */
    public String morteTxt(){
        return "O morto vivo virou um morto morto.";
    }

    public String toString(){
        return "Você encontrou um Zumbi!";
    }
}
