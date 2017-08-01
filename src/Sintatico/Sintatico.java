package Sintatico;

import Lexico.Lexico;

public class Sintatico {

    public static Lexico lex = new Lexico();
    public static int controleParenteses = 0;

    public static void main(String[] args) {
        lex.abreArquivoFonte();
        listaDeExpressao();
    }

    public static void listaDeExpressao() {
        expressao();

        char opc = '_';

        lex.procuraAutomatoCerto();

        if (lex.token.size() == 0) {
            System.out.println("Lista de expressão Incompleta");
            System.exit(0);
        } else {

            lex.token.remove(lex.token.size() - 1);
            opc = lex.token.get(0);

            while (opc == ';') {
                System.out.print(lex.token);
                System.out.println("   Correto - Símbolo Especial " + lex.getIndiceAtual());
                esvaziaToken();
                expressao();

                lex.procuraAutomatoCerto();
                lex.token.remove(lex.token.size() - 1);
                if (lex.token.size() == 1 && lex.token.get(0) == ';') {
                    opc = lex.token.get(0);
                } else {
                    lex.token.remove(lex.token.size() - 1);
                    lex.setIndiceAtual(lex.getIndiceAtual() - lex.token.size());
                    esvaziaToken();
                }
            }
        }

    }

    public static void expressao() {
        _expressaoSimples();

        char opc = '_';
        lex.procuraAutomatoCerto();
        if (lex.token.size() == 0) {
            System.out.println("Fim da Expressão");
            System.exit(0);
        }
        //obtendo o = | <> | < | <= | > | >=
        //Convesões
        // <> fica m
        // <= p
        // >= g
        if (lex.token.get(lex.token.size() - 1) == 's') {
            if ((lex.token.size() == 2) && (lex.token.get(0) == '=')) {
                opc = '=';
            } else if ((lex.token.size() == 3) && (lex.token.get(0) == '<') && (lex.token.get(1) == '>')) {
                opc = 'm';
            } else if ((lex.token.size() == 2) && (lex.token.get(0) == '<')) {
                opc = '<';
            } else if ((lex.token.size() == 3) && (lex.token.get(0) == '<') && (lex.token.get(1) == '=')) {
                opc = 'p';
            } else if ((lex.token.size() == 2) && (lex.token.get(0) == '>')) {
                opc = '>';
            } else if ((lex.token.size() == 3) && (lex.token.get(0) == '>') && (lex.token.get(1) == '=')) {
                opc = 'g';
            }
        }
        if ((opc == '=') || (opc == 'm') || (opc == '<') || (opc == 'p') || (opc == '>') || (opc == 'g')) {
            lex.token.remove(lex.token.size() - 1);
            lex.setIndiceAtual(lex.getIndiceAtual() - lex.token.size());
            esvaziaToken();
            //System.out.println(lex.getIndiceAtual());
            relacao20();
            _expressaoSimples();
        } else {
            System.out.println("Fim da Expressão");
            System.exit(0);
        }
    }

    public static void relacao20() {
        char opc = '_';
        lex.procuraAutomatoCerto();
        if (lex.token.size() == 0) {
            System.out.println("Erro: era esperado uma Relação");
            System.exit(0);
        }
        //obtendo o = | <> | < | <= | > | >=
        //Convesões
        // <> fica m
        // <= p
        // >= g
        if (lex.token.get(lex.token.size() - 1) == 's') {
            if ((lex.token.size() == 2) && (lex.token.get(0) == '=')) {
                opc = '=';
            } else if ((lex.token.size() == 3) && (lex.token.get(0) == '<') && (lex.token.get(1) == '>')) {
                opc = 'm';
            } else if ((lex.token.size() == 2) && (lex.token.get(0) == '<')) {
                opc = '<';
            } else if ((lex.token.size() == 3) && (lex.token.get(0) == '<') && (lex.token.get(1) == '=')) {
                opc = 'p';
            } else if ((lex.token.size() == 2) && (lex.token.get(0) == '>')) {
                opc = '>';
            } else if ((lex.token.size() == 3) && (lex.token.get(0) == '>') && (lex.token.get(1) == '=')) {
                opc = 'g';
            }
        }
        if ((opc == '=') || (opc == 'm') || (opc == '<') || (opc == 'p') || (opc == '>') || (opc == 'g')) {
            lex.token.remove(lex.token.size() - 1);
            System.out.print(lex.token);
            System.out.println("   Correto - Relação " + lex.getIndiceAtual());
            esvaziaToken();
        } else {
            System.out.println("Relação Inválida");
            System.exit(0);
        }
    }

