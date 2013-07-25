package de.rixtrick.demo.dao;

import java.util.List;

import org.hibernate.criterion.Criterion;

public interface GenericHibernateDao<E, ID> {

	E findById(ID id);

	List<E> findAll();

	void saveOrUpdate(E e);

	void delete(E e);

	List<E> findByCriteria(Criterion... criterion);

}
