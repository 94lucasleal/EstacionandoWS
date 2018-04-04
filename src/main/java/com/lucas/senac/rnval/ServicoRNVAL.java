package com.lucas.senac.rnval;

import com.lucas.senac.bean.Servico;

public class ServicoRNVAL {
    
    public void validarInserirServico(Servico bean) {
        if (bean.getNome().isEmpty()) {
            throw new RuntimeException("Campo NOME não informado");
        }
    }

    public void validarExcluirServico(Servico bean) {
        if (bean.getIdservico() < 0) {
            throw new RuntimeException("Campo idServico não informado");
        }
    }

    public void validarConsultarServico(Servico bean) {
        validarExcluirServico(bean);
    }
    
    public void validarAlterarServico(Servico bean) {
        validarConsultarServico(bean);
    }
    
}
