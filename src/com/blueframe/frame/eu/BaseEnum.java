package com.blueframe.frame.eu;

import org.springframework.beans.factory.annotation.Autowired;

public class BaseEnum {
	public String label;
	public String value;

	public BaseEnum() {
	}

	public BaseEnum(String label, String value) {
		this.setLabel(label);
		this.setValue(value);
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Autowired
	public String toString() {
		return this.value;
	}
}
