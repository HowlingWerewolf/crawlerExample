package example.crawllinkstodb.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import java.io.Serializable;

@ManagedBean
@SessionScoped
public class DiceBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String value;
	private String side;

	public String getValue() {
		Dice dice = new Dice(Integer.parseInt(side));
		value = "" + dice.roll(1);
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getSide() {
		return side;
	}

	public void setSide(String side) {
		this.side = side;
	}

}