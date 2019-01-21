package com.learn.growthcodelab.viewshowcase.viewpager.lifecycle

import android.os.Parcel
import android.os.Parcelable

class LikeItem(
        val index: Int, var amount: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readInt())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(index)
        parcel.writeInt(amount)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<LikeItem> {
        override fun createFromParcel(parcel: Parcel): LikeItem {
            return LikeItem(parcel)
        }

        override fun newArray(size: Int): Array<LikeItem?> {
            return arrayOfNulls(size)
        }

        fun generateLikeItems() = (0..9).toList().map { LikeItem(it, 9-it) }
    }

}