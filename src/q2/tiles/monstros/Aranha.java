package q2.tiles.monstros;

/**
 * Classe para representar uma Aranha
 * @author Carlos Bravo - cehaga@dcc.ufrj.br
 */
public class Aranha extends Monstro{
    public Aranha(int hp, int dano){
        super(hp, dano);
    }

    /**
     * Realiza um ataque, imprimindo seu aviso na saída padrão
     * @return O dano causado
     */
    public int atacar(){
        System.out.println("Aranha atacou com Picada.");
        return super.atacar();
    }

    /**
     * Recebe um ataque e retorna true se está morto
     * @param ataque Quantidade de dano recebido
     * @return true caso tenha morrido com esse ataque
     */
    public boolean receberAtaque(int ataque){
        System.out.println("Você tacou fogo na Aranha. Ela perdeu "+ataque+" de vida.");
        return super.receberAtaque(ataque);
    }

    /**
     * Texto de morte do Monstro
     * @return Seu texto de morte
     */
    public String morteTxt(){
        return "Este desenvolvedor web não encontrará mais bugs.";
    }

    public String toString(){
        return "Você encontrou uma Aranha!";
    }
}
