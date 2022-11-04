// Vinicius Lima, Marcus Viniccius

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Jogo {

    public static void main(String[] args) {

        Jogo[] jogos = new Jogo[900];

        try {
            File file = new File("partidas.txt");
            Scanner sc = new Scanner(file, "UTF-8");

            for (int i = 0; i < jogos.length; i++) {
                String linhaArq = sc.nextLine();
                jogos[i] = new Jogo(linhaArq);
            }
            sc.close();

        } catch (IOException e) {
            System.out.println("Erro ao abrir o arquivo");
        }
        
        MyIO.setCharset("UTF-8");
        
        Pilha pilha = new Pilha(570);
        String line = MyIO.readLine();
        while (!line.equals("FIM")) {
        	pilha.empilhar(Jogo.busca(line, jogos));
        	line = MyIO.readLine();
        }

        int qtd = MyIO.readInt();
        for (int j = 0; j < qtd; j++) {
            String op = MyIO.readLine();
            if (op.equals("D")) {
            	System.out.print("(D) ");
            	pilha.desempilhar().imprimir();
            }
            else {
            	String[] splittedOp = op.split(" ");
            	pilha.empilhar(Jogo.busca(splittedOp[1], jogos));
            }
        }

        pilha.mostrar();
    }

    private int dia, mes, ano, placarSelecao1, placarSelecao2;
    private String etapa, selecao1, selecao2, local;

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getPlacarSelecao1() {
        return placarSelecao1;
    }

    public void setPlacarSelecao1(int placarSelecao1) {
        this.placarSelecao1 = placarSelecao1;
    }

    public int getPlacarSelecao2() {
        return placarSelecao2;
    }

    public void setPlacarSelecao2(int placarSelecao2) {
        this.placarSelecao2 = placarSelecao2;
    }

    public String getEtapa() {
        return etapa;
    }

    public void setEtapa(String etapa) {
        this.etapa = etapa;
    }

    public String getSelecao1() {
        return selecao1;
    }

    public void setSelecao1(String selecao1) {
        this.selecao1 = selecao1;
    }

    public String getSelecao2() {
        return selecao2;
    }

    public void setSelecao2(String selecao2) {
        this.selecao2 = selecao2;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Jogo(String entrada) {
        String[] entradaSpliter = entrada.split("#");

        setAno(Integer.parseInt(entradaSpliter[0]));
        setEtapa(entradaSpliter[1]);
        setDia(Integer.parseInt(entradaSpliter[2]));
        setMes(Integer.parseInt(entradaSpliter[3]));
        setSelecao1(entradaSpliter[4]);
        setPlacarSelecao1(Integer.parseInt(entradaSpliter[5]));
        setPlacarSelecao2(Integer.parseInt(entradaSpliter[6]));
        setSelecao2(entradaSpliter[7]);
        setLocal(entradaSpliter[8]);

    }

    public Jogo(int dia, int mes, int ano, String selecao1) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
        this.selecao1 = selecao1;
        selecao2 = "";
        placarSelecao1 = 0;
        placarSelecao2 = 0;
        local = "";
        etapa = "";
    }

    public Jogo(Jogo jogo) {
        dia = jogo.getDia();
        mes = jogo.getMes();
        ano = jogo.getAno();
        etapa = jogo.getEtapa();
        selecao1 = jogo.getSelecao1();
        selecao2 = jogo.getSelecao2();
        placarSelecao1 = jogo.getPlacarSelecao1();
        placarSelecao2 = jogo.getPlacarSelecao2();
        local = jogo.getLocal();
    }

    public boolean equals(Jogo target) {
        return target.getDia() == dia && target.getMes() == mes && target.getAno() == ano && target.getSelecao1().equals(selecao1);
    }

    public void imprimir() {
        System.out.println("[COPA " + ano + "] [" + etapa + "] [" + dia + "/" + mes + "] [" + selecao1 + " (" + placarSelecao1 + ") x (" + placarSelecao2 + ") " + selecao2 + "] [" + local + "]");
    }

    public boolean isGreaterThan(Jogo jogo) {
        if (ano > jogo.getAno()) return true;
        if (ano < jogo.getAno()) return false;
        if (mes > jogo.getMes()) return true;
        if (mes < jogo.getMes()) return false;
        if (dia > jogo.getDia()) return true;
        if (dia < jogo.getDia()) return false;
        return selecao1.compareTo(jogo.getSelecao1()) > 0;
    }

    @Override
    public Jogo clone() {
        return new Jogo(this);
    }

    public static Jogo busca(String targetStr, Jogo[] jogos) {
        String[] targetInfo = targetStr.split(";");
        String[] targetDate = targetInfo[0].split("/");
        Jogo target = new Jogo(
                Integer.parseInt(targetDate[0]),
                Integer.parseInt(targetDate[1]),
                Integer.parseInt(targetDate[2]),
                targetInfo[1]
        );

        for (Jogo jogo : jogos) {
            if (jogo.equals(target)) return jogo;
        }

        return null;
    }
    
    
}

class Pilha{
	
	private int topo, fundo;
	private int tamanho;
	private Jogo vetor[];
	
	Pilha(int tamanho){
		this.tamanho = tamanho;
		vetor= new Jogo[tamanho];	
		this.fundo = 0;
		this.topo  = 0;		
	
	}
	Pilha(){
		this.tamanho = 10;
		vetor = new Jogo[tamanho];
		this.fundo = 0;
		this.topo  = 0;	
	
	}
	
	public boolean pilhaVazia() {
		if(topo == fundo)
			return true;
		else
			return false;
	}
	public boolean pilhaCheia() {
		if(topo == tamanho)
			return true;
		else
			return false;
				
	}
	
	public Jogo desempilhar() {
		
		Jogo desempilhado;
		
		if(!pilhaVazia()) {
			topo--;
			desempilhado = vetor[topo];
			return desempilhado;
		}
		
		return null;
	}
	
	public void empilhar(Jogo jogo) {
		if(!pilhaCheia()) {
			
			vetor[topo] = jogo;
			topo++;
		}
	}
	
	public void mostrar() {
		for (int i = fundo; i < topo; i++) {
            System.out.print("[" + i + "] ");
			vetor[i].imprimir();
        }
	}
}

