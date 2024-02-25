import model.TipoModelo;
import model.TipoMotorizacao;
import model.Veiculo;
import service.Fachada;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(" Criando um veículo");
        System.out.println(" ///////////// ");

        Veiculo v1 = new Veiculo(TipoModelo.FIAT, "Uno", 12, TipoMotorizacao.GASOLINA, 50, 50);
        System.out.println(v1);

        System.out.println(" ///////////// ");

        System.out.println(" Adicionando  mais veiculos e Listando varios veículos\n");

        Fachada.cadastrarVeiculo(v1);

        Veiculo v2 = new Veiculo(TipoModelo.MASERATI, "MC20", 6, TipoMotorizacao.FLEX, 129, 129);
        Fachada.cadastrarVeiculo(v2);
        Veiculo v3 = new Veiculo(TipoModelo.AUDI, "A4", 15, TipoMotorizacao.ELETRICO, 150, 150);
        Fachada.cadastrarVeiculo(v3);
        Veiculo v4 = new Veiculo(TipoModelo.HYUNDAI, "Azera", 9, TipoMotorizacao.GASOLINA, 90, 11.2);
        Fachada.cadastrarVeiculo(v4);
        Veiculo v5 = new Veiculo(TipoModelo.HYUNDAI, "HB20", 19, TipoMotorizacao.DIESEL, 80, 30);
        Fachada.cadastrarVeiculo(v5);
        Veiculo v6 = new Veiculo(TipoModelo.AUDI, "A3 Sedan", 23, TipoMotorizacao.ELETRICO, 120, 120);
        Fachada.cadastrarVeiculo(v6);

        Veiculo v7 = new Veiculo(TipoModelo.NISSAN, "350Z", 14, TipoMotorizacao.GASOLINA, 100, 100);
        Fachada.cadastrarVeiculo(v7);

        Veiculo v8 = new Veiculo(TipoModelo.BMW, "X3", 17, TipoMotorizacao.DIESEL, 110, 110);
        Fachada.cadastrarVeiculo(v8);

        Veiculo v9 = new Veiculo(TipoModelo.TOYOTA, "RAV4", 15, TipoMotorizacao.GASOLINA, 95, 95);
        Fachada.cadastrarVeiculo(v9);

        Veiculo v10 = new Veiculo(TipoModelo.MERCEDES, "GLA", 16, TipoMotorizacao.GASOLINA, 105, 100);
        Fachada.cadastrarVeiculo(v10);

        Veiculo v11 = new Veiculo(TipoModelo.PORSCHE, "Cayenne", 20, TipoMotorizacao.DIESEL, 125, 125);
        Fachada.cadastrarVeiculo(v11);

        Veiculo v12 = new Veiculo(TipoModelo.FORD, "Mustang", 11, TipoMotorizacao.GASOLINA, 115, 111);
        Fachada.cadastrarVeiculo(v12);

        Veiculo v13 = new Veiculo(TipoModelo.HONDA, "Civic", 18, TipoMotorizacao.GASOLINA, 130, 0);
        Fachada.cadastrarVeiculo(v13);

        Veiculo v14 = new Veiculo(TipoModelo.VOLKSWAGEN, "Jetta", 16, TipoMotorizacao.DIESEL, 110, 50);
        Fachada.cadastrarVeiculo(v14);

        Veiculo v15 = new Veiculo(TipoModelo.AUDI, "A4", 21, TipoMotorizacao.GASOLINA, 100, 40);
        Fachada.cadastrarVeiculo(v15);

        String veiculosMostrados = Fachada.mostrarVeiculos();
        System.out.println(veiculosMostrados);
        
        System.out.println(" ///////////// ");
        System.out.println(" Adicionando veículo com o modelo não pertecente a marca \n");
        try {
            @SuppressWarnings("unused")
            Veiculo vError1 = new Veiculo(TipoModelo.FIAT, "NOUSSA", 15, TipoMotorizacao.ELETRICO, 150, 150);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println(" ///////////// ");
        System.out.println(" Listando 10 veículos por MENOR Autonomia\n");

        Fachada.classificarMenorAutonomia();

        veiculosMostrados = Fachada.mostrarVeiculos(10);
        System.out.println(veiculosMostrados);

        System.out.println(" ///////////// ");
        System.out.println(" Listando 10 veículos por MAIOR Autonomia\n");

        Fachada.classificarMaiorAutonomia();

        veiculosMostrados = Fachada.mostrarVeiculos(10);
        System.out.println(veiculosMostrados);

        System.out.println(" ///////////// ");
        System.out.println("Listando os veículos movidos a gasolina.\n");
        System.out.println(Fachada.listarVeiculoPorMotorizacao(TipoMotorizacao.GASOLINA));
        System.out.println(" ///////////// ");

        System.out.println("Listando os veículos eletricos.\n");
        System.out.println(Fachada.listarVeiculoPorMotorizacao(TipoMotorizacao.ELETRICO));
        System.out.println(" ///////////// ");
        
        System.out.println("Abastecendo os veículos movidos a diesel.\n");
        Fachada.AbastecerFrota(50, TipoMotorizacao.DIESEL);
        System.out.println("Abastecendo os veículos movidos a gasolina.\n");
        Fachada.AbastecerFrota(90, TipoMotorizacao.GASOLINA);
        System.out.println(" ///////////// ");
        
        System.out.println("Listando os veículos com autonomia inferior a 12");
        System.out.println(Fachada.listarVeiculosPorAutonomiaInferior(12));

        
    }

}
