package bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import dao.UsuarioDAO;
import entidade.Usuario;

@ManagedBean
@ViewScoped
public class UsuarioBean {
	
	 private Usuario usuario = new Usuario();
	    private List<Usuario> usuarios;
	    private UsuarioDAO usuarioDAO = new UsuarioDAO();
	    
	    	
	    	public String salvar() {
	    		UsuarioDAO.salvar(usuario);
	    		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Usuario salvo com sucesso"));
	    		usuario = new Usuario();
	    		return null;
	    	}

	  
	    public void listar() {
	        usuarios = usuarioDAO.listar();
	    }

	    public void excluir(Usuario usuario) {
	        usuarioDAO.excluir(usuario);
    		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario excluido com sucesso", ""));
	        listar();
	    }

	    public void visualizar(Usuario usuario) {
	        this.usuario = usuario;
	    }

	    public Usuario getUsuario() {
	        return usuario;
	    }

	    public void setUsuario(Usuario usuario) {
	        this.usuario = usuario;
	    }

	    public List<Usuario> getUsuarios() {
	    	usuarios = UsuarioDAO.listar();
	    	return usuarios;
	    }

}
