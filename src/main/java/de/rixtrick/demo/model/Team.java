package de.rixtrick.demo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author buehner
 * 
 */
@Entity
@Table(name = "TEAMS")
public class Team extends PersistentObject {

	private static final long serialVersionUID = -3347746010176522188L;

	public static final String NAME = "name";
	public static final String ICON_URL = "iconUrl";
	public static final String SQUAD = "squad";

	@Column(name = "name", nullable = false, unique = true, length = 64)
	private String name;

	@Column(name = "icon")
	private String iconUrl;

	@OneToMany(mappedBy = GoalGetter.CURRENT_TEAM, cascade = { CascadeType.ALL })
	private Set<GoalGetter> squad = new HashSet<GoalGetter>();

	public Team() {
	}

	public Team(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIconUrl() {
		return iconUrl;
	}

	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}

	public Set<GoalGetter> getSquad() {
		return squad;
	}

	public void setSquad(Set<GoalGetter> squad) {
		this.squad = squad;
	}

	@Override
	public String toString() {
		return name + ", id : " + getId() + ", created at " + getCreated()
				+ ", updated at " + getModified();
	}

}
