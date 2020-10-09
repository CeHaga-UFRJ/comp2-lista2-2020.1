package q2.tiles.monstros;

/**
 * Classe para representar um Esqueleto
 * @author Carlos Bravo - cehaga@dcc.ufrj.br
 */
public class Esqueleto extends Monstro{
    public Esqueleto(int hp, int dano){
        super(hp, dano);
    }

    /**
     * Realiza um ataque, imprimindo seu aviso na saída padrão
     * @return O dano causado
     */
    public int atacar(){
        System.out.println("Esqueleto atacou com Osso Duro de Roer.");
        return super.atacar();
    }

    /**
     * Recebe um ataque e retorna true se está morto
     * @param ataque Quantidade de dano recebido
     * @return true caso tenha morrido com esse ataque
     */
    public boolean receberAtaque(int ataque){
        System.out.println("Você chamou um cachorro pra comer o Esqueleto. Ele perdeu "+ataque+" de hp.");
        return super.receberAtaque(ataque);
    }

    /**
     * Texto de morte do Monstro
     * @return Seu texto de morte
     */
    public String morteTxt(){
        return "Os restos do esqueleto formam um ótimo xilofone.";
    }

    public String toString(){
        return "Você encontrou um Esqueleto!";
    }
}
