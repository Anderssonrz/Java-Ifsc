package com.peregrinoti.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.peregrinoti.entity.Emprestimo;

public class EmprestimoDAO implements DAO<Emprestimo> {

    private AmigoDAO amigoDAO;
    private RevistaDAO revistaDAO;

    public EmprestimoDAO() {
        this.amigoDAO = new AmigoDAO();
        this.revistaDAO = new RevistaDAO();
    }

    private void fecharRecursos(Connection conexao, PreparedStatement stm) {
        try {
            if (stm != null) stm.close();
            if (conexao != null) conexao.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Emprestimo get(Long id) {
        Emprestimo emprestimo = null;
        String sql = "SELECT * FROM emprestimo WHERE id = ?";

        Connection conexao = null;
        PreparedStatement stm = null;
        ResultSet rset = null;

        try {
            conexao = new Conexao().getConnection();
            stm = conexao.prepareStatement(sql);
            stm.setLong(1, id);
            rset = stm.executeQuery();

            if (rset.next()) {
                emprestimo = new Emprestimo();
                emprestimo.setId(rset.getLong("id"));
                emprestimo.setDataEmprestimo(rset.getDate("data_emprestimo"));
                emprestimo.setDataDevolucao(rset.getDate("data_devolucao"));

              
                emprestimo.setAmigo(amigoDAO.get(rset.getLong("amigo_id")));
                emprestimo.setRevista(revistaDAO.get(rset.getLong("revista_id")));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            fecharRecursos(conexao, stm);
        }

        return emprestimo;
    }

    @Override
    public List<Emprestimo> getAll() {
        List<Emprestimo> emprestimos = new ArrayList<>();
        String sql = "SELECT * FROM emprestimo";

        Connection conexao = null;
        PreparedStatement stm = null;
        ResultSet rset = null;

        try {
            conexao = new Conexao().getConnection();
            stm = conexao.prepareStatement(sql);
            rset = stm.executeQuery();

            while (rset.next()) {
                Emprestimo emprestimo = new Emprestimo();
                emprestimo.setId(rset.getLong("id"));
                emprestimo.setDataEmprestimo(rset.getDate("data_emprestimo"));
                emprestimo.setDataDevolucao(rset.getDate("data_devolucao"));

                // Relacionamentos
                emprestimo.setAmigo(amigoDAO.get(rset.getLong("amigo_id")));
                emprestimo.setRevista(revistaDAO.get(rset.getLong("revista_id")));

                emprestimos.add(emprestimo);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            fecharRecursos(conexao, stm);
        }

        return emprestimos;
    }

    @Override
    public int save(Emprestimo emprestimo) {
        String sql = "INSERT INTO emprestimo (nome_amigo, telefone_amigo, ano, nome_revista) VALUES (?, ?, ?, ?)";

        Connection conexao = null;
        PreparedStatement stm = null;

        try {
            conexao = new Conexao().getConnection();
            stm = conexao.prepareStatement(sql);

           
            stm.setString(1, emprestimo.getAmigo().getNome());  
            stm.setString(2, emprestimo.getAmigo().getTelefone());  
            stm.setInt(3, emprestimo.getAno()); 
            stm.setString(4, emprestimo.getRevista().getNome());  

            stm.execute();
            return 1;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            fecharRecursos(conexao, stm);
        }

        return 0;
    }


    @Override
    public boolean update(Emprestimo emprestimo, String[] params) {
        String sql = "UPDATE emprestimo SET data_emprestimo = ?, data_devolucao = ?, amigo_id = ?, revista_id = ? WHERE id = ?";

        Connection conexao = null;
        PreparedStatement stm = null;

        try {
            conexao = new Conexao().getConnection();
            stm = conexao.prepareStatement(sql);

            stm.setDate(1, new Date(emprestimo.getDataEmprestimo().getTime()));
            stm.setDate(2, new Date(emprestimo.getDataDevolucao().getTime()));
            stm.setLong(3, emprestimo.getAmigo().getId());
            stm.setLong(4, emprestimo.getRevista().getId());
            stm.setLong(5, emprestimo.getId());

            stm.execute();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            fecharRecursos(conexao, stm);
        }

        return false;
    }

    @Override
    public boolean delete(Emprestimo emprestimo) {
        String sql = "DELETE FROM emprestimo WHERE id = ?";

        Connection conexao = null;
        PreparedStatement stm = null;

        try {
            conexao = new Conexao().getConnection();
            stm = conexao.prepareStatement(sql);

            stm.setLong(1, emprestimo.getId());
            stm.execute();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            fecharRecursos(conexao, stm);
        }

        return false;
    }
}
