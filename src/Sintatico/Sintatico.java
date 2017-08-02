package Sintatico;

import Lexico.Lexico;

public class Sintatico {

    public static Lexico lex = new Lexico();
    public static int controleParenteses = 0;

    public static void main(String[] args) {
        lex.abreArquivoFonte();
        programa_1();
    }

    public static void programa_1() {
        char opc = '_';
        lex.procuraAutomatoCerto();

        if (lex.token.size() == 0) {
            System.out.println("Erro: Termo Incompleto");
            System.exit(0);
        }

        if ((lex.token.size() == 9) && (lex.token.get(0) == 'p') && (lex.token.get(1) == 'r') && (lex.token.get(2) == 'o') && (lex.token.get(3) == 'g') && (lex.token.get(4) == 'r') && (lex.token.get(5) == 'a') && (lex.token.get(6) == 'm') && (lex.token.get(7) == 'a')) {
            opc = 'p';
        }

        if (opc == 'p') {
            lex.token.remove(lex.token.size() - 1);
            System.out.print(lex.token);
            System.out.println("   Correto - Nome PROGRAMA " + lex.getIndiceAtual());
            esvaziaToken();
            if (identificador_29()) {
                lex.token.remove(lex.token.size() - 1);
                System.out.print(lex.token);
                System.out.println("   Correto - Identificador " + lex.getIndiceAtual());
                esvaziaToken();

                lex.procuraAutomatoCerto();
                if (lex.token.size() == 2 && lex.token.get(0) == ';') {
                    lex.token.remove(lex.token.size() - 1);
                    System.out.print(lex.token);
                    System.out.println("   Correto - Simbolo Especial " + lex.getIndiceAtual());
                    esvaziaToken();
                } else {
                    System.out.println("Erro era esperado um ';' ");
                    System.exit(0);
                }
                bloco_2();
            }
        } else {
            System.out.println("Erro era esperado o nome PROGRAMA ");
            System.exit(0);
        }
    }

    public static void bloco_2() {
        char opc = '_';
        lex.procuraAutomatoCerto();

        if (lex.token.size() == 0) {
            System.out.println("Erro: Bloco Incompleto");
            System.exit(0);
        }

        if ((lex.token.size() == 5) && (lex.token.get(0) == 't') && (lex.token.get(1) == 'i') && (lex.token.get(2) == 'p') && (lex.token.get(3) == 'o')) {
            opc = 't';
        } else if ((lex.token.size() == 4) && (lex.token.get(0) == 'v') && (lex.token.get(1) == 'a') && (lex.token.get(2) == 'r')) {
            opc = 'v';
        } else if ((lex.token.size() == 7) && (lex.token.get(0) == 'i') && (lex.token.get(1) == 'n') && (lex.token.get(2) == 'i') && (lex.token.get(3) == 'c') && (lex.token.get(4) == 'i') && (lex.token.get(5) == 'o')) {
            opc = 'i';
        } else {
            lex.token.remove(lex.token.get(lex.token.size() - 1));
            System.out.println("Erro: '" + lex.token + "'  é um nome Identificador");
            System.exit(0);
        }

        switch (opc) {
            case 't':
                lex.token.remove(lex.token.size() - 1);
                System.out.print(lex.token);
                System.out.println("   Correto - Nome TIPO " + lex.getIndiceAtual());
                esvaziaToken();
                defTipo_3();
                break;
            case 'v':
                lex.token.remove(lex.token.size() - 1);
                System.out.print(lex.token);
                System.out.println("   Correto - Nome VAR " + lex.getIndiceAtual());
                esvaziaToken();
                defVar_5();
                break;
            case 'i':
                lex.token.remove(lex.token.size() - 1);
                System.out.print(lex.token);
                System.out.println("   Correto - Nome INICIO " + lex.getIndiceAtual());
                esvaziaToken();
                comandoComposto_11();
                break;
            default:
                return;
        }
    }

