package br.com.restful.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.com.restful.factory.ConnectionFactory;
import br.com.restful.model.Aluno;

public class AlunoDAO extends ConnectionFactory {

	private static AlunoDAO instance;

	public static AlunoDAO getInstance() {
		if (instance == null)
			instance = new AlunoDAO();
		return instance;
	}

	public ArrayList<Aluno> listarTodos() {
		Connection conexao = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Aluno> alunos = null;

		conexao = criarConexao();
		alunos = new ArrayList<Aluno>();
		try {
			pstmt = conexao.prepareStatement("select * from alunos order by nome");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Aluno aluno = new Aluno();

				aluno.setId(rs.getInt("idaluno"));
				aluno.setNome(rs.getString("nome"));
				aluno.setCpf(rs.getString("cpf"));
				aluno.setCurso(rs.getString("curso"));
				aluno.setIdade(rs.getInt("idade"));

				alunos.add(aluno);
			}

		} catch (Exception e) {
			System.out.println("Erro ao listar todos os alunos: " + e);
			e.printStackTrace();
		} finally {
			fecharConexao(conexao, pstmt, rs);
		}
		return alunos;
	}

	public Integer deleteAluno(Integer idaluno) {
		Connection conexao = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		conexao = criarConexao();
		try {
			pstmt = conexao.prepareStatement("delete from alunos where idaluno = " + idaluno);
			rs = pstmt.executeQuery();
		} catch (Exception e) {
			System.out.println("Erro ao deletar o aluno");
			e.printStackTrace();
		} finally {
			fecharConexao(conexao, pstmt, rs);
		}
		return idaluno;
	}

	public Aluno updateAluno(Aluno idaluno, String nome, String cpf, String curso, Integer idade) {
		Connection conexao = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		conexao = criarConexao();
		try {
			pstmt = conexao
					.prepareStatement("update alunos set " + nome + cpf + curso + idade + "where idaluno = " + idaluno);
			rs = pstmt.executeQuery();
		} catch (Exception e) {
			System.out.println("Erro ao alterar as informações do aluno");
			e.printStackTrace();
		} finally {
			fecharConexao(conexao, pstmt, rs);
		}
		return idaluno;
	}

	public Aluno insertAluno(String nome, String cpf, String curso, Integer idade) {
		Connection conexao = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		conexao = criarConexao();
		try {
			pstmt = conexao.prepareStatement(
					"insert into alunos (nome, cpf, curso, idade) values ( " + nome + cpf + curso + idade + ")");
			rs = pstmt.executeQuery();
		} catch (Exception e) {
			System.out.println("Erro ao incluir o aluno");
			e.printStackTrace();
		} finally {
			fecharConexao(conexao, pstmt, rs);
		}
		return null;
	}

	@SuppressWarnings("null")
	public Aluno getAlunoByID(int id) {
		Connection conexao = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Aluno aluno = new Aluno();

		ArrayList<Aluno> alunos = null;
		conexao = criarConexao();

		try {
			pstmt = conexao.prepareStatement("select * from alunos where idaluno = " + id);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				aluno.setId(rs.getInt("idaluno"));
				aluno.setNome(rs.getString("nome"));
				aluno.setCpf(rs.getString("cpf"));
				aluno.setCurso(rs.getString("curso"));
				aluno.setIdade(rs.getInt("idade"));

				alunos.add(aluno);
			}
		} catch (Exception e) {
			System.out.println("Erro ao encontrar o aluno pelo id informado");
		} finally {
			fecharConexao(conexao, pstmt, rs);
		}
		return aluno;
	}

}
