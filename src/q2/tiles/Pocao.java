package q2.tiles;

/**
 * Classe para representar uma poção
 * @author Carlos Bravo - cehaga@dcc.ufrj.br
 */
public class Pocao extends Tile{
    private int cura;

    public Pocao(int cura){
        this.cura = cura;
    }

    public int getCura(){
        return cura;
    }
}
