package com.appschallenge.emergency.business.dao;

import java.util.Map;

/**
 * Interface generique pour les DAO
 */
public interface GenericDao<T> {

	/**
	 * retourne le nombre d'objets correspondant aux criteres
	 *
	 * @param params
	 * @return
	 */
	long countAll(Map<String, Object> params);

	/**
	 * Cree un enregistrement
	 *
	 * @param t
	 * @return
	 */
	T create(T t);

	/**
	 * Supprime un enregistrement
	 *
	 * @param id
	 */
	void delete(Object id);

	/**
	 * Retrouve un objet par son ID
	 *
	 * @param id
	 * @return
	 */
	T find(Object id);

	/**
	 * Met a jour un objet
	 * 
	 * @param t
	 * @return
	 */
	T update(T t);
}
