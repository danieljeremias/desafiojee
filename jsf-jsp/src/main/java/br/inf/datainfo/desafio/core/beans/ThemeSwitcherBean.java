package br.inf.datainfo.desafio.core.beans;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Model;

import br.inf.datainfo.desafio.core.entities.Theme;

@Model
public class ThemeSwitcherBean extends AbstractBean<Theme> {

	private static final long serialVersionUID = -3274792097286566965L;

	private List<Theme> themes;

	@Override
	public Theme createModel() {
		return new Theme();
	}

	public List<Theme> getThemes() {
		if (this.themes == null) {
			this.themes = new ArrayList<>();
			this.themes.add(new Theme(0, "Nova-Light", "nova-light"));
			this.themes.add(new Theme(1, "Nova-Dark", "nova-dark"));
			this.themes.add(new Theme(2, "Nova-Colored", "nova-colored"));
			this.themes.add(new Theme(3, "Luna-Blue", "luna-blue"));
			this.themes.add(new Theme(4, "Luna-Amber", "luna-amber"));
			this.themes.add(new Theme(5, "Luna-Green", "luna-green"));
			this.themes.add(new Theme(6, "Luna-Pink", "luna-pink"));
			this.themes.add(new Theme(7, "Omega", "omega"));
		}
		return themes;
	}

}