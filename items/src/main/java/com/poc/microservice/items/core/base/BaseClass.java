package com.poc.microservice.items.core.base;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

/**
 * Esta es la clase base que utilizaremos en las demas entidades
 * @author Emilio
 */
@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class) /** Esto nos permite utilizar las anotaciones de CreateDate por ejemplo */
public class BaseClass {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @CreatedDate
    private Date created;

    @LastModifiedDate
    private Date modified;

    @Version
    private int version;
}
