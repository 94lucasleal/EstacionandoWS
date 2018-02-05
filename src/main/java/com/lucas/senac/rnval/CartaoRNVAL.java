package com.lucas.senac.rnval;

import com.lucas.senac.bean.Cartao;

public class CartaoRNVAL {
    
    public void validarInserirCartao(Cartao bean) {
        if (bean.getNomeTitular().isEmpty()) {
            throw new RuntimeException("Campo NOME DO TITULAR não informado");
        }
        if (bean.getCpfTitular().isEmpty()) {
            throw new RuntimeException("Campo CPF DO TITULAR não informado");
        }
        if (bean.getNumeroCartao().isEmpty()) {
            throw new RuntimeException("Campo NUMERO DO CARTAO não informado");
        }
    }

    public void validarExcluirCartao(Cartao bean) {
        validarConsultarCartao(bean);
    }

    public void validarConsultarCartao(Cartao bean) {
        if (bean.getIdCartao() == 0) {
            throw new RuntimeException("Campo Código não informado");
        }
    }
    
    public void validarAlterarCartao(Cartao bean) {
        validarConsultarCartao(bean);
    }
    
}
