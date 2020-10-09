package q1.trajeto;

/**
 * Classe para representar um trajeto
 * @author Carlos Bravo - cehaga@dcc.ufrj.br
 */
public class Trajeto {
    private double distancia;
    private String caminho;
    private int qtdPessoas;
    private double qtdCarga;
    private double tempo;
    private String clima;

    /**
     * @param distancia Distância
     * @param caminho Tipo de caminho
     * @param qtdPessoas Quantidade de pessoas
     * @param qtdCarga Quantidade de carga
     * @param tempo Tempo de percurso
     * @param clima Clima do percurso
     */
    public Trajeto(double distancia, String caminho, int qtdPessoas, double qtdCarga, double tempo, String clima) {
        this.distancia = distancia;
        this.caminho = caminho;
        this.qtdPessoas = qtdPessoas;
        this.qtdCarga = qtdCarga;
        this.tempo = tempo;
        this.clima = clima;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }

    public int getQtdPessoas() {
        return qtdPessoas;
    }

    public void setQtdPessoas(int qtdPessoas) {
        this.qtdPessoas = qtdPessoas;
    }

    public double getQtdCarga() {
        return qtdCarga;
    }

    public void setQtdCarga(double qtdCarga) {
        this.qtdCarga = qtdCarga;
    }

    public double getTempo() {
        return tempo;
    }

    public void setTempo(double tempo) {
        this.tempo = tempo;
    }

    public String getClima() {
        return clima;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }
}
