package datastruct

// Map的定义
def colors = [red  : 'ff0000', green: '00ff00', blue : '0000ff']
println colors
println colors.getClass()

// Map的获取
println colors['red']
println colors.green

// Map的添加
colors.yellow = 'ffff00'
println colors
colors.complex = [a: 1, b: 2]
println colors

// Map的操作
def students = [
        1: [
                number: '0001',
                name: 'Bob',
                score : 55,
                sex: 'male'
        ],
        2: [
                number: '0002',
                name: 'Johnny',
                score : 62,
                sex: 'female'
        ],
        3: [
                number: '0003',
                name: 'Claire',
                score : 73,
                sex: 'female'
        ],
        4: [
                number: '0004',
                name: 'Amy',
                score : 66,
                sex: 'male'
        ]
]

// each
students.each {
    def student -> println "the key is ${student.key}, the value is ${student.value}"
}

// eachWithIndex
students.eachWithIndex {
    def student, int index -> println "the index is ${index}, the key is ${student.key}, the value is ${student.value}"
}

// each
students.each {
    key, value -> println "the key is ${key}, the value is ${value}"
}

// eachWithIndex
students.eachWithIndex {
    key, value, index -> println "the index is ${index}, the key is ${key}, the value is ${value}"
}

// Map的查找

// find
println students.find { def student -> student.value.score >= 60 }

// findAll
println students.findAll { def student -> student.value.score >= 60 }

// count
println students.count { def student -> student.value.score >= 60 && student.value.sex == 'male' }

// collect
println students.findAll { def student -> student.value.score >= 60 }.collect { return it.value.name }

// groupBy
println students.groupBy { def student -> return student.value.score >= 60 ? '及格' : '不及格' }

// Map的排序

// sort
println students.sort {
    def student1, def student2 ->
        Number score1 = student1.value.score
        Number score2 = student2.value.score
        return score1 == score2 ? 0 : score1 < score2 ? -1 : 1
}

