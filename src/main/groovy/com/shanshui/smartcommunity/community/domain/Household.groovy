package com.shanshui.smartcommunity.community.domain

import org.hibernate.annotations.Target
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties

import javax.persistence.*
import com.shanshui.smartcommunity.user.domain.User

@Entity
class Household implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id
    String number

    @Column(updatable = true)
    User owner
    double area

    @ManyToOne(targetEntity = Building.class)
    Building building

    @ManyToOne(targetEntity = Community.class)
    Community community
    String unit = 'm2'
}
