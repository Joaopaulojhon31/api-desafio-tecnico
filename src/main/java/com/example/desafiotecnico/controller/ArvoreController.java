package com.example.desafiotecnico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.desafiotecnico.service.ArvoreService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@Controller
@RequestMapping("/arvore")
@CrossOrigin("*")
public class ArvoreController {

	@Autowired
	private ArvoreService arvoreService;

	@Operation(summary = "Cria uma árvore de altura mínima", description = "Constrói uma árvore binária de altura mínima a partir de um array ordenado. array = { 1, 2, 3, 4, 5, 6, 7 }", responses = {
			@ApiResponse(responseCode = "200", description = "Árvore criada com sucesso"), })

	@GetMapping
	public ResponseEntity<String> criarArvore() {

		int[] array = new int[] { 1, 2, 3, 4, 5, 6, 7 };

		ArvoreService.TreeNode raiz = arvoreService.criarArvoreBalanceada(array, 0, array.length - 1);
		int tamanho = arvoreService.calcularTamanhoArvore(raiz);

		return ResponseEntity.ok("A árvore foi criada com sucesso! O valor da raiz é: " + raiz.valor
				+ " e o tamanho da árvore (número de nós) é: " + tamanho);
	}
}
