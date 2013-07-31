package de.rixtrick.demo.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;

import de.rixtrick.demo.dao.GenericHibernateDao;
import de.rixtrick.demo.model.PersistentObject;

/**
 * @author buehner
 * 
 */
public abstract class GenericHibernateDaoImpl<E extends PersistentObject, ID extends Serializable>
		implements GenericHibernateDao<E, ID> {

	/**
	 * Represents the class of the entity
	 */
	private Class<E> clazz;

	protected GenericHibernateDaoImpl(Class<E> clazz) {
		this.clazz = clazz;
	}

	/**
	 * Hibernate SessionFactory
	 */
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public E findById(ID id) {
		return (E) getSession().get(clazz, id);
	}

	/**
	 * Returns all Entities by calling findByCriteria(), i.e. without arguments.
	 * 
	 * @see GenericHibernateDaoImpl#findByCriteria(Criterion...)
	 * @return All entities
	 */
	@Override
	public List<E> findAll() {
		return findByCriteria();
	}

	@Override
	public void saveOrUpdate(E e) {
		e.setModified(DateTime.now());
		getSession().saveOrUpdate(e);
	}

	@Override
	public void delete(E e) {
		getSession().delete(e);
	}

	/**
	 * Gets the results, that match a variable number of passed criterions. Call
	 * this method without arguments to find all entities.
	 * 
	 * @param criterion
	 *            A variable number of hibernate criterions
	 * @return Entities matching the passed hibernate criterions
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<E> findByCriteria(Criterion... criterion) {
		Criteria criteria = getSession().createCriteria(clazz);
		for (Criterion c : criterion) {
			criteria.add(c);
		}
		return criteria.list();
	}

}
