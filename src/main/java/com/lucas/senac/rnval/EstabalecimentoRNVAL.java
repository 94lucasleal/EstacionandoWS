package com.lucas.senac.rnval;

import com.lucas.senac.bean.Estabelecimento;

public class EstabalecimentoRNVAL {
    
    public void validarInserirEstabelecimento(Estabelecimento bean) {
        if (bean.getRazaoSocial().isEmpty()) {
            throw new RuntimeException("Campo RAZAO SOCIAL não informado");
        }
        if (bean.getCnpj().isEmpty()) {
            throw new RuntimeException("Campo CNPJ não informado");
        }
    }

    public void validarExcluirEstabelecimento(Estabelecimento bean) {
        validarConsultarEstabelecimento(bean);
    }

    public void validarConsultarEstabelecimento(Estabelecimento bean) {
    }
    
    public void validarAlterarEstabelecimento(Estabelecimento bean) {
        if (bean.getIdEstacionamento()== 0) {
            throw new RuntimeException("Campo Código não informado");
        }
    }
    
    
}
