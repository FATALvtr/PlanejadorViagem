package planejadorviagem;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.sound.sampled.DataLine;
import javax.swing.JOptionPane;

public class PlanejadorViagem {
    
    public static void main(String[] args) {
        planejar();
    }
    public static void menu(){
        //Planejar viagem
        //Sair
        String opcao[] = {"Planejar Viagem", "Sair"};
        int escolher = JOptionPane.showOptionDialog(null, "Planejar Viagem", "Trip Planner", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcao, opcao[0]);
        if (escolher == 0) {
            planejar();
        }else{
            JOptionPane.showMessageDialog(null, "SISTEMA FINALIZADO", "Trip Planner", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public static void planejar(){
        //dados
//        Nome do viajante 
//        Data da viagem no formato dd/MM/yyyy 
//        Quantidade de dias de viagem (inteiro) 
//        Valor gasto por dia (decimal) 
//        String nome;
//        String data;
//        int dias;
//        double valor;
                  
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
    public static void processar(double dias, double valor, LocalDate dataViagem){
//        Calcular o valor total da viagem: 
//        total = dias * valorPorDia ]
        double total = dias * valor; // calculo total de gastos na viagem
        LocalDate hoje = LocalDate.now(); //Pega a data atual do sistema
        if (dataViagem.isBefore(hoje)) {
            JOptionPane.showConfirmDialog(null, "Situação: Viagem Passada");
        }
        if (dataViagem.isEqual(hoje)) {
            JOptionPane.showConfirmDialog(null, "Situação: Viagem é Hoje!");
        }
        if (dataViagem.isAfter(hoje)) {
            JOptionPane.showConfirmDialog(null, "Situação: Viagem Futura");
            
            long faltamDias = 
        }
        
//        Verificar se a viagem é: 
//        Passada 
//        Hoje 
//        Futura 
//        Se for futura, calcular quantos dias faltam 
    }
    public static void resultado(){
//        Nome 
//        Data da viagem 
//        Dias de viagem 
//        Valor total 
//        Situação da viagem (passada, hoje ou futura) 
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
