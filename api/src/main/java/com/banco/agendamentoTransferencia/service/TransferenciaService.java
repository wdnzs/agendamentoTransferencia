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
		Double taxa = calcularTaxa(dia, transferencia.getValor());
		if (taxa == null) {
			throw new RuntimeException("Não há taxa aplicável para esta transferência.");
		}
		transferencia.setTaxa(taxa);
		return transferenciaRepository.save(transferencia);
	}
	
	private Double calcularTaxa(Long dia, Double valor) {
		double taxa;
		if(dia == 0) {
			taxa = 3 + (valor * 0.25);
			return taxa;
		} else if (dia >= 1 && dia <= 10) {
			taxa = 12 + (valor * 0);
			return taxa;
		} else if (dia >= 11 && dia <= 20) {
			taxa = valor * 0.82;
			return taxa;
		} else if (dia >= 21 && dia <= 30) {
			taxa = valor * 0.69;
			return taxa;
		} else if (dia >= 31 && dia <= 40) {
			taxa = valor * 0.47;
			return taxa;
		} else if (dia >= 41 && dia <= 50) {
			taxa = valor * 0.17;
			return taxa;
		} else return null;
		
	}
	
    public List<Transferencia> listarTransferencias() {
        return transferenciaRepository.findAll();
    }
	
}