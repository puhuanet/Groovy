package objectorention

// Groovy中默认都是public的
class Person implements Serializable {

    String name

    Integer age

    def increaseAge(Integer years) {
        this.age += years
    }

    // 方法丢失的时候先调用
    def methodMissing(String name, Object args) {
        return "the method is missing"
    }

    // 方法找不到的时候用它替代
    def invokeMethod(String name, Object args) {
        return "the method is ${name}, the params is ${args}"
    }

}
