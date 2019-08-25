package br.inf.datainfo.desafio.core.beans;

import java.io.Serializable;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.inf.datainfo.desafio.core.entities.AbstractEntity;

public abstract class AbstractBean<T extends AbstractEntity<?>> implements Serializable {

	private static final long serialVersionUID = -623078133672966122L;

	private T model;

	public AbstractBean() {
		super();
		this.model = this.createModel();
	}

	/**
	 * Cria o model
	 * 
	 * @return T
	 */
	public abstract T createModel();

	/**
	 * Recupera o objeto model
	 * 
	 * @return T
	 */
	public T getModel() {
		if (this.model == null) {
			this.model = this.createModel();
		}
		return this.model;
	}

	/**
	 * Define um novo objeto model
	 * 
	 * @param T
	 */
	public void setModel(T model) {
		this.model = model;
	}

	/**
	 * Verifica se o parametro se trata de uma mensagem ou um Codigo de Mensagem
	 * 
	 * @param summary Texto ou Codigo da Mensagem no arquivo de properties
	 * @return Mensagem
	 */
	private String checkProperty(String summary) {
		return summary;
	}

	private Map<String, Object> getSessionMap() {
		return this.getExternalContext().getSessionMap();
	}

	/**
	 * Recupera um parâmetro da requisição
	 * 
	 * @param String key
	 * @return Object value
	 */
	protected Object getRequestParameter(String key) {
		return this.getExternalContext().getRequestParameterMap().get(key) != null
				? this.getExternalContext().getRequestParameterMap().get(key)
				: null;
	}

	/**
	 * Adiciona um novo atributo na sessão.
	 * 
	 * @param String key
	 * @param Object value
	 */
	protected void setAttributeSession(String key, Object value) {
		this.getSessionMap().put(key, value);
	}

	/**
	 * Recupera um atributo da sessão
	 * 
	 * @param String key
	 * @return Object value
	 */
	protected Object getAttributeSession(String key) {
		return this.getAttributeSession(key, false);
	}

	/**
	 * Recupera um atributo da sessão
	 * 
	 * @param String  key
	 * @param boolean defines to remove the object
	 * @return Object value
	 */
	protected Object getAttributeSession(String key, boolean removes) {
		if (removes) {
			return this.getSessionMap().get(key) != null ? this.getSessionMap().remove(key) : null;
		}
		return this.getSessionMap().get(key) != null ? this.getSessionMap().get(key) : null;
	}

	/**
	 * Adicionad diretiva para redirecional alterando a URL
	 * 
	 * @param String pageToRedirect
	 * @return String page
	 */
	protected String redirect(String pageToRedirect) {
		return pageToRedirect.concat("?faces-redirect=true");
	}

	/**
	 * Recupera a request encapsulada pela FacesServlet
	 * 
	 * @return HttpServletRequest
	 */
	protected HttpServletRequest getRequest() {
		return this.getExternalContext() != null ? (HttpServletRequest) this.getExternalContext().getRequest() : null;
	}

	/**
	 * Recupera a response encapsulada pela FacesServlet
	 * 
	 * @return HttpServletResponse
	 */
	protected HttpServletResponse getResponse() {
		return this.getExternalContext() != null ? (HttpServletResponse) this.getExternalContext().getResponse() : null;
	}

	/**
	 * Recupera o context do FacesServlet
	 * 
	 * @return FacesContext
	 */
	protected FacesContext getCurrentFacesContext() {
		return FacesContext.getCurrentInstance();
	}

	/**
	 * Recupera o contexto da FacesServlet
	 * 
	 * @return ExternalContext
	 */
	protected ExternalContext getExternalContext() {
		if (this.getCurrentFacesContext() != null && this.getCurrentFacesContext().getExternalContext() != null) {
			return this.getCurrentFacesContext().getExternalContext();
		} else {
			return null;
		}
	}

	/**
	 * Recupera o path do contexto da aplicação
	 * 
	 * @return String
	 */
	protected String getContextPath() {
		ServletContext servletContext = (ServletContext) this.getExternalContext().getContext();
		return servletContext.getContextPath();
	}

	/**
	 * Adiciona mensagem de erro
	 * 
	 * @param clientId
	 * @param summary  Mensagem ou Codigo de Mensagem no arquivo de Properties
	 * @param detail
	 */
	protected void addErrorMessage(String clientId, String summary, String detail) {
		addMessage(clientId, FacesMessage.SEVERITY_ERROR, this.checkProperty(summary), detail);
	}

