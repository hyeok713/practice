package com.example.codingtest

import java.util.*

fun main() {
    val book_time = arrayOf(
        arrayOf("15:00", "17:00"),
        arrayOf("16:40", "18:20"),
        arrayOf("14:20", "15:20"),
        arrayOf("14:10", "19:20"),
        arrayOf("18:20", "21:20"),
    )

    val bookList = ArrayList<Book>()
    for (bookTime in book_time) {
        val checkInTime = toMinute(bookTime[0])
        val checkOutTime = toMinute(bookTime[1])

        bookList.add(Book(checkInTime, checkOutTime))
    }

    bookList.sortWith { o1, o2 ->
        return@sortWith if (o1.checkIn == o2.checkOut) {
            o1.checkOut - o2.checkOut
        } else {
            o1.checkIn - o2.checkIn
        }
    }

    val checkOutTimeList = ArrayList<Int>()

    for (book in bookList) {
        var roomRequired = false
        checkOutTimeList.sort()
        for (i in 0 until checkOutTimeList.size) {
            val deadline = checkOutTimeList[i] + 9
            if (book.checkIn >= deadline) {
                checkOutTimeList[i] = book.checkOut
                roomRequired = true
            }
        }
        if(!roomRequired) checkOutTimeList.add(book.checkOut)
    }

    println(checkOutTimeList.size)
}

fun toMinute(time: String): Int {
    val split = time.split(":")
    val hour = Integer.parseInt(split[0])
    val minute = Integer.parseInt(split[1])
    return hour * 60 + minute
}

data class Book(val checkIn: Int, val checkOut: Int)


fun main2() {

    val CHECK_IN = 0
    val CHECK_OUT = 1

    val book_time = arrayOf(
        arrayOf("15:00", "17:00"),
        arrayOf("16:40", "18:20"),
        arrayOf("14:20", "15:20"),
        arrayOf("14:10", "19:20"),
        arrayOf("18:20", "21:20"),
    )

    val stl: StringTokenizer
    val bookTime = book_time.map { arr ->
        arr.map { str -> str.replace(":", "").toInt() }
    }.also {
        it.map { time ->
            val result = time[CHECK_OUT] + 9
            if (result % 100 > 60) {
                result + 100 + (result % 10)
            }
            result
        }
    }   // 퇴실 시간 9 분 더해주어, 청소가 끝나는 시간에 예약이 불가능 한 것을 방지

    val roomArr = ArrayList<List<Int>>()

    for (crntBook in bookTime) {
        var roomRequired = true
        for (prevBook in roomArr) {
            if (!roomRequired) break

            val a = prevBook[CHECK_OUT] > crntBook[CHECK_IN]
            val b = crntBook[CHECK_OUT] > prevBook[CHECK_IN]
            roomRequired = a && b
        }

        if (roomRequired) {
            println("방 배정")
            roomArr.add(crntBook)
        }

    }
    println(roomArr.size)
}