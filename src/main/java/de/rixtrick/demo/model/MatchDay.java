package de.rixtrick.demo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author buehner
 * 
 */
@Entity
@Table
public class MatchDay extends PersistentObject {

	private static final long serialVersionUID = -5590146487017453822L;

	private String name;

	private Integer orderIndex;

	// TODO League

	// LocalDate start;

	// LocalDate end;

	@OneToMany(mappedBy = "matchDay", cascade = { CascadeType.ALL })
	private Set<Match> matches = new HashSet<Match>();

	public MatchDay() {
	}

	public MatchDay(String name, Integer orderIndex) {
		this.name = name;
		this.orderIndex = orderIndex;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getOrderIndex() {
		return orderIndex;
	}

	public void setOrderIndex(Integer orderIndex) {
		this.orderIndex = orderIndex;
	}

	public Set<Match> getMatches() {
		return matches;
	}

	public void setMatches(Set<Match> matches) {
		this.matches = matches;
	}

}
