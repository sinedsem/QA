package ru.kapahgaiii.qa.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "questions")
public class Question {

    @Id
    @Column(name = "question_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "uid")
    private User user;


    @Column(name = "title")
    private String title;

    @Column(name = "text")
    private String text;

    @Column(name = "votes")
    private Integer votes;

    @Column(name = "messages")
    private Integer messages;

    @Column(name = "updated_time")
    private Timestamp updatedTime;


    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "question_tags",
            joinColumns = @JoinColumn(name = "question_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private Set<Tag> tags = new HashSet<Tag>();


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getVotes() {
        return votes;
    }

    public void setVotes(Integer votes) {
        this.votes = votes;
    }

    public void incrementVotes() {
        this.votes++;
    }

    public void decrementVotes() {
        this.votes--;
    }

    public Integer getMessages() {
        return messages;
    }

    public void incrementMessages(){
        messages++;
    }

    public void setMessages(Integer messages) {
        this.messages = messages;
    }

    public Timestamp getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Timestamp updatedTime) {
        this.updatedTime = updatedTime;
    }


    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Question question = (Question) o;

        if (id != null ? !id.equals(question.id) : question.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
