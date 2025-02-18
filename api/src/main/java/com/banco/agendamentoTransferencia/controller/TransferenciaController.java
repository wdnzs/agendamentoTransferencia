package com.banco.agendamentoTransferencia.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.banco.agendamentoTransferencia.model.Transferencia;
import com.banco.agendamentoTransferencia.service.TransferenciaService;


@RestController
class TransferenciaController {
	
	@Autowired
	private TransferenciaService transferenciaService;
	
	@PostMapping("/transferencia")
	public Transferencia agendarTransferencia(@RequestBody Transferencia transferencia) {
		return transferenciaService.agendarTransferencia(transferencia);
	}
	
	@GetMapping("/listarTransferencias")
	public List<Transferencia> listarTransferencias() {
		return transferenciaService.listarTransferencias();
	}
}