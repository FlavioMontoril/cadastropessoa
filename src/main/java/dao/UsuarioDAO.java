package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import entidade.Usuario;
import util.JPAUtil;

public class UsuarioDAO {
	
	public static void salvar(Usuario usuario) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(usuario);
        em.getTransaction().commit();
        em.close();
    }

    public static void editar(Usuario usuario) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(usuario);
        em.getTransaction().commit();
        em.close();
    }

    public static void excluir(Usuario usuario) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        usuario = em.find(Usuario.class, usuario.getId());
        em.remove(usuario);
        em.getTransaction().commit();
        em.close();
    }

    public static List<Usuario> listar() {
    		EntityManager em = JPAUtil.getEntityManager();
    		TypedQuery<Usuario> q = em.createQuery("select u from Usuario u", Usuario.class);
    		List<Usuario> listarUsuarios = q.getResultList();
    		em.close();
    		return listarUsuarios;
    }

    public long contarUsuarios() {
        EntityManager em = JPAUtil.getEntityManager();
        javax.persistence.Query query = em.createQuery("SELECT COUNT(u) FROM Usuario u");
        return (long) query.getSingleResult();
    }

}
