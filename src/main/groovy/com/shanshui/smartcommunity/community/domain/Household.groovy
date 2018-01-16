package com.shanshui.smartcommunity.community.domain

import com.shanshui.smartcommunity.user.domain.User
import org.springframework.format.annotation.DateTimeFormat

import javax.persistence.*

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

    @DateTimeFormat(style = 'yyyy-MM')
    Date lastPropertyFeePayed
}
