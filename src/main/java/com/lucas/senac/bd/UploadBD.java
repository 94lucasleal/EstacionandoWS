package com.lucas.senac.bd;

import com.lucas.senac.bean.Upload;
import com.lucas.senac.infra.CrudBD;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UploadBD extends CrudBD<Upload>{
    
    public void inserir(Upload upload) {
        Connection conn = null;
        try {
            conn = abrirConexao();

            PreparedStatement pstm = conn.prepareStatement("INSERT INTO teste (imagem) VALUES (?)");
            pstm.setBytes(1, upload.getImagem());

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

    public Upload consultar(Upload bean) {
        Upload uploadRetorno = null;

        Connection conn = null;
        try {
            conn = abrirConexao();

            PreparedStatement pstm = conn.prepareStatement("SELECT * FROM teste WHERE id = ?");
            pstm.setInt(1, bean.getId());

            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                System.out.println("Registro encontrado");
                uploadRetorno = new Upload();
                uploadRetorno.setId(rs.getInt("id"));
                uploadRetorno.setImagem(rs.getBytes("imagem"));
            }
            System.out.println("Consulta executada com sucesso");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            fecharConexao(conn);
        }

        return uploadRetorno;
    }
}


