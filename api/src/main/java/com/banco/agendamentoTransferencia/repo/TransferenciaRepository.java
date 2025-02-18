package com.banco.agendamentoTransferencia.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banco.agendamentoTransferencia.model.Transferencia;

public interface TransferenciaRepository extends JpaRepository<Transferencia, Long>{

}
