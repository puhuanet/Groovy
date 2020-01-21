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

// 闭包的三个重要变量：this，owner和delegate
// this：代表闭包定义处的类
// owner：代表闭包定义处的类或者对象
// delegate：代表任意对象，默认与owner一致
clouser = {
    println this
    println owner
    println delegate
}
// 都是当前脚本的对象
clouser()

// 类内部静态闭包
class Boy {

    def static clouser = {
        println this
        println owner
        println delegate
    }

    def static say() {
        def clouser = {
            println this
            println owner
            println delegate
        }
        clouser.call()
    }

}
Boy.clouser()
Boy.say()

// 类内部动态闭包
class Girl {

    def clouser = {
        println this
        println owner
        println delegate
    }

    def say() {
        def clouser = {
            println this
            println owner
            println delegate
        }
        clouser.call()
    }

}
Girl girl = new Girl();
girl.clouser()
girl.say()

// 在闭包中定义闭包
def outerClouser = {
    def innerClouser = {
        println this
        println owner
        println delegate
    }
    innerClouser.delegate = girl
    innerClouser()
}
outerClouser()

// 闭包委托策略
class Student {
    String name
    def pretty = {
        "My name is ${name}"
    }
    String toString() {
        pretty.call()
    }
}

class Teacher {
    String name;
}

def student = new Student(name: 'Oliver')
def teacher = new Teacher(name: 'Cathy')
println student.toString()
student.pretty.delegate = teacher
// 修改委托策略
// DELEGATE_FIRST：先从delegate的对象中寻找
// DELEGATE_ONLY：只从delegate的对象中寻找
student.pretty.resolveStrategy = groovy.lang.Closure.DELEGATE_FIRST
println student.toString()