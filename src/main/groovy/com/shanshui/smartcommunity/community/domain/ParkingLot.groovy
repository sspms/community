package com.shanshui.smartcommunity.community.domain

import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.Id
import javax.persistence.ManyToOne

/**
 * Created by I336253 on 11/22/2017.
 */
@Entity
class ParkingLot implements Serializable {
    @Id
    int id

    @ManyToOne
    Community community
    @ManyToOne
    Household household

    long user

    @Enumerated(EnumType.STRING)
    OwnershipStatus ownership

    @Enumerated(EnumType.STRING)
    ParkingStatus status

    String number

    Date date // start date, sold or rent
    // there might be a layout image to indicate where this parking lot is
    String layoutUrl
    enum OwnershipStatus {
        SOLD,
        RENT,
        SHARE,
        NOT_OPEN
    }

    enum ParkingStatus {
        OCCUPIED,
        OPEN
    }
}
