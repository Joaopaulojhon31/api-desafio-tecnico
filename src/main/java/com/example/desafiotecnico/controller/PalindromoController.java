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

	@Operation(summary = "Verifica se uma palavra � um pal�ndromo", description = "Este endpoint recebe uma palavra e verifica se ela � um pal�ndromo. Um pal�ndromo � uma palavra ou frase que pode ser lida da mesma forma de tr�s para frente, desconsiderando espa�os, pontua��o e diferen�as de mai�sculas/min�sculas.", responses = {
			@ApiResponse(responseCode = "200", description = "A palavra � um pal�ndromo") })

	@PostMapping("/verificar")
	public boolean verificarPalindromo(@RequestBody String palavra) {
		return palindromoService.verificarPalindromo(palavra);
	}
}