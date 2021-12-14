package com.acsent.androidmista.network
import android.text.format.DateUtils
import com.squareup.moshi.Json
import java.text.SimpleDateFormat
import java.util.*

data class TopicsListItem (
    val id: String,
    val forum: String,
    @Json(name = "sect1") val section: String?,
    @Json(name = "user0") val author: String?,
    val user: String?,
    val created: String,
    @Json(name = "utime") val updated: Long,
    @Json(name = "answ") val count: String,
    val text: String

/*
    var sect2: String = ""
    var v8: String = ""
    var closed: Int = 0
    var down: Int = 0
    var text: String = ""
    var is_voting: Int = 0
    var answ: Int = 0
 */
) {
fun getUpdatedStr(): String {
    val pattern: String = if (DateUtils.isToday(updated * 1000)) "HH:mm" else "dd.MM.yy"

    val date = Date(updated * 1000)
    val sdf = SimpleDateFormat(pattern)
    return sdf.format(date)
    }
}