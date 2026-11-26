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

    public static boolean atualizar(Compromisso c) {
        try(Connection conexao = Conexao.getConexao()) {

            String sql = "UPDATE compromisso SET nome=?, descricao=?, data=?, horario=?, nomeContato=?, telefone=?, " +
                    "situacao=? WHERE id = ?;";

            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, c.getNomeCompromisso());
            statement.setString(2, c.getDescricao());
            statement.setString(3, c.getData());
            statement.setString(4, c.getHorario());
            statement.setString(5, c.getNomeContato());
            statement.setString(6, c.getTelefone());
            statement.setBoolean(7, c.isSituacao());
            statement.setLong(8, c.getId());
            statement.executeUpdate();
            return true;

        } catch(SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean excluir(Compromisso c) {
        try(Connection conexao = Conexao.getConexao()) {

            String sql = "DELETE FROM compromisso WHERE id = ?;";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setLong(1, c.getId());
            statement.executeUpdate();
            return true;

        } catch(SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static List<Compromisso> listarComFiltro(String ordem, String filtro, String pesquisa) {
        try(Connection conexao = Conexao.getConexao()) {

            //Montando SQL de consulta:

            String direcao = ordem.equals("ANTIGOS") ? " ASC" : " DESC"; //Ordem da consulta
            String where, sql2, and, sql3; //Condições do SELECT

            if(!filtro.isEmpty() || !pesquisa.isEmpty()) { //Se há pelo menos uma condição
                where = " WHERE";

                //Define a condição de filtrar pela situação
                sql2 = switch (filtro) {
                    case "CONCLUIDOS" -> " situacao = true";
                    case "PENDENTES" -> " situacao = false";
                    default -> "";
                };

                //Define a condição de filtrar pelo nome
                sql3 = pesquisa.isEmpty() ? "" : " nome LIKE ?";

                //Se as duas condições existem, define o AND para conectá-las
                and = (!sql2.isEmpty() && !sql3.isEmpty()) ? " AND" : "";

            } else {
                //Se não há condição algmuma, as Strings são vazias
                where = "";
                sql2 = "";
                sql3 = "";
                and = "";
            }

            //Monta a SQL completa:
            String sqlFinal = "SELECT * FROM compromisso" + where + sql2 + and + sql3
                    + " ORDER BY STR_TO_DATE(data, '%d/%m/%Y') " + direcao
                    + ", STR_TO_DATE(horario, '%H : %i') " + direcao + ";";

            PreparedStatement statement = conexao.prepareStatement(sqlFinal);

            //Se há condição de busca pelo nome, preenche o parâmetro corretamente
            if(!sql3.isEmpty()) statement.setString(1, pesquisa + "%");

            ResultSet result = statement.executeQuery();

            ArrayList<Compromisso> retorno = new ArrayList<>();
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
