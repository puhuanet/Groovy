package file

import groovy.json.JsonOutput
import groovy.json.JsonSlurper
import objectorention.Person

def list = [
        new Person(name: 'oliver', age: 18),
        new Person(name: 'cathy', age: 18)
]
def json

// 输出json字符串
println json=JsonOutput.toJson(list)
// 优化输出格式
println JsonOutput.prettyPrint(json)

def slurper = new JsonSlurper()
// 将json字符串转化为对象
list = slurper.parseText(json)
println list
// 将其他类型的数据转化为对象
list = slurper.parse(json.getBytes())
println list

