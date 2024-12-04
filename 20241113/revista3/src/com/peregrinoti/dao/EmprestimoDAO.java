package com.peregrinoti.dao;

import java.sql.Connection;
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

	@Override
	public Object get(Long id) {
		Emprestimo emprestimo = null;
		String sql = "select * from emprestimo where id = ?";

		// Recupera a conexão com o banco
		Connection conexao = null;

		// Criar uma preparação da consulta
		PreparedStatement stm = null;

		// Criar uma classe que guarde o retorno da operação
		ResultSet rset = null;

		try {

			conexao = new Conexao().getConnection();

			stm = conexao.prepareStatement(sql);
			stm.setInt(1, id.intValue());
			rset = stm.executeQuery();

			while (rset.next()) {
				emprestimo = new Emprestimo();

				// atribui campo para atributo
				emprestimo.setId(rset.getLong("id"));
				emprestimo.setDataEmprestimo(rset.getDate("data_emprestimo"));
				emprestimo.setDataDevolucao(rset.getDate("data_devolucao"));

				// buscando as chaves estrangeiras
				emprestimo.setAmigo(this.amigoDAO.get(rset.getLong("amigo_id")));
				emprestimo.setRevista(this.revistaDAO.get(rset.getLong("revista_id")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stm != null) {
					stm.close();
				}

				if (conexao != null) {
					conexao.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return emprestimo;
	}

	@Override
	public List<Emprestimo> getAll() {
		List<Emprestimo> revistas = new ArrayList<Emprestimo>();

		String sql = "select * from emprestimo";

		// Recupera a conexão com o banco
		Connection conexao = null;

		// Criar uma preparação da consulta
		PreparedStatement stm = null;

		// Criar uma classe que guarde o retorno da operação
		ResultSet rset = null;

		try {

			conexao = new Conexao().getConnection();

			stm = conexao.prepareStatement(sql);
			rset = stm.executeQuery();

			while (rset.next()) {
				Emprestimo emprestimo = new Emprestimo();

				// atribui campo para atributo
				emprestimo.setId(rset.getLong("id"));
				emprestimo.setDataEmprestimo(rset.getDate("data_emprestimo"));
				emprestimo.setDataDevolucao(rset.getDate("data_devolucao"));

				// buscando as chaves estrangeiras
				emprestimo.setAmigo(this.amigoDAO.get(rset.getLong("amigo_id")));
				emprestimo.setRevista(this.revistaDAO.get(rset.getLong("revista_id")));

				revistas.add(emprestimo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stm != null) {
					stm.close();
				}

				if (conexao != null) {
					conexao.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return revistas;
	}

	@Override
	public int save(Emprestimo emprestimo) {
		String sql = "insert into emprestimo (data_emprestimo, data_devolucao, amigo_id, revista_id)"
				+ " values (?, ?, ?, ?)";

		// Recupera a conexão com o banco
		Connection conexao = null;

		// Criar uma preparação da consulta
		PreparedStatement stm = null;

		try {

			conexao = new Conexao().getConnection();

			stm = conexao.prepareStatement(sql);
			stm.setDate(1, emprestimo.getDataEmprestimo());
			stm.setDate(2, emprestimo.getDataDevolucao());
			stm.setLong(3, emprestimo.getAmigo().getId());
			stm.setLong(4, emprestimo.getRevista().getId());

			stm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stm != null) {
					stm.close();
				}

				if (conexao != null) {
					conexao.close();
				}
				return 1;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public boolean update(Emprestimo emprestimo, String[] params) {
		String sql = "update emprestimo set data_emprestimo = ?, data_devolucao = ?, amigo_id = ?, revista_id = ? where id = ?";

		// Recupera a conexão com o banco
		Connection conexao = null;

		// Criar uma preparação da consulta
		PreparedStatement stm = null;

		try {
			conexao = new Conexao().getConnection();

			stm = conexao.prepareStatement(sql);
			stm.setDate(1, emprestimo.getDataEmprestimo());
			stm.setDate(2, emprestimo.getDataDevolucao());
			stm.setLong(3, emprestimo.getAmigo().getId());
			stm.setLong(4, emprestimo.getRevista().getId());
			stm.setLong(5, emprestimo.getRevista().getId());

			stm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stm != null) {
					stm.close();
				}

				if (conexao != null) {
					conexao.close();
				}
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public boolean delete(Emprestimo emprestimo) {
		String sql = "delete from emprestimo where id = ?";

		// Recupera a conexão com o banco
		Connection conexao = null;

		// Criar uma preparação da consulta
		PreparedStatement stm = null;

		try {
			conexao = new Conexao().getConnection();

			stm = conexao.prepareStatement(sql);
			stm.setLong(1, emprestimo.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stm != null) {
					stm.close();
				}

				if (conexao != null) {
					conexao.close();
				}
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}
}
