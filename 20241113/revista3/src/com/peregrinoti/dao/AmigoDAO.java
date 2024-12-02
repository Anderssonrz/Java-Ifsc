package com.peregrinoti.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.peregrinoti.entity.Amigo;

public class AmigoDAO implements DAO<Amigo> {

	@Override
	public Object get(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Amigo> getAll() {
		List<Amigo> amigos = new ArrayList<Amigo>();

		String sql = "select * from amigo";

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
				Amigo amigo = new Amigo();

				// atribui campo para atributo
				amigo.setId(rset.getLong("id"));
				amigo.setNome(rset.getString("nome"));
				amigo.setNomeResponsavel(rset.getString("nome_responsavel"));
				amigo.setTelefone(rset.getString("telefone"));
				amigo.setEndereco(rset.getString("endereco"));

				amigos.add(amigo);
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
		return amigos;

	}

	@Override
	public int save(Amigo amigo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean update(Amigo amigo, String[] params) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Amigo amigo) {
		String sql = "delete from amigo where id = ?";

		// Recupera a conexão com o banco
		Connection conexao = null;

		// Criar uma preparação da consulta
		PreparedStatement stm = null;

		try {
			conexao = new Conexao().getConnection();

			stm = conexao.prepareStatement(sql);
			stm.setLong(1, amigo.getId());
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