    public static void _expressaoSimples() {
        lex.procuraAutomatoCerto();
        if (lex.token.size() == 0) {
            System.out.println("Erro: Termo Incompleto");
            System.exit(0);
        }
        //obtendo o '+' ou '-'
        if (lex.token.get(lex.token.size() - 1) == 's' && (lex.token.size() == 2) && (lex.token.get(0) == '+')) {
            lex.token.remove(lex.token.size() - 1);
            System.out.print(lex.token);
            System.out.println("   Correto - Símbolo Especial " + lex.getIndiceAtual());
            esvaziaToken();
            //lex.procuraAutomatoCerto();
        } else if (lex.token.get(lex.token.size() - 1) == 's' && (lex.token.size() == 2) && (lex.token.get(0) == '-')) {
            lex.token.remove(lex.token.size() - 1);
            System.out.print(lex.token);
            System.out.println("   Correto - Símbolo Especial " + lex.getIndiceAtual());
            esvaziaToken();
            //lex.procuraAutomatoCerto();

        } else {
            lex.setIndiceAtual(lex.getIndiceAtual() - (lex.token.size() - 1));
            esvaziaToken();
        }
        _termo();

    }

    public static void expressaoSimplesQuePodeRepetir() {
        char escolha = '_';
        lex.procuraAutomatoCerto();

        if (lex.token.size() == 0) {
            System.out.println("Erro: Termo Incompleto");
            System.exit(0);
        }

        //obtendo o ou | + | -
        if ((lex.token.size() == 3) && (lex.token.get(0) == 'o') && (lex.token.get(1) == 'u')) {
            escolha = 'o';
        } else if ((lex.token.size() == 2) && (lex.token.get(0) == '+')) {
            escolha = '+';
        } else if ((lex.token.size() == 2) && (lex.token.get(0) == '-')) {
            escolha = '-';
        }

        if ((escolha == 'o') || (escolha == '+') || (escolha == '-')) {
            lex.token.remove(lex.token.size() - 1);
            System.out.print(lex.token);
            System.out.println("   Correto - Símbolo Especial " + lex.getIndiceAtual());
            esvaziaToken();
            lex.procuraAutomatoCerto();
            if (lex.token.size() == 0) {
                System.out.println("Erro: Era esperado o ')'");
                System.exit(0);
            }
        } else {
            System.out.println("Erro, era esperado um parâmetro válido");
            System.exit(0);
        }
        //obtendo o )
        if (lex.token.get(lex.token.size() - 1) == 's') {
            lex.token.remove(lex.token.size() - 1);
            if ((lex.token.size() == 1) && (lex.token.get(0) == ')')) {
                System.out.print(lex.token);
                System.out.println("   Correto - Símbolo Especial " + lex.getIndiceAtual());
                esvaziaToken();
                //lex.procuraAutomatoCerto();
            } else {
                System.out.println("Erro, era esperado ')'");
                System.exit(0);
            }
        }
        _termo();

        lex.procuraAutomatoCerto();
        if (lex.token.size() == 0 && controleParenteses == 0) {
            System.out.println("Fim da Expressão Simples");
            System.exit(0);
        } else if (lex.token.size() == 0 && controleParenteses == 1) {
            System.out.println("Era esperado um ')'");
            System.exit(0);
        } else if (lex.token.size() == 2 && controleParenteses == 1) {
            lex.token.remove(lex.token.size() - 1);
            controleParenteses = 0;
            if (lex.token.get(0) == ')') {
                System.out.print(lex.token);
                System.out.println("   Correto - Símbolo Especial " + lex.getIndiceAtual());
                esvaziaToken();

                lex.procuraAutomatoCerto();
                if (lex.token.size() == 0) {
                    System.out.println("Fim da Expressão");
                    System.exit(0);
                }
            }
        }
        escolha = '_';

        if ((lex.token.size() == 2) && (lex.token.get(0) == '(')) {
            lex.token.remove(lex.token.size() - 1);
            System.out.print(lex.token);
            System.out.println("   Correto - Símbolo Especial " + lex.getIndiceAtual());
            esvaziaToken();
            lex.procuraAutomatoCerto();

            if (lex.token.size() == 0) {
                // System.out.println("Erro, Termo Incompleto");
                // System.exit(0);
            }

            if ((lex.token.size() == 3) && (lex.token.get(0) == 'o') && (lex.token.get(1) == 'u')) {
                escolha = 'o';
            } else if ((lex.token.size() == 2) && (lex.token.get(0) == '+')) {
                escolha = '+';
            } else if ((lex.token.size() == 2) && (lex.token.get(0) == '-')) {
                escolha = '-';
            }
            if (escolha == 'o' || escolha == '+' || escolha == '-') {
                lex.token.remove(lex.token.size() - 1);
                lex.setIndiceAtual(lex.getIndiceAtual() - lex.token.size());
                esvaziaToken();
                System.out.println(lex.getIndiceAtual());
                expressaoSimplesQuePodeRepetir();
            } else if (escolha != 'o' || escolha != '+' || escolha != '-') {
                lex.setIndiceAtual(lex.getIndiceAtual() - (lex.token.size() - 1));
                esvaziaToken();
                termoQuePodeRepetir();
            }
        } else {
            lex.setIndiceAtual(lex.getIndiceAtual() - (lex.token.size() - 1));
            esvaziaToken();
        }

    }

