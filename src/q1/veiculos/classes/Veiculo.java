package q1.veiculos.classes;

/**
 * Classe abstrata para conter todos os veículos
 * @author Carlos Bravo - cehaga@dcc.ufrj.br
 */
public abstract class Veiculo {
    private int velocidadeMax;
    private double cargaMax;
    private int passageirosMax;

    /**
     * @param velocidadeMax Velocidade máxima do Veículo
     * @param cargaMax Carga máxima do Veículo
     * @param passageirosMax Quantidade máxima de passageiros do Veículo
     */
    public Veiculo(int velocidadeMax, double cargaMax, int passageirosMax) {
        this.velocidadeMax = velocidadeMax;
        this.cargaMax = cargaMax;
        this.passageirosMax = passageirosMax;
    }

    public int getVelocidadeMax() {
        return velocidadeMax;
    }

    public void setVelocidadeMax(int velocidadeMax) {
        this.velocidadeMax = velocidadeMax;
    }

    public double getCargaMax() {
        return cargaMax;
    }

    public void setCargaMax(double cargaMax) {
        this.cargaMax = cargaMax;
    }

    public int getPassageirosMax() {
        return passageirosMax;
    }

    public void setPassageirosMax(int passageirosMax) {
        this.passageirosMax = passageirosMax;
    }

    /**
     * Retorna os dados do veículo
     * @return Os dados do veículo
     */
    @Override
    public String toString() {
        return String.format("vel. máxima = %dkm/h, carga max. = %.1fkg, max. passageiros = %d",velocidadeMax,cargaMax,passageirosMax);
    }
}
