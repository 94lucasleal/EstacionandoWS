package com.lucas.senac.bd;

import com.lucas.senac.bean.Servico;
import com.lucas.senac.bean.Usuario;
import com.lucas.senac.infra.CrudBD;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ServicoBD extends CrudBD<Usuario>{
    
    public void inserirServico(Servico bean) {
        Connection conn = null;
        try {
            conn = abrirConexao();

            PreparedStatement pstm = conn.prepareStatement("INSERT INTO servico (idestabelecimento, nome, descricao, preco) VALUES (?,?,?,?)");
            pstm.setInt(1, bean.getIdestabelecimento());
            pstm.setString(2, bean.getNome());
            pstm.setString(3, bean.getDescricao());
            pstm.setDouble(4, bean.getPreco());

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

    public void excluirServico(Servico bean) {
        Connection conn = null;
        try {
            conn = abrirConexao();

            PreparedStatement pstm = conn.prepareStatement("DELETE FROM servico WHERE idservico = ?");
            pstm.setInt(1, bean.getIdservico());

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

    public ArrayList<Servico> consultarServico(Servico bean) {
        ArrayList<Servico> lista = new ArrayList<Servico>();

        Connection conn = null;
        try {
            conn = abrirConexao();

            PreparedStatement pstm = conn.prepareStatement("SELECT * FROM servico WHERE idestabelecimento = ?");
            pstm.setInt(1, bean.getIdestabelecimento());

            System.out.println("Pesquisando: ");
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                System.out.println("Registro encontrado");
                
                Servico servico = new Servico();
                servico.setIdservico(rs.getInt("idservico"));
                servico.setIdestabelecimento(rs.getInt("idestabelecimento"));
                servico.setNome(rs.getString("nome"));
                servico.setDescricao(rs.getString("descricao"));
                servico.setPreco(rs.getDouble("preco"));
                lista.add(servico);
            }
            System.out.println("Pesquisa executada com sucesso");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            fecharConexao(conn);
        }
        return lista;
    }

    public void alterarServico(Servico bean) {
        Connection conn = null;
        try {
            conn = abrirConexao();

            PreparedStatement pstm = conn.prepareStatement("UPDATE usuario SET idestabelecimento = ?, nome = ?, descricao = ?, preco = ? WHERE idservico = ?");
            pstm.setInt(1, bean.getIdestabelecimento());
            pstm.setString(2, bean.getNome());
            pstm.setString(3, bean.getDescricao());
            pstm.setDouble(4, bean.getPreco());
            pstm.setInt(5, bean.getIdservico());

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

    public ArrayList<Servico> buscarTodosServicos() {
        ArrayList<Servico> lista = new ArrayList<Servico>();

        Connection conn = null;
        try {
            conn = abrirConexao();

            PreparedStatement pstm = conn.prepareStatement("SELECT * FROM servico order by idservico");

            System.out.println("Pesquisando: ");
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                System.out.println("Registro encontrado");
                
                Servico servico = new Servico();
                servico.setIdservico(rs.getInt("idservico"));
                servico.setIdestabelecimento(rs.getInt("idestabelecimento"));
                servico.setNome(rs.getString("nome"));
                servico.setDescricao(rs.getString("descricao"));
                servico.setPreco(rs.getDouble("preco"));
                lista.add(servico);
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


