package q1.veiculos.classes;

import q1.util.Range;
import q1.veiculos.interfaces.*;

/**
 * Classe para representar uma lancha
 * @author Carlos Bravo - cehaga@dcc.ufrj.br
 */
public class Lancha extends Veiculo implements Aquatico, Impermeavel{
    public Lancha(){
        super(Range.range(80,140),Range.range(500.0,3000.0),Range.range(4,10));
    }

    /**
     * Retorna os dados da lancha
     * @return Os dados da lancha
     */
    @Override
    public String toString() {
        return "lancha: "+super.toString();
    }
}
