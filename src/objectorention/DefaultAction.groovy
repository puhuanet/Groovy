package objectorention

// 可以给某些方法提供些默认的实现
trait DefaultAction {

    abstract void eat()

    void play() {
        println 'I can play'
    }

}