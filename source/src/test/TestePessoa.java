package test;

import static org.junit.Assert.*;
import org.junit.Test;

import dao.PessoaDAO;
import model.Pessoa;

public class TestePessoa {
	private PessoaDAO pessoaDAO;
	private Pessoa pessoa;

	@Test
	public void testSalvar() {
		pessoa = new Pessoa();

		pessoa.setId(1);
		pessoa.setNome("Teste Inserção Pessoa");
		pessoa.setEmail("pessoa@teste.com");
		pessoa.setTelefone("4599991231");

		pessoaDAO = new PessoaDAO();
		pessoaDAO.salvar(pessoa);

		assertTrue(pessoaDAO.listarTodos().size() > 0);

	}

}