package dao;

import model.Compromisso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CompromissoDAO {

    public static boolean inserir(Compromisso c) {

        try(Connection connection = Conexao.getConexao()) {

            String sql = "INSERT INTO compromisso (nome, descricao, data, horario, nomeContato, telefone, situacao) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?);";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, c.getNomeCompromisso());
            statement.setString(2, c.getDescricao());
            statement.setString(3, c.getData());
            statement.setString(4, c.getHorario());
            statement.setString(5, c.getNomeContato());
            statement.setString(6, c.getTelefone());
            statement.setBoolean(7, c.isSituacao());
            statement.execute();

            System.out.println("Compromisso " + c.getNomeCompromisso() + " registrado com sucesso.");
            return true;
        } catch(SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

}