    public static void defTipo_3() {
        char opc = '_';
        if (identificador_29()) {
            lex.token.remove(lex.token.size() - 1);
            System.out.print(lex.token);
            System.out.println("   Correto - Identificador " + lex.getIndiceAtual());
            esvaziaToken();

            lex.procuraAutomatoCerto();
            if (lex.token.size() == 2 && lex.token.get(0) == '=') {
                lex.token.remove(lex.token.size() - 1);
                System.out.print(lex.token);
                System.out.println("   Correto - Simbolo Especial " + lex.getIndiceAtual());
                esvaziaToken();
            } else {
                System.out.println("Erro era esperado um '=' ");
                System.exit(0);
            }
            if (tipo_4()) {
                lex.token.remove(lex.token.size() - 1);
                System.out.print(lex.token);
                System.out.println("   Correto - Identificador " + lex.getIndiceAtual());
                esvaziaToken();

                lex.procuraAutomatoCerto();
                if (lex.token.size() == 2 && lex.token.get(0) == ';') {
                    lex.token.remove(lex.token.size() - 1);
                    System.out.print(lex.token);
                    System.out.println("   Correto - Simbolo Especial " + lex.getIndiceAtual());
                    esvaziaToken();
                } else {
                    System.out.println("Erro era esperado um ';' ");
                    System.exit(0);
                }
            }
        }
        lex.procuraAutomatoCerto();
        if ((lex.token.size() == 7) && (lex.token.get(0) == 'i') && (lex.token.get(1) == 'n') && (lex.token.get(2) == 'i') && (lex.token.get(3) == 'c') && (lex.token.get(4) == 'i') && (lex.token.get(5) == 'o')) {
            opc = 'i';
        } else {
            opc = '_';
        }
        if (opc != 'i') {
            lex.setIndiceAtual(lex.getIndiceAtual() - (lex.token.size() - 1));
            esvaziaToken();
            defTipo_3();
        } else {
            lex.token.remove(lex.token.size() - 1);
            System.out.print(lex.token);
            System.out.println("   Correto - Nome INICIO " + lex.getIndiceAtual());
            esvaziaToken();
            comandoComposto_11();
        }
    }

    public static boolean tipo_4() {
        lex.procuraAutomatoCerto();
        if ((lex.token.get(lex.token.size() - 1) == 'i') || (lex.token.get(lex.token.size() - 1) == 'p')) {
            return true;
        } else {
            System.out.println("Era esperado um IDENTIFICADOR");
            return false;
        }
    }

    public static void defVar_5() {
        char opc = '_';
        listaDeIdentificador_6();

        lex.procuraAutomatoCerto();
        if (lex.token.size() == 2 && lex.token.get(0) == ':') {
            lex.token.remove(lex.token.size() - 1);
            System.out.print(lex.token);
            System.out.println("   Correto - Simbolo Especial " + lex.getIndiceAtual());
            esvaziaToken();
        } else {
            System.out.println("Erro era esperado um ':' ");
            System.exit(0);
        }
        if (tipo_4()) {
            lex.token.remove(lex.token.size() - 1);
            System.out.print(lex.token);
            System.out.println("   Correto - Identificador " + lex.getIndiceAtual());
            esvaziaToken();

            lex.procuraAutomatoCerto();
            if (lex.token.size() == 2 && lex.token.get(0) == ';') {
                lex.token.remove(lex.token.size() - 1);
                System.out.print(lex.token);
                System.out.println("   Correto - Simbolo Especial " + lex.getIndiceAtual());
                esvaziaToken();
            } else {
                System.out.println("Erro era esperado um ';' ");
                System.exit(0);
            }
        }
        lex.procuraAutomatoCerto();
        if ((lex.token.size() == 7) && (lex.token.get(0) == 'i') && (lex.token.get(1) == 'n') && (lex.token.get(2) == 'i') && (lex.token.get(3) == 'c') && (lex.token.get(4) == 'i') && (lex.token.get(5) == 'o')) {
            opc = 'i';
        } else {
            opc = '_';
        }
        if (opc != 'i') {
            lex.setIndiceAtual(lex.getIndiceAtual() - (lex.token.size() - 1));
            esvaziaToken();
            defVar_5();
        } else {
            lex.token.remove(lex.token.size() - 1);
            System.out.print(lex.token);
            System.out.println("   Correto - Nome INICIO " + lex.getIndiceAtual());
            esvaziaToken();
            comandoComposto_11();
        }
    }