    public static void _termo() {
        fator_24();

        lex.procuraAutomatoCerto();
        if (lex.token.size() == 0) {
            System.out.println("Erro: Termo Incompleto");
            System.exit(0);
        }
        //obtendo o(
        if (lex.token.get(lex.token.size() - 1) == 's') {
            lex.token.remove(lex.token.size() - 1);
            if ((lex.token.size() == 1) && (lex.token.get(0) == '(')) {
                System.out.print(lex.token);
                System.out.println("   Correto - Símbolo Especial " + lex.getIndiceAtual());
                esvaziaToken();
                //lex.procuraAutomatoCerto();
            } else {
                System.out.println("Erro, era esperado '('");
                System.exit(0);
            }
        }
        termoQuePodeRepetir();
    }

    public static void termoQuePodeRepetir() {
        //fator_24();

        char escolha = '_';
        lex.procuraAutomatoCerto();

        if (lex.token.size() == 0) {
            System.out.println("Erro: Termo Incompleto");
            System.exit(0);
        }

        //obtendo o * | div | e
        if ((lex.token.size() == 4) && (lex.token.get(0) == 'd') && (lex.token.get(1) == 'i') && (lex.token.get(2) == 'v')) {
            escolha = 'd';
        } else if ((lex.token.size() == 2) && (lex.token.get(0) == '*')) {
            escolha = '*';
        } else if ((lex.token.size() == 2) && (lex.token.get(0) == 'e')) {
            escolha = 'e';
        }

        if ((escolha == 'd') || (escolha == '*') || (escolha == 'e')) {
            lex.token.remove(lex.token.size() - 1);
            System.out.print(lex.token);
            System.out.println("   Correto - Símbolo Especial " + lex.getIndiceAtual());
            esvaziaToken();
            lex.procuraAutomatoCerto();
            if (lex.token.size() == 0) {
                System.out.println("Erro: Era esperado o ')'");
                System.exit(0);
            }
        } else {
            System.out.println("Erro, era esperado um parâmetro válido");
            System.exit(0);
        }
        //obtendo o )
        if (lex.token.get(lex.token.size() - 1) == 's') {
            lex.token.remove(lex.token.size() - 1);
            if ((lex.token.size() == 1) && (lex.token.get(0) == ')')) {
                System.out.print(lex.token);
                System.out.println("   Correto - Símbolo Especial " + lex.getIndiceAtual());
                esvaziaToken();
                //lex.procuraAutomatoCerto();
            } else {
                System.out.println("Erro, era esperado ')'");
                System.exit(0);
            }
        }
        fator_24();

        lex.procuraAutomatoCerto();
        escolha = '_';

        if ((lex.token.size() == 2) && (lex.token.get(0) == '(')) {
            lex.token.remove(lex.token.size() - 1);
            System.out.print(lex.token);
            System.out.println("   Correto - Símbolo Especial " + lex.getIndiceAtual());
            esvaziaToken();
            lex.procuraAutomatoCerto();

            if (lex.token.size() == 0) {
                System.out.println("Erro, Termo Incompleto");
                System.exit(0);
            }

            if ((lex.token.size() == 4) && (lex.token.get(0) == 'd') && (lex.token.get(1) == 'i') && (lex.token.get(2) == 'v')) {
                escolha = 'd';
            } else if ((lex.token.size() == 2) && (lex.token.get(0) == '*')) {
                escolha = '*';
            } else if ((lex.token.size() == 2) && (lex.token.get(0) == 'e')) {
                escolha = 'e';
            }
            if (escolha == 'd' || escolha == '*' || escolha == 'e') {
                lex.token.remove(lex.token.size() - 1);
                lex.setIndiceAtual(lex.getIndiceAtual() - lex.token.size());
                esvaziaToken();
                System.out.println(lex.getIndiceAtual());
                termoQuePodeRepetir();
            } else if (escolha != 'd' && escolha != '*' && escolha != 'e') {
                lex.setIndiceAtual(lex.getIndiceAtual() - (lex.token.size() - 1));
                esvaziaToken();
                expressaoSimplesQuePodeRepetir();
            }
        } else {
            lex.setIndiceAtual(lex.getIndiceAtual() - (lex.token.size() - 1));
            esvaziaToken();
        }

    }

