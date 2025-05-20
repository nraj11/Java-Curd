package com.omnie.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.omnie.dto.PageObject;

public abstract class CrudServiceImpl<DT, EN, ID> implements CrudService<DT,EN, ID> {
	

	@Override
	public DT add(DT data) {
		preAdd(data);
		EN mappedToDT = getMapper().mapToDAO(data);
		if(mappedToDT==null) {
			return data;
		}
		EN save = getRepository().save(mappedToDT);
		postAdd(data);
		return getMapper().mapToDTO(save);
	}
	
	protected EN findByRef(ID id) {
		return getRepository().getReferenceById(id);
	}

	@Override
	public void postAdd(DT data) {
		
	}
	
	@Override
	public void preAdd(DT data) {
		
	}

	@Override
	public boolean update(DT data) {
		preUpdate(data);
		EN mappedToDT = getMapper().mapToDAO(data);
		if(mappedToDT==null) {
			return false;
		}
		getRepository().save(mappedToDT);
		postUpdate(data);
		return true;
	}
	
	@Override
	public void preUpdate(DT data) {
		
	}
	
	@Override
	public void postUpdate(DT data) {
		
	}

	@Override
	public boolean delete(ID uuid) {
		getRepository().deleteById(uuid);
		return true;
	}
	
	@Override
	public void preDelete(ID uuid) {
		
	}
	
	@Override
	public void postDelete(ID uuid) {
		
	}

	@Override
	public DT findById(ID uuid) {
		return getMapper().mapToDTO(getRepository().getReferenceById(uuid));
	}
	
	@Override
	public List<DT> findAllById(List<ID> ids) {
		return getMapper().mapToDTO(getRepository().findAllById(ids));
	}

	@Override
	public List<DT> findAll() {
		return getMapper().mapToDTO(getRepository().findAll()) ;
	}
	
	@Override
	public List<DT> findAll(Sort sort) {
		return getMapper().mapToDTO(getRepository().findAll(sort)) ;
	}

	@Override
	public PageObject fetchPageObject(int pageNumber, int count) {
		Pageable pageable =PageRequest.of(pageNumber, count);
		Page<EN> page = getRepository().findAll(pageable);
		List<DT> reslist = getMapper().mapToDTO(page.toList());
		PageObject responseDto=new PageObject();
		responseDto.setCount(page.getTotalElements());
		responseDto.setElements(reslist);
		return responseDto;
	}
	
	@Override
	public PageObject fetchPageObject(int pageNumber, int count, Sort sort) {
		Pageable pageable =PageRequest.of(pageNumber, count , sort);
		Page<EN> page = getRepository().findAll(pageable);
		List<DT> reslist = getMapper().mapToDTO(page.toList());
		PageObject responseDto=new PageObject();
		responseDto.setCount(page.getTotalElements());
		responseDto.setElements(reslist);
		return responseDto;
	}

	@Override
	public List<DT> fetchPageList(int pageNumber, int count) {
		Pageable pageable =PageRequest.of(pageNumber, count);
		Page<EN> page = getRepository().findAll(pageable);
		return getMapper().mapToDTO(page.toList());
	}
	
	@Override
	public List<DT> fetchPageList(int pageNumber, int count , Sort sort) {
		Pageable pageable =PageRequest.of(pageNumber, count, sort);
		Page<EN> page = getRepository().findAll(pageable);
		return getMapper().mapToDTO(page.toList());
	}
}
