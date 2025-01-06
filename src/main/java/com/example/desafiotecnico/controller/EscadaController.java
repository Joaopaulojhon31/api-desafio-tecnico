package com.example.desafiotecnico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.desafiotecnico.service.EscadaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@Controller
@RequestMapping("/escada")
@CrossOrigin("*")
public class EscadaController {

	@Autowired
	private EscadaService escadaService;

	@Operation(summary = "Possibilidades", description = "Conta quantas maneiras possiveis a criança pode subir uma escada com n degraus", responses = {
			@ApiResponse(responseCode = "200", description = "Quantidade calculada com sucesso"), })

	@GetMapping("/maneiras-de-subir/{quantidade}")
	public ResponseEntity<String> maneirasDeSubirEscada(@PathVariable("quantidade") Long quantidade) {

		return new ResponseEntity<String>(escadaService.calcularManeirasDeSubir(quantidade), HttpStatus.OK);
	}

}
