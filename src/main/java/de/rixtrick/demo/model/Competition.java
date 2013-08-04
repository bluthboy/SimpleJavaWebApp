package de.rixtrick.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

/**
 * @author buehner
 * 
 */
@Entity
@Table
public class Competition extends PersistentObject {

	private static final long serialVersionUID = 1867737649008505171L;

	@Column(length = 64)
	private String name;

	@Column(length = 64)
	private String sport;

	@Column(length = 32)
	private String code;

	private Integer level;

	private Integer startYear;

	private Integer endYear;

	@OneToMany(mappedBy = "competition", cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@OrderBy("orderIndex")
	private List<MatchDay> matchDays = new ArrayList<MatchDay>();

	public Competition() {
	}

	public Competition(String name, String sport, Integer level,
			Integer startYear, Integer endYear) {
		this.name = name;
		this.sport = sport;
		this.level = level;
		this.startYear = startYear;
		this.endYear = endYear;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSport() {
		return sport;
	}

	public void setSport(String sport) {
		this.sport = sport;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getStartYear() {
		return startYear;
	}

	public void setStartYear(Integer startYear) {
		this.startYear = startYear;
	}

	public Integer getEndYear() {
		return endYear;
	}

	public void setEndYear(Integer endYear) {
		this.endYear = endYear;
	}

	public List<MatchDay> getMatchDays() {
		return matchDays;
	}

	public void setMatchDays(List<MatchDay> matchDays) {
		this.matchDays = matchDays;
	}

}
