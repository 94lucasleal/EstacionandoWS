package com.lucas.senac.bd;

import com.lucas.senac.bean.Cartao;
import com.lucas.senac.infra.CrudBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CartaoBD extends CrudBD<Cartao> {

    public void inserirCartao(Cartao bean) {
        Connection conn = null;
        try {
            conn = abrirConexao();

            PreparedStatement pstm = conn.prepareStatement("INSERT INTO cartao(nometitular, cpftitular, numerocartao) VALUES (?,?,?)");
            pstm.setString(1, bean.getNomeTitular());
            pstm.setString(2, bean.getCpfTitular());
            pstm.setString(3, bean.getNumeroCartao());

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
            pstm.setInt(1, bean.getIdCartao());

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
            pstm.setInt(1, bean.getIdCartao());

            System.out.println("Consultando: " + bean);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                System.out.println("Registro encontrado");
                cartaoRetorno = new Cartao();
                cartaoRetorno.setIdCartao(rs.getInt("idcartao"));
                cartaoRetorno.setNomeTitular(rs.getString("nometitular"));
                cartaoRetorno.setCpfTitular(rs.getString("cpftitular"));
                cartaoRetorno.setNumeroCartao(rs.getString("numerocartao"));
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
            pstm.setString(1, bean.getNomeTitular());
            pstm.setString(2, bean.getCpfTitular());
            pstm.setString(3, bean.getNumeroCartao());
            pstm.setInt(4, bean.getIdCartao());

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
                cartao.setIdCartao(rs.getInt("idcartao"));
                cartao.setNomeTitular(rs.getString("nometitular"));
                cartao.setCpfTitular(rs.getString("cpftitular"));
                cartao.setNumeroCartao(rs.getString("numerocartao"));

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
                cartao.setIdCartao(rs.getInt("idcartao"));
                cartao.setNomeTitular(rs.getString("nometitular"));
                cartao.setCpfTitular(rs.getString("cpftitular"));
                cartao.setNumeroCartao(rs.getString("numerocartao"));

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
