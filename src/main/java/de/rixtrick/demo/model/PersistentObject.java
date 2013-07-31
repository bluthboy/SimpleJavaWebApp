/**
 * Inspired by
 * http://ocpsoft.org/java/hibernate-use-a-base-class-to-map-common-fields/
 */
package de.rixtrick.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.joda.time.ReadableDateTime;

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

	public static final String ID = "id";
	public static final String CREATED = "created";
	public static final String MODIFIED = "modified";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private final Integer id = null;

	@Column(name = "created")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private final ReadableDateTime created;

	@Column(name = "modified")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private ReadableDateTime modified;

	protected PersistentObject() {
		this.created = DateTime.now();
		this.modified = DateTime.now();
	}

	public Integer getId() {
		return id;
	}

	public ReadableDateTime getCreated() {
		return created;
	}

	public ReadableDateTime getModified() {
		return modified;
	}

	public void setModified(ReadableDateTime modified) {
		this.modified = modified;
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

	@Override
	public String toString() {
		return String.valueOf(id);
	}

}
