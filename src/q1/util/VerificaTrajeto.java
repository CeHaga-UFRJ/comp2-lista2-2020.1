package q1.util;

import q1.trajeto.Trajeto;
import q1.veiculos.classes.*;
import q1.veiculos.interfaces.Anfibio;
import q1.veiculos.interfaces.Aquatico;
import q1.veiculos.interfaces.Impermeavel;
import q1.veiculos.interfaces.Offroad;

import java.util.*;

/**
 * Classe abstrata com utilidades de Trajeto
 * @author Carlos Bravo - cehaga@dcc.ufrj.br
 */
public abstract class VerificaTrajeto {
    private static Scanner sc = new Scanner(System.in);

    /**
     * Lê os dados de trajeto da entrada padrão
     * @return Um objeto Trajeto
     */
    public static Trajeto leTrajeto(){
        String[] dados;
        double distancia;
        String caminho;
        int qtdPessoas;
        double qtdCarga;
        double tempo;
        String clima;
        List<String> caminhosValidos = Arrays.asList("rodovia", "estrada de terra", "rio", "lago", "mar");
        List<String> climasValidos = Arrays.asList("sol", "chuva");
        while(true){
            System.out.println("Entre com os dados no formato:\n<distância>, <tipo de caminho>, <número de pessoas>, <quantidade de carga>, <tempo limite>, <clima>");
            String entrada = sc.nextLine();
            dados = entrada.split(",");
            if(dados.length != 6) {
                System.out.println("Entrada inválida.");
                continue;
            }
            try{
                distancia = Double.parseDouble(dados[0].trim());
                if(!caminhosValidos.contains(dados[1].trim().toLowerCase())) throw new NumberFormatException();
                caminho = dados[1].trim().toLowerCase();
                qtdPessoas = Integer.parseInt(dados[2].trim());
                qtdCarga = Double.parseDouble(dados[3].trim());
                tempo = Double.parseDouble(dados[4].trim());
                if(!climasValidos.contains(dados[5].trim().toLowerCase())) throw new NumberFormatException();
                clima = dados[5].trim().toLowerCase();
            }catch(NumberFormatException e){
                System.out.println("Entrada inválida.");
                continue;
            }
            break;
        }
        return new Trajeto(distancia, caminho, qtdPessoas, qtdCarga, tempo, clima);
    }

    /**
     * Verifica a capacidade de cada veículo
     * @param trajeto O Trajeto a ser percorrido
     * @return Um List com os veículos válidos para esse trajeto
     */
    public static List<Veiculo> verificaCapacidade(Trajeto trajeto){
        Veiculo[] veiculos = new Veiculo[]{new Bicicleta(), new Caminhao(), new Canoa(), new Carro(), new Jipe(), new Lancha(), new Moto(), new Tanque()};
        List<Veiculo> veiculosValidos = new ArrayList<Veiculo>();
        List<String> agua = Arrays.asList("rio", "lago", "mar");
        double distancia = trajeto.getDistancia();
        String caminho = trajeto.getCaminho();
        int qtdPessoas = trajeto.getQtdPessoas();
        double qtdCarga = trajeto.getQtdCarga();
        double tempo = trajeto.getTempo();
        String clima = trajeto.getClima();
        for(Veiculo veiculo : veiculos){
            double velMedia = veiculo.getVelocidadeMax()/2;
            if(velMedia < distancia/tempo) continue;
            if(!agua.contains(caminho) && veiculo instanceof Aquatico) continue;
            if(agua.contains(caminho) && !(veiculo instanceof Aquatico || veiculo instanceof Anfibio)) continue;
            if(caminho.equals("estrada de terra") && !(veiculo instanceof Offroad)) continue;
            if(clima.equals("chuva") && !(veiculo instanceof Impermeavel)) continue;
            if(qtdCarga > veiculo.getCargaMax()) continue;
            if(qtdPessoas > veiculo.getPassageirosMax()) continue;
            veiculosValidos.add(veiculo);
        }
        return veiculosValidos;
    }
}
