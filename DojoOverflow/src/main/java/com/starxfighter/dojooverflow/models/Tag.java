package com.starxfighter.dojooverflow.models;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="tags")
public class Tag {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String subject;
	@Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    @OneToMany(mappedBy="tag", fetch=FetchType.LAZY)
    @JsonIgnore
    private List<TagQuestion> tagQuestions;
    
	public Tag() {
	}

	public Tag(Long id, String subject, Date createdAt, Date updatedAt, List<TagQuestion> tagQuestions) {
		this.id = id;
		this.subject = subject;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.tagQuestions = tagQuestions;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
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
		return "Tag [id=" + id + ", subject=" + subject + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
				+ ", tagQuestions=" + tagQuestions + "]";
	}
	
	
//end
}
