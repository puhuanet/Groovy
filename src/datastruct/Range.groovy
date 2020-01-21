package datastruct

// Range的定义
def range = 1..10
println range
println range.class

// Range的获取
println range[0]
println range.contains(10)
// 起始值
println range.from
println range.to

// Range的操作与List一样

// Range的遍历

// each
range.each {
    println it
}

// for
for (i in range) {
    println i
}

// switch
def getGrade(Number number) {
    def result
    switch (number) {
        case 0..<60:
            result = '不及格'
            break
        case 60..<70:
            result = '及格'
            break
        case 70..<80:
            result = '良好'
            break
        case 80..100:
            result = '优秀'
            break
    }
    return result
}
println getGrade(60)