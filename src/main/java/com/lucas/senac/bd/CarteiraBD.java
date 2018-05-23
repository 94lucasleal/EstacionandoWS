package com.lucas.senac.bd;

import com.lucas.senac.bean.Carteira;
import com.lucas.senac.infra.CrudBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CarteiraBD extends CrudBD<Carteira> {

    public void inserir(Carteira bean) {
        Connection conn = null;
        try {
            conn = abrirConexao();

            PreparedStatement pstm = conn.prepareStatement("INSERT INTO cartao(idusuario, saldo_disponivel, saldo_pendente) VALUES (?, ?, ?)");
            pstm.setInt(1, bean.getIdusuario());
            pstm.setFloat(2, bean.getSaldo_disponivel());
            pstm.setFloat(3, bean.getSaldo_pendente());

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

    public void excluir(Carteira bean) {
        Connection conn = null;
        try {
            conn = abrirConexao();

            PreparedStatement pstm = conn.prepareStatement("DELETE FROM carteira WHERE idcarteira=?");
            pstm.setInt(1, bean.getIdcarteira());

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

    public Carteira consultar(Carteira bean) {
        Carteira carteiraRetorno = null;
        Connection conn = null;
        try {
            conn = abrirConexao();

            PreparedStatement pstm = conn.prepareStatement("SELECT * FROM carteira WHERE idcarteira=?");
            pstm.setInt(1, bean.getIdcarteira());

            System.out.println("Consultando: " + bean);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                System.out.println("Registro encontrado");
                carteiraRetorno = new Carteira();
                carteiraRetorno.setIdcarteira(rs.getInt("idcarteira"));
                carteiraRetorno.setIdusuario(rs.getInt("idusuario"));
                carteiraRetorno.setSaldo_disponivel(rs.getFloat("saldo_disponivel"));
                carteiraRetorno.setSaldo_pendente(rs.getFloat("saldo_pendente"));
            }
            System.out.println("Consulta executada com sucesso");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            fecharConexao(conn);
        }
        return carteiraRetorno;
    }

    public void alterar(Carteira bean) {
        Connection conn = null;
        try {
            conn = abrirConexao();

            PreparedStatement pstm = conn.prepareStatement("UPDATE carteira SET idusuario=?, saldo_disponivel=?, saldo_pendente=? ");
            
            pstm.setInt(1, bean.getIdusuario());
            pstm.setFloat(2, bean.getSaldo_disponivel());
            pstm.setFloat(3, bean.getSaldo_pendente());
            
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

    public ArrayList<Carteira> pesquisar(String pesquisa) {
        ArrayList<Carteira> lista = new ArrayList<Carteira>();

        Connection conn = null;
        try {
            conn = abrirConexao();

            PreparedStatement pstm = conn.prepareStatement("SELECT * FROM carteira WHERE idusuario = ?");
            pstm.setInt(1, Integer.parseInt(pesquisa));

            System.out.println("Pesquisando: " + pesquisa);
            System.out.println(pstm.toString());
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                System.out.println("Registro encontrado");
                Carteira carteiraRetorno = new Carteira();
                carteiraRetorno.setIdcarteira(rs.getInt("idcarteira"));
                carteiraRetorno.setIdusuario(rs.getInt("idusuario"));
                carteiraRetorno.setSaldo_disponivel(rs.getFloat("saldo_disponivel"));
                carteiraRetorno.setSaldo_pendente(rs.getFloat("saldo_pendente"));

                lista.add(carteiraRetorno);
                System.out.println(carteiraRetorno.toString());
            }
            System.out.println("Pesquisa executada com sucesso");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            fecharConexao(conn);
        }
        return lista;
    }
    
    public ArrayList<Carteira> buscarTodos() {
        ArrayList<Carteira> lista = new ArrayList<Carteira>();

        Connection conn = null;
        try {
            conn = abrirConexao();

            PreparedStatement pstm = conn.prepareStatement("SELECT * FROM carteira");

            System.out.println("Pesquisando: ");
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                System.out.println("Registro encontrado");

                Carteira carteiraRetorno = new Carteira();
                carteiraRetorno.setIdcarteira(rs.getInt("idcarteira"));
                carteiraRetorno.setIdusuario(rs.getInt("idusuario"));
                carteiraRetorno.setSaldo_disponivel(rs.getFloat("saldo_disponivel"));
                carteiraRetorno.setSaldo_pendente(rs.getFloat("saldo_pendente"));

                lista.add(carteiraRetorno);
                System.out.println(carteiraRetorno.toString());
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
