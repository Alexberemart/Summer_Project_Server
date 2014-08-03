package com.grupoasv.model.dao.base;import java.io.Serializable;import java.util.List;/** *  * Base class for DAO *  *  */public interface GenericDAO<T, ID extends Serializable>{	/**	 * 	 * Get a T type proxy by the given ID	 * 	 */	T findById(ID id, boolean lock);	/**	 * 	 * Get a T type object by the given ID.	 * Note that findById returns a proxy while this method returns the instance	 * 	 */	T getById(ID id, boolean lock);	/** 	 * Get all T type instances 	 */	List<T> findAll();		List<T> findAllPaginated(Integer firstResult, Integer maxResults, String orderBy);		List<T> findAllPaginated(Integer firstResult, Integer maxResults, String orderBy, Boolean ascending);		/** 	 * Get all T type objects filtering by example 	 */	List<T> findByExample(T exampleInstance);	/** 	 * Persists a T type object 	 */	T makePersistent(T entity);	/** 	 * Removes a T type object 	 */	void makeTransient(T entity);}