package com.example.desafiotecnico.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.desafiotecnico.service.ListaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/lista")
@Controller
@CrossOrigin("*")
public class ListaController {

	@Autowired
	private ListaService listaService;

	@Operation(summary = "Remove duplicados de uma lista encadeada", description = "Lista encadeada (0, 1, 2, 3, 4,4,2,1) e remove valores duplicados.", responses = {
			@ApiResponse(responseCode = "200", description = "Lista processada com sucesso"), })

	@GetMapping("/remover-duplicados")
	public ResponseEntity<String> removerDuplicados() {
		List<Integer> valores = Arrays.asList(0, 1, 2, 3, 4, 4, 2, 1);

		ListaService.Node head = listaService.criarListaEncadeada(valores);
		ListaService.Node listaSemDuplicados = listaService.removerDuplicados(head);

		String resultado = listaService.listaParaString(listaSemDuplicados);
		return ResponseEntity.ok("Lista sem duplicados: " + resultado);
	}
}
