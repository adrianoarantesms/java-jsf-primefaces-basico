package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Pessoa;

public class PessoaDAO {
	EntityManagerFactory emf;
	EntityManager em;

	public PessoaDAO() {
		emf = Persistence.createEntityManagerFactory("conexao");
		em = emf.createEntityManager();

	}

	public void salvar(Pessoa pessoa) {
		em.getTransaction().begin();
		em.merge(pessoa);
		em.getTransaction().commit();
		emf.close();

	}

	public void excluir(Pessoa pessoa) {
		em.getTransaction().begin();
		em.remove(pessoa);
		em.getTransaction().commit();
		emf.close();
	}
	@SuppressWarnings("unchecked")
	public List<Pessoa> listarTodos() {
		em.getTransaction().begin();
		Query consulta = em.createQuery("select pessoa from Pessoa pessoa");
		List<Pessoa> pessoas = consulta.getResultList();
		em.getTransaction().commit();
		emf.close();
		return pessoas;
	}

}