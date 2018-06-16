package com.starxfighter.dojooverflow.models;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="answers")
public class Answer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(columnDefinition="LONGTEXT")
	private String answerdt;
	@Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="question_id")
    private Question question;
    
	public Answer() {
	}

	public Answer(Long id, String answerdt, Date createdAt, Date updatedAt, Question question) {
		this.id = id;
		this.answerdt = answerdt;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.question = question;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAnswerdt() {
		return answerdt;
	}

	public void setAnswerdt(String answerdt) {
		this.answerdt = answerdt;
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

	public void setQuestions(Question question) {
		this.question = question;
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
		return "Answer [id=" + id + ", answerdt=" + answerdt + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
				+ ", questions=" + question + "]";
	}	
	
	
//end
}
