package br.edu.poo.m0038.dao;

import br.edu.poo.m0038.config.ConexaoBD;
import br.edu.poo.m0038.model.Jogador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JogadorDAO {

    // CREATE
    public void inserir(Jogador j) throws SQLException {
        String sql = "INSERT INTO jogador (nome, email, cep, logradouro, bairro, cidade, uf) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = ConexaoBD.getConexao();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, j.getNome());
            ps.setString(2, j.getEmail());
            ps.setString(3, j.getCep());
            ps.setString(4, j.getLogradouro());
            ps.setString(5, j.getBairro());
            ps.setString(6, j.getCidade());
            ps.setString(7, j.getUf());
            ps.executeUpdate();
        }
    }

    // READ (todos)
    public List<Jogador> listar() throws SQLException {
        List<Jogador> lista = new ArrayList<>();
        String sql = "SELECT * FROM jogador ORDER BY id";
        try (Connection con = ConexaoBD.getConexao();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(montar(rs));
            }
        }
        return lista;
    }

    // READ (um só)
    public Jogador buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM jogador WHERE id = ?";
        try (Connection con = ConexaoBD.getConexao();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return montar(rs);
                }
            }
        }
        return null;
    }

    // UPDATE
    public boolean atualizar(Jogador j) throws SQLException {
        String sql = "UPDATE jogador SET nome=?, email=?, cep=?, logradouro=?, "
                + "bairro=?, cidade=?, uf=? WHERE id=?";
        try (Connection con = ConexaoBD.getConexao();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, j.getNome());
            ps.setString(2, j.getEmail());
            ps.setString(3, j.getCep());
            ps.setString(4, j.getLogradouro());
            ps.setString(5, j.getBairro());
            ps.setString(6, j.getCidade());
            ps.setString(7, j.getUf());
            ps.setInt(8, j.getId());
            return ps.executeUpdate() > 0;
        }
    }

    // DELETE
    public boolean deletar(int id) throws SQLException {
        String sql = "DELETE FROM jogador WHERE id = ?";
        try (Connection con = ConexaoBD.getConexao();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }

    // Converte uma linha do banco em um objeto Jogador
    private Jogador montar(ResultSet rs) throws SQLException {
        Jogador j = new Jogador();
        j.setId(rs.getInt("id"));
        j.setNome(rs.getString("nome"));
        j.setEmail(rs.getString("email"));
        j.setCep(rs.getString("cep"));
        j.setLogradouro(rs.getString("logradouro"));
        j.setBairro(rs.getString("bairro"));
        j.setCidade(rs.getString("cidade"));
        j.setUf(rs.getString("uf"));
        return j;
    }
}