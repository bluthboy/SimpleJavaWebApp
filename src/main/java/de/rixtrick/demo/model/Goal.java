/**
 * 
 */
package de.rixtrick.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author buehner
 * 
 */
@Entity
@Table
public class Goal extends PersistentObject {

	private static final long serialVersionUID = -5973714555707116724L;

	public static final String GOAL_GETTER = "goalGetter";

	// TODO Match

	@Column
	Integer matchMinute;

	@ManyToOne
	@JoinColumn(name = GOAL_GETTER)
	private GoalGetter goalGetter;

	@Column
	private boolean homeGoal;

	@Column
	private boolean penalty = false;

	@Column
	private boolean ownGoal = false;

	@Column
	private boolean overTime = false;

	@Column
	private String comment;

	public Goal() {

	}

	public Integer getMatchMinute() {
		return matchMinute;
	}

	public void setMatchMinute(Integer matchMinute) {
		this.matchMinute = matchMinute;
	}

	public GoalGetter getGoalGetter() {
		return goalGetter;
	}

	public void setGoalGetter(GoalGetter goalGetter) {
		this.goalGetter = goalGetter;
	}

	public boolean isHomeGoal() {
		return homeGoal;
	}

	public void setHomeGoal(boolean homeGoal) {
		this.homeGoal = homeGoal;
	}

	public boolean isPenalty() {
		return penalty;
	}

	public void setPenalty(boolean penalty) {
		this.penalty = penalty;
	}

	public boolean isOwnGoal() {
		return ownGoal;
	}

	public void setOwnGoal(boolean ownGoal) {
		this.ownGoal = ownGoal;
	}

	public boolean isOverTime() {
		return overTime;
	}

	public void setOverTime(boolean overTime) {
		this.overTime = overTime;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
