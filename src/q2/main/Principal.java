package q2.main;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

/**
 * Classe principal do programa
 * @author Carlos Bravo - cehaga@dcc.ufrj.br
 */
public class Principal {
    public static void main(String[] args) {
        PrintStream out = System.out;
        try {
            out = new PrintStream(System.out, true, "UTF-8");
        }catch (UnsupportedEncodingException e){
            System.out.println(e);
        }
        System.setOut(out);
        Jogo jogo = new Jogo();
        jogo.comecar();
    }
}
