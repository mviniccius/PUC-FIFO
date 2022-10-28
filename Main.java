import java.io.*;
import java.nio.charset.*;

class MyIO {

    private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in, Charset.forName("ISO-8859-1")));
    private static String charset = "ISO-8859-1";

    public static void setCharset(String charset_){
        charset = charset_;
        in = new BufferedReader(new InputStreamReader(System.in, Charset.forName(charset)));
    }

    public static void print(){
    }

    public static void print(int x){
        try {
            PrintStream out = new PrintStream(System.out, true, charset);
            out.print(x);
        }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
    }

    public static void print(double x){
        try {
            PrintStream out = new PrintStream(System.out, true, charset);
            out.print(x);
        }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
    }

    public static void print(String x){
        try {
            PrintStream out = new PrintStream(System.out, true, charset);
            out.print(x);
        }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
    }

    public static void print(boolean x){
        try {
            PrintStream out = new PrintStream(System.out, true, charset);
            out.print(x);
        }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
    }

    public static void print(char x){
        try {
            PrintStream out = new PrintStream(System.out, true, charset);
            out.print(x);
        }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
    }

    public static void println(){
    }

    public static void println(int x){
        try {
            PrintStream out = new PrintStream(System.out, true, charset);
            out.println(x);
        }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
    }

    public static void println(double x){
        try {
            PrintStream out = new PrintStream(System.out, true, charset);
            out.println(x);
        }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
    }

    public static void println(String x){
        try {
            PrintStream out = new PrintStream(System.out, true, charset);
            out.println(x);
        }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
    }

    public static void println(boolean x){
        try {
            PrintStream out = new PrintStream(System.out, true, charset);
            out.println(x);
        }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
    }

    public static void println(char x){
        try {
            PrintStream out = new PrintStream(System.out, true, charset);
            out.println(x);
        }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
    }

    public static void printf(String formato, double x){
        try {
            PrintStream out = new PrintStream(System.out, true, charset);
            out.printf(formato, x);// "%.2f"
        }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
    }

    public static double readDouble(){
        double d = -1;
        try{
            d = Double.parseDouble(readString().trim().replace(",","."));
        }catch(Exception e){}
        return d;
    }

    public static double readDouble(String str){
        try {
            PrintStream out = new PrintStream(System.out, true, charset);
            out.print(str);
        }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
        return readDouble();
    }

    public static float readFloat(){
        return (float) readDouble();
    }

    public static float readFloat(String str){
        return (float) readDouble(str);
    }

    public static int readInt(){
        int i = -1;
        try{
            i = Integer.parseInt(readString().trim());
        }catch(Exception e){}
        return i;
    }

    public static int readInt(String str){
        try {
            PrintStream out = new PrintStream(System.out, true, charset);
            out.print(str);
        }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
        return readInt();
    }

    public static String readString(){
        String s = "";
        char tmp;
        try{
            do{
                tmp = (char)in.read();
                if(tmp != '\n' && tmp != ' ' && tmp != 13){
                    s += tmp;
                }
            }while(tmp != '\n' && tmp != ' ');
        }catch(IOException ioe){
            System.out.println("lerPalavra: " + ioe.getMessage());
        }
        return s;
    }

    public static String readString(String str){
        try {
            PrintStream out = new PrintStream(System.out, true, charset);
            out.print(str);
        }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
        return readString();
    }

    public static String readLine(){
        String s = "";
        char tmp;
        try{
            do{
                tmp = (char)in.read();
                if(tmp != '\n' && tmp != 13){
                    s += tmp;
                }
            }while(tmp != '\n');
        }catch(IOException ioe){
            System.out.println("lerPalavra: " + ioe.getMessage());
        }
        return s;
    }

    public static String readLine(String str){
        try {
            PrintStream out = new PrintStream(System.out, true, charset);
            out.print(str);
        }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
        return readLine();
    }

    public static char readChar(){
        char resp = ' ';
        try{
            resp  = (char)in.read();
        }catch(Exception e){}
        return resp;
    }

    public static char readChar(String str){
        try {
            PrintStream out = new PrintStream(System.out, true, charset);
            out.print(str);
        }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
        return readChar();
    }

    public static boolean readBoolean(){
        boolean resp = false;
        String str = "";

        try{
            str = readString();
        }catch(Exception e){}

        if(str.equals("true") || str.equals("TRUE") || str.equals("t") || str.equals("1") ||
                str.equals("verdadeiro") || str.equals("VERDADEIRO") || str.equals("V")){
            resp = true;
        }

        return resp;
    }

    public static boolean readBoolean(String str){
        try {
            PrintStream out = new PrintStream(System.out, true, charset);
            out.print(str);
        }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
        return readBoolean();
    }

    public static void pause(){
        try{
            in.read();
        }catch(Exception e){}
    }

    public static void pause(String str){
        try {
            PrintStream out = new PrintStream(System.out, true, charset);
            out.print(str);
        }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
        pause();
    }
}

