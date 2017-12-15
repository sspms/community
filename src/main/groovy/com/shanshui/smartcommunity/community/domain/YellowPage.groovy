package com.shanshui.smartcommunity.community.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.OneToMany

@Entity
class YellowPage implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id
    String district
    @OneToMany
    @JoinColumn(name = 'id')
    List<PublicService> services
    String description
}
