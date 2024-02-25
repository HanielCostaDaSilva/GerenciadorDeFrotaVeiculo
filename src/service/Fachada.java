package service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import model.TipoMotorizacao;
import model.Veiculo;

public class Fachada {

    private static ArrayList<Veiculo> veiculos = new ArrayList<>();

    public static void cadastrarVeiculo(Veiculo v) {

        Fachada.veiculos.add(v);
    }

    public static void removerVeiculo(Veiculo v) {
        Fachada.veiculos.remove(v);
    }

    public static ArrayList<Veiculo> listarVeiculo() {
        return Fachada.veiculos;
    }

    /*Retorna uma lista contendo todos os veículos cadastrados que possuem um determinado tipo de combustível
     * 
    */
    public static ArrayList<Veiculo> listarVeiculoPorMotorizacao(TipoMotorizacao motorizacao) {
        ArrayList<Veiculo> veiculosEncontrados = new ArrayList<>();

        for (Veiculo v : veiculos) {
            if (v.getTipoMotorização() == motorizacao)
                veiculosEncontrados.add(v);
        }

        return veiculosEncontrados;

    }

    /**
     * Lista os veículos com autonomia inferior a uma porcentagem informada.
     * @param limInferAuto
     * @return
     */
    public static ArrayList<Veiculo> listarVeiculosPorAutonomiaInferior(double limInferAuto) {
        ArrayList<Veiculo> veiculosEncontrados = new ArrayList<>();

        for (Veiculo v : veiculos) {
            if (v.getAutonomia() < limInferAuto)
                veiculosEncontrados.add(v);
        }

        return veiculosEncontrados;

    }


    public static void classificarMenorAutonomia() {
        Collections.sort(Fachada.veiculos, Comparator.comparing(Veiculo::getAutonomia));
    }

    public static void classificarMaiorAutonomia() {
        Collections.sort(Fachada.veiculos, Comparator.comparing(Veiculo::getAutonomia).reversed());
    }



    public static String mostrarVeiculos() {

        int cont = 1;

        String s = "";

        for (Veiculo v : veiculos) {
            s += "Veiculo " + cont + " :" + v + "\n";
            cont++;

        }

        return s;
    }

    public static String mostrarVeiculos(int limite) {

        String s = "";

        // Garantia que o limite não irá estourar o vetor
        limite = (limite > veiculos.size()) ? veiculos.size() : limite;

        for (int i = 0; i < limite; i++) {
            s += "Veiculo " + (i + 1) + " :" + veiculos.get(i) + "\n";

        }

        return s;
    }
    /**
     * Método responsável por abastecer toda a frota com base em um tipo de combustível e quantidade a abastecer;
     * Caso a quantidade de combustível no tanque + a quantidade a abastecer for superior ao limite do tanque:
     * Será abastecido até o limite;
     */
    public static ArrayList<Veiculo> AbastecerFrota(double quantAbastecer, TipoMotorizacao tipoMotorizacao){
        ArrayList<Veiculo> veiculosAbastecidos = new ArrayList<>();

        for(Veiculo v : veiculos){
            //Só tente abastecer se o  veículo for de um determinado tipo de motor e o tanque não estiver cheio
            if(v.getTipoMotorização() == tipoMotorizacao && v.getCombustivelDisponivel()< v.getTanqueLimite()){

                double combTanque=v.getCombustivelDisponivel()+ quantAbastecer;
                
                //Não é possível colocar mais combustível que o limite do veículo.
                if( combTanque > v.getTanqueLimite()){
                    combTanque= v.getTanqueLimite();
                     
                     System.err.println("O valor inserido para abastecer o veiculo:\n"+ v+ "\nsuperou o limite do tanque. Foi perdido " + (v.getTanqueLimite() - quantAbastecer)+ "L/Kw de "+ v.getTipoMotorização());
                    }
                    
                    v.setCombustivelDisponivel(combTanque);
                    System.out.println("O veiculo:\n"+ v+ "\n foi abastecido");
            }
        }
        return veiculosAbastecidos;

    }

}
