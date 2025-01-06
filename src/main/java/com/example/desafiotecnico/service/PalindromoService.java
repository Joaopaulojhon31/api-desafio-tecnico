package com.example.desafiotecnico.service;

import org.springframework.stereotype.Service;

@Service
public class PalindromoService {

	public static class DNode {
		public char val;
		public DNode next, prev;

		public DNode(char val) {
			this.val = val;
		}
	}

	public boolean verificarPalindromo(String palavra) {
		if (palavra == null || palavra.isEmpty()) {
			return false;
		}

		DNode head = criarListaLigada(palavra);

		DNode esquerda = head;
		DNode direita = head;

		while (direita.next != null) {
			direita = direita.next;
		}

		while (esquerda != direita && esquerda.prev != direita) {
			if (esquerda.val != direita.val) {
				return false;
			}
			esquerda = esquerda.next;
			direita = direita.prev;
		}

		return true;
	}

	private DNode criarListaLigada(String palavra) {
		if (palavra == null || palavra.isEmpty()) {
			return null;
		}

		DNode head = new DNode(palavra.charAt(0));
		DNode current = head;

		for (int i = 1; i < palavra.length(); i++) {
			DNode newNode = new DNode(palavra.charAt(i));
			current.next = newNode;
			newNode.prev = current;
			current = newNode;
		}

		return head;
	}
}
