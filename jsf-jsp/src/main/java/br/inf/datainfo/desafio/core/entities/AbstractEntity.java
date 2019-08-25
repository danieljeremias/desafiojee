package br.inf.datainfo.desafio.core.entities;

import java.io.Serializable;

public interface AbstractEntity<T> extends Serializable {

	public abstract T getId();

	public abstract void setId(T id);

}