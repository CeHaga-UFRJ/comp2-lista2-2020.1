package q2.exceptions;

/**
 * Exceção para caso o jogador ande para fora do mapa
 * @author Carlos Bravo - cehaga@dcc.ufrj.br
 */
public class PlayerOutOfBoundsException extends Exception{
    public PlayerOutOfBoundsException(String msg){
        super(msg);
    }
}
