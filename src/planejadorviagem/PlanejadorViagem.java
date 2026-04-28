package planejadorviagem;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import javax.sound.sampled.DataLine;
import javax.swing.JOptionPane;

public class PlanejadorViagem {
    
    public static void main(String[] args) {
        menu();
    }
    public static void menu(){
        String opcao[] = {"Planejar Viagem", "Sair"};
        int escolher = JOptionPane.showOptionDialog(null, "Planejar Viagem", "Trip Planner", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcao, opcao[0]);
        if (escolher == 0) {
        //Planejar viagem
            planejar();
        }else{
        //Sair
            JOptionPane.showMessageDialog(null, "SISTEMA FINALIZADO", "Trip Planner", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public static void planejar(){
        //dados    
        String nome = JOptionPane.showInputDialog(null, "Digite o nome do Viajante", "Trip Planner", JOptionPane.QUESTION_MESSAGE);
        if(!campo(nome))return;
        System.out.println("nome:"+nome);
        String dataRaw = JOptionPane.showInputDialog(null, "Digite a data de partida: ", "Trip Planner", JOptionPane.QUESTION_MESSAGE);
        if(!campo(dataRaw))return;
        LocalDate data = formatarData(dataRaw);
        System.out.println("data: "+data);
        String dias = JOptionPane.showInputDialog(null, "Quantidades de dias viajando: ", "Trip Planner", JOptionPane.QUESTION_MESSAGE);
        if(!campo(dias))return;
        converter(dias);
        double diaConvert = converter(dias);
        System.out.println("dias: "+diaConvert);
        String valor = JOptionPane.showInputDialog(null, "Valor gasto por dia: ", "Trip Planner", JOptionPane.QUESTION_MESSAGE);
        if(!campo(valor))return;
        converter(valor);
        double valorConvert = converter(valor);
        System.out.println("valor: "+valorConvert);
        
        processar(diaConvert, valorConvert, data, nome);
        
    }
    public static boolean campo(String campo){
//        Campos vazios 
        if (campo == null || campo.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "O campo não pode estar vazio!", "Erro",JOptionPane.ERROR_MESSAGE);
            return false; //Indica que deu erro
            }
            return true; //Esta correto e pode continuar
        }
        
    
    public static double converter(String valor){
        double numero = Double.parseDouble(valor);
        if (numero >= 1) {
            return numero;
        }else{
            JOptionPane.showConfirmDialog(null, "O valor não pode ser negativo!");
            return (0);
        }
    }    
    public static void processar(double dias, double valor, LocalDate dataViagem,String nome){
//        Calcular o valor total da viagem: 
//        total = dias * valorPorDia 
        double total = dias * valor; // calculo total de gastos na viagem
        LocalDate hoje = LocalDate.now(); //Pega a data atual do sistema
        String situacao = "";
        if (dataViagem.isBefore(hoje)) {
            situacao = "Viagem Passada";
            JOptionPane.showConfirmDialog(null, "Situação: "+situacao);
        }
        if (dataViagem.isEqual(hoje)) {
            situacao = "Viagem é Hoje!";
            JOptionPane.showConfirmDialog(null, "Situação: "+situacao);
        }
        if (dataViagem.isAfter(hoje)) {
            situacao = "Viagem Futura";
            JOptionPane.showConfirmDialog(null, "Situação: "+situacao);
            
            long faltamDias = ChronoUnit.DAYS.between(hoje, dataViagem);
            JOptionPane.showMessageDialog(null, "Situação: Viagem Futura\nFaltam " + faltamDias + " dias!");
        }
        
        resultado(nome, dataViagem, dias, total, situacao);

    }
    public static void resultado(String nome, LocalDate dataViagem, double dias, double valorTotal, String situacao) {
    
    // Formatando a data para o padrão brasileiro ao exibir
    DateTimeFormatter formatoBR = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    String dataFormatada = dataViagem.format(formatoBR);

    String mensagem = String.format(
        "RESUMO DA VIAGEM\n\n" +
        "Viajante: %s\n" +
        "Data da viagem: %s\n" +
        "Dias viajando: %.0f\n" +
        "Valor total: R$ %.2f\n" +
        "Situação: %s", 
        nome, dataFormatada, dias, valorTotal, situacao
    );

    JOptionPane.showMessageDialog(null, mensagem, "Resultado Final", JOptionPane.INFORMATION_MESSAGE);

    }
    public static LocalDate formatarData(String data){
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            return LocalDate.parse(data, formato);
        } catch (Exception e) {
            System.out.println("Error: Formato de data invalido!");
            return null;
        }
    }
    
}
