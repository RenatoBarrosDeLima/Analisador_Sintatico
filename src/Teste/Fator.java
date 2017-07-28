package Teste;

import Lexico.Lexico;

public class Fator {

    public static Lexico lex = new Lexico();

    public void fator() {

        lex.procuraAutomatoCerto();
        
        System.out.println("\n\n" + lex.token);

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
        }
    }

    public void esvaziaToken() {
        while (!lex.token.isEmpty()) {
            lex.token.remove(0);
        }
    }
}
