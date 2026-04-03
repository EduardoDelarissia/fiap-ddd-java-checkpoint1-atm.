import java.util.Scanner;

public class FiapBankAtm {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // ==========================================
        // FASE A: CADASTRO DE DADOS E AUTENTICAÇÃO
        // ==========================================

        // 1. Solicitar Nome Completo do cliente
        System.out.println("============================================");
        System.out.println("   Bem-vindo ao FIAP Bank ATM - Alpha v1.0  ");
        System.out.println("============================================");
        System.out.print("Por favor, informe seu Nome Completo: ");
        String nomeCompleto = scanner.nextLine().trim();

        // Extrair o primeiro nome para a mensagem de boas-vindas
        String primeiroNome = nomeCompleto.split(" ")[0];
        System.out.println("Olá, " + primeiroNome + "! Seja bem-vindo(a) ao FIAP Bank.");
        System.out.println();

        // 2. Cadastro de Senha Forte
        // Regex para senha forte: mínimo 8 chars, 1 número, 1 letra maiúscula, 1 caractere especial
        String regexSenhaForte = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[!@#$%^&*()\\-_+=?><])." + "{8,}$";
        String senhaCadastrada = "";
        boolean senhaValida = false;

        System.out.println("--- Cadastro de Senha ---");
        System.out.println("Sua senha deve conter:");
        System.out.println("  - No mínimo 8 caracteres");
        System.out.println("  - Ao menos um número");
        System.out.println("  - Ao menos uma letra maiúscula");
        System.out.println("  - Ao menos um caractere especial: !@#$%^&*()\\_-+=?><");
        System.out.println();

        while (!senhaValida) {
            System.out.print("Crie sua senha: ");
            String senhaDigitada = scanner.nextLine();

            if (senhaDigitada.matches(regexSenhaForte)) {
                senhaCadastrada = senhaDigitada;
                senhaValida = true;
                System.out.println("Senha cadastrada com sucesso!");
            } else {
                System.out.println("Senha fraca! Verifique os requisitos e tente novamente.");
            }
        }

        System.out.println();

        // 3. Autenticação (Login)
        System.out.println("--- Autenticação ---");
        System.out.println("Por favor, insira sua senha para acessar o terminal.");

        int tentativas = 0;
        boolean autenticado = false;

        while (tentativas < 3 && !autenticado) {
            System.out.print("Digite sua senha: ");
            String senhaLogin = scanner.nextLine();

            // Comparar Strings corretamente com .equals()
            if (senhaLogin.equals(senhaCadastrada)) {
                autenticado = true;
                System.out.println("Acesso liberado! Bem-vindo(a), " + primeiroNome + ".");
            } else {
                tentativas++;
                int tentativasRestantes = 3 - tentativas;
                if (tentativasRestantes > 0) {
                    System.out.println("Senha incorreta. Tentativas restantes: " + tentativasRestantes);
                }
            }
        }

        // Bloquear acesso após 3 tentativas inválidas
        if (!autenticado) {
            System.out.println("*ACESSO BLOQUEADO*");
            scanner.close();
            return;
        }

        System.out.println();

        // ==========================================
        // FASE B & C: MENU PRINCIPAL E OPERAÇÕES
        // ==========================================

        double saldo = 0.00;
        int opcao = 0;

        do {
            System.out.println("============================================");
            System.out.println("              MENU PRINCIPAL                ");
            System.out.println("============================================");
            System.out.println("  [ 1 ] Consultar Saldo");
            System.out.println("  [ 2 ] Fazer Depósito");
            System.out.println("  [ 3 ] Fazer Saque");
            System.out.println("  [ 4 ] Sair");
            System.out.println("============================================");
            System.out.print("Escolha uma opção: ");

            // Leitura de opção como inteiro
            String entradaOpcao = scanner.nextLine().trim();

            // Verificar se a entrada é um número válido
            boolean entradaValida = true;
            for (int i = 0; i < entradaOpcao.length(); i++) {
                if (!Character.isDigit(entradaOpcao.charAt(i))) {
                    entradaValida = false;
                    break;
                }
            }

            if (!entradaValida || entradaOpcao.isEmpty()) {
                System.out.println("Opção inválida. Por favor, digite um número entre 1 e 4.");
                System.out.println();
                continue;
            }

            opcao = Integer.parseInt(entradaOpcao);

            switch (opcao) {

                case 1:
                    // Opção 1: Consultar Saldo
                    System.out.println("--------------------------------------------");
                    System.out.printf("  Saldo atual: R$ %.2f%n", saldo);
                    System.out.println("--------------------------------------------");
                    System.out.println();
                    break;

                case 2:
                    // Opção 2: Fazer Depósito
                    System.out.print("Informe o valor do depósito: R$ ");
                    String entradaDeposito = scanner.nextLine().trim().replace(",", ".");
                    try {
                        double valorDeposito = Double.parseDouble(entradaDeposito);
                        if (valorDeposito <= 0) {
                            System.out.println("Depósito inválido. O valor deve ser maior que zero.");
                        } else {
                            saldo += valorDeposito;
                            System.out.printf("Depósito de R$ %.2f realizado com sucesso!%n", valorDeposito);
                            System.out.printf("Novo saldo: R$ %.2f%n", saldo);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Valor inválido. Por favor, informe um número válido.");
                    }
                    System.out.println();
                    break;

                case 3:
                    // Opção 3: Fazer Saque
                    System.out.print("Informe o valor do saque: R$ ");
                    String entradaSaque = scanner.nextLine().trim().replace(",", ".");
                    try {
                        double valorSaque = Double.parseDouble(entradaSaque);
                        if (valorSaque <= 0) {
                            System.out.println("Saque inválido. O valor deve ser maior que zero.");
                        } else if (valorSaque > saldo) {
                            System.out.println("Saldo insuficiente para realizar o saque.");
                            System.out.printf("Saldo disponível: R$ %.2f%n", saldo);
                        } else {
                            saldo -= valorSaque;
                            System.out.printf("Saque de R$ %.2f realizado com sucesso!%n", valorSaque);
                            System.out.printf("Novo saldo: R$ %.2f%n", saldo);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Valor inválido. Por favor, informe um número válido.");
                    }
                    System.out.println();
                    break;

                case 4:
                    // Opção 4: Sair
                    System.out.println("============================================");
                    System.out.println("  O FIAP Bank agradece sua preferência!");
                    System.out.println("  Até logo, " + primeiroNome + "!");
                    System.out.println("============================================");
                    break;

                default:
                    System.out.println("Opção inválida. Por favor, escolha entre 1 e 4.");
                    System.out.println();
                    break;
            }

        } while (opcao != 4);

        scanner.close();
    }
}
