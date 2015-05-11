package exeIntegrados;

import java.util.Arrays;
import java.util.Random;

import javax.swing.JOptionPane;

public class AlgedUtils {

	private int busca;

	public void bubbleSort() {
		int aux;
		for (int i = 0; i < VetorUtils.vetor.length; i++) {
			for (int j = 0; j < VetorUtils.vetor.length - 1; j++) {
				if (VetorUtils.vetor[j] > VetorUtils.vetor[j + 1]) {
					aux = VetorUtils.vetor[j];
					VetorUtils.vetor[j] = VetorUtils.vetor[j + 1];
					VetorUtils.vetor[j + 1] = aux;
				}
			}
		}
		JOptionPane.showMessageDialog(null,
				"Vetor organizado: " + Arrays.toString(VetorUtils.vetor));
		shuffleArray();
	}

	public void selectionSort() {
		for (int j = 0; j < VetorUtils.vetor.length - 1; j++) {
			int menor = j;

			for (int i = menor + 1; i < VetorUtils.vetor.length; i++) {
				if (VetorUtils.vetor[i] < VetorUtils.vetor[menor]) {
					menor = i;
				}
			}
			if (menor != j) {
				int t = VetorUtils.vetor[j];
				VetorUtils.vetor[j] = VetorUtils.vetor[menor];
				VetorUtils.vetor[menor] = t;
			}
		}
		JOptionPane.showMessageDialog(null,
				"Vetor organizado: " + Arrays.toString(VetorUtils.vetor));
		shuffleArray();

	}

	public void insertionSort() {
		int n = VetorUtils.vetor.length;
		for (int j = 1; j < n; j++) {
			int aux = VetorUtils.vetor[j];
			int i = j - 1;
			while ((i > -1) && (VetorUtils.vetor[i] > aux)) {
				VetorUtils.vetor[i + 1] = VetorUtils.vetor[i];
				i--;
			}
			VetorUtils.vetor[i + 1] = aux;
		}
		JOptionPane.showMessageDialog(null,
				"Vetor organizado: " + Arrays.toString(VetorUtils.vetor));
		shuffleArray();
	}

	private void shuffleArray() {
		int index;
		Random random = new Random();
		for (int i = VetorUtils.vetor.length - 1; i > 0; i--) {
			index = random.nextInt(i + 1);
			if (index != i) {
				VetorUtils.vetor[index] ^= VetorUtils.vetor[i];
				VetorUtils.vetor[i] ^= VetorUtils.vetor[index];
				VetorUtils.vetor[index] ^= VetorUtils.vetor[i];
			}
		}
	}

	public void quickSort() {
		ordenar(VetorUtils.vetor, 0, VetorUtils.vetor.length - 1);
		JOptionPane.showMessageDialog(null,
				"Vetor organizado: " + Arrays.toString(VetorUtils.vetor));
		shuffleArray();
	}

	private void ordenar(int[] vetor, int inicio, int fim) {
		if (inicio < fim) {
			int posicaoPivo = separar(vetor, inicio, fim);
			ordenar(vetor, inicio, posicaoPivo - 1);
			ordenar(vetor, posicaoPivo + 1, fim);
		}
	}

	private int separar(int[] vetor, int inicio, int fim) {
		int ini = vetor[inicio];
		int i = inicio + 1, f = fim;
		while (i <= f) {
			if (vetor[i] <= ini)
				i++;
			else if (ini < vetor[f])
				f--;
			else {
				int troca = vetor[i];
				vetor[i] = vetor[f];
				vetor[f] = troca;
				i++;
				f--;
			}
		}
		vetor[inicio] = vetor[f];
		vetor[f] = ini;
		return f;
	}

	public void mergeSort() {
		merge(0, VetorUtils.vetor.length - 1);
		JOptionPane.showMessageDialog(null,
				"Vetor organizado: " + Arrays.toString(VetorUtils.vetor));
		shuffleArray();
	}

	public void merge(int inicio, int fim) {
		if (fim <= inicio) {
			return;
		}
		int meio = (inicio + fim) / 2;
		merge(inicio, meio);
		merge(meio + 1, fim);
		int[] A = new int[meio - inicio + 1];
		int[] B = new int[fim - meio];
		for (int i = 0; i <= meio - inicio; i++) {
			A[i] = VetorUtils.vetor[inicio + i];
		}
		for (int i = 0; i <= fim - meio - 1; i++) {
			B[i] = VetorUtils.vetor[meio + 1 + i];
		}
		int i = 0;
		int j = 0;
		for (int k = inicio; k <= fim; k++) {
			if (i < A.length && j < B.length) {
				if (A[i] < B[j]) {
					VetorUtils.vetor[k] = A[i++];
				} else {
					VetorUtils.vetor[k] = B[j++];
				}
			} else if (i < A.length) {
				VetorUtils.vetor[k] = A[i++];
			} else if (j < B.length) {
				VetorUtils.vetor[k] = B[j++];
			}
		}
	}

	// Metodos de Busca ===================================================

	public void buscaLinearIterativa() {
		busca = Integer.parseInt(JOptionPane
				.showInputDialog("Digite o valor que deseja encontrar"));

		for (int i = 0; i < VetorUtils.vetor.length; i++) {
			if (VetorUtils.vetor[i] == busca) {
				JOptionPane.showMessageDialog(null, "Posicao: " + i);
				return;
			}
		}
		JOptionPane.showMessageDialog(null, "O numero nao esta no vetor");
	}

	public void buscaBinariaIterativa() {
		busca = Integer.parseInt(JOptionPane
				.showInputDialog("Digite o valor que deseja encontrar"));
		int inicio = 0;
		int fim = VetorUtils.vetor.length - 1;

		while (inicio <= fim) {
			int meio = (inicio + fim) / 2;

			if (VetorUtils.vetor[meio] == busca) {
				JOptionPane.showMessageDialog(null, "Posicao: " + meio);
				return;
			}

			if (busca > VetorUtils.vetor[meio]) {
				inicio = meio + 1;
			} else {
				fim = meio - 1;
			}
		}
		JOptionPane.showMessageDialog(null, "O numero nao esta no vetor");
	}

	public void buscaBinariaRecursiva() {
		busca = Integer.parseInt(JOptionPane
				.showInputDialog("Digite o valor que deseja encontrar"));
		int res = busca(0, VetorUtils.vetor.length - 1);

		if (res == -1) {
			JOptionPane.showMessageDialog(null, "O numero nao esta no vetor");
			return;
		} else {
			JOptionPane.showMessageDialog(null, "Posicao: " + res);
			return;
		}
	}

	private int busca(int menor, int maior) {
		int media = (maior + menor) / 2;
		int valorMeio = VetorUtils.vetor[media];

		if (menor > maior)
			return -1;
		else if (valorMeio == busca)
			return media;
		else if (valorMeio < busca)
			return busca(media + 1, maior);
		else
			return busca(menor, media - 1);
	}

	public void buscaLinearRecursiva() {
		busca = Integer.parseInt(JOptionPane
				.showInputDialog("Digite o valor que deseja encontrar"));
		buscaLiner(VetorUtils.vetor.length);
	}

	public int buscaLiner(int n) {
		if (n >= 0) {
			if (VetorUtils.vetor[n] == busca) {
				JOptionPane.showMessageDialog(null, "Posicao: " + n);
				return 0;
			} else {
				return buscaLiner(n - 1);
			}
		}
		JOptionPane.showMessageDialog(null, "O numero nao esta no vetor");
		return 0;
	}

}
