package q1.veiculos.classes;

import q1.util.Range;
import q1.veiculos.interfaces.*;

/**
 * Classe para representar um jipe
 * @author Carlos Bravo - cehaga@dcc.ufrj.br
 */
public class Jipe extends Veiculo implements Offroad{
    public Jipe(){
        super(Range.range(120,160),Range.range(500.0,1000.0),Range.range(2,5));
    }

    /**
     * Retorna os dados do jipe
     * @return Os dados do jipe
     */
    @Override
    public String toString() {
        return "jipe: "+super.toString();
    }
}
