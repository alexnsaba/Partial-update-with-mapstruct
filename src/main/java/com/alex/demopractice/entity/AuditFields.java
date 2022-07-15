package com.alex.demopractice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
public class AuditFields implements Serializable {
    @Schema(example = "alexNsaba")
    private String updatedBy;

    @Schema(example = "alexNsaba")
    private String createdBy;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private LocalDateTime whenUpdated;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private LocalDateTime whenCreated;

    @JsonIgnore
    private boolean deleted;

    @JsonIgnore
    private LocalDateTime whenDeleted;
}
