package com.shanshui.smartcommunity.community.domain

import javax.persistence.*

@Entity
class Household implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id
    String number
    //User owner
    double area
    @ManyToOne
    Building building
    @ManyToOne
    Community community
    String unit = 'm2'
}
