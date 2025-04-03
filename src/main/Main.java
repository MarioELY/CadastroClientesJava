package main;

import model.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PessoaFisicaRepo repoFisica = new PessoaFisicaRepo();
        PessoaJuridicaRepo repoJuridica = new PessoaJuridicaRepo();
        int opcao;

        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1 - Incluir");
            System.out.println("2 - Alterar");
            System.out.println("3 - Excluir");
            System.out.println("4 - Exibir por ID");
            System.out.println("5 - Exibir todos");
            System.out.println("6 - Salvar dados");
            System.out.println("7 - Recuperar dados");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            opcao = Integer.parseInt(sc.nextLine());

            switch (opcao) {
                case 1:
                    System.out.print("Tipo (F para Física, J para Jurídica): ");
                    String tipo = sc.nextLine();
                    System.out.print("ID: ");
                    int id = Integer.parseInt(sc.nextLine());
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    if (tipo.equalsIgnoreCase("F")) {
                        System.out.print("CPF: ");
                        String cpf = sc.nextLine();
                        System.out.print("Idade: ");
                        int idade = Integer.parseInt(sc.nextLine());
                        repoFisica.inserir(new PessoaFisica(id, nome, cpf, idade));
                    } else {
                        System.out.print("CNPJ: ");
                        String cnpj = sc.nextLine();
                        repoJuridica.inserir(new PessoaJuridica(id, nome, cnpj));
                    }
                    break;
                case 2:
                    System.out.print("Tipo (F ou J): ");
                    tipo = sc.nextLine();
                    System.out.print("ID: ");
                    id = Integer.parseInt(sc.nextLine());
                    if (tipo.equalsIgnoreCase("F")) {
                        PessoaFisica pf = repoFisica.obter(id);
                        if (pf != null) {
                            System.out.println("Dados atuais:");
                            pf.exibir();
                            System.out.print("Novo nome: ");
                            pf.setNome(sc.nextLine());
                            System.out.print("Novo CPF: ");
                            pf.setCpf(sc.nextLine());
                            System.out.print("Nova idade: ");
                            pf.setIdade(Integer.parseInt(sc.nextLine()));
                            repoFisica.alterar(pf);
                        }
                    } else {
                        PessoaJuridica pj = repoJuridica.obter(id);
                        if (pj != null) {
                            System.out.println("Dados atuais:");
                            pj.exibir();
                            System.out.print("Novo nome: ");
                            pj.setNome(sc.nextLine());
                            System.out.print("Novo CNPJ: ");
                            pj.setCnpj(sc.nextLine());
                            repoJuridica.alterar(pj);
                        }
                    }
                    break;
                case 3:
                    System.out.print("Tipo (F ou J): ");
                    tipo = sc.nextLine();
                    System.out.print("ID para excluir: ");
                    id = Integer.parseInt(sc.nextLine());
                    if (tipo.equalsIgnoreCase("F")) {
                        repoFisica.excluir(id);
                    } else {
                        repoJuridica.excluir(id);
                    }
                    break;
                case 4:
                    System.out.print("Tipo (F ou J): ");
                    tipo = sc.nextLine();
                    System.out.print("ID: ");
                    id = Integer.parseInt(sc.nextLine());
                    if (tipo.equalsIgnoreCase("F")) {
                        PessoaFisica pf = repoFisica.obter(id);
                        if (pf != null) pf.exibir();
                    } else {
                        PessoaJuridica pj = repoJuridica.obter(id);
                        if (pj != null) pj.exibir();
                    }
                    break;
                case 5:
                    System.out.print("Tipo (F ou J): ");
                    tipo = sc.nextLine();
                    if (tipo.equalsIgnoreCase("F")) {
                        for (PessoaFisica pf : repoFisica.obterTodos()) {
                            pf.exibir();
                            System.out.println("-----");
                        }
                    } else {
                        for (PessoaJuridica pj : repoJuridica.obterTodos()) {
                            pj.exibir();
                            System.out.println("-----");
                        }
                    }
                    break;
                case 6:
                    System.out.print("Prefixo do arquivo: ");
                    String prefixoSalvar = sc.nextLine();
                    try {
                        repoFisica.persistir(prefixoSalvar + ".fisica.bin");
                        repoJuridica.persistir(prefixoSalvar + ".juridica.bin");
                    } catch (Exception e) {
                        System.out.println("Erro ao salvar: " + e.getMessage());
                    }
                    break;
                case 7:
                    System.out.print("Prefixo do arquivo: ");
                    String prefixoRecuperar = sc.nextLine();
                    try {
                        repoFisica.recuperar(prefixoRecuperar + ".fisica.bin");
                        repoJuridica.recuperar(prefixoRecuperar + ".juridica.bin");
                    } catch (Exception e) {
                        System.out.println("Erro ao recuperar: " + e.getMessage());
                    }
                    break;
                case 0:
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
        sc.close();
    }
}