	/**
	 * Adiciona mensagem de erro
	 * 
	 * @param summary Mensagem ou Codigo de Mensagem no arquivo de Properties
	 * @param detail  Mensagem ou Codigo de Mensagem no arquivo de Properties de
	 *                detalhe
	 */
	protected void addErrorMessage(String summary, String detail) {
		addMessage(FacesMessage.SEVERITY_ERROR, this.checkProperty(summary), this.checkProperty(detail));
	}

	/**
	 * Adiciona mensagem de erro
	 * 
	 * @param summary Mensagem ou Codigo de Mensagem no arquivo de Properties
	 */
	protected void addErrorMessage(String summary) {
		addMessage(FacesMessage.SEVERITY_ERROR, this.checkProperty(summary), null);
	}

	/**
	 * Adiciona mensagem de informação
	 * 
	 * @param clientId
	 * @param summary  Mensagem ou Codigo de Mensagem no arquivo de Properties
	 * @param detail
	 */
	protected void addInfoMessage(String clientId, String summary, String detail) {
		addMessage(clientId, FacesMessage.SEVERITY_INFO, this.checkProperty(summary), detail);
	}

	/**
	 * Adiciona mensagem de informação
	 * 
	 * @param summary Mensagem ou Codigo de Mensagem no arquivo de Properties
	 * @param detail
	 */
	protected void addInfoMessage(String summary, String detail) {
		addMessage(FacesMessage.SEVERITY_INFO, this.checkProperty(summary), detail);
	}

	/**
	 * Adiciona mensagem de informação
	 * 
	 * @param summary Mensagem ou Codigo de Mensagem no arquivo de Properties
	 */
	protected void addInfoMessage(String summary) {
		addMessage(FacesMessage.SEVERITY_INFO, this.checkProperty(summary), null);
	}

	/**
	 * Adiciona mensagem de erro fatal (erros sem possibilidade de recuperação da
	 * aplicação)
	 * 
	 * @param clientId
	 * @param summary  Mensagem ou Codigo de Mensagem no arquivo de Properties
	 * @param detail
	 */
	protected void addFatalMessage(String clientId, String summary, String detail) {
		addMessage(clientId, FacesMessage.SEVERITY_FATAL, this.checkProperty(summary), this.checkProperty(detail));
	}

	/**
	 * Adiciona mensagem de erro fatal (erros sem possibilidade de recuperação da
	 * aplicação)
	 * 
	 * @param summary Mensagem ou Codigo de Mensagem no arquivo de Properties
	 * @param detail
	 */
	protected void addFatalMessage(String summary, String detail) {
		addMessage(FacesMessage.SEVERITY_FATAL, this.checkProperty(summary), this.checkProperty(detail));
	}

	/**
	 * Adiciona mensagem de erro fatal (erros sem possibilidade de recuperação da
	 * aplicação)
	 * 
	 * @param summary Mensagem ou Codigo de Mensagem no arquivo de Properties
	 */
	protected void addFatalMessage(String summary) {
		addMessage(FacesMessage.SEVERITY_FATAL, this.checkProperty(summary), null);
	}

	/**
	 * Adiciona mensagem de alerta
	 * 
	 * @param clientId
	 * @param summary  Mensagem ou Codigo de Mensagem no arquivo de Properties
	 * @param detail
	 */
	protected void addWarnlMessage(String clientId, String summary, String detail) {
		addMessage(clientId, FacesMessage.SEVERITY_WARN, this.checkProperty(summary), detail);
	}

	/**
	 * Adiciona mensagem de alerta
	 * 
	 * @param summary Mensagem ou Codigo de Mensagem no arquivo de Properties
	 * @param detail
	 */
	protected void addWarnlMessage(String summary, String detail) {
		addMessage(FacesMessage.SEVERITY_WARN, this.checkProperty(summary), detail);
	}

	/**
	 * Adiciona mensagem de alerta
	 * 
	 * @param summary Mensagem ou Codigo de Mensagem no arquivo de Properties
	 */
	protected void addWarnlMessage(String summary) {
		addMessage(FacesMessage.SEVERITY_WARN, this.checkProperty(summary), null);
	}

	private static void addMessage(String clientId, FacesMessage.Severity severity, String summary, String detail) {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(clientId, new FacesMessage(severity, summary, detail));
	}

	private static void addMessage(FacesMessage.Severity severity, String summary, String detail) {
		addMessage(null, severity, summary, detail);
	}

}