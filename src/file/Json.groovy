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

// 从网络上获取数据
def getNetworkData(String url) {
    // 发送http请求
    def connection = new URL(url).openConnection()
    connection.setRequestMethod('GET')
    connection.connect()
    def response = connection.content.text
    // 将json转化为实体对象
    def jsonSluper = new JsonSlurper()
    return jsonSluper.parseText(response)
}

// 输出获取到的数据
println getNetworkData('https://www.baidu.com/home/xman/data/tipspluslist').data