
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Questao9 {

	static int INFINITO = 99999;
	static int distancias[];
	
	/**
	 * M�todo que utiliza a busca em largura para calcular a distancia de um 
	 * vertice v para todos os outros vertices no grafo e armazena as distancias
	 * encontradas no vetor 'distancias', ou seja, a distancia do vertice vi
	 * para o vertice vj � igual a distancias[j].
	 * @param g
	 * @param v
	 */
	public static void calculaDistanciaUsandoBuscaEmLargura(Grafo g, Vertice v) {
		distancias = new int[g.getNumeroVertices()];
		for (int i = 0; i < g.getNumeroVertices(); i++)
			distancias[i] = INFINITO;
		Stack<Vertice> pilha = new Stack<Vertice>();
		distancias[v.getChave()] = 0;
		pilha.push(v);
		while(!pilha.isEmpty()) {
			Vertice x = pilha.pop();
			for (int k = 0; k < g.getNumeroVertices(); k++) {
				if (g.existeAresta(x.getChave(), k) && distancias[k] == INFINITO) {
					distancias[k] = distancias[x.getChave()] + 1;
					pilha.push(g.getVertices().get(k));
				}
			}
		}
	}
	
	/**
	 * M�todo usado para calcular a distancia entre dois vertices no grafo.
	 * @param g
	 * @param i
	 * @param j
	 */
	public static void distanciaEntreDoisVertcies(Grafo g, int i, int j) {
		calculaDistanciaUsandoBuscaEmLargura(g, g.getVertices().get(i));
		if (distancias[j] == INFINITO)
			System.out.println("\n N�o existe um caminho entre o vertice (" + i + ") e o vertice (" + j + ")");
		else
			System.out.println("\n A dist�ncia entre o vertice (" + i + ") e o vertice (" + j + ") �: " + distancias[j]);
	}
	
	/**
	 * Classe que implementa o Grafo 'G'
	 *
	 */
	public static class Grafo {
		
		List<Vertice> vertices;
		int numeroVertices;
		
		public Grafo(int numeroVertices) {
			this.numeroVertices = numeroVertices;
			this.vertices = new ArrayList<Vertice>(0);
			for (int i = 0; i < numeroVertices; i++)
				this.vertices.add(new Vertice(i));
		}
		
		public void insereAresta(int i, int j) {
			Vertice v1 = this.vertices.get(i);
			Vertice v2 = this.vertices.get(j);
			v1.listaAdj.add(v2);
		}
		
		public boolean existeAresta(int i, int j) {
			return this.vertices.get(i).existeAresta(j);
		}
		
		public int getNumeroVertices() {
			return this.numeroVertices;
		}
		
		public List<Vertice> getVertices() {
			return this.vertices;
		}
	}
	
	/**
	 * Classe que implementa um v�rtice do grafo.
	 *
	 */
	public static class Vertice {
		
		int marca;
		int chave;
		List<Vertice> listaAdj;
		
		public Vertice(int chave) {
			this.chave = chave;
			this.listaAdj = new ArrayList<Vertice>();
		}
		
		public boolean existeAresta(int j) {
			for (Vertice v : listaAdj)
				if (v.chave == j)
					return true;
			return false;
		}
		
		@Override
		public String toString() {
			return chave+"";
		}
		
		public int getChave() {
			return this.chave;
		}
		
		public List<Vertice> getListaAdj() {
			return this.listaAdj;
		}
	}
	
	public static void main(String[] args) {
		Grafo digrafo = new Grafo(10);
		
		//Criando o Grafo 'G'
		digrafo.insereAresta(0, 2);
		digrafo.insereAresta(0, 3);
		digrafo.insereAresta(1, 4);
		digrafo.insereAresta(1, 8);
		digrafo.insereAresta(2, 5);
		digrafo.insereAresta(3, 7);
		digrafo.insereAresta(3, 8);
		digrafo.insereAresta(4, 8);
		digrafo.insereAresta(5, 6);
		digrafo.insereAresta(6, 2);
		digrafo.insereAresta(7, 9);
		digrafo.insereAresta(8, 0);
		digrafo.insereAresta(9, 7);
		
		Scanner scan = new Scanner(System.in);
		System.out.print(" Qual o primeiro v�rtice ? ");
		int v1 = scan.nextInt();
		
		while(v1 < 0 || v1 > 9){
			System.out.println(" V�rtice inv�lido!");
			System.out.print(" Qual o primeiro v�rtice ? ");
			v1 = scan.nextInt();
		}
		
		System.out.print("\n Qual o segundo v�rtice ? ");
		int v2 = scan.nextInt();
		
		while(v2 < 0 || v2 > 9){
			System.out.println(" V�rtice inv�lido!");
			System.out.print(" Qual o segundo v�rtice ? ");
			v2 = scan.nextInt();
		}
		
		distanciaEntreDoisVertcies(digrafo, v1, v2);
	}
	
}
