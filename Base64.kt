val baseAscii = listOf('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q','R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 
'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/')        
fun main() {
    val cadena = "this is a string!!"
    println(toBase64(cadena))
}

private fun toBase64(cadena: String): String {
    var binaryData: String = ""
    cadena.forEach { letter ->
        binaryData += fillBytes(Integer.toBinaryString(letter.code));
    }
    val result = separate6bits(binaryData)
    var baseReturn = ""
    result.forEach { item ->
        baseReturn += baseAscii[item]
    }
    return baseReturn
}

private fun fillBytes(binaryNumber: String): String {
    var singleNumber = binaryNumber
    for(i in binaryNumber.length..7) {
        singleNumber = "0" + singleNumber
    }
    return singleNumber
}

private fun separate6bits(binaryString: String): ArrayList<Int> {
    var counter = 0
    var binaryNumber: String = ""
    var lista: ArrayList<Int> = ArrayList()
    binaryString.forEach { item ->
        if(counter < 6) {
            binaryNumber += item
            counter++
        } else {
            lista.add(convertBinaryToDecimal(binaryNumber.toLong()))
            counter = 1
            binaryNumber = item.toString()
        }
     }
     return lista
}

fun convertBinaryToDecimal(num: Long): Int {
    var num = num
    var decimalNumber = 0
    var i = 0
    var remainder: Long

    while (num.toInt() != 0) {
        remainder = num % 10
        num /= 10
        decimalNumber += (remainder * Math.pow(2.0, i.toDouble())).toInt()
        ++i
    }
    return decimalNumber
}