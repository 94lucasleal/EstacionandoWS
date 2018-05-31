package com.lucas.senac.bd;

import com.lucas.senac.infra.CrudBD;
import com.lucas.senac.bean.Estabelecimento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class EstabelecimetoBD extends CrudBD<Estabelecimento> {

    SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");

    public void inserirEstabelecimento(Estabelecimento bean) {
        Connection conn = null;
        try {
            conn = abrirConexao();

            PreparedStatement pstm = conn.prepareStatement("INSERT INTO estabelecimento (idusuario, "
                    + "idtipoestabelecimento, razaoSocial, cnpj, estado, municipio, bairro, "
                    + "logradouro, cep, numero, referencia, latitude, longitude,"
                    + "valormeiahora, valorhora, valordiaria, valormensal, valoradicional, imagem, vagas_total, vagas_reservada, vagas_disponivel, "
                    + "entrada_segunda, entrada_terca, entrada_quarta, entrada_quinta, entrada_sexta, entrada_sabado, entrada_domingo,"
                    + "saida_segunda, saida_terca, saida_quarta, saida_quinta, saida_sexta, saida_sabado, saida_domingo) "
                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pstm.setInt(1, bean.getIdusuario());
            pstm.setInt(2, bean.getIdtipoestabelecimento());
            pstm.setString(3, bean.getRazaosocial());
            pstm.setString(4, bean.getCnpj());
            pstm.setString(5, bean.getEstado());
            pstm.setString(6, bean.getMunicipio());
            pstm.setString(7, bean.getBairro());
            pstm.setString(8, bean.getLogradouro());
            pstm.setString(9, "" + String.valueOf(bean.getCep()));
            pstm.setInt(10, bean.getNumero());
            pstm.setString(11, bean.getReferencia());
            pstm.setDouble(12, bean.getLatitude());
            pstm.setDouble(13, bean.getLongitude());
            pstm.setDouble(14, bean.getValormeiahora());
            pstm.setDouble(15, bean.getValorhora());
            pstm.setDouble(16, bean.getValordiaria());
            pstm.setDouble(17, bean.getValormensal());
            pstm.setDouble(18, bean.getValoradicional());
            pstm.setString(19, bean.getImagem());
            pstm.setInt(20, bean.getVagastotal());
            pstm.setInt(21, bean.getVagasreservada());
            pstm.setInt(22, bean.getVagasdisponivel());
            pstm.setTime(23, new java.sql.Time(format.parse(bean.getEntrada_segunda()).getTime()));
            pstm.setTime(24, new java.sql.Time(format.parse(bean.getEntrada_terca()).getTime()));
            pstm.setTime(25, new java.sql.Time(format.parse(bean.getEntrada_quarta()).getTime()));
            pstm.setTime(26, new java.sql.Time(format.parse(bean.getEntrada_quinta()).getTime()));
            pstm.setTime(27, new java.sql.Time(format.parse(bean.getEntrada_sexta()).getTime()));
            pstm.setTime(28, new java.sql.Time(format.parse(bean.getEntrada_sabado()).getTime()));
            pstm.setTime(29, new java.sql.Time(format.parse(bean.getEntrada_domingo()).getTime()));
            pstm.setTime(30, new java.sql.Time(format.parse(bean.getSaida_segunda()).getTime()));
            pstm.setTime(31, new java.sql.Time(format.parse(bean.getSaida_terca()).getTime()));
            pstm.setTime(32, new java.sql.Time(format.parse(bean.getSaida_quarta()).getTime()));
            pstm.setTime(33, new java.sql.Time(format.parse(bean.getSaida_quinta()).getTime()));
            pstm.setTime(34, new java.sql.Time(format.parse(bean.getSaida_sexta()).getTime()));
            pstm.setTime(35, new java.sql.Time(format.parse(bean.getSaida_sabado()).getTime()));
            pstm.setTime(36, new java.sql.Time(format.parse(bean.getSaida_domingo()).getTime()));

            System.out.println(pstm.toString());
            System.out.println("Salvando: " + bean);
            pstm.execute();
            commitTransacao(conn);
            System.out.println("Salvamento executado com sucesso");
        } catch (Exception e) {
            rollbackTransacao(conn);
            throw new RuntimeException(e);
        } finally {
            fecharConexao(conn);
        }
    }

    public void excluirEstabelecimento(Estabelecimento bean) {
        Connection conn = null;
        try {
            conn = abrirConexao();

            PreparedStatement pstm = conn.prepareStatement("DELETE FROM estabelecimento WHERE idestabelecimento=?");
            pstm.setInt(1, bean.getIdestabelecimento());

            System.out.println(pstm.toString());
            System.out.println("Excluindo: " + bean);
            pstm.execute();
            commitTransacao(conn);
            System.out.println("Exclusão executada com sucesso");
        } catch (Exception e) {
            rollbackTransacao(conn);
            throw new RuntimeException(e);
        } finally {
            fecharConexao(conn);
        }
    }

    public Estabelecimento consultarEstabelecimento(Estabelecimento bean) {
        Estabelecimento estabelecimentoRetorno = null;

        Connection conn = null;
        try {
            conn = abrirConexao();

            PreparedStatement pstm = conn.prepareStatement("SELECT * FROM estabelecimento WHERE idestabelecimento=?");
            pstm.setInt(1, bean.getIdestabelecimento());

            System.out.println(pstm.toString());
            System.out.println("Consultando: " + bean);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                System.out.println("Registro encontrado");
                estabelecimentoRetorno = new Estabelecimento();
                estabelecimentoRetorno.setIdestabelecimento(rs.getInt("idestabelecimento"));
                estabelecimentoRetorno.setIdusuario(rs.getInt("idusuario"));
                estabelecimentoRetorno.setIdtipoestabelecimento(rs.getInt("idtipoestabelecimento"));
                estabelecimentoRetorno.setRazaosocial(rs.getString("razaoSocial"));
                estabelecimentoRetorno.setCnpj(rs.getString("cnpj"));
                estabelecimentoRetorno.setEstado(rs.getString("estado"));
                estabelecimentoRetorno.setMunicipio(rs.getString("municipio"));
                estabelecimentoRetorno.setBairro(rs.getString("bairro"));
                estabelecimentoRetorno.setLogradouro(rs.getString("logradouro"));
                estabelecimentoRetorno.setCep(rs.getInt("cep"));
                estabelecimentoRetorno.setNumero(rs.getInt("numero"));
                estabelecimentoRetorno.setReferencia(rs.getString("referencia"));
                estabelecimentoRetorno.setLatitude(rs.getDouble("latitude"));
                estabelecimentoRetorno.setLongitude(rs.getDouble("longitude"));
                estabelecimentoRetorno.setValormeiahora(rs.getDouble("valormeiahora"));
                estabelecimentoRetorno.setValorhora(rs.getDouble("valorhora"));
                estabelecimentoRetorno.setValordiaria(rs.getDouble("valordiaria"));
                estabelecimentoRetorno.setValormensal(rs.getDouble("valormensal"));
                estabelecimentoRetorno.setValoradicional(rs.getDouble("valoradicional"));
                estabelecimentoRetorno.setImagem(rs.getString("imagem"));
                estabelecimentoRetorno.setVagastotal(rs.getInt("vagas_total"));
                estabelecimentoRetorno.setVagasreservada(rs.getInt("vagas_reservada"));
                estabelecimentoRetorno.setVagasdisponivel(rs.getInt("vagas_disponivel"));
                estabelecimentoRetorno.setEntrada_segunda(rs.getString("entrada_segunda"));
                estabelecimentoRetorno.setSaida_segunda(rs.getString("saida_segunda"));
                estabelecimentoRetorno.setEntrada_terca(rs.getString("entrada_terca"));
                estabelecimentoRetorno.setSaida_terca(rs.getString("saida_terca"));
                estabelecimentoRetorno.setEntrada_quarta(rs.getString("entrada_quarta"));
                estabelecimentoRetorno.setSaida_quarta(rs.getString("saida_quarta"));
                estabelecimentoRetorno.setEntrada_quinta(rs.getString("entrada_quinta"));
                estabelecimentoRetorno.setSaida_quinta(rs.getString("saida_quinta"));
                estabelecimentoRetorno.setEntrada_sexta(rs.getString("entrada_sexta"));
                estabelecimentoRetorno.setSaida_sexta(rs.getString("saida_sexta"));
                estabelecimentoRetorno.setEntrada_sabado(rs.getString("entrada_sabado"));
                estabelecimentoRetorno.setSaida_sabado(rs.getString("saida_sabado"));
                estabelecimentoRetorno.setEntrada_domingo(rs.getString("entrada_domingo"));
                estabelecimentoRetorno.setSaida_domingo(rs.getString("saida_domingo"));

            }
            System.out.println("Consulta executada com sucesso");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            fecharConexao(conn);
        }
        return estabelecimentoRetorno;
    }

    public void alterarEstabelecimento(Estabelecimento bean) {
        Connection conn = null;
        try {
            conn = abrirConexao();

            PreparedStatement pstm = conn.prepareStatement("UPDATE estabelecimento SET idusuario = ?, "
                    + "idtipoestabelecimento = ?, razaoSocial = ?, cnpj = ?, estado = ?, municipio = ?, bairro = ?, "
                    + "logradouro = ?, cep = ?, numero = ?, referencia = ?, latitude = ?, longitude = ?, "
                    + "valormeiahora = ?, valorhora = ?, valordiaria = ?, valormensal = ?, valoradicional = ?, imagem = ?, vagas_total = ?, "
                    + "vagas_reservada = ?, vagas_disponivel = ?, entrada_segunda=?, entrada_terca=?, entrada_quarta=?, entrada_quinta=?, entrada_sexta=?, entrada_sabado=?, entrada_domingo=?,"
                    + "saida_segunda=?, saida_terca=?, saida_quarta=?, saida_quinta=?, saida_sexta=?, saida_sabado=?, saida_domingo=? "
                    + "WHERE idestabelecimento = ?");
            pstm.setInt(1, bean.getIdusuario());
            pstm.setInt(2, bean.getIdtipoestabelecimento());
            pstm.setString(3, bean.getRazaosocial());
            pstm.setString(4, bean.getCnpj());
            pstm.setString(5, bean.getEstado());
            pstm.setString(6, bean.getMunicipio());
            pstm.setString(7, bean.getBairro());
            pstm.setString(8, bean.getLogradouro());
            pstm.setString(9, "" + String.valueOf(bean.getCep()));
            pstm.setInt(10, bean.getNumero());
            pstm.setString(11, bean.getReferencia());
            pstm.setDouble(12, bean.getLatitude());
            pstm.setDouble(13, bean.getLongitude());
            pstm.setDouble(14, bean.getValormeiahora());
            pstm.setDouble(15, bean.getValorhora());
            pstm.setDouble(16, bean.getValordiaria());
            pstm.setDouble(17, bean.getValormensal());
            pstm.setDouble(18, bean.getValoradicional());
            pstm.setString(19, bean.getImagem());
            pstm.setInt(20, bean.getVagastotal());
            pstm.setInt(21, bean.getVagasreservada());
            pstm.setInt(22, bean.getVagasdisponivel());
            pstm.setTime(23, new java.sql.Time(format.parse(bean.getEntrada_segunda()).getTime()));
            pstm.setTime(24, new java.sql.Time(format.parse(bean.getEntrada_terca()).getTime()));
            pstm.setTime(25, new java.sql.Time(format.parse(bean.getEntrada_quarta()).getTime()));
            pstm.setTime(26, new java.sql.Time(format.parse(bean.getEntrada_quinta()).getTime()));
            pstm.setTime(27, new java.sql.Time(format.parse(bean.getEntrada_sexta()).getTime()));
            pstm.setTime(28, new java.sql.Time(format.parse(bean.getEntrada_sabado()).getTime()));
            pstm.setTime(29, new java.sql.Time(format.parse(bean.getEntrada_domingo()).getTime()));
            pstm.setTime(30, new java.sql.Time(format.parse(bean.getSaida_segunda()).getTime()));
            pstm.setTime(31, new java.sql.Time(format.parse(bean.getSaida_terca()).getTime()));
            pstm.setTime(32, new java.sql.Time(format.parse(bean.getSaida_quarta()).getTime()));
            pstm.setTime(33, new java.sql.Time(format.parse(bean.getSaida_quinta()).getTime()));
            pstm.setTime(34, new java.sql.Time(format.parse(bean.getSaida_sexta()).getTime()));
            pstm.setTime(35, new java.sql.Time(format.parse(bean.getSaida_sabado()).getTime()));
            pstm.setTime(36, new java.sql.Time(format.parse(bean.getSaida_domingo()).getTime()));
            pstm.setInt(37, bean.getIdestabelecimento());

            System.out.println("Script: " + pstm.toString());
            System.out.println("Alterando: " + bean);
            pstm.execute();
            commitTransacao(conn);
            System.out.println("Alteração executada com sucesso");
        } catch (Exception e) {
            rollbackTransacao(conn);
            throw new RuntimeException(e);
        } finally {
            fecharConexao(conn);
        }
    }

    public ArrayList<Estabelecimento> pesquisarEstabelecimentoUsuario(String pesquisa) {
        ArrayList<Estabelecimento> lista = new ArrayList<Estabelecimento>();

        Connection conn = null;
        try {
            conn = abrirConexao();

            System.out.println("1: " + pesquisa);
            PreparedStatement pstm = conn.prepareStatement("SELECT * FROM estabelecimento WHERE idusuario = ? order by idestabelecimento");
            pstm.setInt(1, Integer.parseInt(pesquisa));

            System.out.println("2: " + pesquisa);
            System.out.println(pstm.toString());
            System.out.println("Pesquisando: " + pesquisa);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                System.out.println("Registro encontrado");

                Estabelecimento estabelecimento = new Estabelecimento();
                estabelecimento.setIdestabelecimento(rs.getInt("idestabelecimento"));
                estabelecimento.setIdusuario(rs.getInt("idusuario"));
                estabelecimento.setIdtipoestabelecimento(rs.getInt("idtipoestabelecimento"));
                estabelecimento.setRazaosocial(rs.getString("razaoSocial"));
                estabelecimento.setCnpj(rs.getString("cnpj"));
                estabelecimento.setEstado(rs.getString("estado"));
                estabelecimento.setMunicipio(rs.getString("municipio"));
                estabelecimento.setBairro(rs.getString("bairro"));
                estabelecimento.setLogradouro(rs.getString("logradouro"));
                estabelecimento.setCep(rs.getInt("cep"));
                estabelecimento.setNumero(rs.getInt("numero"));
                estabelecimento.setReferencia(rs.getString("referencia"));
                estabelecimento.setLatitude(rs.getDouble("latitude"));
                estabelecimento.setLongitude(rs.getDouble("longitude"));
                estabelecimento.setValormeiahora(rs.getDouble("valormeiahora"));
                estabelecimento.setValorhora(rs.getDouble("valorhora"));
                estabelecimento.setValordiaria(rs.getDouble("valordiaria"));
                estabelecimento.setValormensal(rs.getDouble("valormensal"));
                estabelecimento.setValoradicional(rs.getDouble("valoradicional"));
                estabelecimento.setImagem(rs.getString("imagem"));
                estabelecimento.setVagastotal(rs.getInt("vagas_total"));
                estabelecimento.setVagasreservada(rs.getInt("vagas_reservada"));
                estabelecimento.setVagasdisponivel(rs.getInt("vagas_disponivel"));
                estabelecimento.setEntrada_segunda(rs.getString("entrada_segunda"));
                estabelecimento.setSaida_segunda(rs.getString("saida_segunda"));
                estabelecimento.setEntrada_terca(rs.getString("entrada_terca"));
                estabelecimento.setSaida_terca(rs.getString("saida_terca"));
                estabelecimento.setEntrada_quarta(rs.getString("entrada_quarta"));
                estabelecimento.setSaida_quarta(rs.getString("saida_quarta"));
                estabelecimento.setEntrada_quinta(rs.getString("entrada_quinta"));
                estabelecimento.setSaida_quinta(rs.getString("saida_quinta"));
                estabelecimento.setEntrada_sexta(rs.getString("entrada_sexta"));
                estabelecimento.setSaida_sexta(rs.getString("saida_sexta"));
                estabelecimento.setEntrada_sabado(rs.getString("entrada_sabado"));
                estabelecimento.setSaida_sabado(rs.getString("saida_sabado"));
                estabelecimento.setEntrada_domingo(rs.getString("entrada_domingo"));
                estabelecimento.setSaida_domingo(rs.getString("saida_domingo"));

                lista.add(estabelecimento);
                System.out.println(estabelecimento.toString());
            }
            System.out.println("Pesquisa executada com sucesso");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            fecharConexao(conn);
        }
        return lista;
    }

    public ArrayList<Estabelecimento> pesquisarEstabelecimento(String pesquisa) {
        ArrayList<Estabelecimento> lista = new ArrayList<Estabelecimento>();

        Connection conn = null;
        try {
            conn = abrirConexao();

            PreparedStatement pstm = conn.prepareStatement("SELECT * FROM estabelecimento WHERE razaoSocial like ? OR cnpj like ? order by idestabelecimento");
            pstm.setString(1, "%" + pesquisa + "%");
            pstm.setString(2, "%" + pesquisa + "%");

            System.out.println("Pesquisando: " + pesquisa);
            System.out.println(pstm.toString());
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                System.out.println("Registro encontrado");

                Estabelecimento estabelecimento = new Estabelecimento();
                estabelecimento.setIdestabelecimento(rs.getInt("idestabelecimento"));
                estabelecimento.setIdusuario(rs.getInt("idusuario"));
                estabelecimento.setIdtipoestabelecimento(rs.getInt("idtipoestabelecimento"));
                estabelecimento.setRazaosocial(rs.getString("razaoSocial"));
                estabelecimento.setCnpj(rs.getString("cnpj"));
                estabelecimento.setEstado(rs.getString("estado"));
                estabelecimento.setMunicipio(rs.getString("municipio"));
                estabelecimento.setBairro(rs.getString("bairro"));
                estabelecimento.setLogradouro(rs.getString("logradouro"));
                estabelecimento.setCep(rs.getInt("cep"));
                estabelecimento.setNumero(rs.getInt("numero"));
                estabelecimento.setReferencia(rs.getString("referencia"));
                estabelecimento.setLatitude(rs.getDouble("latitude"));
                estabelecimento.setLongitude(rs.getDouble("longitude"));
                estabelecimento.setValormeiahora(rs.getDouble("valormeiahora"));
                estabelecimento.setValorhora(rs.getDouble("valorhora"));
                estabelecimento.setValordiaria(rs.getDouble("valordiaria"));
                estabelecimento.setValormensal(rs.getDouble("valormensal"));
                estabelecimento.setValoradicional(rs.getDouble("valoradicional"));
                estabelecimento.setImagem(rs.getString("imagem"));
                estabelecimento.setVagastotal(rs.getInt("vagas_total"));
                estabelecimento.setVagasreservada(rs.getInt("vagas_reservada"));
                estabelecimento.setVagasdisponivel(rs.getInt("vagas_disponivel"));
                estabelecimento.setEntrada_segunda(rs.getString("entrada_segunda"));
                estabelecimento.setSaida_segunda(rs.getString("saida_segunda"));
                estabelecimento.setEntrada_terca(rs.getString("entrada_terca"));
                estabelecimento.setSaida_terca(rs.getString("saida_terca"));
                estabelecimento.setEntrada_quarta(rs.getString("entrada_quarta"));
                estabelecimento.setSaida_quarta(rs.getString("saida_quarta"));
                estabelecimento.setEntrada_quinta(rs.getString("entrada_quinta"));
                estabelecimento.setSaida_quinta(rs.getString("saida_quinta"));
                estabelecimento.setEntrada_sexta(rs.getString("entrada_sexta"));
                estabelecimento.setSaida_sexta(rs.getString("saida_sexta"));
                estabelecimento.setEntrada_sabado(rs.getString("entrada_sabado"));
                estabelecimento.setSaida_sabado(rs.getString("saida_sabado"));
                estabelecimento.setEntrada_domingo(rs.getString("entrada_domingo"));
                estabelecimento.setSaida_domingo(rs.getString("saida_domingo"));

                lista.add(estabelecimento);
                System.out.println(estabelecimento.toString());
            }
            System.out.println("Pesquisa executada com sucesso");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            fecharConexao(conn);
        }
        return lista;
    }

    public ArrayList<Estabelecimento> buscarTodosEstabelecimento() {
        ArrayList<Estabelecimento> lista = new ArrayList<Estabelecimento>();

        Connection conn = null;
        try {
            conn = abrirConexao();

            PreparedStatement pstm = conn.prepareStatement("select * from estabelecimento order by idestabelecimento");

            System.out.println("Pesquisando: ");
            System.out.println(pstm.toString());
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                System.out.println("Registro encontrado");

                Estabelecimento estabelecimento = new Estabelecimento();
                estabelecimento.setIdestabelecimento(rs.getInt("idestabelecimento"));
                estabelecimento.setIdusuario(rs.getInt("idusuario"));
                estabelecimento.setIdtipoestabelecimento(rs.getInt("idtipoestabelecimento"));
                estabelecimento.setRazaosocial(rs.getString("razaoSocial"));
                estabelecimento.setCnpj(rs.getString("cnpj"));
                estabelecimento.setEstado(rs.getString("estado"));
                estabelecimento.setMunicipio(rs.getString("municipio"));
                estabelecimento.setBairro(rs.getString("bairro"));
                estabelecimento.setLogradouro(rs.getString("logradouro"));
                estabelecimento.setCep(rs.getInt("cep"));
                estabelecimento.setNumero(rs.getInt("numero"));
                estabelecimento.setReferencia(rs.getString("referencia"));
                estabelecimento.setLatitude(rs.getDouble("latitude"));
                estabelecimento.setLongitude(rs.getDouble("longitude"));
                estabelecimento.setValormeiahora(rs.getDouble("valormeiahora"));
                estabelecimento.setValorhora(rs.getDouble("valorhora"));
                estabelecimento.setValordiaria(rs.getDouble("valordiaria"));
                estabelecimento.setValormensal(rs.getDouble("valormensal"));
                estabelecimento.setValoradicional(rs.getDouble("valoradicional"));
                estabelecimento.setImagem(rs.getString("imagem"));
                estabelecimento.setVagastotal(rs.getInt("vagas_total"));
                estabelecimento.setVagasreservada(rs.getInt("vagas_reservada"));
                estabelecimento.setVagasdisponivel(rs.getInt("vagas_disponivel"));
                estabelecimento.setEntrada_segunda(rs.getString("entrada_segunda"));
                estabelecimento.setSaida_segunda(rs.getString("saida_segunda"));
                estabelecimento.setEntrada_terca(rs.getString("entrada_terca"));
                estabelecimento.setSaida_terca(rs.getString("saida_terca"));
                estabelecimento.setEntrada_quarta(rs.getString("entrada_quarta"));
                estabelecimento.setSaida_quarta(rs.getString("saida_quarta"));
                estabelecimento.setEntrada_quinta(rs.getString("entrada_quinta"));
                estabelecimento.setSaida_quinta(rs.getString("saida_quinta"));
                estabelecimento.setEntrada_sexta(rs.getString("entrada_sexta"));
                estabelecimento.setSaida_sexta(rs.getString("saida_sexta"));
                estabelecimento.setEntrada_sabado(rs.getString("entrada_sabado"));
                estabelecimento.setSaida_sabado(rs.getString("saida_sabado"));
                estabelecimento.setEntrada_domingo(rs.getString("entrada_domingo"));
                estabelecimento.setSaida_domingo(rs.getString("saida_domingo"));

                lista.add(estabelecimento);
                System.out.println(estabelecimento.toString());
            }
            System.out.println("Pesquisa executada com sucesso");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            fecharConexao(conn);
        }
        return lista;
    }

}