    public static void listaDeIdentificador_6() {
        if (identificador_29()) {
            lex.token.remove(lex.token.size() - 1);
            System.out.print(lex.token);
            System.out.println("   Correto - Identificador " + lex.getIndiceAtual());
            esvaziaToken();

            lex.procuraAutomatoCerto();
            if (lex.token.size() == 2 && lex.token.get(0) == ',') {
                lex.token.remove(lex.token.size() - 1);
                System.out.print(lex.token);
                System.out.println("   Correto - Simbolo Especial " + lex.getIndiceAtual());
                esvaziaToken();

                listaDeIdentificador_6();
            } else {
                lex.setIndiceAtual(lex.getIndiceAtual() - (lex.token.size() - 1));
                esvaziaToken();
            }
        }
    }

    public static void comandoComposto_11() {
        char opc = '_';
        comandoSemRotulo_12();

        lex.procuraAutomatoCerto();
        if ((lex.token.size() == 2) && (lex.token.get(0) == ';')) {
            lex.token.remove(lex.token.size() - 1);
            System.out.print(lex.token);
            System.out.println("   Correto - Simbolo Especial " + lex.getIndiceAtual());
            esvaziaToken();
        } else {
            System.out.println("Erro: era esperado um ';'");
            System.exit(0);
        }
        lex.procuraAutomatoCerto();
        if ((lex.token.size() == 4) && (lex.token.get(0) == 'f') && (lex.token.get(1) == 'i') && (lex.token.get(2) == 'm')) {
            opc = 'f';
        } else {
            opc = '_';
        }
        switch (opc) {
            case '_':
                lex.setIndiceAtual(lex.getIndiceAtual() - (lex.token.size() - 1));
                esvaziaToken();
                comandoComposto_11();
                break;
            case 'f':
                lex.token.remove(lex.token.size() - 1);
                System.out.print(lex.token);
                System.out.println("    FIM DO PROGRAMA");
                System.exit(0);
        }
    }

    public static void comandoSemRotulo_12() {
        char opc = '_';
        lex.procuraAutomatoCerto();

        if (lex.token.size() == 0) {
            System.out.println("Erro: Bloco Incompleto");
            System.exit(0);
        }

        if ((lex.token.size() == 3) && (lex.token.get(0) == 's') && (lex.token.get(1) == 'e')) {
            opc = 's';
        } else if ((lex.token.size() == 9) && (lex.token.get(0) == 'e') && (lex.token.get(1) == 'n') && (lex.token.get(2) == 'q') && (lex.token.get(3) == 'u') && (lex.token.get(4) == 'a') && (lex.token.get(5) == 'n') && (lex.token.get(6) == 't') && (lex.token.get(7) == 'o')) {
            opc = 'e';
        } else if ((lex.token.size() == 5) && (lex.token.get(0) == 'l') && (lex.token.get(1) == 'e') && (lex.token.get(2) == 'i') && (lex.token.get(3) == 'a')) {
            opc = 'l';
        } else if ((lex.token.size() == 8) && (lex.token.get(0) == 'i') && (lex.token.get(1) == 'm') && (lex.token.get(2) == 'p') && (lex.token.get(3) == 'r') && (lex.token.get(4) == 'i') && (lex.token.get(5) == 'm') && (lex.token.get(6) == 'a')) {
            opc = 'p';
        } else {
            //senão vai para a expressão x
            opc = 'x';
            //lex.setIndiceAtual(lex.getIndiceAtual() - (lex.token.size() - 1));
            //esvaziaToken();
            //expressao_20();
        }

        switch (opc) {
            case 's':
                lex.token.remove(lex.token.size() - 1);
                System.out.print(lex.token);
                System.out.println("   Correto - Nome SE " + lex.getIndiceAtual());
                esvaziaToken();
                ///defTipo_3();
                break;
            case 'e':
                lex.token.remove(lex.token.size() - 1);
                System.out.print(lex.token);
                System.out.println("   Correto - Nome ENQUANTO " + lex.getIndiceAtual());
                esvaziaToken();
                expressao_20();
                break;
            case 'l':
                lex.token.remove(lex.token.size() - 1);
                System.out.print(lex.token);
                System.out.println("   Correto - Nome LEIA " + lex.getIndiceAtual());
                esvaziaToken();
                comandoLeia_17();
                break;
            case 'p':
                lex.token.remove(lex.token.size() - 1);
                System.out.print(lex.token);
                System.out.println("   Correto - Nome IMPRIMA " + lex.getIndiceAtual());
                esvaziaToken();
                //comandoComposto_11();
                break;
            default:
                lex.setIndiceAtual(lex.getIndiceAtual() - (lex.token.size() - 1));
                esvaziaToken();
                atribuicao_13();
        }
    }

