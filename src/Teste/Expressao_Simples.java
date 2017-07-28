/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Teste;

import Lexico.Lexico;
import java.util.ArrayList;

/**
 *
 * @author renato
 */
public class Expressao_Simples {

    public static Lexico lex = new Lexico();

    public static void funcao_Simples() {
        lex.procuraAutomatoCerto();

        //Simbolo Especial '+' ou '-'
        if (lex.token.get(lex.token.size() - 1) == 's') {
            lex.token.remove(lex.token.size() - 1);
            if ((lex.token.get(lex.token.size() - 1)) == '+' || (lex.token.get(lex.token.size() - 1) == '-')) {
                System.out.print(lex.token);
                System.out.println("   Correto - Símbolo Especial");
                esvaziaToken();
                lex.procuraAutomatoCerto();
            } else {
                System.out.println("Erro, era esperado '+' ou '-' e apareceu '" + lex.token.get(lex.token.size() - 1) + "'");
                System.exit(0);
            }
        }
        //Numero
        if (lex.token.get(lex.token.size() - 1) == 'd') {
            lex.token.remove(lex.token.size() - 1);
            System.out.print(lex.token);
            System.out.println("   Correto - Numero");
            esvaziaToken();
            lex.procuraAutomatoCerto();
            if (lex.token.get(lex.token.size() - 1) != 's') {
                {
                    System.out.println("Erro, era esperado o simbolo especial '('");
                    System.exit(0);
                }
            }
        }
        //Chamada de Funcao
        if ((lex.token.get(lex.token.size() - 1) == 'i') || (lex.token.get(lex.token.size() - 1) == 'p')) {
            lex.token.remove(lex.token.size() - 1);
            System.out.print(lex.token);
            System.out.println("   Correto - Identificador");
            esvaziaToken();
            lex.procuraAutomatoCerto();

        }
        //Repetição da Expressão { ( + | - | ou ) <termo> }
        // Procurando o '('
        if (lex.token.get(lex.token.size() - 1) == 's') {
            lex.token.remove(lex.token.size() - 1);
            if (lex.token.get(lex.token.size() - 1) == '(') {
                System.out.print(lex.token);
                System.out.println("   Correto - Símbolo Especial");

                esvaziaToken();
                lex.procuraAutomatoCerto();
            } else {
                System.out.println("Erro, era esperado '(' e apareceu '" + lex.token.get(lex.token.size() - 1));
                System.exit(0);
            }
        }

        // Procurando o '+' ou '-'
        if (lex.token.get(lex.token.size() - 1) == 's') {
            lex.token.remove(lex.token.size() - 1);
            if ((lex.token.get(lex.token.size() - 1) == '+') || (lex.token.get(lex.token.size() - 1) == '-')) {
                System.out.print(lex.token);
                System.out.println("   Correto - Símbolo Especial");
                esvaziaToken();
                lex.procuraAutomatoCerto();
                if (lex.token.get(lex.token.size() - 2) != ')') {
                    {
                        System.out.println("Erro, era esperado o simbolo especial ')'");
                        System.exit(0);
                    }
                }
            } else {
                System.out.println("Erro: '+' | '-' | 'ou' era esperado !");
                System.exit(0);
            }

            // Procurando o 'ou'
        } else {
            String ou = "ou";
            if (lex.token.get(lex.token.size() - 1) == 'i') {
                ArrayList<Character> ou1 = new ArrayList<>();
                for (int i = 0; i < lex.token.size() - 1; i++) {
                    ou1.add(ou.charAt(i));
                }
                lex.token.remove(lex.token.size() - 1);
                if (lex.token.containsAll(ou1)) {
                    System.out.print(lex.token);
                    System.out.println("   Correto - Nome 'ou'");
                    esvaziaToken();
                    lex.procuraAutomatoCerto();
                } else {
                    System.out.println("Erro: '+' | '-' | 'ou' era esperado !");
                    System.exit(0);

                }
            } else {
                System.out.println("Erro: '+' | '-' | 'ou' era esperado !");
                System.exit(0);
            }
        }

        // Procurando o ')'
        if (lex.token.get(lex.token.size() - 1) == 's') {
            lex.token.remove(lex.token.size() - 1);
            if (lex.token.get(lex.token.size() - 1) == ')') {
                System.out.print(lex.token);
                System.out.println("   Correto - Símbolo Especial");

                esvaziaToken();
                lex.procuraAutomatoCerto();
            } else {
                System.out.println("Erro, era esperado ')' e apareceu '" + lex.token.get(lex.token.size() - 1));
                System.exit(0);
            }
        }
    }

    public static void esvaziaToken() {
        while (!lex.token.isEmpty()) {
            lex.token.remove(0);
        }
    }

}