class Jogo {
    private int dia, mes, ano, placarSelecao1, placarSelecao2;
    private String etapa, selecao1, selecao2, local;

    public Jogo(int ano, String etapa, int dia, int mes, String selecao1, int placarSelecao1, int placarSelecao2, String selecao2, String local) {
        this.setAno(ano);
        this.setEtapa(etapa);
        this.setDia(dia);
        this.setMes(mes);
        this.setSelecao1(selecao1);
        this.setSelecao2(selecao2);
        this.setPlacarSelecao1(placarSelecao1);
        this.setPlacarSelecao2(placarSelecao2);
        this.setLocal(local);
    }

    public Jogo(Jogo jogo){
        this.setDia(jogo.getDia());
        this.setMes(jogo.getMes());
        this.setAno(jogo.getAno());
        this.setEtapa(jogo.getEtapa());
        this.setSelecao1(jogo.getSelecao1());
        this.setSelecao2(jogo.getSelecao2());
        this.setPlacarSelecao1(jogo.getPlacarSelecao1());
        this.setPlacarSelecao2(jogo.getPlacarSelecao2());
        this.setLocal(jogo.getLocal());
    }

    public Jogo(){}

    public void setLocal(String local) {
        this.local = local;
    }

    public void setPlacarSelecao2(int placarSelecao2) {
        this.placarSelecao2 = placarSelecao2;
    }

    public void setPlacarSelecao1(int placarSelecao1) {
        this.placarSelecao1 = placarSelecao1;
    }

    public void setSelecao2(String selecao2) {
        this.selecao2 = selecao2;
    }

