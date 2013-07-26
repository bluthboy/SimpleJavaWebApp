/**
 * Inspired by
 * http://ocpsoft.org/java/hibernate-use-a-base-class-to-map-common-fields/
 */
package de.rixtrick.demo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * This class represents the abstract superclass for all entities that are
 * persisted in the database.
 * 
 * @author buehner
 * 
 */
@MappedSuperclass
public abstract class PersistentObject implements Serializable {

	private static final long serialVersionUID = 8132816717625996240L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private final Long id = null;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created")
	private final Date created;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated")
	private Date updated;

	protected PersistentObject() {
		this.created = now();
		this.updated = now();
	}

	protected Date now() {
		return new Date();
	}

	protected void update() {
		this.updated = now();
	}

	public Long getId() {
		return id;
	}

	public Date getCreated() {
		return created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = prime + ((created == null) ? 0 : created.hashCode());
		return result;
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof PersistentObject))
			return false;
		PersistentObject other = (PersistentObject) obj;
		if (created == null) {
			if (other.created != null)
				return false;
		} else if (!created.equals(other.created))
			return false;
		return true;
	}

}
