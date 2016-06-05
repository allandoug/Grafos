
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Questao2 {
	
	/**
	 * Classe que implementa o Grafo 'G' usando matriz de adjacencias.
	 *
	 */
	public static class GrafoMatriz{
		int matriz[][] = {{0,1,0,1,1,0,0,0},
						{1,0,1,0,0,1,0,0},
						{0,1,0,1,0,0,0,1},
						{1,0,1,0,0,0,1,0},
						{1,0,0,0,0,1,1,0},
						{0,1,0,0,1,0,0,1},
						{0,0,0,1,1,0,0,1},
						{0,0,1,0,0,1,1,0}};
		
		public boolean existeAresta(int i, int j) throws InterruptedException {
			if (matriz[i][j] == 1)
				return true;
			else
				return false;
		}
		
		public List<Integer> obterVerticesAdjacentes(int i) throws InterruptedException {
			List<Integer> saida = new ArrayList<>(0);
			for (int k = 0; k < 8; k++){
				Thread.sleep(10);
				if (matriz[i][k] == 1)
					saida.add(k);
			}
			return saida;
		}
	}
	
	/**
	 * Classe que implementa o Grafo 'G' usando lista de adjacencias.
	 *
	 */
	public static class GrafoLista{
		@SuppressWarnings("unchecked")
		List<Integer> vertices[] = new List[8];
		
		public GrafoLista() {
			for (int i = 0; i < 8; i++)
				vertices[i] = new ArrayList<>(0);
			criarGrafo();
		}
		
		public String existeAresta(int i, int j) throws InterruptedException {
			for (Integer k : vertices[i]) {
				if (k == j)
					return "verdadeiro";
			}
			return "falso";
		}
		
		public List<Integer> obterVerticesAdjacentes(int i) throws InterruptedException {
			Thread.sleep(10);
			return vertices[i];
		}
		
		public void addArestas(int i, int... j) {
			for (Integer k : j) {
				vertices[i].add(k);
			}
		}
		
		public void criarGrafo() {
			addArestas(0, 1, 3, 4);
			addArestas(1, 0, 2, 5);
			addArestas(2, 1, 3, 7);
			addArestas(3, 0, 2, 6);
			addArestas(4, 0, 5, 6);
			addArestas(5, 1, 4, 7);
			addArestas(6, 3, 4, 7);
			addArestas(7, 2, 5, 6);
		}
	}

	public static void main(String[] args) throws InterruptedException {
		
		Scanner scan = new Scanner(System.in);
		System.out.print(" Digite o n�mero do v�rtice ao qual deseja encontrar os v�rtices\n adjacentes: ");
		int v = scan.nextInt();
		while(v < 0 || v > 7){
			System.out.println(" V�rtice inv�lido! ");
			System.out.print(" Digite o n�mero do v�rtice: ");
			v = scan.nextInt();
		}
		
		System.out.println(" Criando o grafo 'G' usando matriz de adjacencias.");
		System.out.println("------------------------------------------------------------------");
		GrafoMatriz grafoMatriz = new GrafoMatriz();
			System.out.println(" Obtendo a lista de vertices adjacentes ao vertice: " + v);
			System.out.println(" Resultado: " + grafoMatriz.obterVerticesAdjacentes(v));
		
		
		System.out.println("\n\n Criando o grafo 'G' usando lista de adjacencias.");
		System.out.println("------------------------------------------------------------------");
		GrafoLista grafoLista = new GrafoLista();
			System.out.println(" Obtendo a lista de vertices adjacentes ao vertice: " + v);
			System.out.println(" Resultado: " + grafoLista.obterVerticesAdjacentes(v));
	}
}
