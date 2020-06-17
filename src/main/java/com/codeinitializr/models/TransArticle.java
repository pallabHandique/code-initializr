package com.codeinitializr.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * TransArticle
 */
@Entity
public class TransArticle  extends Auditable{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long articleId;

    @NotBlank(message = "* Please enter a title")    
    @Size(max = 1000)
    private String title;
 
    @Size(max = 5000)
	@NotBlank(message = "* Please enter a description")
    private String description;

    private String visibleTo;

    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_topic_id")
	private TransTopics transTopic;

    @Column(name = "content", columnDefinition = "longtext")
    private String content;
    
    @Column(name = "keywords", columnDefinition = "text")
    private String keywords;

    @Size(max = 1050)
    private String slug;

    @Column(columnDefinition = "tinyint(1) default 0")
    private Boolean isActive = true;

    private Integer displayOrder;


    public TransArticle() {
    }

    public TransArticle(Long articleId, String title, String description, String visibleTo, TransTopics transTopic, String content, String keywords, String slug, Boolean isActive, Integer displayOrder) {
        this.articleId = articleId;
        this.title = title;
        this.description = description;
        this.visibleTo = visibleTo;
        this.transTopic = transTopic;
        this.content = content;
        this.keywords = keywords;
        this.slug = slug;
        this.isActive = isActive;
        this.displayOrder = displayOrder;
    }

    public Long getArticleId() {
        return this.articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVisibleTo() {
        return this.visibleTo;
    }

    public void setVisibleTo(String visibleTo) {
        this.visibleTo = visibleTo;
    }

    public TransTopics getTransTopic() {
        return this.transTopic;
    }

    public void setTransTopic(TransTopics transTopic) {
        this.transTopic = transTopic;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getKeywords() {
        return this.keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getSlug() {
        return this.slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Boolean isIsActive() {
        return this.isActive;
    }

    public Boolean getIsActive() {
        return this.isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Integer getDisplayOrder() {
        return this.displayOrder;
    }

    public void setDisplayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
    }

    public TransArticle articleId(Long articleId) {
        this.articleId = articleId;
        return this;
    }

    public TransArticle title(String title) {
        this.title = title;
        return this;
    }

    public TransArticle description(String description) {
        this.description = description;
        return this;
    }

    public TransArticle visibleTo(String visibleTo) {
        this.visibleTo = visibleTo;
        return this;
    }

    public TransArticle transTopic(TransTopics transTopic) {
        this.transTopic = transTopic;
        return this;
    }

    public TransArticle content(String content) {
        this.content = content;
        return this;
    }

    public TransArticle keywords(String keywords) {
        this.keywords = keywords;
        return this;
    }

    public TransArticle slug(String slug) {
        this.slug = slug;
        return this;
    }

    public TransArticle isActive(Boolean isActive) {
        this.isActive = isActive;
        return this;
    }

    public TransArticle displayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof TransArticle)) {
            return false;
        }
        TransArticle transArticle = (TransArticle) o;
        return Objects.equals(articleId, transArticle.articleId) && Objects.equals(title, transArticle.title) && Objects.equals(description, transArticle.description) && Objects.equals(visibleTo, transArticle.visibleTo) && Objects.equals(transTopic, transArticle.transTopic) && Objects.equals(content, transArticle.content) && Objects.equals(keywords, transArticle.keywords) && Objects.equals(slug, transArticle.slug) && Objects.equals(isActive, transArticle.isActive) && Objects.equals(displayOrder, transArticle.displayOrder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(articleId, title, description, visibleTo, transTopic, content, keywords, slug, isActive, displayOrder);
    }

    @Override
    public String toString() {
        return "{" +
            " articleId='" + getArticleId() + "'" +
            ", title='" + getTitle() + "'" +
            ", description='" + getDescription() + "'" +
            ", visibleTo='" + getVisibleTo() + "'" +
            ", transTopic='" + getTransTopic() + "'" +
            ", content='" + getContent() + "'" +
            ", keywords='" + getKeywords() + "'" +
            ", slug='" + getSlug() + "'" +
            ", isActive='" + isIsActive() + "'" +
            ", displayOrder='" + getDisplayOrder() + "'" +
            "}";
    }
    
}