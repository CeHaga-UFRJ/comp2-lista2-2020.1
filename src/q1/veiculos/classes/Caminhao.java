package q1.veiculos.classes;

import q1.util.Range;
import q1.veiculos.interfaces.*;

/**
 * Classe para representar um caminhão
 * @author Carlos Bravo - cehaga@dcc.ufrj.br
 */
public class Caminhao extends Veiculo implements Impermeavel, Offroad{
    public Caminhao(){
        super(Range.range(60,100),Range.range(1000.0,10000.0),Range.range(1,3));
    }

    /**
     * Retorna os dados do caminhão
     * @return Os dados do caminhão
     */
    @Override
    public String toString() {
        return "caminhão: "+super.toString();
    }
}
