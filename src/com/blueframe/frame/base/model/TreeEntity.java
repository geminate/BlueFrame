package com.blueframe.frame.base.model;

public abstract class TreeEntity<T> extends BaseEntity<T> {

	protected T parent;

	public abstract T getParent();

	public abstract void setParent(T parent);
}
