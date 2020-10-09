package q1.veiculos.classes;

import q1.util.Range;
import q1.veiculos.interfaces.*;

/**
 * Classe para representar um carro
 * @author Carlos Bravo - cehaga@dcc.ufrj.br
 */
public class Carro extends Veiculo implements Impermeavel{
    public Carro(){
        super(Range.range(120,180),Range.range(500.0,1500.0),Range.range(2,7));
    }

    /**
     * Retorna os dados do carro
     * @return Os dados do carro
     */
    @Override
    public String toString() {
        return "carro: "+super.toString();
    }
}
