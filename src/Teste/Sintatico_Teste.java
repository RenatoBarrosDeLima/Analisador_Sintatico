package Teste;

import Lexico.Lexico;
import java.util.ArrayList;

public class Sintatico_Teste {

    public static Lexico lex = new Lexico();

    public static void main(String[] args) {
        lex.abreArquivoFonte();
        fator();

    }

    public static boolean nome_var() {
        lex.procuraAutomatoCerto();
        String var = "var";
        if (lex.token.get(lex.token.size() - 1) == 'i' && (lex.token.size() - 1 == var.length())) {
            ArrayList<Character> var1 = new ArrayList<>();
            for (int i = 0; i < lex.token.size() - 1; i++) {
                var1.add(var.charAt(i));
            }
            lex.token.remove(lex.token.size() - 1);

            if (lex.token.containsAll(var1)) {
                System.out.print(lex.token);
                System.out.println("   Correto - var");
                esvaziaToken();
                return true;
            } else {
                System.out.println("Erro: var era esperado !");
                System.exit(0);
                return false;
            }
        } else {
            System.out.println("Erro: var era esperado !");
            System.exit(0);
            return false;
        }
    }

    public static void esvaziaToken() {
        while (!lex.token.isEmpty()) {
            lex.token.remove(0);
        }
    }

    public static void expressaoSimples() {
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

    public static void fator() {

        lex.procuraAutomatoCerto();

        //Numero
        if (lex.token.get(lex.token.size() - 1) == 'd') {
            lex.token.remove(lex.token.size() - 1);
            System.out.print(lex.token);
            System.out.println("   Correto - Numero");
            esvaziaToken();
            lex.procuraAutomatoCerto();
            if (lex.token.get(lex.token.size() - 2) != '(') {
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
        }
    }

    public static void termo() {
        fator();
 
        System.out.println("\n\n NADA");
        
        lex.procuraAutomatoCerto();

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

}
