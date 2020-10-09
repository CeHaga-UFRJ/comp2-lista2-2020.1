package q1.util;

import java.util.Random;

/**
 * Classe abstrata de utilidades numéricas
 * @author Carlos Bravo - cehaga@dcc.ufrj.br
 */
public abstract class Range {
    private static final Random random = new Random();

    /**
     * Retorna um número aleatório entre o intervalo definido
     * @param min Valor mínimo
     * @param max Valor máximo
     * @return Valor aleatório
     */
    public static double range(double min, double max){
        return random.nextDouble()*(max-min)+min;
    }

    /**
     * Retorna um número aleatório entre o intervalo definido
     * @param min Valor mínimo
     * @param max Valor máximo
     * @return Valor aleatório
     */
    public static int range(int min, int max){
        return random.nextInt(max-min)+min;
    }
}
