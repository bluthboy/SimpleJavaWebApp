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
@Table(name = "GOALS")
public class Goal extends PersistentObject {

	private static final long serialVersionUID = -5973714555707116724L;

	public static final String GOAL_GETTER = "goalGetter";

	// TODO Match

	@Column(name = "matchMinute")
	Integer matchMinute;

	@ManyToOne
	@JoinColumn(name = GOAL_GETTER)
	private GoalGetter goalGetter;

	@Column(name = "homeGoal")
	private boolean homeGoal;

	@Column(name = "penalty")
	private boolean penalty = false;

	@Column(name = "ownGoal")
	private boolean ownGoal = false;

	@Column(name = "overTime")
	private boolean overTime = false;

	@Column(name = "comment")
	private String comment;

	public Goal() {

	}

	public Integer getMatchMinute() {
		return matchMinute;
	}

	public void setMatchMinute(Integer matchMinute) {
		this.matchMinute = matchMinute;
		update();
	}

	public GoalGetter getGoalGetter() {
		return goalGetter;
	}

	public void setGoalGetter(GoalGetter goalGetter) {
		this.goalGetter = goalGetter;
		update();
	}

	public boolean isHomeGoal() {
		return homeGoal;
	}

	public void setHomeGoal(boolean homeGoal) {
		this.homeGoal = homeGoal;
		update();
	}

	public boolean isPenalty() {
		return penalty;
	}

	public void setPenalty(boolean penalty) {
		this.penalty = penalty;
		update();
	}

	public boolean isOwnGoal() {
		return ownGoal;
	}

	public void setOwnGoal(boolean ownGoal) {
		this.ownGoal = ownGoal;
		update();
	}

	public boolean isOverTime() {
		return overTime;
	}

	public void setOverTime(boolean overTime) {
		this.overTime = overTime;
		update();
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
		update();
	}
}
