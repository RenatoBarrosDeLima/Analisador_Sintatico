package Teste;

import Lexico.Lexico;
import java.util.ArrayList;

/**
 *
 * @author renato
 */
public class Termo {

    public static Lexico lex = new Lexico();
    public static Fator fat = new Fator();

    public void termo() {
        //fat.fator();
        lex.procuraAutomatoCerto();
        System.out.println("\n\n"+lex.token);
        
        

        //Repetição da Expressão { ( + | div | e ) <fator> }
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

        // Procurando o '*'
        if (lex.token.get(lex.token.size() - 1) == 's') {
            lex.token.remove(lex.token.size() - 1);
            if (lex.token.get(lex.token.size() - 1) == '*') {
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
                System.out.println("Erro: '+' | '- div' | 'e' era esperado !");
                System.exit(0);
            }

            // Procurando o 'ou'
        } else if (lex.token.size() == 4 && lex.token.get(lex.token.size() - 1) == 'i') {
            String div = "div";
            if (lex.token.get(lex.token.size() - 1) == 'i') {
                ArrayList<Character> div1 = new ArrayList<>();
                for (int i = 0; i < lex.token.size() - 1; i++) {
                    div1.add(div.charAt(i));
                }
                lex.token.remove(lex.token.size() - 1);
                if (lex.token.containsAll(div1)) {
                    System.out.print(lex.token);
                    System.out.println("   Correto - Nome 'div'");
                    esvaziaToken();
                    lex.procuraAutomatoCerto();
                } else {
                    System.out.println("Erro: '*' | 'div' | 'e' era esperado !");
                    System.exit(0);

                }
            } else {
                System.out.println("Erro: '*' | 'div' | 'e' era esperado !");
                System.exit(0);
            }
        } else if (lex.token.size() == 2 && lex.token.get(lex.token.size() - 1) == 'i') {
            String e = "e";
            if (lex.token.get(lex.token.size() - 1) == 'i') {
                ArrayList<Character> e1 = new ArrayList<>();
                for (int i = 0; i < lex.token.size() - 1; i++) {
                    e1.add(e.charAt(i));
                }
                lex.token.remove(lex.token.size() - 1);
                if (lex.token.containsAll(e1)) {
                    System.out.print(lex.token);
                    System.out.println("   Correto - Nome 'e'");
                    esvaziaToken();
                    lex.procuraAutomatoCerto();
                } else {
                    System.out.println("Erro: '*' | 'div' | 'e' era esperado !");
                    System.exit(0);

                }
            } else {
                System.out.println("Erro: '*' | 'div' | 'e' era esperado !");
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
