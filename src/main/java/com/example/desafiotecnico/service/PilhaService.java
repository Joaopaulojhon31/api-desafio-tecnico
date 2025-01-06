package com.example.desafiotecnico.service;

import java.util.Stack;

import org.springframework.stereotype.Service;

@Service
public class PilhaService {

	public void ordenarPilha(Stack<Integer> pilha) {
		Stack<Integer> pilhaAuxiliar = new Stack<>();

		while (!pilha.isEmpty()) {
			int elementoAtual = pilha.pop();

			while (!pilhaAuxiliar.isEmpty() && pilhaAuxiliar.peek() > elementoAtual) {
				pilha.push(pilhaAuxiliar.pop());
			}

			pilhaAuxiliar.push(elementoAtual);
		}

		while (!pilhaAuxiliar.isEmpty()) {
			pilha.push(pilhaAuxiliar.pop());
		}
	}

}
