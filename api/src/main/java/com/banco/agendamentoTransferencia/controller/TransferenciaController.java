package com.banco.agendamentoTransferencia.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.banco.agendamentoTransferencia.model.TaxaCalculadora;
import com.banco.agendamentoTransferencia.model.Transferencia;
import com.banco.agendamentoTransferencia.repo.TransferenciaRepository;


@RestController
class TransferenciaController {
    private final TransferenciaRepository repository;

    public TransferenciaController(TransferenciaRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/transferencia")
    public String agendarTransferencia(@RequestBody Transferencia transferencia) {
        if (!TaxaCalculadora.validarTaxa(transferencia)) {
            return "Erro: Nenhuma taxa aplicável encontrada para esta transferência.";
        }
        transferencia.setDataAgendamento(LocalDate.now());
        repository.save(transferencia);
        return "Transferência agendada com sucesso.";
    }

    @GetMapping("/listaTransferencia")
    public List<Transferencia> listarTransferencias() {
        return repository.findAll();
    }
}