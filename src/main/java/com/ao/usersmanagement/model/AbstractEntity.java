package com.ao.usersmanagement.model;

import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

public abstract class AbstractEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Column(name = "creation_date", columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP")
    private LocalDateTime creationDate = LocalDateTime.now();

    @UpdateTimestamp
    @Column(name = "last_update_date", columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP")
    private LocalDateTime lastUpdateDate = LocalDateTime.now();

    @PrePersist
    protected void onCreate() {
        var currentDate = LocalDateTime.now();
        this.creationDate = currentDate;
        this.lastUpdateDate = currentDate;
    }

    @PreUpdate
    protected void onUpdate() {
        this.lastUpdateDate = LocalDateTime.now();
    }

}