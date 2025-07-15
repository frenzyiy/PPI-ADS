import java.util.*;

public class conversor_de_bases {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("-------------------------------------");
            System.out.println("\n         ESCOLHAS");
            System.out.println("1 - Octal para Decimal");
            System.out.println("2 - Octal para Binário");
            System.out.println("3 - Hexadecimal para Decimal");
            System.out.println("4 - Binário para Hexadecimal");
            System.out.println("5 - Decimal para base 2, 8 e 16");
            System.out.println("6 - Binário para Octal");
            System.out.println("7 - Binário para Decimal");
            System.out.println("0 - Sair");
            System.out.println("-------------------------------------");
            System.out.print("Digite a opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    octalParaDecimal();
                    break;
                case 2:
                    octalParaBinario();
                    break;
                case 3:
                    hexaParaDecimal();
                    break;
                case 4:
                    binarioParaHexa();
                    break;
                case 5:
                    decimalParaQualquerBase();
                    break;
                case 6:
                    binarioParaOctal();
                    break;
                case 7:
                    binarioParaDecimal();
                    break;
                case 0:
                    System.out.println("Fechando");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        } while (opcao != 0);

        scanner.close();
    }

    // 1 - Octal para Decimal
    public static void octalParaDecimal() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o número octal: ");
        int numOctal = scanner.nextInt();

        int decimal = 0;
        int posicao = 0;

        while (numOctal > 0) {
            int resto = numOctal % 10;
            if (resto < 0 || resto > 7) {
                System.out.println("Número inválido");
                return;
            }
            decimal += resto * Math.pow(8, posicao);
            numOctal = numOctal / 10;
            posicao++;
        }
        System.out.println("O resultado é: " + decimal);
    }

    // 2 - Octal para Binário
    public static void octalParaBinario() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o número em octal: ");
        int numOctal = scanner.nextInt();

        // octal pra decimal
        int decimal = 0;
        int posicao = 0;

        while (numOctal > 0) {
            int resto = numOctal % 10;
            if (resto < 0 || resto > 7) {
                System.out.println("Número inválido");
                return;
            }
            decimal += resto * Math.pow(8, posicao);
            numOctal = numOctal / 10;
            posicao++;
        }

        // decimal pra binario
        int binario = 0;
        int mult = 1;
        while (decimal > 0) {
            binario += (decimal % 2) * mult;
            decimal = decimal / 2;
            mult *= 10;
        }
        System.out.println("O resultado é: " + binario);
    }

    // 3 - Hexadecimal para Decimal
    public static void hexaParaDecimal() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o número em hexadecimal: ");
        String numHex = scanner.nextLine().toUpperCase();

        int decimal = 0;
        int posicao = 0;

        for (int i = numHex.length() - 1; i >= 0; i--) {
            char chaar = numHex.charAt(i);
            int valor;
            if (chaar >= '0' && chaar <= '9') {
                valor = chaar - '0';
            } else if (chaar >= 'A' && chaar <= 'F') {
                valor = 10 + (chaar - 'A');
            } else {
                System.out.println("Número inválido");
                return;
            }
            decimal += valor * Math.pow(16, posicao);
            posicao++;
        }
        System.out.println("O resultado é: " + decimal);
    }

    // 4 - Binário para Hexadecimal
    public static void binarioParaHexa() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o número em binário: ");
        int numBin = scanner.nextInt();

        // binario pra decimal
        int decimal = 0;
        int posicao = 0;

        while (numBin > 0) {
            int resto = numBin % 10;
            if (resto < 0 || resto > 1) {
                System.out.println("Número inválido");
                return;
            }
            decimal += resto * Math.pow(2, posicao);
            numBin = numBin / 10;
            posicao++;
        }

        // decimal pra hexa
        if (decimal == 0) {
            System.out.println("Número inválido");
        } else {
            String hex = "";
            int temp = decimal;
            while (temp > 0) {
                int resto = temp % 16;
                char digito;
                if (resto < 10) {
                    digito = (char) ('0' + resto);
                } else {
                    digito = (char) ('a' + (resto - 10));
                }
                hex = digito + hex;
                temp = temp / 16;
            }
            System.out.println("O resultado é: " + hex);
        }
    }

    // 5 - Decimal para base 2 8 ou 16
    public static void decimalParaQualquerBase() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o número a ser convertido: ");
        int num = scanner.nextInt();
        System.out.print("Digite a base: ");
        int base = scanner.nextInt();

        if (num == 0) {
            System.out.println("0");
        } else {
            String resultado = "";
            int numero = num;

            while (numero > 0) {
                int resto = numero % base;
                resultado = resto + resultado;
                numero = numero / base;
            }
            System.out.println("O resultado é: " + resultado);
        }
    }

    // 6 - Binário para Octal
    public static void binarioParaOctal() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o número em binário: ");
        int numBin = scanner.nextInt();

        // binario pra decimal
        int decimal = 0;
        int posicao = 0;

        while (numBin > 0) {
            int resto = numBin % 10;
            if (resto < 0 || resto > 1) {
                System.out.println("Número inválido");
                return;
            }
            decimal += resto * Math.pow(2, posicao);
            numBin = numBin / 10;
            posicao++;
        }

        // decimal pra octal
        int octal = 0;
        int mult = 1;

        while (decimal > 0) {
            octal += (decimal % 8) * mult;
            decimal = decimal / 8;
            mult *= 10;
        }

        System.out.println("O resultado é: " + octal);
    }

    // 7 - Binário para Decimal
    public static void binarioParaDecimal() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o número em binário: ");
        int numBin = scanner.nextInt();

        int decimal = 0;
        int posicao = 0;

        while (numBin > 0) {
            int resto = numBin % 10;
            if (resto < 0 || resto > 1) {
                System.out.println("Número inválido");
                return;
            }
            decimal += resto * Math.pow(2, posicao);
            numBin = numBin / 10;
            posicao++;
        }
        System.out.println("O resultado é : " + decimal);

    }
}