    public void setSelecao1(String selecao1) {
        this.selecao1 = selecao1;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public void setEtapa(String etapa) {
        this.etapa = etapa;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getLocal() {
        return this.local;
    }

    public int getPlacarSelecao2() {
        return this.placarSelecao2;
    }

    public int getPlacarSelecao1() {
        return this.placarSelecao1;
    }

    public String getSelecao2() {
        return this.selecao2;
    }

    public String getSelecao1() {
        return this.selecao1;
    }

    public int getMes() {
        return this.mes;
    }

    public int getDia() {
        return this.dia;
    }

    public String getEtapa() {
        return this.etapa;
    }

    public int getAno() {
        return this.ano;
    }

    public void imprimir(){
        System.out.println(String.format("(D) [COPA %d] [%s] [%d/%d] [%s (%d) x (%d) %s] [%s]",
                this.getAno(),
                this.getEtapa(),
                this.getDia(),
                this.getMes(),
                this.getSelecao1(),
                this.getPlacarSelecao1(),
                this.getPlacarSelecao2(),
                this.getSelecao2(),
                this.getLocal()));
    }

    public static Jogo ler(String entrada){
        String[] colunas = entrada.split("#");
        Jogo jogo = new Jogo();
        for(int i = 0; i < colunas.length; i++){
            jogo.setAno(Integer.valueOf(colunas[i]));
            jogo.setEtapa(String.valueOf(colunas[i]));
            jogo.setDia(Integer.valueOf(colunas[i]));
            jogo.setMes(Integer.valueOf(colunas[i]));
            jogo.setSelecao1(String.valueOf(colunas[i]));
            jogo.setPlacarSelecao1(Integer.valueOf(colunas[i]));
            jogo.setPlacarSelecao2(Integer.valueOf(colunas[i]));
            jogo.setSelecao2(String.valueOf(colunas[i]));
            jogo.setLocal(String.valueOf(colunas[i]));
        }
        return jogo;
    }

    public Jogo clone(){
        Jogo jogo = new Jogo(this);
        return jogo;
    }

    public double obterMediaGols(){
        return (placarSelecao1 + placarSelecao2)/2;
    }
}



class Fila{

    private Jogo[] fila;
    private int frente;
    private int tras;
    private int tamanho;

    public Fila(int tamanho){
        this.fila = new Jogo[tamanho + 1];
        this.frente = 0;
        this.tras = 0;
        this.tamanho = tamanho;
    }

    public void enfileirar(Jogo novo) {

        int posicao;

        if (!filaCheia()) {
            posicao = tras % tamanho;
            if(this.fila[posicao] == null) {
                this.fila[posicao] = new Jogo();
            }
            this.fila[posicao] = novo;
            tras++;
        }
    }

    public boolean filaVazia(){
        return frente == tras;
    }

    public boolean filaCheia(){
        return ((tras + 1) % tamanho) == (frente % tamanho);
    }

    public Jogo desenfileirar() {

        Jogo desenfileirado;
        int posicao;

        if (!filaVazia()) {
            posicao = frente % tamanho;
            desenfileirado = fila[posicao];
            frente++;
            desenfileirado.imprimir();
            return desenfileirado;
        }

        return null;
    }

    public void mostrar() {
        for (Jogo jogo: this.fila) {
            jogo.imprimir();
        }
    }
}

  class ArquivoTextoLeitura {

    private BufferedReader entrada;

    ArquivoTextoLeitura(String nomeArquivo) {

        try {
            entrada = new BufferedReader(new InputStreamReader(new FileInputStream(nomeArquivo), "UTF-8"));
        } catch (UnsupportedEncodingException excecao) {
            System.out.println(excecao.getMessage());
        } catch (FileNotFoundException excecao) {
            System.out.println("Arquivo nao encontrado");
        }
    }

    public void fecharArquivo() {

        try {
            entrada.close();
        }
        catch (IOException excecao) {
            System.out.println("Erro no fechamento do arquivo de leitura: " + excecao);
        }
    }

    @SuppressWarnings("finally")
    public String ler() {

        String textoEntrada = null;

        try {
            textoEntrada = entrada.readLine();
        }
        catch (EOFException excecao) { //Excecao de final de arquivo.
            textoEntrada = null;
        }
        catch (IOException excecao) {
            System.out.println("Erro de leitura: " + excecao);
            textoEntrada = null;
        }
        finally {
            return textoEntrada;
        }
    }
}

public class Main {

    public static Jogo searchForGame(Jogo[] jogos, int ano, int mes, int dia, String pais) {
    	for (Jogo jogo : jogos) {
            if (jogo.getAno() == ano) {
                if ((jogo.getSelecao1().equals(pais)
                        || jogo.getSelecao2().equals(pais))
                        && jogo.getDia() == dia
                        && jogo.getMes() == mes) {
                    return jogo;
                }
            }
        }
        return null;
    }


    public static void main(String[] args) throws Exception{

        String DATABASE_PATH = "partidas.txt";
        MyIO.setCharset("UTF-8");
        Jogo[] copa = new Jogo[1200];
        String str, listString[];
        int contador = 0;


        ArquivoTextoLeitura dbReader = new ArquivoTextoLeitura(DATABASE_PATH);
        String row = dbReader.ler();
        while (row != null) {
            listString = row.split("#");

            Jogo jogo = new Jogo(Integer.parseInt(listString[0]),
                    listString[1],
                    Integer.parseInt(listString[2]),
                    Integer.parseInt(listString[3]),
                    listString[4],
                    Integer.parseInt(listString[5]),
                    Integer.parseInt(listString[6]),
                    listString[7],
                    listString[8]);

            copa[contador++] = jogo;
            row = dbReader.ler();
        }
        dbReader.fecharArquivo();
        

        Fila fila = new Fila(100);
        str = MyIO.readLine();
        while (!str.equals("FIM")) {
            listString = str.split(";");
            int dia = Integer.parseInt(listString[0].split("/")[0]);
            int mes = Integer.parseInt(listString[0].split("/")[1]);
            int ano = Integer.parseInt(listString[0].split("/")[2]);
            String pais = listString[1];
            Jogo jogo = searchForGame(copa, ano, mes, dia, pais);
            fila.enfileirar(jogo);
            System.out.println((int)jogo.obterMediaGols());
            if(fila.filaCheia())
            	fila.desenfileirar();
            str = MyIO.readLine();
        }

        int commandQntt = MyIO.readInt();
        while(commandQntt > 0) {
            String command = MyIO.readString();
            if(command.equals("D")) {
                Jogo jogo = new Jogo(fila.desenfileirar());
                jogo.imprimir();
            }
            else {
                String [] spltdCommand = command.split(" ");
                if(spltdCommand.length != 2) {
                    throw new Exception("Command has not a empty space between command word and game string");
                }
                listString = spltdCommand[1].split(";");
                int dia = Integer.parseInt(listString[0].split("/")[0]);
                int mes = Integer.parseInt(listString[0].split("/")[1]);
                int ano = Integer.parseInt(listString[0].split("/")[2]);
                String pais = listString[1];

                Jogo jogo = searchForGame(copa, ano, mes, dia, pais);
                fila.enfileirar(jogo);
                System.out.println((int)jogo.obterMediaGols());
            }
            commandQntt--;
        }

    }
}