    public static void atribuicao_13() {
        if (identificador_29()) {
            lex.token.remove(lex.token.size() - 1);
            System.out.print(lex.token);
            System.out.println("   Correto - Identificador " + lex.getIndiceAtual());
            esvaziaToken();

            lex.procuraAutomatoCerto();
            if (lex.token.size() == 3 && lex.token.get(0) == ':' && lex.token.get(1) == '=') {
                lex.token.remove(lex.token.size() - 1);
                System.out.print(lex.token);
                System.out.println("   Correto - Símbolo Especial " + lex.getIndiceAtual());
                esvaziaToken();
                expressao_20();
            } else {
                System.out.println("Erro: era esperado um ':='");
                System.exit(0);
            }
        }
    }

    public static void chamadaDeProcedimento_14() {
        if (identificador_29()) {
            lex.token.remove(lex.token.size() - 1);
            System.out.print(lex.token);
            System.out.println("   Correto - Identificador " + lex.getIndiceAtual());
            esvaziaToken();

            lex.procuraAutomatoCerto();
            if (lex.token.size() == 2 && lex.token.get(0) == '(') {
                //lex.token.remove(lex.token.size() - 1);
                //System.out.print(lex.token);
                //System.out.println("   Correto - Símbolo Especial " + lex.getIndiceAtual());
                listaDeExpressao_19();
                esvaziaToken();
                fator_24();
            } else {
                System.out.println("Fim da Chamada de Procedimento");
            }
        }
    }

    public static void comandoLeia_17() {
        char opc = '_';
        lex.procuraAutomatoCerto();

        if (lex.token.size() == 0) {
            System.out.println("Erro: Termo Incompleto");
            System.exit(0);
        }

        //obtendo o ou | + | -
        if ((lex.token.size() == 2) && (lex.token.get(0) == '(')) {
            lex.token.remove(lex.token.size() - 1);
            System.out.print(lex.token);
            System.out.println("   Correto - Simbolo Especial " + lex.getIndiceAtual());
            esvaziaToken();
            listaDeIdentificador_6();

            lex.procuraAutomatoCerto();
            if ((lex.token.size() == 2) && (lex.token.get(0) == ')')) {
                lex.token.remove(lex.token.size() - 1);
                System.out.print(lex.token);
                System.out.println("   Correto - Simbolo Especial " + lex.getIndiceAtual());
                esvaziaToken();
            } else {
                System.out.println("Erro: era esperado um ')'");
                System.exit(0);
            }
        } else {
            System.out.println("Erro: era esperado um '('");
            System.exit(0);
        }

    }

