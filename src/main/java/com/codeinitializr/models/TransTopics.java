package com.codeinitializr.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * TransTopics
 */
@Entity
public class TransTopics  extends Auditable {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
    private Long topicId;
    
    @NotBlank(message = "Topic name is required")
    @Size(max = 400)
    private String name;
    
    @NotBlank(message = "Topic description is required")
    @Size(max = 5000)
    private String description;
    
    @Column(columnDefinition = "tinyint(1) default 0")
    private boolean isActive = true;

    private String visibleTo;

    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parent_topic_id")
	private TransTopics parentTopic;

	@OneToMany(mappedBy = "parentTopic", fetch = FetchType.LAZY)
    private List<TransTopics> subTopics = new ArrayList<>();

    @Size(max = 450)
    private String slug;

    private Integer displayOrder;

    public TransTopics() {
    }

    public TransTopics(Long topicId, String name, String description, boolean isActive, String visibleTo, TransTopics parentTopic, List<TransTopics> subTopics, String slug, Integer displayOrder) {
        this.topicId = topicId;
        this.name = name;
        this.description = description;
        this.isActive = isActive;
        this.visibleTo = visibleTo;
        this.parentTopic = parentTopic;
        this.subTopics = subTopics;
        this.slug = slug;
        this.displayOrder = displayOrder;
    }

    public Long getTopicId() {
        return this.topicId;
    }

    public void setTopicId(Long topicId) {
        this.topicId = topicId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isIsActive() {
        return this.isActive;
    }

    public boolean getIsActive() {
        return this.isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public String getVisibleTo() {
        return this.visibleTo;
    }

    public void setVisibleTo(String visibleTo) {
        this.visibleTo = visibleTo;
    }

    public TransTopics getParentTopic() {
        return this.parentTopic;
    }

    public void setParentTopic(TransTopics parentTopic) {
        this.parentTopic = parentTopic;
    }

    public List<TransTopics> getSubTopics() {
        return this.subTopics;
    }

    public void setSubTopics(List<TransTopics> subTopics) {
        this.subTopics = subTopics;
    }

    public String getSlug() {
        return this.slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Integer getDisplayOrder() {
        return this.displayOrder;
    }

    public void setDisplayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
    }

    public TransTopics topicId(Long topicId) {
        this.topicId = topicId;
        return this;
    }

    public TransTopics name(String name) {
        this.name = name;
        return this;
    }

    public TransTopics description(String description) {
        this.description = description;
        return this;
    }

    public TransTopics isActive(boolean isActive) {
        this.isActive = isActive;
        return this;
    }

    public TransTopics visibleTo(String visibleTo) {
        this.visibleTo = visibleTo;
        return this;
    }

    public TransTopics parentTopic(TransTopics parentTopic) {
        this.parentTopic = parentTopic;
        return this;
    }

    public TransTopics subTopics(List<TransTopics> subTopics) {
        this.subTopics = subTopics;
        return this;
    }

    public TransTopics slug(String slug) {
        this.slug = slug;
        return this;
    }

    public TransTopics displayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof TransTopics)) {
            return false;
        }
        TransTopics transTopics = (TransTopics) o;
        return Objects.equals(topicId, transTopics.topicId) && Objects.equals(name, transTopics.name) && Objects.equals(description, transTopics.description) && isActive == transTopics.isActive && Objects.equals(visibleTo, transTopics.visibleTo) && Objects.equals(parentTopic, transTopics.parentTopic) && Objects.equals(subTopics, transTopics.subTopics) && Objects.equals(slug, transTopics.slug) && Objects.equals(displayOrder, transTopics.displayOrder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(topicId, name, description, isActive, visibleTo, parentTopic, subTopics, slug, displayOrder);
    }

    @Override
    public String toString() {
        return "{" +
            " topicId='" + getTopicId() + "'" +
            ", name='" + getName() + "'" +
            ", description='" + getDescription() + "'" +
            ", isActive='" + isIsActive() + "'" +
            ", visibleTo='" + getVisibleTo() + "'" +
            ", parentTopic='" + getParentTopic() + "'" +
            ", subTopics='" + getSubTopics() + "'" +
            ", slug='" + getSlug() + "'" +
            ", displayOrder='" + getDisplayOrder() + "'" +
            "}";
    }

}
