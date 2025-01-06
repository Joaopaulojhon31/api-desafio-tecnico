package com.example.desafiotecnico.service;

import org.springframework.stereotype.Service;

@Service
public class EscadaService {

	public String calcularManeirasDeSubir(Long totalDegraus) {

		if (totalDegraus == null || totalDegraus < 0) {
			return montarTexto(0);
		}
		if (totalDegraus == 0) {
			return montarTexto(1);
		}

		long[] maneiras = new long[totalDegraus.intValue() + 1];
		maneiras[0] = 1;
		maneiras[1] = 1;
		if (totalDegraus > 1) {
			maneiras[2] = 2;
		}

		for (int i = 3; i <= totalDegraus; i++) {
			maneiras[i] = maneiras[i - 1] + maneiras[i - 2] + maneiras[i - 3];
		}

		return montarTexto((int) maneiras[totalDegraus.intValue()]);
	}

	private String montarTexto(Integer totalDegraus) {
		return "Existem " + totalDegraus + " maneiras de subir a escada ";
	}
}