    public static void comandoImprima_18() {
        char opc = '_';
        lex.procuraAutomatoCerto();

        if (lex.token.size() == 0) {
            System.out.println("Erro: Termo Incompleto");
            System.exit(0);
        }

        //obtendo o ou | + | -
        if ((lex.token.size() == 8) && (lex.token.get(0) == 'i') && (lex.token.get(1) == 'm') && (lex.token.get(2) == 'p') && (lex.token.get(3) == 'r') && (lex.token.get(4) == 'i') && (lex.token.get(5) == 'm') && (lex.token.get(6) == 'a')) {
            opc = 'i';
        }

        if (opc == 'i') {
            lex.token.remove(lex.token.size() - 1);
            System.out.print(lex.token);
            System.out.println("   Correto - Nome IMPRIMA " + lex.getIndiceAtual());
            esvaziaToken();

            lex.procuraAutomatoCerto();
            if (lex.token.size() == 2 && lex.token.get(0) == '(') {
                //lex.token.remove(lex.token.size() - 1);
                //System.out.print(lex.token);
                //System.out.println("   Correto - Símbolo Especial " + lex.getIndiceAtual());
                listaDeExpressao_19();
                esvaziaToken();
            } else {
                System.out.println("Erro: era esperado um '('");
                System.exit(0);
            }
            fator_24();
        }
    }

    public static void listaDeExpressao_19() {
        expressao_20();

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
                expressao_20();

                lex.procuraAutomatoCerto();
                lex.token.remove(lex.token.size() - 1);
                if (lex.token.size() == 1 && lex.token.get(0) == ';') {
                    opc = lex.token.get(0);
                } else {
                    lex.token.remove(lex.token.size() - 1);
                    lex.setIndiceAtual(lex.getIndiceAtual() - lex.token.size());
                    esvaziaToken();
                }
                System.out.println("------------------------------" + lex.token);
                opc = lex.token.get(0);
            }
        }

    }

    public static void expressao_20() {
        expressaoSimples_22();

        char opc = '_';
        lex.procuraAutomatoCerto();
        if (lex.token.size() == 0) {
            System.out.println("Fim da Expressão 1");
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
            } else if ((lex.token.size() == 2) && (lex.token.get(0) == ';')) {
                opc = ';';
            }
        }
        if ((opc == '=') || (opc == 'm') || (opc == '<') || (opc == 'p') || (opc == '>') || (opc == 'g')) {
            lex.token.remove(lex.token.size() - 1);
            lex.setIndiceAtual(lex.getIndiceAtual() - lex.token.size());
            esvaziaToken();
            //System.out.println(lex.getIndiceAtual());
            relacao_21();
            expressaoSimples_22();
        } else if (opc == ';') {
            lex.token.remove(lex.token.size() - 1);
            System.out.print(lex.token);
            System.out.println("   Correto - Identificador" + lex.getIndiceAtual());
            esvaziaToken();
            expressao_20();
        } else {
            System.out.println("Fim da Expressão 2");
            //System.exit(0);
        }
    }

    public static void relacao_21() {
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

    public static void expressaoSimples_22() {
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
        termo_23();

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
        termo_23();

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
                System.out.println("Erro, Termo Incompleto");
                System.exit(0);
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

    public static void termo_23() {
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
        }//(expressao_20)
        else if ((lex.token.get(lex.token.size() - 1) == 's') && (lex.token.get(0) == '(') && lex.token.size() == 2) {
            lex.token.remove(lex.token.size() - 1);
            System.out.print(lex.token);
            System.out.println("   Correto - Identificador " + lex.getIndiceAtual());
            esvaziaToken();
            controleParenteses = controleParenteses + 1;
            expressao_20();

        } else if ((lex.token.get(lex.token.size() - 1) == 's') && (lex.token.get(0) == ')') && lex.token.size() == 2) {
            lex.token.remove(lex.token.size() - 1);
            System.out.print(lex.token);
            System.out.println("   Correto - Identificador " + lex.getIndiceAtual());
            esvaziaToken();
        } else {
            System.out.println("Erro, Era esperado um Fator " + lex.token.size());
            System.exit(0);
        }
    }

    public static boolean identificador_29() {
        lex.procuraAutomatoCerto();
        if ((lex.token.get(lex.token.size() - 1) == 'i') || (lex.token.get(lex.token.size() - 1) == 'p')) {
            return true;
        } else {
            System.out.println("Era esperado um IDENTIFICADOR");
            return false;
        }
    }

    public static void esvaziaToken() {
        while (!lex.token.isEmpty()) {
            lex.token.remove(0);
        }
    }
}
