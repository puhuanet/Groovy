package objectorention

// 应用的入口类
class Entry {

    static void main(def args) {
        // 应用启动
        println '正在启动...'

        // 应用初始化
        println '初始化开始...'
        ApplicationManager.init()
        println '初始化完成...'

        // 创建Person
        def person = PersonManager.createPerson('oliver', 18)
        println "the name is ${person.name}, the age is ${person.age}"
    }

}
