package q1.veiculos.classes;

import q1.util.Range;
import q1.veiculos.interfaces.*;

/**
 * Classe para representar uma canoa
 * @author Carlos Bravo - cehaga@dcc.ufrj.br
 */
public class Canoa extends Veiculo implements Aquatico{
    public Canoa(){
        super(Range.range(10,40),Range.range(20.0,60.0),Range.range(1,4));
    }

    /**
     * Retorna os dados da canoa
     * @return Os dados da canoa
     */
    @Override
    public String toString() {
        return "canoa: "+super.toString();
    }
}
