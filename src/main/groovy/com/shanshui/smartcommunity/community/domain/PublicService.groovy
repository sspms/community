package com.shanshui.smartcommunity.community.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class PublicService implements Serializable {
    @Id
    @GeneratedValue
    Long id
    String description
    String number
}
