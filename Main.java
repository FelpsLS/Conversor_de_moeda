import java.io.IOException;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Conversor converte = new Conversor();
        System.err.println("Bem vindo ao conversor de moedas");
        // var moeda = sc.nextLine().toUpperCase();
        while(true){
            System.out.println("""
                1. Dolar -> Peso argentino
                2. Peso argentino -> Dolar
                3. Dolar -> Real brasileiro
                4. Real brasileiro -> Dolar
                5. Dolar -> Peso colombiano
                6. Peso colombiano -> Dolar
                7. Sair
                """);
            System.out.println("Escolha uma das opcoes de conversao: ");
            int opcao = sc.nextInt();

            if(opcao == 7){
                System.out.println("Finalizando a aplicacao");
                break;
            }

            System.out.println("Digite o valor: ");
            double valor = sc.nextDouble();
            
            String origMoeda = null;
            String novaMoeda = null;

            switch (opcao) {
                case 1:
                    origMoeda = "USD";
                    novaMoeda = "ARS";
                break;
                
                case 2:
                    origMoeda = "ARS";
                    novaMoeda = "USD";
                break;
                case 3:
                    origMoeda = "USD";
                    novaMoeda = "BRL";
                break;
                case 4:
                    origMoeda = "BRL";
                    novaMoeda = "USD";
                break;
                case 5:
                    origMoeda = "USD";
                    novaMoeda = "COP";
                break;
                case 6:
                    origMoeda = "COP";
                    novaMoeda = "USD";
                break;

                default:
                    System.out.println("Opcao inválida");
                continue;
            }
            try{
                Moeda novMoeda = converte.convertMoeda(origMoeda);
                Double taxaCambio = novMoeda.getConversion_rates().get(novaMoeda);
                if(taxaCambio != null){
                    double valorConvert = valor * taxaCambio;
                    System.err.printf("Valor convertido e: %.2f - %s\n", valorConvert, novaMoeda);
                }else {
                    System.out.println("Nao foi possivel converter o valo desejada na moeda selecionada\n");
                }
            }catch(RuntimeException e){
                System.err.println(e.getMessage());
                System.out.println("Finalizando a aplicacao");
            }
        }
       
        
    }
}