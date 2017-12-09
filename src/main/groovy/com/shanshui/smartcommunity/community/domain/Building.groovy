package com.shanshui.smartcommunity.community.domain

import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToMany

@Entity
class Building implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id

    String number
    @ManyToOne(targetEntity = Community.class)
    Community community
    @OneToMany(targetEntity = Household)
    @JoinColumn(name = 'id')
    List<Household> households
    int totalHouseholds
    @Enumerated(EnumType.STRING)
    BuildingType type
}
