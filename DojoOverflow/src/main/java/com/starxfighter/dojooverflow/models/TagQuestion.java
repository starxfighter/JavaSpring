package com.starxfighter.dojooverflow.models;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="tag_questions")
public class TagQuestion {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="question_id")
    private Question question;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="tag_id")
    private Tag tag;

	public TagQuestion() {
	}

	public TagQuestion(Long iD, Date createdAt, Date updatedAt, Question question, Tag tag) {
		this.id = iD;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.question = question;
		this.tag = tag;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Tag getTag() {
		return tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}

	@Override
	public String toString() {
		return "TagQuestion [id=" + id + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", question="
				+ question + ", tag=" + tag + "]";
	}
	
	
//end
}
