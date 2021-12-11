package com.acsent.androidmista

import org.json.JSONObject
import java.net.HttpURLConnection
import java.net.URL
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*

class TopicsListRequest {
    // число тем, которые нужно вернуть (по умолчанию - 20)
    var topics: Int? = null
    // время (в формате unixtime) после которого надо вернуть ветки;
    var utime: Int? = null
    // если указано, то ответ заворачивается в вызов функции, имя которой передано в параметре (реализация JSONP)
    var callback: String? = null
    // раздел форума (1c|it|life);
    var forum: String? = null
    var section_short_name: String? = null
    var user_id: String? = null
    var mytopics: String? = null

}

class TopicsListItemResponse {
    var id: Int = 0
    var forum: String = ""
    var sect1: String = ""
    var sect2: String = ""
    var v8: String = ""
    var closed: Int = 0
    var down: Int = 0
    var text: String = ""
    var utime: Int = 0
    var created: Int = 0
    var user: String = ""
    var user0: String = ""
    var is_voting: Int = 0
    var answ: Int = 0
}

object API {

    val domain: String = "https://forum.mista.ru"
    val urlTopicsList: String = "api/topic.php"

    fun getTopicsList(request: TopicsListRequest? = null): Array<TopicsListItemResponse> {

        var item1 = TopicsListItemResponse()
        item1.id = 1
        item1.user0 = "user0_1"
        item1.user  = "user_1"
        item1.sect1 = "sect1_1"
        item1.text  = "topic <b>bold</b> 1о дардврплодв по авлпр пр ваполдарв дплора впорв д вапдрвдлопр волпр а"
        item1.answ  = 20

        var item2= TopicsListItemResponse()
        item2.id = 2
        item2.user0 = "user0_2"
        item2.user  = "user_2"
        item2.sect1 = "sect1_2"
        item2.text  = "topic <b>bold</b> 2"
        item2.answ  = (1..200).random()
        return arrayOf(item1, item2, item1, item2)
    }

}