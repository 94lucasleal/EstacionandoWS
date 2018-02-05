package com.lucas.senac.rn;

import javax.jws.WebService;
import com.lucas.senac.bean.Estabelecimento;
import com.lucas.senac.bd.EstabelecimetoBD;
import com.lucas.senac.rnval.EstabalecimentoRNVAL;
import java.util.List;
import javax.jws.WebParam;

@WebService(endpointInterface = "com.lucas.senac.rn.EstabelecimentoRN", serviceName = "EstabelecimentoRN")
public class EstabelecimentoRN {

    private final EstabelecimetoBD estabelecimetoBD;
    private final EstabalecimentoRNVAL estabalecimentoRNVAL;

    public EstabelecimentoRN() {
        estabelecimetoBD = new EstabelecimetoBD();
        estabalecimentoRNVAL = new EstabalecimentoRNVAL();
    }

    public void inserirEstabelecimento(@WebParam(name = "idEstacionamento") Integer idEstacionamento,
            @WebParam(name = "idUsuario") Integer idUsuario,
            @WebParam(name = "idTipoEstabelecimento") Integer idTipoEstabelecimento,
            @WebParam(name = "razaoSocial") String razaoSocial,
            @WebParam(name = "cnpj") String cnpj,
            @WebParam(name = "estado") String estado,
            @WebParam(name = "municipio") String municipio,
            @WebParam(name = "bairro") String bairro,
            @WebParam(name = "logradouro") String logradouro,
            @WebParam(name = "cep") Integer cep,
            @WebParam(name = "numero") Integer numero,
            @WebParam(name = "referencia") String referencia,
            @WebParam(name = "latitude") Double latitude,
            @WebParam(name = "longitude") Double longitude,
            @WebParam(name = "valormeiahora") Double valormeiahora,
            @WebParam(name = "valorhora") Double valorhora,
            @WebParam(name = "valordiaria") Double valordiaria,
            @WebParam(name = "valormensal") Double valormensal,
            @WebParam(name = "valoradicional") Double valoradicional,
            @WebParam(name = "imagem") Integer imagem) {

        Estabelecimento estabelecimento = new Estabelecimento(idEstacionamento, idUsuario, idTipoEstabelecimento, razaoSocial, cnpj, estado, municipio, bairro, logradouro, cep,
                numero, referencia, latitude, longitude, valormeiahora, valorhora, valordiaria, valormensal, valoradicional, imagem);
        
        estabalecimentoRNVAL.validarInserirEstabelecimento(estabelecimento);
        estabelecimetoBD.inserirEstabelecimento(estabelecimento);
    }

    public void excluirEstabelecimento(@WebParam(name = "idEstacionamento") Integer idEstacionamento) {
        Estabelecimento estabelecimento = new Estabelecimento(idEstacionamento, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null);
        estabalecimentoRNVAL.validarExcluirEstabelecimento(estabelecimento);
        estabelecimetoBD.excluirEstabelecimento(estabelecimento);
    }

    public Estabelecimento consultarEstabelecimento(@WebParam(name = "idEstacionamento") Integer idEstacionamento) {
        Estabelecimento estabelecimento = new Estabelecimento(idEstacionamento, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null);
        estabalecimentoRNVAL.validarConsultarEstabelecimento(estabelecimento);
        return estabelecimetoBD.consultarEstabelecimento(estabelecimento);
    }

    public void alterarEstabelecimento(@WebParam(name = "idEstacionamento") Integer idEstacionamento,
            @WebParam(name = "idUsuario") Integer idUsuario,
            @WebParam(name = "idTipoEstabelecimento") Integer idTipoEstabelecimento,
            @WebParam(name = "razaoSocial") String razaoSocial,
            @WebParam(name = "cnpj") String cnpj,
            @WebParam(name = "estado") String estado,
            @WebParam(name = "municipio") String municipio,
            @WebParam(name = "bairro") String bairro,
            @WebParam(name = "logradouro") String logradouro,
            @WebParam(name = "cep") Integer cep,
            @WebParam(name = "numero") Integer numero,
            @WebParam(name = "referencia") String referencia,
            @WebParam(name = "latitude") Double latitude,
            @WebParam(name = "longitude") Double longitude,
            @WebParam(name = "valormeiahora") Double valormeiahora,
            @WebParam(name = "valorhora") Double valorhora,
            @WebParam(name = "valordiaria") Double valordiaria,
            @WebParam(name = "valormensal") Double valormensal,
            @WebParam(name = "valoradicional") Double valoradicional,
            @WebParam(name = "imagem") Integer imagem) {

        Estabelecimento estabelecimento = new Estabelecimento(idEstacionamento, idUsuario, idTipoEstabelecimento, razaoSocial, cnpj, estado, municipio, bairro, logradouro, cep,
                numero, referencia, latitude, longitude, valormeiahora, valorhora, valordiaria, valormensal, valoradicional, imagem);

        estabalecimentoRNVAL.validarAlterarEstabelecimento(estabelecimento);
        estabelecimetoBD.alterarEstabelecimento(estabelecimento);
    }

    public List<Estabelecimento> pesquisarEstabelecimento(@WebParam(name = "pesquisa") String pesquisa) {
        return estabelecimetoBD.pesquisarEstabelecimento(pesquisa);
    }

    public List<Estabelecimento> buscarTodosEstabelecimento() {
        return estabelecimetoBD.buscarTodosEstabelecimento();
    }

}
