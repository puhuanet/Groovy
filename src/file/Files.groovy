package file

import objectorention.Person

def file = new File('../../.idea/Groovy.iml')

// 逐行读取文件
file.eachLine { line ->
    println line
}

// 读取全部内容-要换行
def text = file.getText()
println text

// 读取全部内容-不换行
def result = file.readLines()
println result

// 读取部分内容
def reader = file.withReader { reader ->
    char[] buffer = new char[100]
    reader.read(buffer)
    return buffer
}
println reader

// 拷贝文件
def copy(String sourcePath, String destationPath) {
    try {
        def desFile = new File(destationPath)
        if (!desFile.exists()) {
            desFile.createNewFile()
        }
        new File(sourcePath).withReader { reader ->
            def lines = reader.readLines()
            desFile.withWriter { writer ->
                lines.each { line ->
                    writer.append(line + "\r\n")
                }
            }
        }
        return true
    } catch (Exception e) {
        e.printStackTrace()
    }
    return false
}
println copy('../../.idea/Groovy.iml', '/tmp/Groovy.iml')

// 序列化
def saveObject(Object object, String path) {
    try {
        def desFile = new File(path)
        if (!desFile.exists()) {
            desFile.createNewFile()
        }
        desFile.withObjectOutputStream { out ->
            out.writeObject(object)
        }
        return true
    } catch (Exception e) {
    }
    return false
}

// 反序列化
def readObject(String path) {
    def obj = null
    try {
        def file = new File(path)
        if (file == null || !file.exists()) return null
        file.withObjectInputStream { input ->
            obj = input.readObject()
        }
    } catch (Exception e) {

    }
    return obj
}

// 序列化测试
def person = new Person(name: 'Oliver King', age: 18)
saveObject(person, '/tmp/person.bin')
person = (Person) readObject('/tmp/person.bin')
println "the name is ${person.name} and the age is ${person.age}"