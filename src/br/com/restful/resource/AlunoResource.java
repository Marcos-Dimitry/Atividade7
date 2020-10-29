package br.com.restful.resource;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.restful.controller.AlunoController;
import br.com.restful.model.Aluno;

@Path("/aluno")
public class AlunoResource {

	@GET
	@Path("/listarTodos")
	@Produces("application/json")
	public ArrayList<Aluno> listarTodos() {
		return new AlunoController().listarTodos();
	}

	@POST
	@Path("/deleteAluno/{id}")
	@Produces("application/json")
	public Integer deleteAluno(@PathParam("id") Integer idaluno) {
		return new AlunoController().deleteAluno(idaluno);
	}

	@GET
	@Path("/getAlunoById/{id}")
	@Produces("application/json")
	public Aluno getAlunoById(@PathParam("id") Integer id) {
		return new AlunoController().getAlunoById(id);
	}

	@PUT
	@Path("/updatAluno/{id}")
	@Produces("application/json")
	public Aluno updateAluno(@PathParam("id") Integer id) {
		return new AlunoController().getAlunoById(id);
	}

	@POST
	@Path("inserir")
	@Produces("application/json")
	public Aluno insertAluno(String nome, String cpf, String curso, Integer idade) {
		return new AlunoController().insertAluno(nome, cpf, curso, idade);
	}

}
