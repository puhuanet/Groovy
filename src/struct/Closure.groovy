package struct

def clouser
// 无参数
clouser = {
    println "Hello Groovy!"
}
// 通过call调用
clouser.call()
// 直接调用
clouser()

// 一个参数
clouser = {
    String name -> println "Hello ${name}!"
}
// 通过call调用
clouser.call("Groovy")
// 直接调用
clouser("Groovy")

// 多个参数
clouser = {
    String name,int age -> println "Hello ${name}, my age is ${age}!"
}
// 通过call调用
clouser.call("Groovy", 18)
// 直接调用
clouser("Groovy", 18)

// 默认参数
clouser = {
    println "Hello ${it}!"
}
// 通过call调用
clouser.call("Groovy")
// 直接调用
clouser("Groovy")

// 返回值为字符串
clouser = {
    return  "Hello Groovy!"
}
// 通过call调用
println clouser.call()
// 直接调用
println clouser()

// 返回值为null
clouser = {
    println  "Hello Groovy!"
}
// 通过call调用
println clouser.call()
// 直接调用
println clouser()

int x=5

// 求阶乘-upto()方法
int fab1(int number) {
    int result = 1
    result.upto(number, {num -> result *= num})
    return result
}
println fab1(x)

// 求阶乘-downto()方法
int fab2(int number) {
    int result = 1
    number.downto(1) {
        num -> result *= num
    }
    return result
}
println fab2(x)

int cal(int number) {
    int result = 0
    number.times {
        num -> result += num
    }
    return result
}
println cal(x)

// 字符串与闭包结合使用
String str = 'the 2 and 3 is 5'

// each
println str.each {
    String temp -> println temp.multiply(2)
}

// find
println str.find {
    String s -> s.isNumber()
}

// findAll
println str.findAll {
    String s -> s.isNumber()
}

// any
println str.any {
    String s -> s.isNumber()
}

// every
println str.every {
    String s -> s.isNumber()
}

// collect
println str.collect {
    it.toUpperCase()
}