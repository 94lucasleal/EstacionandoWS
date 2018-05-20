package com.lucas.senac.bd;

import com.lucas.senac.bean.Transacao;
import com.lucas.senac.infra.CrudBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class TransacaoBD extends CrudBD<Transacao> {

    public void inserir(Transacao bean) {
        Connection conn = null;
        try {
            conn = abrirConexao();

            PreparedStatement pstm = conn.prepareStatement("INSERT INTO transacao(idestabelecimento, idusuario, dta_entrada, "
                    + "dta_saida, amount, refunded_amount, authorized_amount, paid_amount, installments, cost, tid, nsu, boleto_url, "
                    + "boleto_barcode, referer, ip, acquirer_name, payment_method, status, status_reason, date_updated, "
                    + "customers_document, customers_name, customers_email, date_created, cartao_brand, cartao_first_digits, "
                    + "cartao_last_digits, cartao_name, cartao_valid) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            pstm.setInt(1, bean.getIdestabelecimento());
            pstm.setInt(2, bean.getIdusuario());
            pstm.setTimestamp(3, new java.sql.Timestamp(bean.getDta_entrada().getTime()));
            pstm.setTimestamp(4, new java.sql.Timestamp(bean.getDta_saida().getTime()));
            pstm.setInt(5, bean.getAmount());
            pstm.setInt(6, bean.getRefunded_amount());
            pstm.setInt(7, bean.getAuthorized_amount());
            pstm.setInt(8, bean.getPaid_amount());
            pstm.setInt(9, bean.getInstallments());
            pstm.setInt(10, bean.getCost());
            pstm.setString(11, bean.getTid());
            pstm.setString(12, bean.getNsu());
            pstm.setString(13, bean.getBoleto_url());
            pstm.setString(14, bean.getBoleto_barcode());
            pstm.setString(15, bean.getReferer());
            pstm.setString(16, bean.getIp());
            pstm.setString(17, bean.getAcquirer_name());
            pstm.setString(18, bean.getPayment_method());
            pstm.setString(19, bean.getStatus());
            pstm.setString(20, bean.getStatus_reason());
            pstm.setString(21, bean.getDate_updated());
            pstm.setString(22, bean.getCustomers_document());
            pstm.setString(23, bean.getCustomers_name());
            pstm.setString(24, bean.getCustomers_email());
            pstm.setString(25, bean.getDate_created());
            pstm.setString(26, bean.getCartao_brand());
            pstm.setString(27, bean.getCartao_first_digits());
            pstm.setString(28, bean.getCartao_last_digits());
            pstm.setString(29, bean.getCartao_name());
            pstm.setBoolean(30, bean.getCartao_valid());

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

    public void excluir(Transacao bean) {
        Connection conn = null;
        try {
            conn = abrirConexao();

            PreparedStatement pstm = conn.prepareStatement("DELETE FROM transacao WHERE idtransacao=?");
            pstm.setInt(1, bean.getIdtransacao());

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

    public Transacao consultar(Transacao bean) {
        Transacao transacaoRetorno = null;
        Connection conn = null;
        try {
            conn = abrirConexao();

            PreparedStatement pstm = conn.prepareStatement("SELECT * FROM transacao WHERE idtransacao=?");
            pstm.setInt(1, bean.getIdtransacao());

            System.out.println("Consultando: " + bean);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                System.out.println("Registro encontrado");
                transacaoRetorno = new Transacao();
                transacaoRetorno.setIdtransacao(rs.getInt("idtransacao"));
                transacaoRetorno.setIdestabelecimento(rs.getInt("idestabelecimento"));
                transacaoRetorno.setIdusuario(rs.getInt("idusuario"));
                transacaoRetorno.setDta_entrada(rs.getTimestamp("dta_entrada"));
                transacaoRetorno.setDta_saida(rs.getTimestamp("dta_saida"));
                transacaoRetorno.setAmount(rs.getInt("amount"));
                transacaoRetorno.setRefunded_amount(rs.getInt("refunded_amount"));
                transacaoRetorno.setAuthorized_amount(rs.getInt("authorized_amount"));
                transacaoRetorno.setPaid_amount(rs.getInt("paid_amount"));
                transacaoRetorno.setInstallments(rs.getInt("installments"));
                transacaoRetorno.setCost(rs.getInt("cost"));
                transacaoRetorno.setTid(rs.getString("tid"));
                transacaoRetorno.setNsu(rs.getString("nsu"));
                transacaoRetorno.setBoleto_url(rs.getString("boleto_url"));
                transacaoRetorno.setBoleto_barcode(rs.getString("boleto_barcode"));
                transacaoRetorno.setReferer(rs.getString("referer"));
                transacaoRetorno.setIp(rs.getString("ip"));
                transacaoRetorno.setAcquirer_name(rs.getString("acquirer_name"));
                transacaoRetorno.setPayment_method(rs.getString("payment_method"));
                transacaoRetorno.setStatus(rs.getString("status"));
                transacaoRetorno.setStatus_reason(rs.getString("status_reason"));
                transacaoRetorno.setDate_updated(rs.getString("date_updated"));
                transacaoRetorno.setCustomers_document(rs.getString("customers_document"));
                transacaoRetorno.setCustomers_name(rs.getString("customers_name"));
                transacaoRetorno.setCustomers_email(rs.getString("customers_email"));
                transacaoRetorno.setDate_created(rs.getString("date_created"));
                transacaoRetorno.setCartao_brand(rs.getString("cartao_brand"));
                transacaoRetorno.setCartao_first_digits(rs.getString("cartao_first_digits"));
                transacaoRetorno.setCartao_last_digits(rs.getString("cartao_last_digits"));
                transacaoRetorno.setCartao_name(rs.getString("cartao_name"));
                transacaoRetorno.setCartao_valid(rs.getBoolean("cartao_valid"));
            }
            System.out.println("Consulta executada com sucesso");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            fecharConexao(conn);
        }
        return transacaoRetorno;
    }

    public void alterar(Transacao bean) {
        Connection conn = null;
        try {
            conn = abrirConexao();

            PreparedStatement pstm = conn.prepareStatement("UPDATE transacao SET idestabelecimento = ?, idusuario = ?, dta_entrada = ?, "
                    + "dta_saida = ?, amount = ?, refunded_amount = ?, authorized_amount = ?, paid_amount = ?, installments = ?, cost = ?, tid = ?, nsu = ?, boleto_url = ?, "
                    + "boleto_barcode = ?, referer = ?, ip = ?, acquirer_name = ?, payment_method = ?, status = ?, status_reason = ?, date_updated = ?, "
                    + "customers_document = ?, customers_name = ?, customers_email = ?, date_created = ?, cartao_brand = ?, cartao_first_digits = ?, "
                    + "cartao_last_digits = ?, cartao_name = ?, cartao_valid = ? where idtransacao = ?");
            
            pstm.setInt(1, bean.getIdestabelecimento());
            pstm.setInt(2, bean.getIdusuario());
            pstm.setTimestamp(3, new java.sql.Timestamp(bean.getDta_entrada().getTime()));
            pstm.setTimestamp(4, new java.sql.Timestamp(bean.getDta_saida().getTime()));
            pstm.setInt(5, bean.getAmount());
            pstm.setInt(6, bean.getRefunded_amount());
            pstm.setInt(7, bean.getAuthorized_amount());
            pstm.setInt(8, bean.getPaid_amount());
            pstm.setInt(9, bean.getInstallments());
            pstm.setInt(10, bean.getCost());
            pstm.setString(11, bean.getTid());
            pstm.setString(12, bean.getNsu());
            pstm.setString(13, bean.getBoleto_url());
            pstm.setString(14, bean.getBoleto_barcode());
            pstm.setString(15, bean.getReferer());
            pstm.setString(16, bean.getIp());
            pstm.setString(17, bean.getAcquirer_name());
            pstm.setString(18, bean.getPayment_method());
            pstm.setString(19, bean.getStatus());
            pstm.setString(20, bean.getStatus_reason());
            pstm.setString(21, bean.getDate_updated());
            pstm.setString(22, bean.getCustomers_document());
            pstm.setString(23, bean.getCustomers_name());
            pstm.setString(24, bean.getCustomers_email());
            pstm.setString(25, bean.getDate_created());
            pstm.setString(26, bean.getCartao_brand());
            pstm.setString(27, bean.getCartao_first_digits());
            pstm.setString(28, bean.getCartao_last_digits());
            pstm.setString(29, bean.getCartao_name());
            pstm.setBoolean(30, bean.getCartao_valid());
            pstm.setInt(31, bean.getIdtransacao());
            
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

    public ArrayList<Transacao> pesquisar(String pesquisa) {
        ArrayList<Transacao> lista = new ArrayList<Transacao>();

        Connection conn = null;
        try {
            conn = abrirConexao();

            PreparedStatement pstm = conn.prepareStatement("SELECT * FROM transacao WHERE idestabelecimento = ?");
            pstm.setInt(1, Integer.parseInt(pesquisa));

            System.out.println("Pesquisando: " + pesquisa);
            System.out.println(pstm.toString());
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                System.out.println("Registro encontrado");
                Transacao transacaoRetorno = new Transacao();
                transacaoRetorno.setIdtransacao(rs.getInt("idtransacao"));
                transacaoRetorno.setIdestabelecimento(rs.getInt("idestabelecimento"));
                transacaoRetorno.setIdusuario(rs.getInt("idusuario"));
                transacaoRetorno.setDta_entrada(rs.getTimestamp("dta_entrada"));
                transacaoRetorno.setDta_saida(rs.getTimestamp("dta_saida"));
                transacaoRetorno.setAmount(rs.getInt("amount"));
                transacaoRetorno.setRefunded_amount(rs.getInt("refunded_amount"));
                transacaoRetorno.setAuthorized_amount(rs.getInt("authorized_amount"));
                transacaoRetorno.setPaid_amount(rs.getInt("paid_amount"));
                transacaoRetorno.setInstallments(rs.getInt("installments"));
                transacaoRetorno.setCost(rs.getInt("cost"));
                transacaoRetorno.setTid(rs.getString("tid"));
                transacaoRetorno.setNsu(rs.getString("nsu"));
                transacaoRetorno.setBoleto_url(rs.getString("boleto_url"));
                transacaoRetorno.setBoleto_barcode(rs.getString("boleto_barcode"));
                transacaoRetorno.setReferer(rs.getString("referer"));
                transacaoRetorno.setIp(rs.getString("ip"));
                transacaoRetorno.setAcquirer_name(rs.getString("acquirer_name"));
                transacaoRetorno.setPayment_method(rs.getString("payment_method"));
                transacaoRetorno.setStatus(rs.getString("status"));
                transacaoRetorno.setStatus_reason(rs.getString("status_reason"));
                transacaoRetorno.setDate_updated(rs.getString("date_updated"));
                transacaoRetorno.setCustomers_document(rs.getString("customers_document"));
                transacaoRetorno.setCustomers_name(rs.getString("customers_name"));
                transacaoRetorno.setCustomers_email(rs.getString("customers_email"));
                transacaoRetorno.setDate_created(rs.getString("date_created"));
                transacaoRetorno.setCartao_brand(rs.getString("cartao_brand"));
                transacaoRetorno.setCartao_first_digits(rs.getString("cartao_first_digits"));
                transacaoRetorno.setCartao_last_digits(rs.getString("cartao_last_digits"));
                transacaoRetorno.setCartao_name(rs.getString("cartao_name"));
                transacaoRetorno.setCartao_valid(rs.getBoolean("cartao_valid"));

                lista.add(transacaoRetorno);
                System.out.println(transacaoRetorno.toString());
            }
            System.out.println("Pesquisa executada com sucesso");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            fecharConexao(conn);
        }
        return lista;
    }

    public ArrayList<Transacao> buscarTodos() {
        ArrayList<Transacao> lista = new ArrayList<Transacao>();

        Connection conn = null;
        try {
            conn = abrirConexao();

            PreparedStatement pstm = conn.prepareStatement("SELECT * FROM transacao");

            System.out.println("Pesquisando: ");
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                System.out.println("Registro encontrado");

                Transacao transacaoRetorno = new Transacao();
                transacaoRetorno.setIdtransacao(rs.getInt("idtransacao"));
                transacaoRetorno.setIdestabelecimento(rs.getInt("idestabelecimento"));
                transacaoRetorno.setIdusuario(rs.getInt("idusuario"));
                transacaoRetorno.setDta_entrada(rs.getTimestamp("dta_entrada"));
                transacaoRetorno.setDta_saida(rs.getTimestamp("dta_saida"));
                transacaoRetorno.setAmount(rs.getInt("amount"));
                transacaoRetorno.setRefunded_amount(rs.getInt("refunded_amount"));
                transacaoRetorno.setAuthorized_amount(rs.getInt("authorized_amount"));
                transacaoRetorno.setPaid_amount(rs.getInt("paid_amount"));
                transacaoRetorno.setInstallments(rs.getInt("installments"));
                transacaoRetorno.setCost(rs.getInt("cost"));
                transacaoRetorno.setTid(rs.getString("tid"));
                transacaoRetorno.setNsu(rs.getString("nsu"));
                transacaoRetorno.setBoleto_url(rs.getString("boleto_url"));
                transacaoRetorno.setBoleto_barcode(rs.getString("boleto_barcode"));
                transacaoRetorno.setReferer(rs.getString("referer"));
                transacaoRetorno.setIp(rs.getString("ip"));
                transacaoRetorno.setAcquirer_name(rs.getString("acquirer_name"));
                transacaoRetorno.setPayment_method(rs.getString("payment_method"));
                transacaoRetorno.setStatus(rs.getString("status"));
                transacaoRetorno.setStatus_reason(rs.getString("status_reason"));
                transacaoRetorno.setDate_updated(rs.getString("date_updated"));
                transacaoRetorno.setCustomers_document(rs.getString("customers_document"));
                transacaoRetorno.setCustomers_name(rs.getString("customers_name"));
                transacaoRetorno.setCustomers_email(rs.getString("customers_email"));
                transacaoRetorno.setDate_created(rs.getString("date_created"));
                transacaoRetorno.setCartao_brand(rs.getString("cartao_brand"));
                transacaoRetorno.setCartao_first_digits(rs.getString("cartao_first_digits"));
                transacaoRetorno.setCartao_last_digits(rs.getString("cartao_last_digits"));
                transacaoRetorno.setCartao_name(rs.getString("cartao_name"));
                transacaoRetorno.setCartao_valid(rs.getBoolean("cartao_valid"));

                lista.add(transacaoRetorno);
                System.out.println(transacaoRetorno.toString());
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
