package com.algaworks.brewer.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.Scanner;

public class GeradorDeSenhas {

    static final String SENHA1 = "@ngul@r0";
    static final String SENHA2 = "m0b1l30";
    static final String SENHA3 = "admin";
    static final String SENHA4 = "sw@gg3r";
    static final String SENHA5 = "usuario";
    static final String SENHA6 ="admin";


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String opcao = "";


        System.out.println("------------------");
        do{
            System.out.println("Escolha uma opção:");
            System.out.println("1 - " + GeradorDeSenhas.SENHA1);
            System.out.println("2 - " + GeradorDeSenhas.SENHA2);
            System.out.println("3 - " + GeradorDeSenhas.SENHA3);
            System.out.println("4 - " + GeradorDeSenhas.SENHA4);
            System.out.println("5 - " + GeradorDeSenhas.SENHA5);
            System.out.println("6 - " + GeradorDeSenhas.SENHA6);
            System.out.println("0 - SAIR");
            System.out.println("------------------");
            opcao = sc.nextLine();
            geraSenha(opcao);
        }while(!opcao.equalsIgnoreCase("0"));

    }


    private static void geraSenha(String opcao){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        switch (opcao) {
            case "0":
                return;
            case "1":
                extracted(encoder, GeradorDeSenhas.SENHA1);
                break;
            case "2":
                extracted(encoder, GeradorDeSenhas.SENHA2);
                break;
            case "3":
                extracted(encoder, GeradorDeSenhas.SENHA3);
                break;
            case "4":
                extracted(encoder, GeradorDeSenhas.SENHA4);
                break;
            case "5":
                extracted(encoder, GeradorDeSenhas.SENHA5);
                break;
            case "6":
                extracted(encoder, GeradorDeSenhas.SENHA6);
                break;
        }
    }

    private static void extracted(BCryptPasswordEncoder encoder, String senha) {
        System.out.println("--------------------"+senha+"----------------------------------------");
        System.out.println(encoder.encode(senha));
        System.out.println("------------------------------------------------------------");
    }

}
