package de.rixtrick.demo.dao;

import java.util.List;

import org.hibernate.criterion.Criterion;

public interface AbstractDao<E, I> {

	E findById(I id);

	void saveOrUpdate(E e);

	void delete(E e);

	@SuppressWarnings("rawtypes")
	List findByCriteria(Criterion criterion);

}
