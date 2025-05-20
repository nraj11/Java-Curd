package com.nraj.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.nraj.dto.PageObject;
import com.nraj.mapper.GenericMapper;

public interface CrudService<DT, EN, ID> {
	/**
	 * 
	 * @return
	 */
	JpaRepository<EN, ID> getRepository();
	/***
	 * 
	 * @return
	 */
	GenericMapper<EN, DT>  getMapper();
	/***
	 * 
	 * @param data
	 * @return
	 */
	DT add(DT data);
	
	void postAdd(DT data);

	void preAdd(DT data);
	/***
	 * 
	 * @param data
	 * @return
	 */
	boolean update(DT data);
	
	void postUpdate(DT data);

	void preUpdate(DT data);
	/***
	 * 
	 * @param uuid
	 * @return
	 */
	boolean delete(ID uuid);
	
	void postDelete(ID uuid);

	void preDelete(ID uuid);
	/**
	 * 
	 * @param uuid
	 * @return
	 */
	DT findById(ID uuid);
	
	List<DT> findAllById(List<ID> ids);
	/**
	 * 
	 * @return
	 */
	List<DT> findAll();
	
	/**
	 * 
	 * @return
	 */
	List<DT> findAll(Sort sort);
	
	/**
	 * @param pageNumber
	 * @param count
	 * @return
	 */
	PageObject fetchPageObject(int pageNumber, int count);

	/**
	 * @param pageNumber
	 * @param count
	 * @return
	 */
	List<DT> fetchPageList(int pageNumber, int count);

	/**
	 * @param pageNumber
	 * @param count
	 * @param sort
	 * @return
	 */
	PageObject fetchPageObject(int pageNumber, int count, Sort sort);

	/**
	 * @param pageNumber
	 * @param count
	 * @param sort
	 * @return
	 */
	List<DT> fetchPageList(int pageNumber, int count, Sort sort);
	
	

}
