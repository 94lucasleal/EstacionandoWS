package com.lucas.senac.bd;

import com.lucas.senac.bean.Estabelecimento;
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

    public ArrayList<Estabelecimento> pesquisar(Favoritos bean) {
        ArrayList<Estabelecimento> lista = new ArrayList<Estabelecimento>();
        
        Connection conn = null;
        try {
            conn = abrirConexao();

            PreparedStatement pstm = conn.prepareStatement("SELECT esta.* FROM favoritos fav, estabelecimento esta WHERE fav.idestabelecimento = esta.idestabelecimento AND fav.ativo = 'S' AND fav.idusuario = ? ");
            pstm.setInt(1, bean.getIdusuario());

            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                System.out.println("Registro encontrado");
                
                Estabelecimento estabelecimento = new Estabelecimento();
                estabelecimento.setIdestabelecimento(rs.getInt("idestabelecimento"));
                estabelecimento.setIdusuario(rs.getInt("idusuario"));
                estabelecimento.setIdtipoestabelecimento(rs.getInt("idtipoestabelecimento"));
                estabelecimento.setRazaosocial(rs.getString("razaoSocial"));
                estabelecimento.setCnpj(rs.getString("cnpj"));
                estabelecimento.setEstado(rs.getString("estado"));
                estabelecimento.setMunicipio(rs.getString("municipio"));
                estabelecimento.setBairro(rs.getString("bairro"));
                estabelecimento.setLogradouro(rs.getString("logradouro"));
                estabelecimento.setCep(rs.getInt("cep"));
                estabelecimento.setNumero(rs.getInt("numero"));
                estabelecimento.setReferencia(rs.getString("referencia"));
                estabelecimento.setLatitude(rs.getDouble("latitude"));
                estabelecimento.setLongitude(rs.getDouble("longitude"));
                estabelecimento.setValormeiahora(rs.getDouble("valormeiahora"));
                estabelecimento.setValorhora(rs.getDouble("valorhora"));
                estabelecimento.setValordiaria(rs.getDouble("valordiaria"));
                estabelecimento.setValormensal(rs.getDouble("valormensal"));
                estabelecimento.setValoradicional(rs.getDouble("valoradicional"));
                estabelecimento.setImagem(rs.getString("imagem"));
                estabelecimento.setVagastotal(rs.getInt("vagas_total"));
                estabelecimento.setVagasreservada(rs.getInt("vagas_reservada"));
                estabelecimento.setVagasdisponivel(rs.getInt("vagas_disponivel"));

                lista.add(estabelecimento);
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


