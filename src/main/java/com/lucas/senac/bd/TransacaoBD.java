package com.lucas.senac.bd;

import com.lucas.senac.bean.Transacao;
import com.lucas.senac.estacionando3.utils.Hash;
import com.lucas.senac.infra.CrudBD;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TransacaoBD extends CrudBD<Transacao> {
    
    SimpleDateFormat formataa = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public void inserir(Transacao bean) {
        Connection conn = null;
        try {
            conn = abrirConexao();

            PreparedStatement pstm;

            System.out.println("teste1 :" + bean);

            System.out.println("4 - TESTE ");
            pstm = conn.prepareStatement("INSERT INTO transacao(idestabelecimento, idusuario, dta_entrada, "
                    + "dta_saida, amount, refunded_amount, authorized_amount, paid_amount, installments, cost, tid, nsu, boleto_url, "
                    + "boleto_barcode, referer, ip, acquirer_name, payment_method, status, status_reason, date_updated, "
                    + "customers_document, customers_name, customers_email, date_created, cartao_brand, cartao_first_digits, "
                    + "cartao_last_digits, cartao_name, cartao_valid, qrcode, id) VALUES (?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            if (bean.getIdestabelecimento() != null) {
                pstm.setInt(1, bean.getIdestabelecimento());
            } else {
                pstm.setObject(1, null);
            }
            if (bean.getIdusuario() != null) {
                pstm.setInt(2, bean.getIdusuario());
            } else {
                pstm.setObject(2, null);
            }
            if (bean.getDta_entrada() != null) {
                pstm.setTimestamp(3, new java.sql.Timestamp(format.parse(bean.getDta_entrada()).getTime()));
            } else {
                pstm.setObject(3, null);
            }
            if (bean.getDta_saida() != null) {
                pstm.setTimestamp(4, new java.sql.Timestamp(format.parse(bean.getDta_saida()).getTime()));
            } else {
                pstm.setObject(4, null);
            }
            if (bean.getAmount() != null) {
                pstm.setInt(5, bean.getAmount());
            } else {
                pstm.setObject(5, null);
            }
            if (bean.getRefunded_amount() != null) {
                pstm.setInt(6, bean.getRefunded_amount());
            } else {
                pstm.setObject(6, null);
            }
            if (bean.getAuthorized_amount() != null) {
                pstm.setInt(7, bean.getAuthorized_amount());
            } else {
                pstm.setObject(7, null);
            }
            if (bean.getPaid_amount() != null) {
                pstm.setInt(8, bean.getPaid_amount());
            } else {
                pstm.setObject(8, null);
            }
            if (bean.getInstallments() != null) {
                pstm.setInt(9, bean.getInstallments());
            } else {
                pstm.setObject(9, null);
            }
            if (bean.getCost() != null) {
                pstm.setInt(10, bean.getCost());
            } else {
                pstm.setObject(10, null);
            }
            if (bean.getTid() != null) {
                pstm.setString(11, bean.getTid());
            } else {
                pstm.setObject(11, null);
            }
            if (bean.getNsu() != null) {
                pstm.setString(12, bean.getNsu());
            } else {
                pstm.setObject(12, null);
            }
            if (bean.getBoleto_url() != null) {
                pstm.setString(13, bean.getBoleto_url());
            } else {
                pstm.setObject(13, null);
            }
            if (bean.getBoleto_barcode() != null) {
                pstm.setString(14, bean.getBoleto_barcode());
            } else {
                pstm.setObject(14, null);
            }
            if (bean.getReferer() != null) {
                pstm.setString(15, bean.getReferer());
            } else {
                pstm.setObject(15, null);
            }
            if (bean.getIp() != null) {
                pstm.setString(16, bean.getIp());
            } else {
                pstm.setObject(16, null);
            }
            if (bean.getAcquirer_name() != null) {
                pstm.setString(17, bean.getAcquirer_name());
            } else {
                pstm.setObject(17, null);
            }
            if (bean.getPayment_method() != null) {
                pstm.setString(18, bean.getPayment_method());
            } else {
                pstm.setObject(18, null);
            }
            if (bean.getStatus() != null) {
                pstm.setString(19, bean.getStatus());
            } else {
                pstm.setObject(19, null);
            }
            if (bean.getStatus_reason() != null) {
                pstm.setString(20, bean.getStatus_reason());
            } else {
                pstm.setObject(20, null);
            }
            if (bean.getDate_updated() != null) {
                pstm.setString(21, bean.getDate_updated());
            } else {
                pstm.setObject(21, null);
            }
            if (bean.getCustomers_document() != null) {
                pstm.setString(22, bean.getCustomers_document());
            } else {
                pstm.setObject(22, null);
            }
            if (bean.getCustomers_name() != null) {
                pstm.setString(23, bean.getCustomers_name());
            } else {
                pstm.setObject(23, null);
            }
            if (bean.getCustomers_email() != null) {
                pstm.setString(24, bean.getCustomers_email());
            } else {
                pstm.setObject(24, null);
            }
            if (bean.getDate_created() != null) {
                pstm.setString(25, bean.getDate_created());
            } else {
                pstm.setObject(25, null);
            }
            if (bean.getCartao_brand() != null) {
                pstm.setString(26, bean.getCartao_brand());
            } else {
                pstm.setObject(26, null);
            }
            if (bean.getCartao_first_digits() != null) {
                pstm.setString(27, bean.getCartao_first_digits());
            } else {
                pstm.setObject(27, null);
            }
            if (bean.getCartao_last_digits() != null) {
                pstm.setString(28, bean.getCartao_last_digits());
            } else {
                pstm.setObject(28, null);
            }
            if (bean.getCartao_name() != null) {
                pstm.setString(29, bean.getCartao_name());
            } else {
                pstm.setObject(29, null);
            }
            if (bean.getCartao_valid() != null) {
                pstm.setBoolean(30, bean.getCartao_valid());
            } else {
                pstm.setObject(30, null);
            }
            if (bean.getQrcode() != null) {
                pstm.setString(31, bean.getQrcode());
            } else {
                pstm.setObject(31, null);
            }
            if (bean.getId() != null) {
                pstm.setInt(32, bean.getId());
            } else {
                pstm.setObject(32, null);
            }


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
    
    public Transacao consultarQrCode(Transacao bean) {
        Transacao transacaoRetorno = null;
        Connection conn = null;
        try {
            conn = abrirConexao();
            Hash hash = new Hash();

            PreparedStatement pstm = conn.prepareStatement("SELECT * FROM transacao WHERE qrcode = ? AND idtransacao = ?");
            pstm.setString(1, bean.getQrcode());
            pstm.setString(2, hash.decrypt(bean.getQrcode()));

            System.out.println(pstm.toString());
            System.out.println("Consultando: " + bean);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                System.out.println("Registro encontrado");
                transacaoRetorno = new Transacao();
                transacaoRetorno.setIdtransacao(rs.getInt("idtransacao"));
                transacaoRetorno.setIdestabelecimento(rs.getInt("idestabelecimento"));
                transacaoRetorno.setIdusuario(rs.getInt("idusuario"));
                transacaoRetorno.setDta_entrada(rs.getString("dta_entrada"));
                transacaoRetorno.setDta_saida(rs.getString("dta_saida"));
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
                transacaoRetorno.setId(rs.getInt("id"));
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
                transacaoRetorno.setQrcode(rs.getString("qrcode"));
                System.out.println(transacaoRetorno);
            }
            System.out.println("Consulta executada com sucesso");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            fecharConexao(conn);
        }
        return transacaoRetorno;
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
                transacaoRetorno.setDta_entrada(rs.getString("dta_entrada"));
                transacaoRetorno.setDta_saida(rs.getString("dta_saida"));
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
                transacaoRetorno.setQrcode(rs.getString("qrcode"));
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
        Calendar dateTime = Calendar.getInstance();
        Connection conn = null;
        try {
            Date d1;
            conn = abrirConexao();

            PreparedStatement pstm = conn.prepareStatement("UPDATE transacao SET idestabelecimento = ?, idusuario = ?, dta_entrada = ?, "
                    + "dta_saida = ?, amount = ?, refunded_amount = ?, authorized_amount = ?, paid_amount = ?, installments = ?, cost = ?, tid = ?, nsu = ?, boleto_url = ?, "
                    + "boleto_barcode = ?, referer = ?, ip = ?, acquirer_name = ?, payment_method = ?, status = ?, status_reason = ?, date_updated = ?, "
                    + "customers_document = ?, customers_name = ?, customers_email = ?, date_created = ?, cartao_brand = ?, cartao_first_digits = ?, "
                    + "cartao_last_digits = ?, cartao_name = ?, cartao_valid = ?, qrcode = ?, dta_entrada_real = ?, dta_saida_prevista = ?, dta_saida_real = ?, utilizou_reserva = ? where idtransacao = ?");

            System.out.println("1");
            pstm.setInt(1, bean.getIdestabelecimento());
            System.out.println("2");
            pstm.setInt(2, bean.getIdusuario());
            System.out.println("3");
            System.out.println("4");
            pstm.setTimestamp(3, new java.sql.Timestamp(format.parse(bean.getDta_entrada()).getTime()));
            System.out.println("5");
            System.out.println("6");
            pstm.setTimestamp(4, new java.sql.Timestamp(format.parse(bean.getDta_saida()).getTime()));
            System.out.println("7");
            pstm.setInt(5, bean.getAmount());
            System.out.println("8");
            pstm.setInt(6, bean.getRefunded_amount());
            System.out.println("9");
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
            pstm.setString(31, bean.getQrcode());
            if (bean.getDta_entrada_real() != null) {
                pstm.setTimestamp(32, new java.sql.Timestamp(format.parse(bean.getDta_entrada_real()).getTime()));
            } else {
                pstm.setObject(32, null);
            }
            if (bean.getDta_saida_prevista() != null) {
                pstm.setTimestamp(33, new java.sql.Timestamp(format.parse(bean.getDta_saida_prevista()).getTime()));
            } else {
                pstm.setObject(33, null);
            }
            if (bean.getDta_saida_real() != null) {
                pstm.setTimestamp(34, new java.sql.Timestamp(format.parse(bean.getDta_saida_real()).getTime()));
            } else {
                pstm.setObject(34, null);
            }
            pstm.setBoolean(35, bean.getUtilizou_reserva());
            pstm.setInt(36, bean.getIdtransacao());

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
    
   public void estonarPagamento(Transacao bean) {
        Connection conn = null;
        try {
            Date d1;
            conn = abrirConexao();

            PreparedStatement pstm = conn.prepareStatement("UPDATE transacao SET estornado = ? where id = ?");
            pstm.setBoolean(1, bean.getEstornado());
            pstm.setInt(2, bean.getId());

            System.out.println("Estonando: " + bean);
            pstm.execute();
            commitTransacao(conn);
            System.out.println("Estorno realizado com sucesso");
            System.out.println(bean.toString());
        } catch (Exception e) {
            rollbackTransacao(conn);
            throw new RuntimeException(e);
        } finally {
            fecharConexao(conn);
        }
    }
    
    public ArrayList<Transacao> pesquisarReservas(String pesquisa) {
        ArrayList<Transacao> lista = new ArrayList<Transacao>();

        Connection conn = null;
        try {
            conn = abrirConexao();

            PreparedStatement pstm = conn.prepareStatement("SELECT * FROM transacao WHERE dta_entrada > now() AND idusuario = ?");
            pstm.setInt(1, Integer.parseInt(pesquisa));

            System.out.println(pstm.toString());
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                System.out.println("Registro encontrado");
                Transacao transacaoRetorno = new Transacao();
                transacaoRetorno.setIdtransacao(rs.getInt("idtransacao"));
                transacaoRetorno.setIdestabelecimento(rs.getInt("idestabelecimento"));
                transacaoRetorno.setIdusuario(rs.getInt("idusuario"));
                transacaoRetorno.setDta_entrada(rs.getString("dta_entrada"));
                transacaoRetorno.setDta_saida(rs.getString("dta_saida"));
                transacaoRetorno.setAmount(rs.getInt("amount"));
                transacaoRetorno.setRefunded_amount(rs.getInt("refunded_amount"));
                transacaoRetorno.setAuthorized_amount(rs.getInt("authorized_amount"));
                transacaoRetorno.setPaid_amount(rs.getInt("paid_amount"));
                transacaoRetorno.setInstallments(rs.getInt("installments"));
                transacaoRetorno.setCost(rs.getInt("cost"));
                transacaoRetorno.setTid(rs.getString("tid"));
                transacaoRetorno.setNsu(rs.getString("nsu"));
                transacaoRetorno.setId(rs.getInt("id"));
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
                transacaoRetorno.setQrcode(rs.getString("qrcode"));

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
    
    public ArrayList<Transacao> pesquisarVagasEfetivadas(long dtaentrada, long dtasaida, int idestabelecimento) {
        ArrayList<Transacao> lista = new ArrayList<Transacao>();
        
        Date d1 = new Date(dtaentrada);
        Date d2 = new Date(dtasaida);
        SimpleDateFormat isoFormat = new SimpleDateFormat("yyyy-MM-dd");
        TimeZone tz = TimeZone.getTimeZone("GMT-03:00");
	TimeZone.setDefault(tz);
        isoFormat.setTimeZone(tz);

        try {
           System.out.println("2 Entrada: "+isoFormat.format(d1));
           System.out.println("2 Saida: "+isoFormat.format(d2));
           d1 = new Date(isoFormat.parse(isoFormat.format(d1)).getTime());
           d2 = new Date(isoFormat.parse(isoFormat.format(d2)).getTime());
        } catch (ParseException ex) {
            System.out.println(ex.toString());
        }

        Connection conn = null;
        try {
            conn = abrirConexao();
            
            PreparedStatement pstm = conn.prepareStatement("SELECT * FROM transacao WHERE (dta_entrada > ? and dta_entrada < ?) and idestabelecimento = ? and utilizou_reserva = ? order by dta_entrada");
            pstm.setTimestamp(1, new Timestamp(d1.getTime()));
            pstm.setTimestamp(2, new Timestamp(d2.getTime()));
            pstm.setInt(3, idestabelecimento);
            pstm.setString(4, "true");
            
            System.out.println(pstm.toString());
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                System.out.println("Registro encontrado");
                Transacao transacaoRetorno = new Transacao();
                transacaoRetorno.setIdtransacao(rs.getInt("idtransacao"));
                transacaoRetorno.setIdestabelecimento(rs.getInt("idestabelecimento"));
                transacaoRetorno.setIdusuario(rs.getInt("idusuario"));
                transacaoRetorno.setDta_entrada(rs.getString("dta_entrada"));
                transacaoRetorno.setDta_saida(rs.getString("dta_saida"));
                transacaoRetorno.setAmount(rs.getInt("amount"));
                transacaoRetorno.setRefunded_amount(rs.getInt("refunded_amount"));
                transacaoRetorno.setAuthorized_amount(rs.getInt("authorized_amount"));
                transacaoRetorno.setPaid_amount(rs.getInt("paid_amount"));
                transacaoRetorno.setInstallments(rs.getInt("installments"));
                transacaoRetorno.setCost(rs.getInt("cost"));
                transacaoRetorno.setId(rs.getInt("id"));
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
                transacaoRetorno.setQrcode(rs.getString("qrcode"));

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
    
    public ArrayList<Transacao> pesquisarVagasAgendadas(long dtaentrada, long dtasaida, int idestabelecimento) {
        ArrayList<Transacao> lista = new ArrayList<Transacao>();
        
        Date d1 = new Date(dtaentrada);
        Date d2 = new Date(dtasaida);
        SimpleDateFormat isoFormat = new SimpleDateFormat("yyyy-MM-dd");
        TimeZone tz = TimeZone.getTimeZone("GMT-03:00");
	TimeZone.setDefault(tz);
        isoFormat.setTimeZone(tz);

        try {
           System.out.println("2 Entrada: "+isoFormat.format(d1));
           System.out.println("2 Saida: "+isoFormat.format(d2));
           d1 = new Date(isoFormat.parse(isoFormat.format(d1)).getTime());
           d2 = new Date(isoFormat.parse(isoFormat.format(d2)).getTime());
        } catch (ParseException ex) {
            System.out.println(ex.toString());
        }

        Connection conn = null;
        try {
            conn = abrirConexao();
            
            PreparedStatement pstm = conn.prepareStatement("SELECT * FROM transacao WHERE (dta_entrada > ? and dta_entrada < ?) and idestabelecimento = ? order by dta_entrada");
            pstm.setTimestamp(1, new Timestamp(d1.getTime()));
            pstm.setTimestamp(2, new Timestamp(d2.getTime()));
            pstm.setInt(3, idestabelecimento);
            
            System.out.println(pstm.toString());
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                System.out.println("Registro encontrado");
                Transacao transacaoRetorno = new Transacao();
                transacaoRetorno.setIdtransacao(rs.getInt("idtransacao"));
                transacaoRetorno.setIdestabelecimento(rs.getInt("idestabelecimento"));
                transacaoRetorno.setIdusuario(rs.getInt("idusuario"));
                transacaoRetorno.setDta_entrada(rs.getString("dta_entrada"));
                transacaoRetorno.setDta_saida(rs.getString("dta_saida"));
                transacaoRetorno.setAmount(rs.getInt("amount"));
                transacaoRetorno.setRefunded_amount(rs.getInt("refunded_amount"));
                transacaoRetorno.setAuthorized_amount(rs.getInt("authorized_amount"));
                transacaoRetorno.setPaid_amount(rs.getInt("paid_amount"));
                transacaoRetorno.setInstallments(rs.getInt("installments"));
                transacaoRetorno.setCost(rs.getInt("cost"));
                transacaoRetorno.setId(rs.getInt("id"));
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
                transacaoRetorno.setQrcode(rs.getString("qrcode"));

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
    
    public ArrayList<Transacao> pesquisarVagas(long dtaentrada, long dtasaida, int idestabelecimento) {
        ArrayList<Transacao> lista = new ArrayList<Transacao>();
        
        Date d1 = new Date(dtaentrada);
        Date d2 = new Date(dtasaida);
        SimpleDateFormat isoFormat = new SimpleDateFormat("yyyy-MM-dd");
        TimeZone tz = TimeZone.getTimeZone("GMT-03:00");
	TimeZone.setDefault(tz);
        isoFormat.setTimeZone(tz);

        try {
           System.out.println("2 Entrada: "+isoFormat.format(d1));
           System.out.println("2 Saida: "+isoFormat.format(d2));
           d1 = new Date(isoFormat.parse(isoFormat.format(d1)).getTime());
           d2 = new Date(isoFormat.parse(isoFormat.format(d2)).getTime());
        } catch (ParseException ex) {
            System.out.println(ex.toString());
        }

        Connection conn = null;
        try {
            conn = abrirConexao();

            PreparedStatement pstm = conn.prepareStatement("SELECT * FROM transacao WHERE (dta_entrada <= ? AND dta_saida >= ?) OR (dta_entrada <= ? AND dta_saida >= ?) and idestabelecimento = ?");
            pstm.setTimestamp(1, new Timestamp(d1.getTime()));
            pstm.setTimestamp(2, new Timestamp(d1.getTime()));
            pstm.setTimestamp(3, new Timestamp(d2.getTime()));
            pstm.setTimestamp(4, new Timestamp(d2.getTime()));
            pstm.setInt(5, idestabelecimento);

            System.out.println(pstm.toString());
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                System.out.println("Registro encontrado");
                Transacao transacaoRetorno = new Transacao();
                transacaoRetorno.setIdtransacao(rs.getInt("idtransacao"));
                transacaoRetorno.setIdestabelecimento(rs.getInt("idestabelecimento"));
                transacaoRetorno.setIdusuario(rs.getInt("idusuario"));
                transacaoRetorno.setDta_entrada(rs.getString("dta_entrada"));
                transacaoRetorno.setDta_saida(rs.getString("dta_saida"));
                transacaoRetorno.setAmount(rs.getInt("amount"));
                transacaoRetorno.setRefunded_amount(rs.getInt("refunded_amount"));
                transacaoRetorno.setAuthorized_amount(rs.getInt("authorized_amount"));
                transacaoRetorno.setPaid_amount(rs.getInt("paid_amount"));
                transacaoRetorno.setInstallments(rs.getInt("installments"));
                transacaoRetorno.setCost(rs.getInt("cost"));
                transacaoRetorno.setId(rs.getInt("id"));
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
                transacaoRetorno.setQrcode(rs.getString("qrcode"));

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
                transacaoRetorno.setDta_entrada(rs.getString("dta_entrada"));
                transacaoRetorno.setDta_saida(rs.getString("dta_saida"));
                transacaoRetorno.setAmount(rs.getInt("amount"));
                transacaoRetorno.setRefunded_amount(rs.getInt("refunded_amount"));
                transacaoRetorno.setAuthorized_amount(rs.getInt("authorized_amount"));
                transacaoRetorno.setPaid_amount(rs.getInt("paid_amount"));
                transacaoRetorno.setInstallments(rs.getInt("installments"));
                transacaoRetorno.setCost(rs.getInt("cost"));
                transacaoRetorno.setId(rs.getInt("id"));
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
                transacaoRetorno.setQrcode(rs.getString("qrcode"));

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
    
    

    public ArrayList<Transacao> pesquisarHistoricoUsuario(String pesquisa) {
        ArrayList<Transacao> lista = new ArrayList<Transacao>();

        Connection conn = null;
        try {
            conn = abrirConexao();

            PreparedStatement pstm = conn.prepareStatement("SELECT * FROM transacao WHERE idusuario = ? AND dta_entrada IS NOT NULL");
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
                transacaoRetorno.setDta_entrada(rs.getString("dta_entrada"));
                transacaoRetorno.setDta_saida(rs.getString("dta_saida"));
                transacaoRetorno.setAmount(rs.getInt("amount"));
                transacaoRetorno.setRefunded_amount(rs.getInt("refunded_amount"));
                transacaoRetorno.setAuthorized_amount(rs.getInt("authorized_amount"));
                transacaoRetorno.setPaid_amount(rs.getInt("paid_amount"));
                transacaoRetorno.setInstallments(rs.getInt("installments"));
                transacaoRetorno.setCost(rs.getInt("cost"));
                transacaoRetorno.setTid(rs.getString("tid"));
                transacaoRetorno.setId(rs.getInt("id"));
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
                transacaoRetorno.setQrcode(rs.getString("qrcode"));

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
                transacaoRetorno.setDta_entrada(rs.getString("dta_entrada"));
                transacaoRetorno.setDta_saida(rs.getString("dta_saida"));
                transacaoRetorno.setAmount(rs.getInt("amount"));
                transacaoRetorno.setRefunded_amount(rs.getInt("refunded_amount"));
                transacaoRetorno.setAuthorized_amount(rs.getInt("authorized_amount"));
                transacaoRetorno.setPaid_amount(rs.getInt("paid_amount"));
                transacaoRetorno.setInstallments(rs.getInt("installments"));
                transacaoRetorno.setCost(rs.getInt("cost"));
                transacaoRetorno.setId(rs.getInt("id"));
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
                transacaoRetorno.setQrcode(rs.getString("qrcode"));

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
