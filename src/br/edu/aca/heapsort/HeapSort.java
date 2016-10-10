package br.edu.aca.heapsort;

/**
 * Autor : Douglas Juliano Roldo
 * Curso: Ciência da Computação 
 * Disciplina : Analise e Complexidade de Algoritimos 
 * Periodo: 8º
 * Professora : Franciele Carla Petry
 * Exemplo HEAPSORT 
 */

import java.util.Random;


public class HeapSort {
	private static int[] a;
	private static int n;
	private static int esquerda;
	private static int direita;
	private static int maior;

	public static void construirheap(int[] a) {
		n = a.length - 1;
		for (int i = n / 2; i >= 0; i--) {
			maxheap(a, i);
		}
	}

	public static void maxheap(int[] a, int i) {
		esquerda = 2 * i;
		direita = 2 * i + 1;
		if (esquerda <= n && a[esquerda] > a[i]) {
			maior = esquerda;
		} else {
			maior = i;
		}

		if (direita <= n && a[direita] > a[maior]) {
			maior = direita;
		}
		if (maior != i) {
			troca(i, maior);
			maxheap(a, maior);
		}
	}

	public static void troca(int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	public static void sort(int[] a0) {
		a = a0;
		construirheap(a);

		for (int i = n; i > 0; i--) {
			troca(0, i);
			n = n - 1;
			maxheap(a, 0);
		}
	}

	public static void main(String[] args) {
		int N = 10;
		int[] sequence = new int[N];
		Random random = new Random();

		System.out.println(" Teste Heap Sort");

		for (int i = 0; i < N; i++)
			sequence[i] = Math.abs(random.nextInt(100));

		System.out.println("A sequência original é: ");
		for (int i = 0; i < sequence.length; i++)
			System.out.print(sequence[i] + " ");

		sort(sequence);

		System.out.println("\nA seqüência ordenada é:");
		for (int i = 0; i < sequence.length; i++)
			System.out.print(sequence[i] + " ");

	}
}