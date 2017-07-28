package Sintatico;

import Lexico.Lexico;
import java.util.ArrayList;

public class Sintatico {

    public static Lexico lex = new Lexico();

    public static void main(String[] args) {
        lex.abreArquivoFonte();
        func_sintatico();

    }

    public static void func_sintatico() {
        expressao_Simples_22();
    }

    public static void esvaziaToken() {
        while (!lex.token.isEmpty()) {
            lex.token.remove(0);
        }
    }

    public static void expressao_Simples_22() {

        lex.procuraAutomatoCerto();

        //Procurando o '+'
        if ((lex.token.get(lex.token.size() - 1) == 's') && (lex.token.get(0) == '+') && (lex.token.size() == 2)) {
            lex.token.remove(lex.token.size() - 1);
            System.out.print(lex.token.get(0));
            System.out.println("   Correto - Símbolo Especial");
            esvaziaToken();

        } //Chamada de Funcao
        else if ((lex.token.get(lex.token.size() - 1) == 's') && (lex.token.get(0) == '-') && (lex.token.size() == 2)) {
            lex.token.remove(lex.token.size() - 1);
            System.out.print(lex.token.get(0));
            System.out.println("   Correto - Símbolo Especial");
            esvaziaToken();
        } //Se não for + ou - então não faz nada
        else if ((lex.token.get(0) != '+') && (lex.token.get(0) != '-')) {
            lex.token.remove(lex.token.size() - 1);
            lex.setIndiceAtual(lex.getIndiceAtual() - lex.token.size());
            esvaziaToken();
        }

        termo_23();
        
        repetirExpressao_Parent_Mais_Menos_Ou_Parent();
        
        termo_23();
    }

    public static void termo_23() {
        fator_24();
        lex.procuraAutomatoCerto();
        while (lex.token.get(0) == '(') {
            repetirExpressao_Parent_Aster_Div_E_Parent();
            fator_24();
            lex.procuraAutomatoCerto();
        }

    }

    public static void fator_24() {

        lex.procuraAutomatoCerto();
        //Numero
        if (lex.token.get(lex.token.size() - 1) == 'd') {
            lex.token.remove(lex.token.size() - 1);
            System.out.print(lex.token);
            System.out.println("   Correto - Numero");
            esvaziaToken();
        } //Chamada de Funcao
        else if ((lex.token.get(lex.token.size() - 1) == 'i') || (lex.token.get(lex.token.size() - 1) == 'p')) {
            lex.token.remove(lex.token.size() - 1);
            System.out.print(lex.token);
            System.out.println("   Correto - Identificador");
            esvaziaToken();
        } else {
            System.out.println("Erro, Era esperado um Fator");
            System.exit(0);
        }
    }

