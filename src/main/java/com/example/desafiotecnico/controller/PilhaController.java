package com.example.desafiotecnico.controller;

import java.util.ArrayList;
import java.util.Stack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.desafiotecnico.service.PilhaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/pilha")
@Controller
@CrossOrigin("*")
public class PilhaController {

	@Autowired
	private PilhaService pilhaService;

	@Operation(summary = "Ordena uma pilha de números inteiros", description = "Retorna a pilha ordenada em ordem crescente. Dados: 3,1,4,2", responses = {
			@ApiResponse(responseCode = "200", description = "Pilha ordenada com sucesso"),

	})
	@PostMapping("/ordenar")
	public ResponseEntity<String> ordenarPilha() {
		
		Stack<Integer> pilha = new Stack<>();
		pilha.push(3);
		pilha.push(1);
		pilha.push(4);
		pilha.push(2);
		
		Stack<Integer> pilhaStack = new Stack<>();
		pilhaStack.addAll(pilha);

		pilhaService.ordenarPilha(pilhaStack);

		return new ResponseEntity<String>("Pilha ordenada: " + pilhaStack, HttpStatus.INTERNAL_SERVER_ERROR);

	}
}