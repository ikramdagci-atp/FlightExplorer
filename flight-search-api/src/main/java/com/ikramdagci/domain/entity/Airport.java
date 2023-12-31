package com.ikramdagci.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "t_airport")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Airport extends BaseEntity{

    private String city;
    @Column(unique = true)
    private String code;

}
