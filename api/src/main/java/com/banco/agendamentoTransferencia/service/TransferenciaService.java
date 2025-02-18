package com.banco.agendamentoTransferencia.service;

import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banco.agendamentoTransferencia.model.Transferencia;
import com.banco.agendamentoTransferencia.repository.TransferenciaRepository;

@Service
public class TransferenciaService {
	
	@Autowired
	private TransferenciaRepository transferenciaRepository;
	
	public Transferencia agendarTransferencia(Transferencia transferencia) {
		long dia = ChronoUnit.DAYS.between(transferencia.getDataAgendamento(), transferencia.getDataTransferencia());
		Double taxa = calcularTaxa(dia);
		if (taxa == null) {
			throw new RuntimeException("Não há taxa aplicável para esta transferência.");
		}
		transferencia.setTaxa(taxa);
		return transferenciaRepository.save(transferencia);
	}
	
	private Double calcularTaxa(Long dia) {
		if (dia <= 3) return 2.5;
		else if (dia <= 10) return 0.0;
		else if (dia <= 20) return 8.2;
		else if (dia <= 30) return 6.9;
		else if (dia <= 40) return 4.7;
		else if (dia <= 50) return 1.7;
		else return null;
	}
	
    public List<Transferencia> listarTransferencias() {
        return transferenciaRepository.findAll();
    }
	
}