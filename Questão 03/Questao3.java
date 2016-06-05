
import java.util.ArrayList;
import java.util.List;

public class Questao3 {
	
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
		
		public List<Integer> obterVerticesAdjacentes(int i) throws InterruptedException {
			List<Integer> saida = new ArrayList<>(0);
			for (int k = 0; k < 8; k++){
				Thread.sleep(1000);
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
		
		public List<Integer> obterVerticesAdjacentes(int i) throws InterruptedException {
			Thread.sleep(1000);
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
		
		long tempoInicio, tempoFim;
		double tempoTotal;
		
		System.out.println(" Criando o grafo 'G' usando matriz de adjacencias.");
		System.out.println("------------------------------------------------------------------");
		GrafoMatriz grafoMatriz = new GrafoMatriz();
		for (int i = 0; i < 8; i++) {
			System.out.println(" Obtendo a lista de vertices adjacentes ao vertice: " + i);
			tempoInicio = System.currentTimeMillis();
			List<?> x = grafoMatriz.obterVerticesAdjacentes(i);
			tempoFim = System.currentTimeMillis();
			tempoTotal = tempoFim - tempoInicio;
			System.out.println(" Resultado: " + x);
			System.out.println(" Tempo em segundos: " + tempoTotal/1000.0);
			System.out.println();
		}
		
		
		System.out.println("\n\n Criando o grafo 'G' usando lista de adjacencias.");
		System.out.println("------------------------------------------------------------------");
		GrafoLista grafoLista = new GrafoLista();
		for (int i = 0; i < 8; i++) {
			System.out.println(" Obtendo a lista de vertices adjacentes ao vertice: " + i);
			tempoInicio = System.currentTimeMillis();
			List<?> x = grafoLista.obterVerticesAdjacentes(i);
			tempoFim = System.currentTimeMillis();
			tempoTotal = tempoFim - tempoInicio;
			System.out.println(" Resultado: " + x);
			System.out.println(" Tempo em segundos: " + tempoTotal/1000.0);
			System.out.println();
		}
	}

}
