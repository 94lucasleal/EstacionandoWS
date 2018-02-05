package com.lucas.senac.rn;

import com.lucas.senac.bd.CartaoBD;
import com.lucas.senac.bd.EstabelecimetoBD;
import com.lucas.senac.bd.UsuarioBD;
import com.lucas.senac.bean.Cartao;
import com.lucas.senac.bean.Estabelecimento;
import com.lucas.senac.bean.Usuario;
import com.lucas.senac.rnval.CartaoRNVAL;
import com.lucas.senac.rnval.EstabalecimentoRNVAL;
import com.lucas.senac.rnval.UsuarioRNVAL;
import java.util.List;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(endpointInterface = "com.lucas.senac.rn.SimpleService", serviceName = "SimpleService")
public class SimpleService{
    
    private final CartaoBD cartaoBD;
    private final CartaoRNVAL cartaoRNVal;
    private final EstabelecimetoBD estabelecimetoBD;
    private final EstabalecimentoRNVAL estabalecimentoRNVAL;
    private final UsuarioBD usuarioBD;
    private final UsuarioRNVAL usuarioRNVal;

    public SimpleService() {
        cartaoBD = new CartaoBD();
        cartaoRNVal = new CartaoRNVAL();
        estabelecimetoBD = new EstabelecimetoBD();
        estabalecimentoRNVAL = new EstabalecimentoRNVAL();
        usuarioBD = new UsuarioBD();
        usuarioRNVal = new UsuarioRNVAL();
    }
    
    public void inserirUsuario(@WebParam(name = "idUsuario") Integer idUsuario,
            @WebParam(name = "nome") String nome,
            @WebParam(name = "cpf") String cpf,
            @WebParam(name = "rg") String rg,
            @WebParam(name = "email") String email,
            @WebParam(name = "senha") String senha,
            @WebParam(name = "idTipoAcesso") Integer idTipoAcesso,
            @WebParam(name = "telefone") long telefone) {

        Usuario usuario = new Usuario(idUsuario, nome, cpf, rg, email, senha, idTipoAcesso, telefone);
        usuarioRNVal.validarInserirUsuario(usuario);
        usuarioBD.inserirUsuario(usuario);
    }

    public void excluirUsuario(@WebParam(name = "idUsuario") Integer idUsuario) {
        Usuario usuario = new Usuario(idUsuario, null, null, null, null, null, null, 0);
        usuarioRNVal.validarExcluirUsuario(usuario);
        usuarioBD.excluirUsuario(usuario);
    }

    public Usuario consultarUsuario(@WebParam(name = "email") String email,
            @WebParam(name = "senha") String senha) {
        Usuario usuario = new Usuario(null, null, null, null, email, senha, null, 0);
        usuarioRNVal.validarConsultarUsuario(usuario);
        return usuarioBD.consultarUsuario(usuario);
    }

    public void alterarUsuario(@WebParam(name = "idUsuario") Integer idUsuario,
            @WebParam(name = "nome") String nome,
            @WebParam(name = "cpf") String cpf,
            @WebParam(name = "rg") String rg,
            @WebParam(name = "email") String email,
            @WebParam(name = "senha") String senha,
            @WebParam(name = "idTipoAcesso") Integer idTipoAcesso,
            @WebParam(name = "telefone") long telefone) {
        
        Usuario usuario = new Usuario(idUsuario, nome, cpf, rg, email, senha, idTipoAcesso, telefone);
        usuarioRNVal.validarAlterarUsuario(usuario);
        usuarioBD.alterarUsuario(usuario);
    }

    public List<Usuario> pesquisarUsuario(@WebParam(name = "pesquisa") String pesquisa) {
        System.out.println(pesquisa);
        return usuarioBD.pesquisarUsuario(pesquisa);
    }

    public List<Usuario> buscarTodosUsuario() {
        return usuarioBD.buscarTodosUsuario();
    }

        public void inserirCartao(@WebParam(name = "idCartao") Integer idCartao,
                        @WebParam(name = "nomeTitular") String nomeTitular,
                        @WebParam(name = "cpfTitular") String cpfTitular,
                        @WebParam(name = "numeroCartao") String numeroCartao) {

        Cartao cartao = new Cartao(idCartao,nomeTitular,cpfTitular,numeroCartao);
        cartaoRNVal.validarInserirCartao(cartao);
        cartaoBD.inserirCartao(cartao);
    }

    public void excluirCartao(@WebParam(name = "idCartao") Integer idCartao) {
        Cartao cartao = new Cartao(idCartao,null,null,null);
        cartaoRNVal.validarExcluirCartao(cartao);
        cartaoBD.excluirCartao(cartao);
    }

    public Cartao consultarCartao(@WebParam(name = "idCartao") Integer idCartao) {
        Cartao cartao = new Cartao(idCartao,null,null,null);
        cartaoRNVal.validarConsultarCartao(cartao);
        return cartaoBD.consultarCartao(cartao);
    }

    public void alterarCartao(@WebParam(name = "idCartao") Integer idCartao,
                        @WebParam(name = "nomeTitular") String nomeTitular,
                        @WebParam(name = "cpfTitular") String cpfTitular,
                        @WebParam(name = "numeroCartao") String numeroCartao) {
        
        Cartao cartao = new Cartao(idCartao,nomeTitular,cpfTitular,numeroCartao);
        cartaoRNVal.validarAlterarCartao(cartao);
        cartaoBD.alterarCartao(cartao);
    }

    public List<Cartao> pesquisarCartao(@WebParam(name = "pesquisa") String pesquisa) {
        return cartaoBD.pesquisarCartao(pesquisa);
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