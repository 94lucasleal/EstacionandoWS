package com.lucas.senac.bd;

import com.lucas.senac.bean.Favoritos;
import com.lucas.senac.infra.CrudBD;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;

public class FavoritosBD extends CrudBD<Favoritos>{
    
    public void inserir(Favoritos favoritos) {
        Connection conn = null;
        try {
            conn = abrirConexao();

            PreparedStatement pstm = conn.prepareStatement("INSERT INTO favoritos(idestabelecimento, idusuario, ativo) VALUES (?,?,?)");
            pstm.setInt(1, favoritos.getIdestabelecimento());
            pstm.setInt(2, favoritos.getIdusuario());
            pstm.setString(3, String.valueOf(favoritos.getAtivo()));

            System.out.println("Salvando: " + favoritos);
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

    public void excluir(Favoritos bean) {
        Connection conn = null;
        try {
            conn = abrirConexao();

            PreparedStatement pstm = conn.prepareStatement("DELETE FROM favoritos WHERE idestabelecimento = ? AND idusuario = ?");
            pstm.setInt(1, bean.getIdestabelecimento());
            pstm.setInt(2, bean.getIdusuario());

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

    public Favoritos consultar(Favoritos bean) {
        Favoritos favoritosRetorno = null;

        Connection conn = null;
        try {
            conn = abrirConexao();

            PreparedStatement pstm = conn.prepareStatement("SELECT * FROM favoritos WHERE idestabelecimento = ? and idusuario = ?");
            pstm.setInt(1, bean.getIdestabelecimento());
            pstm.setInt(2, bean.getIdusuario());

            System.out.println("Consultando: " + bean);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                System.out.println("Registro encontrado");
                favoritosRetorno = new Favoritos();
                favoritosRetorno.setIdestabelecimento(rs.getInt("idestabelecimento"));
                favoritosRetorno.setIdusuario(rs.getInt("idusuario"));
                favoritosRetorno.setAtivo(rs.getString("ativo").charAt(0));
            }
            System.out.println("Consulta executada com sucesso");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            fecharConexao(conn);
        }

        return favoritosRetorno;
    }

    public void alterar(Favoritos bean) {
        Connection conn = null;
        try {
            conn = abrirConexao();

            PreparedStatement pstm = conn.prepareStatement("UPDATE favoritos SET ativo = ? WHERE idestabelecimento = ? and idusuario = ?");
            pstm.setString(1, String.valueOf(bean.getAtivo()));
            pstm.setInt(2, bean.getIdestabelecimento());
            pstm.setInt(3, bean.getIdusuario());

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

    public ArrayList<Favoritos> pesquisar(Favoritos bean) {
        ArrayList<Favoritos> lista = new ArrayList<Favoritos>();
        
        Connection conn = null;
        try {
            conn = abrirConexao();

            PreparedStatement pstm = conn.prepareStatement("SELECT * FROM favoritos WHERE idusuario = ?");
            pstm.setInt(1, bean.getIdusuario());

            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                System.out.println("Registro encontrado");
                
                Favoritos favoritos = new Favoritos();
                favoritos.setIdestabelecimento(rs.getInt("idestabelecimento"));
                favoritos.setIdusuario(rs.getInt("idusuario"));
                favoritos.setAtivo(rs.getString("ativo").charAt(0));

                lista.add(favoritos);
                System.out.println(favoritos.toString());
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


