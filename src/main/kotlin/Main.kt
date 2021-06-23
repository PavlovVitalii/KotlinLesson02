import kotlin.collections.Set as Set

fun main() {

    println("__________TASK_01__________")
    val result01 = task01("aA", "aAAbbbb")
    println("Количество драгоценных камней : $result01")
    println()

    println("__________TASK_02__________")
    val result02 = task02("UD")
    println(if (result02) "Робот вернусля на начальную точку." else "Робот не вернулся на начальную точку.")
    println()

    println("__________TASK_03__________")
    val result03 = task03(arrayOf("a@leetcode.com","b@leetcode.com","c@leetcode.com"))
    println("Количество уникальных адрессов : $result03")

}


fun task01(jewels: String, stones: String): Int {

    var stonesCount = 0
    val jewelsSet = jewels.toCharArray().toSet()
    val stonesArr = stones.toCharArray()

    for (i in jewelsSet) {
        for (j in stonesArr) {
            if (i == j) {
                stonesCount++
            }
        }
    }

    return stonesCount
}

fun task02(moves: String): Boolean {

    var x = 0
    var y = 0
    val moveArr = moves.toCharArray()

    for (i in moveArr) {

        when (i) {
            'U' -> y++
            'D' -> y--
            'R' -> x++
            'L' -> x--
        }
    }

    return x == 0 && y == 0
}

fun task03(emails: Array<String>): Int {

    var result = 0
    var mailSet = hashSetOf<String>()

    for (i in emails) {
        var name = i.substringBefore("@").replace(".", "")

        if ("+" in name) {
            name = name.substringBefore("+")
        }

        var domen = i.substringAfter("@")
        var mail = "$name@$domen"
        mailSet.add(mail)
    }
    result += mailSet.size

    return result
}


