package com.lucas.senac.bd;

import com.lucas.senac.bean.Cartao;
import com.lucas.senac.bean.Pagamento;
import com.lucas.senac.infra.CrudBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CartaoBD extends CrudBD<Cartao> {

    public void inserir(Pagamento bean) {
        Connection conn = null;
        try {
            conn = abrirConexao();

            PreparedStatement pstm = conn.prepareStatement("INSERT INTO pagamento(idestabelecimento, idusuario, product_id, amount,  "+
                    "installments, nsu, tid, authorization_code, acquirer_name, payment_method, status, refuse_reason, status_reason, card_brand, "+
                    "date_updated, date_created, boleto_url, boleto_barcode, dta_pagamento, dta_entrada, dta_saida) "+
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            
            pstm.setInt(1, bean.getIdestabelecimento());
            pstm.setInt(2, bean.getIdusuario());
            pstm.setString(3, bean.getProduct_id());
            pstm.setInt(4, bean.getAmount());
            pstm.setInt(5, bean.getInstallments());
            pstm.setString(6, bean.getNsu());
            pstm.setString(7, bean.getTid());
            pstm.setString(8, bean.getAuthorization_code());
            pstm.setString(9, bean.getAcquirer_name());
            pstm.setString(10, bean.getPayment_method());
            pstm.setString(11, bean.getStatus());
            pstm.setString(12, bean.getRefuse_reason());
            pstm.setString(13, bean.getStatus_reason());
            pstm.setString(14, bean.getCard_brand());
            pstm.setString(15, bean.getDate_updated());
            pstm.setString(16, bean.getDate_created());
            pstm.setString(17, bean.getBoleto_url());
            pstm.setString(18, bean.getBoleto_barcode());
            pstm.setTimestamp(19, new java.sql.Timestamp(bean.getDta_pagamento().getTime()));
            pstm.setTimestamp(20, new java.sql.Timestamp(bean.getDta_entrada().getTime()));
            pstm.setTimestamp(21, new java.sql.Timestamp(bean.getDta_saida().getTime()));
            
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

    public void excluirCartao(Cartao bean) {
        Connection conn = null;
        try {
            conn = abrirConexao();

            PreparedStatement pstm = conn.prepareStatement("DELETE FROM cartao WHERE idcartao=?");
            pstm.setInt(1, bean.getParcels());

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

    public Cartao consultarCartao(Cartao bean) {
        Cartao cartaoRetorno = null;

        Connection conn = null;
        try {
            conn = abrirConexao();

            PreparedStatement pstm = conn.prepareStatement("SELECT * FROM cartao WHERE idcartao=?");
            pstm.setInt(1, bean.getParcels());

            System.out.println("Consultando: " + bean);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                System.out.println("Registro encontrado");
                cartaoRetorno = new Cartao();
                cartaoRetorno.setParcels(rs.getInt("idcartao"));
                cartaoRetorno.setProduct_id(rs.getString("nometitular"));
                cartaoRetorno.setProduct_id(rs.getString("cpftitular"));
                cartaoRetorno.setProduct_id(rs.getString("numerocartao"));
            }
            System.out.println("Consulta executada com sucesso");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            fecharConexao(conn);
        }
        return cartaoRetorno;
    }

    public void alterarCartao(Cartao bean) {
        Connection conn = null;
        try {
            conn = abrirConexao();

            PreparedStatement pstm = conn.prepareStatement("UPDATE cartao SET nometitular = ?, cpftitular = ?, numerocartao = ? WHERE idcartao = ?");
            pstm.setString(1, bean.getProduct_id());
            pstm.setString(2, bean.getProduct_id());
            pstm.setString(3, bean.getProduct_id());
            pstm.setInt(4, bean.getParcels());

            System.out.println("Alterando: " + bean);
            pstm.execute();
            commitTransacao(conn);
            System.out.println("Alteração executada com sucesso");
            System.out.println(bean.toString());
        } catch (Exception e) {
            rollbackTransacao(conn);
            throw new RuntimeException(e);
        } finally {
            fecharConexao(conn);
        }
    }

    public ArrayList<Pagamento> pesquisar(String pesquisa) {
        ArrayList<Pagamento> lista = new ArrayList<Pagamento>();

        Connection conn = null;
        try {
            conn = abrirConexao();

            PreparedStatement pstm = conn.prepareStatement("SELECT * FROM pagamento WHERE idusuario = ? ORDER BY idpagamento");
            pstm.setInt(1, Integer.parseInt(pesquisa));


            System.out.println("Pesquisando: " + pesquisa);
            System.out.println(pstm.toString());
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                System.out.println("Registro encontrado");

                Pagamento pagamento = new Pagamento();
                pagamento.setIdpagamento(rs.getInt("idpagamento"));
                pagamento.setIdestabelecimento(rs.getInt("idestabelecimento"));
                pagamento.setIdusuario(rs.getInt("idusuario"));
                pagamento.setProduct_id(rs.getString("product_id"));
                pagamento.setAmount(rs.getInt("amount"));
                pagamento.setInstallments(rs.getInt("installments"));
                pagamento.setNsu(rs.getString("nsu"));
                pagamento.setTid(rs.getString("tid"));
                pagamento.setAuthorization_code(rs.getString("authorization_code"));
                pagamento.setAcquirer_name(rs.getString("acquirer_name"));
                pagamento.setPayment_method(rs.getString("payment_method"));
                pagamento.setStatus(rs.getString("status"));
                pagamento.setRefuse_reason(rs.getString("refuse_reason"));
                pagamento.setStatus_reason(rs.getString("status_reason"));
                pagamento.setCard_brand(rs.getString("card_brand"));
                pagamento.setDate_updated(rs.getString("date_updated"));
                pagamento.setDate_created(rs.getString("date_created"));
                pagamento.setBoleto_url(rs.getString("boleto_url"));
                pagamento.setBoleto_barcode(rs.getString("boleto_barcode"));
                pagamento.setDta_pagamento(rs.getTimestamp("dta_pagamento"));
                pagamento.setDta_entrada(rs.getTimestamp("dta_entrada"));
                pagamento.setDta_saida(rs.getTimestamp("dta_saida"));

                lista.add(pagamento);
                System.out.println(pagamento.toString());
            }
            System.out.println("Pesquisa executada com sucesso");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            fecharConexao(conn);
        }
        return lista;
    }

    public ArrayList<Cartao> buscarTodosCartao() {
        ArrayList<Cartao> lista = new ArrayList<Cartao>();

        Connection conn = null;
        try {
            conn = abrirConexao();

            PreparedStatement pstm = conn.prepareStatement("SELECT * FROM cartao");

            System.out.println("Pesquisando: ");
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                System.out.println("Registro encontrado");

                Cartao cartao = new Cartao();
                cartao.setParcels(rs.getInt("idcartao"));
                cartao.setProduct_id(rs.getString("nometitular"));
                cartao.setProduct_id(rs.getString("cpftitular"));
                cartao.setProduct_id(rs.getString("numerocartao"));

                lista.add(cartao);
                System.out.println(cartao.toString());
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
