package com.nraj.dto;

import java.util.List;

public class PageObject {
	
	private long count;
	
	private List<?> elements;

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public List<?> getElements() {
		return elements;
	}

	public void setElements(List<?> elements) {
		this.elements = elements;
	}

}
