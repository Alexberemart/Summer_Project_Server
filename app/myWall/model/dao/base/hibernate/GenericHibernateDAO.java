package myWall.model.dao.base.hibernate;

import java.io.Serializable;

/**
 * GenericDAO extension for Hibernate based implementations
 *
 */
public interface GenericHibernateDAO<T, ID extends Serializable> extends myWall.model.dao.base.GenericDAO<T, ID> {
	//
}
