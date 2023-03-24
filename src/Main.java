//Por José Florêncio e Vinicius Cerveira - Ciência da Computação

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Exercicio> exercicios = new ArrayList<>();
        String op = "";
        Scanner select = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        // informe peso
        float peso, percentualGordura;
        int altura;
        System.out.println("Informe o peso: ");
        peso = select.nextFloat();
        System.out.println("Informe a altura(cm): ");
        altura = select.nextInt();
        percentualGordura = (peso / (altura * altura)) * 100;

        Usuario usuario = new Usuario(peso, altura, percentualGordura);
        while (true) {
            System.out.println("===========================");
            System.out.println("1 - Cadastrar Exercício");
            System.out.println("2 - Resumo diário");
            System.out.println("3 - Sair");
            System.out.println("===========================");
            op = select.next();
            switch (op) {
                case "1":
                    System.out.println("1 - Futebol");
                    System.out.println("2 - Corrida");
                    System.out.println("3 - Caminhada");
                    System.out.println("4 - Abdominal");
                    System.out.println("Escoha um exercício: ");
                    int select_atividade = select.nextInt();
                    System.out.println("Digite o tempo em minutos do exercício: ");
                    int tempo = select.nextInt();
                    System.out.println("Digite a data de relização da atividade (##/##/####):");
                    String data = select.next();
                    Date dataExercicio = null;
                    try {
                        dataExercicio = sdf.parse(data);
                    } catch (ParseException e) {
                        System.out.println("Data inválida");
                        break;
//                        e.printStackTrace();
                    }
                    if (select_atividade == 1) {
                        exercicios.add(new Futebol(tempo, dataExercicio));
                    } else if (select_atividade == 2) {
                        exercicios.add(new Corrida(tempo, dataExercicio));
                    } else if (select_atividade == 3) {
                        exercicios.add(new Caminhada(tempo, dataExercicio));
                    }
                    else if (select_atividade == 4) {
                        exercicios.add(new Abdominal(tempo, dataExercicio));
                    }
                    System.out.println("Exercício registrado com sucesso!");
                    break;
                case "2":
                    System.out.println("===========================\n" + "Resumo diário" +
                            "\n===========================");
                    float caloriasperdidas = 0;
                    int minFutebol = 0, minCorrida = 0, minCaminhada = 0, minAbdominal =0;
                    for (Exercicio e : exercicios) {
                        if (sdf.format(e.getDate()).equals(sdf.format(new Date()))) {
                            if (e.getTipo() == "Futebol") {
                                minFutebol += e.getMinutos();
                            } else if (e.getTipo() == "Corrida") {
                                minCorrida += e.getMinutos();
                            } else if (e.getTipo() == "Caminhada") {
                                minCaminhada += e.getMinutos();
                            }
                            else if (e.getTipo() == "Abdominal") {
                                minAbdominal += e.getMinutos();
                            }
                            caloriasperdidas += e.getCalorias();
                        }
                    }
                    System.out.println("Caro usuário, você perdeu " + caloriasperdidas + " calorias hoje.");
                    System.out.println("Você fez " + minFutebol + " minutos de futebol");
                    System.out.println("Você fez " + minCorrida + " minutos de corrida");
                    System.out.println("Você fez " + minCaminhada + " minutos de caminhada");
                    System.out.println("Você fez " + minAbdominal + " minutos de abdominal");
                    break;
                case "3":
                    //sair do programa
                    System.exit(0);
                    break;
            }
        }
    }
}
