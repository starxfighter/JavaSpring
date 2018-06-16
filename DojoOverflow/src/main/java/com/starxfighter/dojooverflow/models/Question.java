package com.starxfighter.dojooverflow.models;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="questions")
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(columnDefinition="LONGTEXT")
	private String questiondt;
	@Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    @OneToMany(mappedBy="question", fetch=FetchType.LAZY)
    private List<Answer> answers;
    
    @OneToMany(mappedBy="question", fetch=FetchType.LAZY)
    @JsonIgnore
    private List<TagQuestion> tagQuestions;
    
    public Question() {
	}

	public Question(Long id, String questiondt, Date createdAt, Date updatedAt, List<Answer> answers,
			List<TagQuestion> tagQuestions) {
		this.id = id;
		this.questiondt = questiondt;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.answers = answers;
		this.tagQuestions = tagQuestions;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQuestiondt() {
		return questiondt;
	}

	public void setQuestiondt(String questiondt) {
		this.questiondt = questiondt;
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

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public List<TagQuestion> getTagQuestions() {
		return tagQuestions;
	}

	public void setTagQuestions(List<TagQuestion> tagQuestions) {
		this.tagQuestions = tagQuestions;
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
		return "Question [id=" + id + ", questiondt=" + questiondt + ", createdAt=" + createdAt + ", updatedAt="
				+ updatedAt + ", answers=" + answers + ", tagQuestions=" + tagQuestions + "]";
	}
	
	
//end
}
