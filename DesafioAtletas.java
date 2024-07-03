import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Locale;

public class DesafioAtletas {
    public static void main(String[] args) {
         Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
       

        String nome, sexo = "", maisAlto = "", aviso = "";
        double altura, peso, pesoMedio = 0, trocaAlt = 0, porcentagem, altuMediaM = 0;
        int qtdAtle, i, contM = 0, contH = 0, totalPessoas = 0;

        System.out.print("Qual a quantidade de atletas? ");
        while (true) {
            try {
                qtdAtle = scanner.nextInt();
                scanner.nextLine(); // Consume newline left-over
                break;
            } catch (InputMismatchException e) {
                System.out.print("Entrada inválida! Favor digitar um número inteiro: ");
                scanner.nextLine(); // Clear invalid input
            }
        }

        for (i = 1; i <= qtdAtle; i++) {
            System.out.println("");
            System.out.println("Digite os dados do atleta número " + i + ":");
            System.out.print("Nome: ");
            nome = scanner.nextLine();

            System.out.print("Sexo (m/f): ");
            while (true) {
                sexo = scanner.nextLine().toLowerCase();
                if (!sexo.equals("m") && !sexo.equals("f")) {
                    System.out.print("Valor inválido! Favor digitar f ou m: ");
                } else {
                    break;
                }
            }

            // Calcular quantidade de homens
            if (sexo.equals("m")) {
                contH++;
            }

            // Repetir caso altura seja diferente do solicitado
            System.out.print("Altura: ");
            while (true) {
                try {
                    altura = scanner.nextDouble();
                    if (altura <= 0) {
                        System.out.print("Valor inválido! Digitar um valor positivo: ");
                    } else {
                        break;
                    }
                } catch (InputMismatchException e) {
                    System.out.print("Entrada inválida! Digitar um valor numérico: ");
                    scanner.nextLine(); // Clear invalid input
                }
            }

            // Média de altura das mulheres e quantidade
            if (sexo.equals("f")) {
                altuMediaM += altura;
                contM++;
            } else {
                aviso = "Não há mulheres cadastradas";
            }

            // Repetir caso peso seja diferente do solicitado
            System.out.print("Peso: ");
            while (true) {
                try {
                    peso = scanner.nextDouble();
                    if (peso <= 0) {
                        System.out.print("Valor inválido! Digitar um valor positivo: ");
                    } else {
                        break;
                    }
                } catch (InputMismatchException e) {
                    System.out.print("Entrada inválida! Digitar um valor numérico: ");
                    scanner.nextLine(); // Clear invalid input
                }
            }
            scanner.nextLine(); // Consume newline left-over

            pesoMedio += peso;

            // Atleta mais alto
            if (altura > trocaAlt) {
                trocaAlt = altura;
                maisAlto = nome;
            }
        }

        // Calcular porcentagem de homens
        porcentagem = ((double) contH * 100) / qtdAtle;

        // Relatório
        System.out.println("");
        System.out.println("RELATÓRIO:");
        System.out.printf("Peso médio dos atletas: %.2f%n", pesoMedio / qtdAtle);
        System.out.println("Atleta mais alto: " + maisAlto);
        System.out.printf("Porcentagem de homens: %.1f%%%n", porcentagem);

        if (contM == 0) {
            System.out.println(aviso);
        } else {
            System.out.printf("Altura média das mulheres: %.2f%n", altuMediaM / contM);
        }

        scanner.close();
    }
}
