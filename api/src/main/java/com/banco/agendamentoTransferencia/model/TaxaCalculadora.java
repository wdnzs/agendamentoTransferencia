package com.banco.agendamentoTransferencia.model;

public class TaxaCalculadora {
	
	public static boolean validarTaxa(Transferencia transferencia) {
		long dias = transferencia.getDataAgendamento().until(transferencia.getDataTransferencia()).getDays();
        if (dias == 0) {
            transferencia.setTaxa(3.00 + (transferencia.getValor() * 0.025));
            return true;
        } else if (dias <= 10) {
            transferencia.setTaxa(12.00);
            return true;
        } else if (dias <= 20) {
            transferencia.setTaxa(transferencia.getValor() * 0.082);
            return true;
        } else if (dias <= 30) {
            transferencia.setTaxa(transferencia.getValor() * 0.069);
            return true;
        } else if (dias <= 40) {
            transferencia.setTaxa(transferencia.getValor() * 0.047);
            return true;
        } else if (dias <= 50) {
            transferencia.setTaxa(transferencia.getValor() * 0.017);
            return true;
        }
        return false;
    }
	
}