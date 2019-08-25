package br.inf.datainfo.desafio.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.inf.datainfo.desafio.core.beans.AbstractBean;
import br.inf.datainfo.desafio.entities.Carro;
import br.inf.datainfo.desafio.service.CarroService;

@Named
@ViewScoped
public class CarroBean extends AbstractBean<Carro> {

	private static final long serialVersionUID = -67261152906661170L;

	private static final String CARRO = "id_carro";

	private List<Carro> carros;
	private boolean editionMode;

	@Inject
	private CarroService service;

	@Override
	public Carro createModel() {
		return new Carro();
	}

	@PostConstruct
	public void init() {
		Integer idCarro = (Integer) super.getAttributeSession(CARRO, true);
		if (idCarro != null) {
			super.addInfoMessage("Registro carregado com sucesso!");
			this.setModel(this.service.getById(idCarro));
			this.setEditionMode(true);
		} else {
			this.setModel(this.createModel());
		}
	}

	public String salvar() {
		this.service.salvar(this.getModel());
		this.setModel(this.createModel());
		super.addInfoMessage("Registro salvo com sucesso!");
		return null;
	}

	public String editar(Carro carro) {
		super.setAttributeSession(CARRO, carro.getId());
		return super.redirect("manter-carros.jsf");
	}

	public String remover(Carro carro) {
		this.service.remover(carro);
		this.setCarros(null);
		super.addInfoMessage("Registro excluído com sucesso!");
		return null;
	}

	public List<Carro> getCarros() {
		if (this.carros == null) {
			this.carros = service.getAll();
		}
		return this.carros;
	}

	public void setCarros(List<Carro> carros) {
		this.carros = carros;
	}

	public boolean isEditionMode() {
		return editionMode;
	}

	public void setEditionMode(boolean editionMode) {
		this.editionMode = editionMode;
	}

}