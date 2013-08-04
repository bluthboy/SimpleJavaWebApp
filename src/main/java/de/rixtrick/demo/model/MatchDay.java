package de.rixtrick.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

	@Column(length = 64)
	private String name;

	private Integer orderIndex;

	@ManyToOne
	@JoinColumn(name = "competition_id")
	private Competition competition;

	// LocalDate start;

	// LocalDate end;

	@OneToMany(mappedBy = "matchDay", cascade = { CascadeType.ALL })
	private List<Match> matches = new ArrayList<Match>();

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

	public Competition getCompetition() {
		return competition;
	}

	public void setCompetition(Competition competition) {
		this.competition = competition;
	}

	public List<Match> getMatches() {
		return matches;
	}

}
