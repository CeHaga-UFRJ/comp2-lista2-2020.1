package q1.main;

import q1.trajeto.*;
import q1.util.*;
import q1.veiculos.classes.*;
import q1.veiculos.interfaces.*;

import java.util.*;

/**
 * Classe principal do programa
 * @author Carlos Bravo - cehaga@dcc.ufrj.br
 */
public class Principal {
    public static void main(String[] args) {
        Trajeto trajeto = VerificaTrajeto.leTrajeto();
        List<Veiculo> veiculos = VerificaTrajeto.verificaCapacidade(trajeto);
        for(Veiculo veiculo : veiculos){
            System.out.println(veiculo);
        }
    }
}
