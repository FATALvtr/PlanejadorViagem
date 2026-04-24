package planejadorviagem;

import javax.sound.sampled.DataLine;
import javax.swing.JOptionPane;

public class PlanejadorViagem {
    
    public static void main(String[] args) {
        
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
        String data = JOptionPane.showInputDialog(null, "Digite a data de partida: ", "Trip Planner", JOptionPane.QUESTION_MESSAGE);
        if(!campo(data))return;
        String dias = JOptionPane.showInputDialog(null, "Quantidades de dias viajando: ", "Trip Planner", JOptionPane.QUESTION_MESSAGE);
        if(!campo(data))return;
        String valor = JOptionPane.showInputDialog(null, "Valor gasto por dia: ", "Trip Planner", JOptionPane.QUESTION_MESSAGE);
        if(!campo(data))return;
    }
    public static boolean campo(String campo){
//        Campos vazios 
        if (campo == null || campo.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "O campo não pode estar vazio!", "Erro",JOptionPane.ERROR_MESSAGE);
            return false; //Indica que deu erro
            }
            return true; //Esta correto e pode continuar
        }
        
    }
    public static double converter(String valor, String data){
//        Conversão de números (usar parseInt e parseDouble) 
//        Data válida (usar LocalDate) 
//        Valores negativos não são permitidos 
        return Double.parseDouble(valor);
        LocalDate;
        date
    }    
    public static void processar(){
//        Calcular o valor total da viagem: 
//        total = dias * valorPorDia 
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
}
