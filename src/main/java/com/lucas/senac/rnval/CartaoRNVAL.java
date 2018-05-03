package com.lucas.senac.rnval;

import com.lucas.senac.bean.Pagamento;

public class CartaoRNVAL {
    
    public void validarInserirCartao(Pagamento bean) {
        /*
        if (bean.getNomeTitular().isEmpty()) {
            throw new RuntimeException("Campo NOME DO TITULAR não informado");
        }
        if (bean.getCpfTitular().isEmpty()) {
            throw new RuntimeException("Campo CPF DO TITULAR não informado");
        }
        if (bean.getNumeroCartao().isEmpty()) {
            throw new RuntimeException("Campo NUMERO DO CARTAO não informado");
        }
        */
    }

    public void validarExcluirCartao(Pagamento bean) {
        //validarConsultarCartao(bean);
    }

    public void validarConsultarCartao(Pagamento bean) {
        /*
        if (bean.getIdCartao() == 0) {
            throw new RuntimeException("Campo Código não informado");
        }
        */
    }
    
    public void validarAlterarCartao(Pagamento bean) {
        //validarConsultarCartao(bean);
    }
    
}