    public static void fator_24() {

        lex.procuraAutomatoCerto();
        if (lex.token.size() == 0) {
            System.out.println("Erro: era esperado um Fator");
            System.exit(0);
        }
        //Numero
        if (lex.token.get(lex.token.size() - 1) == 'd') {
            lex.token.remove(lex.token.size() - 1);
            System.out.print(lex.token);
            System.out.println("   Correto - Numero " + lex.getIndiceAtual());
            esvaziaToken();
        } //Variavel
        else if ((lex.token.get(lex.token.size() - 1) == 'i') || (lex.token.get(lex.token.size() - 1) == 'p')) {
            lex.token.remove(lex.token.size() - 1);
            System.out.print(lex.token);
            System.out.println("   Correto - Identificador " + lex.getIndiceAtual());
            esvaziaToken();
        }//(expressao)
        else if ((lex.token.get(lex.token.size() - 1) == 's') && (lex.token.get(0) == '(') && lex.token.size() == 2) {
            lex.token.remove(lex.token.size() - 1);
            System.out.print(lex.token);
            System.out.println("   Correto - Identificador " + lex.getIndiceAtual());
            esvaziaToken();
            controleParenteses = controleParenteses + 1;
            expressao();

        } else {
            System.out.println("Erro, Era esperado um Fator " + lex.token.get(0));
            System.exit(0);
        }
    }

    public static void esvaziaToken() {
        while (!lex.token.isEmpty()) {
            lex.token.remove(0);
        }
    }

}
