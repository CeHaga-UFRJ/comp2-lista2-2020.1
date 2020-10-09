package q1.veiculos.classes;

import q1.util.Range;
import q1.veiculos.interfaces.*;

/**
 * Classe para representar um tanque anfíbio
 * @author Carlos Bravo - cehaga@dcc.ufrj.br
 */
public class Tanque extends Veiculo implements Anfibio, Offroad, Impermeavel {
    public Tanque(){
        super(Range.range(20,60),Range.range(3000.0,10000.0),Range.range(1,4));
    }

    /**
     * Retorna os dados do tanque anfíbio
     * @return Os dados do tanque anfíbio
     */
    @Override
    public String toString() {
        return "tanque anfíbio: "+super.toString();
    }
}
