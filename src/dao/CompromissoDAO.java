package dao;

import model.Compromisso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public static List<Compromisso> listarTodos() {

        try(Connection connection = Conexao.getConexao()) {

            String sql = "SELECT * FROM compromisso;";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();

            List<Compromisso> retorno = new ArrayList<>();
            while(result.next()) {
                Compromisso c = new Compromisso(result.getLong("id"), result.getString("nome"),
                    result.getString("descricao"), result.getString("data"),
                    result.getString("horario"), result.getString("nomeContato"),
                    result.getString("telefone"), result.getBoolean("situacao"));

                retorno.add(c);
            }

            return retorno;

        } catch(SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

}
