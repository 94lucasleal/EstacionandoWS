package com.lucas.senac.infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe que, posteriormente, será utilizada para armazenar dados de conexão
 * com banco de dados.
 *
 * @author lossurdo
 */
public abstract class CrudBD<T> {

    String logger;

    protected final String BD_STRING_CONEXAO = "jdbc:postgresql://ec2-23-21-184-113.compute-1.amazonaws.com:5432/d62aoe0nomihrd?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";
    protected final String BD_USERNAME = "ggwdnhloaccvrd";
    protected final String BD_PASSWORD = "80003be419ede4c9ad33afc1d680d720493bf756508b5b8d63bc9eaab5505ef1";

    public CrudBD() {
       /*try {
            System.out.println("Identificando Driver JDBC");
            Class.forName("com.postgres.jdbc.Driver");
            System.out.println("Driver JDBC identificado com sucesso");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }*/
    }

    public Connection abrirConexao() {
        try {
            System.out.println("Abrindo a conexão com o banco de dados");
            final Connection conexao = DriverManager.getConnection(BD_STRING_CONEXAO, BD_USERNAME, BD_PASSWORD);

            /*
             Desliga o commit automático, deixando este controle 
             para o desenvolvedor...
             */
            conexao.setAutoCommit(false);

            return conexao;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            System.out.println("Conexão com o banco de dados aberta com sucesso!");
        }
    }

    protected void fecharConexao(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Conexão com o banco de dados encerrada com sucesso");
            }
        } catch (Exception e) {
            System.out.println("Problema ao fechar conexão com banco de dados");
        }
    }

    protected void commitTransacao(Connection connection) {
        if (connection != null) {
            try {
                connection.commit();
                System.out.println("COMMIT da transação efetuado");
            } catch (SQLException ex) {
                System.out.println("Problema ao efetuar COMMIT no banco de dados");
            }
        }
    }

    protected void rollbackTransacao(Connection connection) {
        if (connection != null) {
            try {
                connection.rollback();
                System.out.println("ROLLBACK da transação efetuado");
            } catch (SQLException ex) {
                System.out.println("Problema ao efetuar ROLLBACK no banco de dados");
            }
        }
    }
}