    //Obter a expressão {( * | div | e )
    public static void repetirExpressao_Parent_Aster_Div_E_Parent() {

        if (lex.token.get(0) != '(') {
            {
                System.out.println("Erro, era esperado o simbolo especial '('");
                System.exit(0);
            }
        }
        //Repetição da Expressão { ( + | div | e ) <fator> }
        // Procurando o '('
        if (lex.token.get(lex.token.size() - 1) == 's') {
            lex.token.remove(lex.token.size() - 1);
            if ((lex.token.size() == 1) && (lex.token.get(0) == '(')) {
                System.out.print(lex.token);
                System.out.println("   Correto - Símbolo Especial");
                esvaziaToken();
                lex.procuraAutomatoCerto();
            }
        }

        // Procurando o '*'
        if (lex.token.get(lex.token.size() - 1) == 's') {
            lex.token.remove(lex.token.size() - 1);
            if ((lex.token.size() == 1) && (lex.token.get(0) == '*')) {
                System.out.print(lex.token);
                System.out.println("   Correto - Símbolo Especial");
                esvaziaToken();
                lex.procuraAutomatoCerto();
                if (lex.token.get(0) != ')') {
                    {
                        System.out.println("Erro, era esperado o simbolo especial ')'");
                        System.exit(0);
                    }
                }
            } else {
                System.out.println("Erro: '+' | '- div' | 'e' era esperado ");
                System.exit(0);
            }

            // Procurando o 'div'
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
                    if (lex.token.get(0) != ')') {
                        System.out.println("Erro, era esperado o simbolo especial ')'");
                        System.exit(0);
                    }
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
                    if (lex.token.get(0) != ')') {
                        System.out.println("Erro, era esperado o simbolo especial ')'");
                        System.exit(0);
                    }
                }
            } else {
                System.out.println("Erro: '*' | 'div' | 'e' era esperado !");
                System.exit(0);
            }
        }

        // Procurando o ')'
        if (lex.token.get(lex.token.size() - 1) == 's') {
            lex.token.remove(lex.token.size() - 1);
            if ((lex.token.size() == 1) && (lex.token.get(0) == ')')) {
                System.out.print(lex.token);
                System.out.println("   Correto - Símbolo Especial");
                esvaziaToken();
                //lex.procuraAutomatoCerto();
            } else {
                System.out.println("Erro, era esperado ')' e apareceu '" + lex.token.get(lex.token.size() - 1));
                System.exit(0);
            }
        }
    }

    //Obter a expressão {( + | - | ou )
    public static void repetirExpressao_Parent_Mais_Menos_Ou_Parent() {

        if (lex.token.get(0) != '(') {
            {
                System.out.println("Erro, era esperado o simbolo especial '('");
                System.exit(0);
            }
        }
        // Procurando o '('
        if (lex.token.get(lex.token.size() - 1) == 's') {
            lex.token.remove(lex.token.size() - 1);
            if ((lex.token.size() == 1) && (lex.token.get(0) == '(')) {
                System.out.print(lex.token);
                System.out.println("   Correto - Símbolo Especial");
                esvaziaToken();
                lex.procuraAutomatoCerto();
            }
        }

        // Procurando o '+'
        if ((lex.token.get(lex.token.size() - 1) == 's') && (lex.token.get(0) == '+') && (lex.token.size() == 2)) {
            lex.token.remove(lex.token.size() - 1);
            if ((lex.token.size() == 1) && (lex.token.get(0) == '+')) {
                System.out.print(lex.token);
                System.out.println("   Correto - Símbolo Especial");
                esvaziaToken();
                lex.procuraAutomatoCerto();
                if (lex.token.get(0) != ')') {
                    {
                        System.out.println("Erro, era esperado o simbolo especial ')'");
                        System.exit(0);
                    }
                }
            } else {
                System.out.println("Erro: '+' | '-' | 'ou' era esperado ");
                System.exit(0);
            }

        } // Procurando o '-'
        else if ((lex.token.get(lex.token.size() - 1) == 's') && (lex.token.get(0) == '-') && (lex.token.size() == 2)) {
            lex.token.remove(lex.token.size() - 1);
            if ((lex.token.size() == 1) && (lex.token.get(0) == '-')) {
                System.out.print(lex.token);
                System.out.println("   Correto - Símbolo Especial");
                esvaziaToken();
                lex.procuraAutomatoCerto();
                if (lex.token.get(0) != ')') {
                    {
                        System.out.println("Erro, era esperado o simbolo especial ')'");
                        System.exit(0);
                    }
                }
            } else {
                System.out.println("Erro: '+' | '-' | 'ou' era esperado ");
                System.exit(0);
            }

            // Procurando o 'div'
        } else if (lex.token.size() == 3 && lex.token.get(lex.token.size() - 1) == 'i') {
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
                    if (lex.token.get(0) != ')') {
                        System.out.println("Erro, era esperado o simbolo especial ')'");
                        System.exit(0);
                    }
                }
            } else {
                System.out.println("Erro: '+' | '-' | 'ou' era esperado !");
                System.exit(0);
            }
        }
        // Procurando o ')'
        if (lex.token.get(lex.token.size() - 1) == 's') {
            lex.token.remove(lex.token.size() - 1);
            if ((lex.token.size() == 1) && (lex.token.get(0) == ')')) {
                System.out.print(lex.token);
                System.out.println("   Correto - Símbolo Especial");
                esvaziaToken();
                //lex.procuraAutomatoCerto();
            } else {
                System.out.println("Erro, era esperado ')' e apareceu '" + lex.token.get(lex.token.size() - 1));
                System.exit(0);
            }
        }
    }

}
