package br.com.restful.controller;

import java.util.ArrayList;

import br.com.restful.dao.AlunoDAO;
import br.com.restful.model.Aluno;

public class AlunoController {

	public ArrayList<Aluno> listarTodos() {
		System.out.println("Iniciando aplicação");
		return AlunoDAO.getInstance().listarTodos();
	}

	public Aluno getAlunoById(Integer idaluno) {
		return AlunoDAO.getInstance().getAlunoByID(idaluno);
	}

	public Aluno insertAluno(String nome, String cpf, String curso, Integer idade) {
		return AlunoDAO.getInstance().insertAluno(nome, cpf, curso, idade);
	}

	public Aluno updateAluno(Aluno idaluno, String nome, String cpf, String curso, Integer idade) {
		return AlunoDAO.getInstance().updateAluno(idaluno, nome, cpf, curso, idade);
	}

	public Integer deleteAluno(Integer idaluno) {
		return AlunoDAO.getInstance().deleteAluno(idaluno);
	}
}
