package q1.veiculos.classes;

import q1.util.Range;

/**
 * Classe para representar uma moto
 * @author Carlos Bravo - cehaga@dcc.ufrj.br
 */
public class Moto extends Veiculo{
    public Moto(){
        super(Range.range(140,180),Range.range(50.0,400.0),Range.range(1,2));
    }

    /**
     * Retorna os dados da moto
     * @return Os dados da moto
     */
    @Override
    public String toString() {
        return "moto: "+super.toString();
    }
}
