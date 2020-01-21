package objectorention

def person = new Person(name: "oliver", age: 18)
// 无论是直接.还是调用set/get方法，最终都是调用set/get
println "the name is ${person.name}, the age is ${person.age}"
person.increaseAge(2)
println "the name is ${person.name}, the age is ${person.age}"