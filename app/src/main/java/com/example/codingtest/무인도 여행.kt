package com.example.codingtest

import java.util.*


fun main() {
//    solution(
//        arrayOf(
//            "X591X",
//            "X1X5X",
//            "X231X",
//            "1XXX1"
//        )
//    )

    val queue: Queue<String> = LinkedList()
    queue.offer("1,2")
    queue.offer("1,2")

    queue.toList().distinct().forEach {
        println("list: $it")
    }

}

fun solution(maps: Array<String>): IntArray? {
    val xAxis = maps[0].length
    val yAxis = maps.size

    var left: Int = 0
    var right: Int = 0
    var top: Int = 0
    var bottom: Int = 0

    val que: Queue<String> = LinkedList()   // 좌표값 넣을때 사용.
    val que2: Queue<Int> = LinkedList() // Int 값 넣을때 사용
    for (y in 0 until yAxis) {
        for (x in 0 until xAxis) {
            try {
                if (maps[y][x].isDigit()) {
                    que.offer("$y,$x")
                    // 본인이 숫자이면 주변 확인 == 연결 됬는지 확인하는 과정임
                    left = x - 1
                    maps[y][left]
                    right = x + 1
                }

            } catch (e: IndexOutOfBoundsException) {
                continue
            }
        }
    }
    return null
}