package objectorention

// 应用的管理器
class ApplicationManager {

    static void init() {
        ExpandoMetaClass.enableGlobally()
        // 为Person类添加方法
        Person.metaClass.static.createPerson = {
            String name, Integer age ->
                new Person(name: name, age: age)
        }
    }

}
