package q2.tiles.monstros;

/**
 * Classe para representar um Fantasma
 * @author Carlos Bravo - cehaga@dcc.ufrj.br
 */
public class Fantasma extends Monstro{
    public Fantasma(int hp, int dano){
        super(hp, dano);
    }

    /**
     * Realiza um ataque, imprimindo seu aviso na saída padrão
     * @return O dano causado
     */
    public int atacar(){
        System.out.println("Fantasma atacou com Assombração.");
        return super.atacar();
    }

    /**
     * Recebe um ataque e retorna true se está morto
     * @param ataque Quantidade de dano recebido
     * @return true caso tenha morrido com esse ataque
     */
    public boolean receberAtaque(int ataque){
        System.out.println("Você assustou o Fantasma de volta. Ele perdeu "+ataque+" de hp.");
        return super.receberAtaque(ataque);
    }

    /**
     * Texto de morte do Monstro
     * @return Seu texto de morte
     */
    public String morteTxt(){
        return "Na próxima a assombração vai saber pra quem aparece.";
    }

    public String toString(){
        return "Você encontrou um Fantasma!";
    }
}
