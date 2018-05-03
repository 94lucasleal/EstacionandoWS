package com.lucas.senac.bd;

import com.lucas.senac.bean.Pagamento;
import com.lucas.senac.bean.Historico;
import com.lucas.senac.infra.CrudBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PagamentoBD extends CrudBD<Pagamento> {

    public void inserir(Historico bean) {
        Connection conn = null;
        try {
            conn = abrirConexao();

            PreparedStatement pstm = conn.prepareStatement("INSERT INTO pagamento(idestabelecimento, idusuario, product_id, amount,  "+
                    "installments, nsu, tid, authorization_code, acquirer_name, payment_method, status, refuse_reason, status_reason, card_brand, "+
                    "date_updated, date_created, boleto_url, boleto_barcode, dta_pagamento, dta_entrada, dta_saida) "+
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            
            System.out.println("21");
            pstm.setInt(1, bean.getEstabelecimento().getIdestabelecimento());
            System.out.println("22");
            pstm.setInt(2, bean.getUsuario().getIdUsuario());
            System.out.println("23");
            pstm.setString(3, "product_id");
            System.out.println("24");
            pstm.setInt(4, bean.getTrancasao().getAmount());
            System.out.println("25");
            pstm.setInt(5, bean.getTrancasao().getInstallments());
            System.out.println("26");
            pstm.setString(6, bean.getTrancasao().getNsu());
            System.out.println("27");
            pstm.setString(7, bean.getTrancasao().getTid());
            System.out.println("28");
            pstm.setString(8, "authorization_code");
            System.out.println("29");
            pstm.setString(9, bean.getTrancasao().getAcquirerName());
            System.out.println("30");
            pstm.setString(10, bean.getTrancasao().getPaymentMethod());
            System.out.println("31");
            pstm.setString(11, bean.getTrancasao().getStatus());
            System.out.println("32");
            pstm.setString(12, "refuse_reason");
            System.out.println("33");
            pstm.setString(13, bean.getTrancasao().getStatusReason());
            System.out.println("34");
            pstm.setString(14, bean.getTrancasao().getCard().getBrand());
            System.out.println("35");
            pstm.setString(15, bean.getTrancasao().getDateUpdated());
            System.out.println("36");
            pstm.setString(16, bean.getTrancasao().getDateCreated());
            System.out.println("37");
            pstm.setString(17, bean.getTrancasao().getBoletoUrl());
            System.out.println("38");
            pstm.setString(18, bean.getTrancasao().getBoletoBarcode());
            System.out.println("39");
            pstm.setTimestamp(19, new java.sql.Timestamp(bean.getDta_entrada().getTime()));
            System.out.println("40");
            pstm.setTimestamp(20, new java.sql.Timestamp(bean.getDta_entrada().getTime()));
            System.out.println("41");
            pstm.setTimestamp(21, new java.sql.Timestamp(bean.getDta_saida().getTime()));
            System.out.println("42");
            
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

    public void excluirCartao(Pagamento bean) {
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

    public Pagamento consultarCartao(Pagamento bean) {
        Pagamento cartaoRetorno = null;

        Connection conn = null;
        try {
            conn = abrirConexao();

            PreparedStatement pstm = conn.prepareStatement("SELECT * FROM cartao WHERE idcartao=?");
            pstm.setInt(1, bean.getParcels());

            System.out.println("Consultando: " + bean);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                System.out.println("Registro encontrado");
                cartaoRetorno = new Pagamento();
                cartaoRetorno.setParcels(rs.getInt("idcartao"));
                cartaoRetorno.setDta_entrada(rs.getString("nometitular"));
                cartaoRetorno.setDta_entrada(rs.getString("cpftitular"));
                cartaoRetorno.setDta_entrada(rs.getString("numerocartao"));
            }
            System.out.println("Consulta executada com sucesso");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            fecharConexao(conn);
        }
        return cartaoRetorno;
    }

    public void alterarCartao(Pagamento bean) {
        Connection conn = null;
        try {
            conn = abrirConexao();

            PreparedStatement pstm = conn.prepareStatement("UPDATE cartao SET nometitular = ?, cpftitular = ?, numerocartao = ? WHERE idcartao = ?");
            pstm.setString(1, bean.getDta_entrada());
            pstm.setString(2, bean.getDta_entrada());
            pstm.setString(3, bean.getDta_entrada());
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

    public ArrayList<Historico> pesquisar(String pesquisa) {
        ArrayList<Historico> lista = new ArrayList<Historico>();

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

                /*
                Historico pagamento = new Historico();
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
            */
            }
            System.out.println("Pesquisa executada com sucesso");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            fecharConexao(conn);
        }
        return lista;
    }

    public ArrayList<Pagamento> buscarTodosCartao() {
        ArrayList<Pagamento> lista = new ArrayList<Pagamento>();

        Connection conn = null;
        try {
            conn = abrirConexao();

            PreparedStatement pstm = conn.prepareStatement("SELECT * FROM cartao");

            System.out.println("Pesquisando: ");
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                System.out.println("Registro encontrado");

                Pagamento cartao = new Pagamento();
                cartao.setParcels(rs.getInt("idcartao"));
                cartao.setDta_entrada(rs.getString("nometitular"));
                cartao.setDta_entrada(rs.getString("cpftitular"));
                cartao.setDta_entrada(rs.getString("numerocartao"));

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
