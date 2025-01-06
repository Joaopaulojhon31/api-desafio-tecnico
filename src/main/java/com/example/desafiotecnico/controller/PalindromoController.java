package com.example.desafiotecnico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.desafiotecnico.service.PalindromoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/palindromo")
@Controller
@CrossOrigin("*")
public class PalindromoController {

	@Autowired
	private PalindromoService palindromoService;

	@Operation(summary = "Verifica se uma palavra é um palíndromo", description = "Este endpoint recebe uma palavra e verifica se ela é um palíndromo. Um palíndromo é uma palavra ou frase que pode ser lida da mesma forma de trás para frente, desconsiderando espaços, pontuação e diferenças de maiúsculas/minúsculas.", responses = {
			@ApiResponse(responseCode = "200", description = "A palavra é um palíndromo") })

	@PostMapping("/verificar")
	public boolean verificarPalindromo(@RequestBody String palavra) {
		return palindromoService.verificarPalindromo(palavra);
	}
}