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
            pstm.setDate(19, new java.sql.Date(bean.getDta_pagamento().getTime()));
            pstm.setDate(20, new java.sql.Date(bean.getDta_entrada().getTime()));
            pstm.setDate(21, new java.sql.Date(bean.getDta_saida().getTime()));

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

    public ArrayList<Cartao> pesquisarCartao(String pesquisa) {
        ArrayList<Cartao> lista = new ArrayList<Cartao>();

        Connection conn = null;
        try {
            conn = abrirConexao();

            PreparedStatement pstm = conn.prepareStatement("SELECT * FROM cartao WHERE nometitular like ? OR cpftitular like ? OR numerocartao like ?");
            pstm.setString(1, "%" + pesquisa + "%");
            pstm.setString(2, "%" + pesquisa + "%");
            pstm.setString(3, "%" + pesquisa + "%");

            System.out.println("Pesquisando: " + pesquisa);
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
