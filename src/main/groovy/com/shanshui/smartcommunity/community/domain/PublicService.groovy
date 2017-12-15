package com.shanshui.smartcommunity.community.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class PublicService implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id
    String description
    String number
    String district
}
