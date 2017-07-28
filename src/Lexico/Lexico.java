package Lexico;

import java.io.*;
import java.util.ArrayList;

public class Lexico {

    public int estado, tamFonte;
    public int indiceAtual;
    public char elementoAtual, letraOUdigito;
    public ArrayList<Character> token = new ArrayList<Character>();
    public String[] pReservada = {"programa", "se", "entao", "senao", "enquanto", "faca", "ate", "repita", "inteiro", "real", "caractere", "caso", "escolha", "fim", "procedimento", "funcao", "de", "para", "inicio"};
    public ArrayList<Character> fonte = new ArrayList<Character>();

    public void abreArquivoFonte() {
        estado = 0;
        tamFonte = 0;
        setIndiceAtual(0);
        String todoCodigoFonte = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader("fonte.txt"));
            while (br.ready()) {
                String linha = br.readLine();
                todoCodigoFonte = todoCodigoFonte + linha + '"';
            }
            br.close();
        } catch (IOException ioe) {
            System.out.println("Erro ao abri o Aquivo: " + ioe.getMessage());;
        }

        for (int i = 0; i < todoCodigoFonte.length(); i++) {
            fonte.add(i, todoCodigoFonte.charAt(i));
        }
        tamFonte = fonte.size();
    }

    public ArrayList<Character> identificador(int aux1) {
        for (int i = aux1; i < tamFonte; i++) {
            if (Character.isLetter(fonte.get(i))) {
                letraOUdigito = 'l';
            } else if (Character.isDigit(fonte.get(i))) {
                letraOUdigito = 'd';
            } else if (fonte.get(i) == '_') {
                letraOUdigito = '_';
            } else {
                letraOUdigito = '|';
            }
            elementoAtual = fonte.get(i);
            if (estado == 1) {
                switch (letraOUdigito) {
                    case '_':
                        token.add(elementoAtual);
                        estado = 2;
                        setIndiceAtual(i + 1);
                        break;
                    case 'd':
                        token.add(elementoAtual);
                        estado = 3;
                        setIndiceAtual(i + 1);
                        break;
                    case 'l':
                        token.add(elementoAtual);
                        estado = 3;
                        setIndiceAtual(i + 1);
                        break;
                    default:
                        setIndiceAtual(i);
                        i = tamFonte;
                        break;
                }
            } else if (estado == 2) {
                switch (letraOUdigito) {
                    case 'd':
                        token.add(elementoAtual);
                        estado = 3;
                        setIndiceAtual(i + 1);
                        break;
                    case 'l':
                        token.add(elementoAtual);
                        estado = 3;
                        setIndiceAtual(i + 1);
                        break;
                    default:
                        setIndiceAtual(i);
                        i = tamFonte;
                        break;
                }
            } else if (estado == 3) {
                switch (letraOUdigito) {
                    case 'd':
                        token.add(elementoAtual);
                        estado = 3;
                        setIndiceAtual(i + 1);
                        break;
                    case 'l':
                        token.add(elementoAtual);
                        estado = 3;
                        setIndiceAtual(i + 1);
                        break;
                    default:
                        setIndiceAtual(i);
                        i = tamFonte;
                        break;
                }
            }
        }
        if (estado == 1 || estado == 3) {
            //Verifica se É palavra Reservado ou Não
            int verificaSeEPalavraReservada = 0;
            for (int i = 0; i < pReservada.length; i++) {
                //Se o tamanho do meu toke identificador for igual ao tamanho da minha palavra reservada, então vou comparar se os caracteres são iguais.
                if (token.size() == pReservada[i].length()) {
                    for (int j = 0; j < pReservada[i].length(); j++) {
                        if (token.get(j) == pReservada[i].charAt(j)) {
                            verificaSeEPalavraReservada++;
                        } else {
                            break;
                        }
                    }
                }
            }
            if (verificaSeEPalavraReservada == token.size()) {
                token.add('p');
            } else {
                token.add('i');
            }
        } else {
            System.out.println("\nERRO! Não foi possível chegar a um estado final do Autômato ");
            System.exit(0);
        }
        return token;
    }

    public ArrayList<Character> simboloEspecial(int aux1) {
        for (int i = aux1; i < tamFonte; i++) {
            if (Character.isDigit(fonte.get(i))) {
                letraOUdigito = 'd';
            } else if (fonte.get(i) == ',') {
                letraOUdigito = ',';
            } else if (fonte.get(i) == '/') {
                letraOUdigito = '/';
            } else if (fonte.get(i) == '@') {
                letraOUdigito = '@';
            } else if (fonte.get(i) == '"') {
                letraOUdigito = '"';
            } else {
                letraOUdigito = '|';
            }

            elementoAtual = fonte.get(i);

            if (estado == 0) {
                if (elementoAtual == ';' || elementoAtual == ',' || elementoAtual == '.' || elementoAtual == '+' || elementoAtual == '*' || elementoAtual == '{' || elementoAtual == '}' || elementoAtual == '(' || elementoAtual == ')' || elementoAtual == '=') {
                    token.add(elementoAtual);
                    estado = 1;
                    setIndiceAtual(i + 1);
                    break;
                }
                switch (elementoAtual) {
                    case '-':
                        token.add(elementoAtual);
                        estado = 9;
                        setIndiceAtual(i + 1);
                        break;
                    case '@':
                        token.add(elementoAtual);
                        estado = 13;
                        setIndiceAtual(i + 1);
                        break;
                    case '/':
                        token.add(elementoAtual);
                        estado = 5;
                        setIndiceAtual(i + 1);
                        break;
                    case '<':
                        token.add(elementoAtual);
                        estado = 3;
                        setIndiceAtual(i + 1);
                        break;
                    case '>':
                        token.add(elementoAtual);
                        estado = 3;
                        setIndiceAtual(i + 1);
                        break;
                    case ':':
                        token.add(elementoAtual);
                        estado = 3;
                        setIndiceAtual(i + 1);
                        break;
                    default:
                        i = tamFonte;
                }
            } else if (estado == 3) {
                switch (elementoAtual) {
                    case '>':
                        token.add(elementoAtual);
                        estado = 4;
                        setIndiceAtual(i + 1);
                        break;
                    case '=':
                        token.add(elementoAtual);
                        estado = 4;
                        setIndiceAtual(i + 1);
                        break;
                    default:
                        setIndiceAtual(i);
                        i = tamFonte;
                        break;
                }
            } else if (estado == 5) {
                switch (letraOUdigito) {
                    case '/':
                        token.remove(0);
                        estado = 6;
                        setIndiceAtual(i + 1);
                        break;
                    default:
                        setIndiceAtual(i);
                        i = tamFonte;
                        break;
                }
            } else if (estado == 6) {
                switch (letraOUdigito) {
                    case '/':
                        estado = 7;
                        setIndiceAtual(i + 1);
                        break;
                    default:
                        setIndiceAtual(i + 1);
                        estado = 6;
                        break;
                }
            } else if (estado == 7) {
                switch (letraOUdigito) {
                    case '/':
                        estado = 8;
                        setIndiceAtual(i + 1);
                        i = tamFonte;
                        break;
                    default:
                        estado = 6;
                        setIndiceAtual(i + 1);
                        break;
                }
            } else if (estado == 9) {
                switch (letraOUdigito) {
                    case 'd':
                        token.add(elementoAtual);
                        estado = 10;
                        setIndiceAtual(i + 1);
                        break;
                    default:
                        setIndiceAtual(i);
                        i = tamFonte;
                        break;
                }
            } else if (estado == 10) {
                switch (letraOUdigito) {
                    case 'd':
                        token.add(elementoAtual);
                        estado = 10;
                        setIndiceAtual(i + 1);
                        break;
                    case ',':
                        token.add(elementoAtual);
                        estado = 11;
                        setIndiceAtual(i + 1);
                        break;
                    default:
                        setIndiceAtual(i);
                        i = tamFonte;
                        break;
                }
            } else if (estado == 11) {
                switch (letraOUdigito) {
                    case 'd':
                        token.add(elementoAtual);
                        estado = 12;
                        setIndiceAtual(i + 1);
                        break;
                    default:
                        setIndiceAtual(i);
                        i = tamFonte;
                        break;
                }
            } else if (estado == 12) {
                switch (letraOUdigito) {
                    case 'd':
                        token.add(elementoAtual);
                        estado = 12;
                        setIndiceAtual(i + 1);
                        break;
                    default:
                        setIndiceAtual(i);
                        i = tamFonte;
                        break;
                }
            } else if (estado == 13) {
                switch (letraOUdigito) {
                    case '@':
                        token.remove(0);
                        estado = 14;
                        setIndiceAtual(i + 1);
                        break;
                    default:
                        setIndiceAtual(i);
                        i = tamFonte;
                        break;
                }
            } else if (estado == 14) {
                switch (letraOUdigito) {
                    case '"':
                        estado = 15;
                        setIndiceAtual(i + 1);
                        i = tamFonte;
                        break;
                    default:
                        setIndiceAtual(i + 1);
                        estado = 14;
                        break;
                }
            }
        }
        //Simbolo Especial
        if (estado == 1 || estado == 3 || estado == 4 || estado == 5 || estado == 9 || estado == 13) {
            token.add('s');
        } //Comentário de Várias Linhas
        else if (estado == 8) {

        } //Comentário de Uma linha
        else if (estado == 15) {

        } //Digito
        else if (estado == 10 || estado == 12) {
            token.add('d');
        } //
        else if (estado == 11) {
            System.out.println("\nERRO! Não foi possível chegar a um estado final do Autômato ");
            System.exit(0);
        } else {
            System.out.println("\n ERRO! O Analisador não esperava " + fonte.get(aux1));
            System.exit(0);
        }
        return token;
    }

    public ArrayList<Character> digitos(int aux1) {
        for (int i = aux1; i < tamFonte; i++) {
            if (Character.isDigit(fonte.get(i))) {
                letraOUdigito = 'd';
            } else if (fonte.get(i) == '-') {
                letraOUdigito = '-';
            } else if (fonte.get(i) == ',') {
                letraOUdigito = ',';
            } else {
                letraOUdigito = '|';
            }

            elementoAtual = fonte.get(i);
            if (estado == 1) {
                switch (letraOUdigito) {
                    case 'd':
                        token.add(elementoAtual);
                        estado = 1;
                        setIndiceAtual(i + 1);
                        break;
                    case ',':
                        token.add(elementoAtual);
                        estado = 2;
                        setIndiceAtual(i + 1);
                        break;
                    default:
                        setIndiceAtual(i);
                        i = tamFonte;
                        break;
                }
            } else if (estado == 2) {
                switch (letraOUdigito) {
                    case 'd':
                        token.add(elementoAtual);
                        estado = 3;
                        setIndiceAtual(i + 1);
                        break;
                    default:
                        setIndiceAtual(i);
                        i = tamFonte;
                        break;
                }
            } else if (estado == 3) {
                switch (letraOUdigito) {
                    case 'd':
                        token.add(elementoAtual);
                        estado = 3;
                        setIndiceAtual(i + 1);
                        break;
                    default:
                        setIndiceAtual(i);
                        i = tamFonte;
                        break;
                }
            }
        }
        if (estado == 1 || estado == 3) {
            token.add('d');
        } else {
            System.out.println("\nERRO! Não foi possível chegar a um estado final do Autômato ");
            System.exit(0);
        }
        return token;
    }

    public void procuraAutomatoCerto() {
        while (getIndiceAtual() < tamFonte) {
            if (Character.isLetter(fonte.get(getIndiceAtual()))) {
                elementoAtual = fonte.get(getIndiceAtual());
                estado = 1;
                token.add(elementoAtual);
                setIndiceAtual(getIndiceAtual() + 1);
                token = identificador(getIndiceAtual());
                estado = 0;
                break;

            } else if (Character.isDigit(fonte.get(getIndiceAtual()))) {
                elementoAtual = fonte.get(getIndiceAtual());
                estado = 1;
                token.add(elementoAtual);
                setIndiceAtual(getIndiceAtual() + 1);
                token = digitos(getIndiceAtual());
                estado = 0;
                break;

            } else if (!Character.isLetter(fonte.get(indiceAtual)) && !Character.isDigit(fonte.get(indiceAtual)) && (fonte.get(getIndiceAtual()) != ' ') && fonte.get(getIndiceAtual()) != '"') {
                token = simboloEspecial(getIndiceAtual());
                estado = 0;
                break;
            } else if (fonte.get(getIndiceAtual()) == ' ' || fonte.get(getIndiceAtual()) == '"') {
                setIndiceAtual(getIndiceAtual() + 1);
            }
        }
    }

    /**
     * @return the indiceAtual
     */
    public int getIndiceAtual() {
        return indiceAtual;
    }

    /**
     * @param indiceAtual the indiceAtual to set
     */
    public void setIndiceAtual(int indiceAtual) {
        this.indiceAtual = indiceAtual;
    }

}
