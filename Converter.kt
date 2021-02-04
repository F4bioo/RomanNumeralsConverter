import java.util.*

fun main() {

    fun intToRoman(number: Int): String {
        val map = TreeMap<Int, String>()
        map[1000] = "M"
        map[900] = "CM"
        map[500] = "D"
        map[400] = "CD"
        map[100] = "C"
        map[90] = "XC"
        map[50] = "L"
        map[40] = "XL"
        map[10] = "X"
        map[9] = "IX"
        map[5] = "V"
        map[4] = "IV"
        map[1] = "I"

        val key = map.floorKey(number)

        return if (number == key) {
            map[key].toString()

        } else {
            map[key].toString() + intToRoman(number - key)
        }
    }
    println(intToRoman(900))

    fun romanToInt(roman: String): Int {
        val map = HashMap<Char, Int>()
        map['I'] = 1
        map['V'] = 5
        map['X'] = 10
        map['L'] = 50
        map['C'] = 100
        map['D'] = 500
        map['M'] = 1000

        var result = 0
        for (i in roman.indices) {
            result += if (i > 0 && map[roman[i]]!! > map[roman[i - 1]]!!) {
                (map[roman[i]]!! - 2 * map[roman[i - 1]]!!)
            } else {
                map[roman[i]]!!
            }
        }
        return result
    }
    println(romanToInt("CM"))
}
