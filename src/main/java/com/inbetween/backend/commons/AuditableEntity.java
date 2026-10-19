package com.inbetween.backend.commons;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Objects;
import org.hibernate.annotations.CreationTimestamp;

@MappedSuperclass
public class AuditableEntity extends Entity implements Serializable {

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private String createdAt;

    @Column
    @CreationTimestamp
    private String updatedAt;

    protected AuditableEntity() {
        //jpa
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof AuditableEntity that)) {
            return false;
        }
        return Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(createdAt, updatedAt);
    }

    @Override
    public String toString() {
        return "AuditableEntity{" +
            "createdAt='" + createdAt + '\'' +
            ", updatedAt='" + updatedAt + '\'' +
            '}';
    }
}
