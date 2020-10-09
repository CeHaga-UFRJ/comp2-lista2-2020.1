package q2.mapa;

/**
 * Classe para representar uma coordenada
 * @author Carlos Bravo - cehaga@dcc.ufrj.br
 */
public class Posicao {
    private int x;
    private int y;

    public Posicao(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String toString(){
        return "X: " +x+ ", Y: "+y;
    }
}
