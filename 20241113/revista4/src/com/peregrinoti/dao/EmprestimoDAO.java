  package com.peregrinoti.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.peregrinoti.entity.Emprestimo;
import com.peregrinoti.entity.Revista;

public class EmprestimoDAO implements DAO<Emprestimo> {
	
	private RevistaDAO revistaDAO;

	private AmigoDAO amigoDAO;

	public EmprestimoDAO() {
		this.revistaDAO = new RevistaDAO();
		this.amigoDAO = new AmigoDAO();
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
				emprestimo.setNome(rset.getString("nome"));
				emprestimo.setAno(rset.getDate("ano"));

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
	}

	@Override
	public List<Emprestimo> getAll() {
		List<Emprestimo> emprestimo = new ArrayList<Emprestimo>();

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
				Revista emprestimo = new Revista();

				// atribui campo para atributo
				emprestimo.setId(rset.getLong("id"));
				emprestimo.setNome(rset.getString("nome"));
				emprestimo.setAno(rset.getDate("ano"));

				// buscando as chaves estrangeiras
				emprestimo.setAmigo(this.amigoDAO.get(rset.getLong("amigo_id")));
				emprestimo.setRevista(this.revistaDAO.get(rset.getLong("revista_id")));

				emprestimo.add(emprestimo);
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
	public int save(Emprestimo t) {
		String sql = "insert into revista (nome, ano, caixa_id, tipo_colecao_id)" + " values (?, ?, ?, ?)";

		// Recupera a conexão com o banco
		Connection conexao = null;

		// Criar uma preparação da consulta
		PreparedStatement stm = null;

		try {

			conexao = new Conexao().getConnection();

			stm = conexao.prepareStatement(sql);
			stm.setString(1, revista.getNome());
			stm.setDate(2, revista.getAno());
			stm.setLong(3, revista.getCaixa().getId());
			stm.setLong(4, revista.getTipoColecao().getId());

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
	public boolean update(Emprestimo t, String[] params) {
		String sql = "update revista set nome = ?, ano = ?, caixa_id = ?, tipo_colecao_id = ? where id = ?";

		// Recupera a conexão com o banco
		Connection conexao = null;

		// Criar uma preparação da consulta
		PreparedStatement stm = null;

		try {
			conexao = new Conexao().getConnection();

			stm = conexao.prepareStatement(sql);
			stm.setString(1, revista.getNome());
			stm.setDate(2, revista.getAno());
			stm.setLong(3, revista.getCaixa().getId());
			stm.setLong(4, revista.getTipoColecao().getId());
			stm.setLong(5, revista.getTipoColecao().getId());

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
	public boolean delete(Emprestimo t) {
		String sql = "delete from revista where id = ?";

		// Recupera a conexão com o banco
		Connection conexao = null;

		// Criar uma preparação da consulta
		PreparedStatement stm = null;

		try {
			conexao = new Conexao().getConnection();

			stm = conexao.prepareStatement(sql);
			stm.setLong(1, revista.getId());
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
