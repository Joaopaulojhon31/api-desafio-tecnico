package com.example.desafiotecnico.service;

import org.springframework.stereotype.Service;

@Service
public class ArvoreService {

	public static class TreeNode {
		public int valor;
		public TreeNode esquerda, direita;

		public TreeNode(int valor) {
			this.valor = valor;
		}
	}

	public TreeNode criarArvoreBalanceada(int[] nums, int inicio, int fim) {
		if (inicio > fim)
			return null;

		int meio = (inicio + fim) / 2;
		TreeNode node = new TreeNode(nums[meio]);
		node.esquerda = criarArvoreBalanceada(nums, inicio, meio - 1);
		node.direita = criarArvoreBalanceada(nums, meio + 1, fim);

		return node;
	}

	public int calcularTamanhoArvore(TreeNode raiz) {
		if (raiz == null)
			return 0;
		return 1 + calcularTamanhoArvore(raiz.esquerda) + calcularTamanhoArvore(raiz.direita);
	}
}
