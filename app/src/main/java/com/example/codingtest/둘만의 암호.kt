package com.example.codingtest

fun main() {
    val s ="aukks"
    val index = 5
    val skip = "wbqd"

    // skip 데이터 List<Char> 변환
    val skipped: List<Char> = skip.map { it }
    // alphabet 리스트에서 skipped 필터 사용(제거)
    val alphabet = ('a'..'z').filter { it !in skipped }

    var answer = ""
    s.forEach {
        val i = (alphabet.indexOf(it) + index) % alphabet.size
        answer += alphabet[i]
    }
}

fun main1() {
    var alphabets = "abcdefghijklmnopqrstuvwxyz"
    val s ="aukks"
    val index = 5
    val skip = "wbqd"

    for (i in skip.indices) {
        alphabets = alphabets.replace(skip[i].toString(), "")
    }

    val alphabetSize = alphabets.length


    val sb = StringBuffer()
    for(i in s.indices) {
        val where: Int = alphabets.indexOf(s[i])
        println("where: $where")

        var targetAlphabet: Char
        var targetIndex: Int
        try {
            targetIndex = where + index
            targetAlphabet = alphabets[targetIndex]

            if (skip.contains(targetAlphabet)) targetAlphabet = alphabets[targetIndex + 1]
            sb.append(targetAlphabet)
        } catch (e: StringIndexOutOfBoundsException) {
            targetIndex =  (where + index) - alphabetSize
            targetAlphabet = alphabets[targetIndex]

            if (skip.contains(targetAlphabet))targetAlphabet = alphabets[targetIndex + 1]
            sb.append(targetAlphabet)
        }
    }



    print(sb.toString())
}

