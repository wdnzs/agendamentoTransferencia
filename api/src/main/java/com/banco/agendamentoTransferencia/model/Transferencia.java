package com.banco.agendamentoTransferencia.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transferencia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String contaOrigem;
	private String contaDestino;
	private double valor;
	private double taxa;
	private LocalDate dataTransferencia;
	private LocalDate dataAgendamento;
	
	public Long getId() { 
		return id; 
	}
	
	public void setId(Long id) { 
		this.id = id; 
	}
	
	public String getContaOrigem() { 
		return contaOrigem; 
	}
	
	public void setContaOrigem(String contaOrigem) { 
		this.contaOrigem = contaOrigem; 
	}
	
	public String getContaDestino() { 
		return contaDestino; 
	}
	
	public void setContaDestino(String contaDestino) { 
		this.contaDestino = contaDestino; 
	}
	
	public double getValor() { 
		return valor; 
	}
	
	public void setValor(double valor) { 
		this.valor = valor; 
	}
	
	public double getTaxa() { 
		return taxa; 
	}
	
	public void setTaxa(double taxa) { 
		this.taxa = taxa; 
	}
	
	public LocalDate getDataTransferencia() { 
		return dataTransferencia; 
	}
	
	public void setDataTransferencia(LocalDate dataTransferencia) { 
		this.dataTransferencia = dataTransferencia; 
	}
	
	public LocalDate getDataAgendamento() { 
		return dataAgendamento; 
	}
	
	public void setDataAgendamento(LocalDate dataAgendamento) { 
		this.dataAgendamento = dataAgendamento; 
	}
}