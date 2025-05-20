package com.nraj11.mapper;

import java.util.List;

public interface GenericMapper<E, D> {
	 
	D mapToDTO(E eoObject);
 
	E mapToDAO(D eoObject);
	
	List<E> mapToDAO(List<D> objectList);
	
	List<D> mapToDTO(List<E> eoObjectList);
	
}
