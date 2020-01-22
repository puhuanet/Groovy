package objectorention

def person = new Person(name: "oliver", age: 18)
// 无论是直接.还是调用set/get方法，最终都是调用set/get
println "the name is ${person.name}, the age is ${person.age}"
person.increaseAge(2)
println "the name is ${person.name}, the age is ${person.age}"

// println person.cry()

// 将添加的属性/方法设置为全局可用
ExpandoMetaClass.enableGlobally()

// 为类动态的添加一个属性
Person.metaClass.sex = 'male'
person = new Person(name: "oliver", age: 18)
println person.sex
person.sex = 'female'
println person.sex

// 为类动态的添加一个动态方法
Person.metaClass.sexUpperCase = {
    -> sex.toUpperCase()
}
person = new Person(name: "oliver", age: 18)
println person.sexUpperCase()

// 为类动态的添加一个静态方法
Person.metaClass.static.createPerson = {
    String name, Integer age ->
        new Person(name: name, age: age)
}
person = Person.createPerson('cathy', 18)
println "the name is ${person.name}, the age is ${person.age}"