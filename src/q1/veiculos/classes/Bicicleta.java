package q1.veiculos.classes;

import q1.veiculos.interfaces.Offroad;
import q1.util.Range;

/**
 * Classe para representar uma bicicleta
 * @author Carlos Bravo - cehaga@dcc.ufrj.br
 */
public class Bicicleta extends Veiculo implements Offroad {
    public Bicicleta(){
        super(Range.range(30,60),Range.range(5.0,20.0),Range.range(1,2));
    }

    /**
     * Retorna os dados da bicicleta
     * @return Os dados da bicicleta
     */
    @Override
    public String toString() {
        return "bicicleta: "+super.toString();
    }
}
