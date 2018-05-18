package com.lucas.senac.bd;

import com.lucas.senac.bean.Feedback;
import com.lucas.senac.infra.CrudBD;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;

public class FeedbackBD extends CrudBD<Feedback>{
    
    public void inserir(Feedback bean) {
        Connection conn = null;
        try {
            conn = abrirConexao();

            PreparedStatement pstm = conn.prepareStatement("INSERT INTO feedback (idestabelecimento, nome, nota, descricao) VALUES (?,?,?,?)");
            pstm.setInt(1, bean.getIdestabelecimento());
            pstm.setString(2, bean.getNome());
            pstm.setDouble(3, bean.getNota());
            pstm.setString(4, bean.getDescricao());

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

    public void excluir(Feedback bean) {
        Connection conn = null;
        try {
            conn = abrirConexao();

            PreparedStatement pstm = conn.prepareStatement("DELETE FROM feedback WHERE idfeedback = ?");
            pstm.setInt(1, bean.getIdfeedback());

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

    public Feedback consultar(Feedback bean) {
        Feedback feedbackRetorno = null;

        Connection conn = null;
        try {
            conn = abrirConexao();

            PreparedStatement pstm = conn.prepareStatement("SELECT * FROM feedback WHERE idfeedback = ?");
            pstm.setInt(1, bean.getIdfeedback());
            
            System.out.println("Consultando: " + bean);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                System.out.println("Registro encontrado");
                feedbackRetorno = new Feedback();
                feedbackRetorno.setIdfeedback(rs.getInt("idfeedback"));
                feedbackRetorno.setIdestabelecimento(rs.getInt("idestabelecimento"));
                feedbackRetorno.setNome(rs.getString("nome"));
                feedbackRetorno.setNota(rs.getDouble("nota"));
                feedbackRetorno.setDescricao(rs.getString("descricao"));
            }
            System.out.println("Consulta executada com sucesso");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            fecharConexao(conn);
        }

        return feedbackRetorno;
    }

    public void alterar(Feedback bean) {
        Connection conn = null;
        try {
            conn = abrirConexao();

            PreparedStatement pstm = conn.prepareStatement("UPDATE feedback SET idfeedback = ?, idestabelecimento = ?, nome = ?, nota = ?, descricao = ? WHERE idfeedback = ?");
            pstm.setInt(3, bean.getIdfeedback());

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

    public ArrayList<Feedback> pesquisar(Feedback bean) {
        ArrayList<Feedback> lista = new ArrayList<Feedback>();
        
        Connection conn = null;
        try {
            conn = abrirConexao();

            PreparedStatement pstm = conn.prepareStatement("SELECT * FROM feedback WHERE idestabelecimento = ?");
            pstm.setInt(1, bean.getIdestabelecimento());
            
            System.out.println(pstm.toString());

            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                System.out.println("Registro encontrado");
                
                Feedback feedback = new Feedback();
                feedback.setIdfeedback(rs.getInt("idfeedback"));
                feedback.setIdestabelecimento(rs.getInt("idestabelecimento"));
                feedback.setNome(rs.getString("nome"));
                feedback.setNota(rs.getDouble("nota"));
                feedback.setDescricao(rs.getString("descricao"));

                lista.add(feedback);
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


