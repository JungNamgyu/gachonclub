package com.example.gachon_club.Club.Model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.time.LocalDateTime

@Parcelize
data class Board(var _id: Long?, var club:String, var title:String, var content:String, var name:String, var date: String?, var calendar: String?) : Parcelable