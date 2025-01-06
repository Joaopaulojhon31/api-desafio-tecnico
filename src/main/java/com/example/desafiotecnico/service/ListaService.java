package com.example.desafiotecnico.service;

import java.util.HashSet;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ListaService {

	public static class Node {
		public int val;
		public Node next;

		public Node(int val) {
			this.val = val;
		}
	}

	public Node removerDuplicados(Node head) {
		if (head == null)
			return null;

		HashSet<Integer> set = new HashSet<>();
		Node atual = head;
		Node anterior = null;

		while (atual != null) {
			if (set.contains(atual.val)) {
				anterior.next = atual.next;
			} else {
				set.add(atual.val);
				anterior = atual;
			}
			atual = atual.next;
		}

		return head;
	}

	public Node criarListaEncadeada(List<Integer> valores) {
		if (valores == null || valores.isEmpty())
			return null;

		Node head = new Node(valores.get(0));
		Node atual = head;

		for (int i = 1; i < valores.size(); i++) {
			atual.next = new Node(valores.get(i));
			atual = atual.next;
		}

		return head;
	}

	public String listaParaString(Node head) {
		StringBuilder resultado = new StringBuilder();
		Node atual = head;

		while (atual != null) {
			resultado.append(atual.val).append(" ");
			atual = atual.next;
		}

		return resultado.toString().trim();
	}

}
