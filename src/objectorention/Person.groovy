package objectorention

// Groovy中默认都是public的
class Person implements Action {

    String name

    Integer age

    def increaseAge(Integer years) {
        this.age += years
    }

    @Override
    void eat() {

    }

    @Override
    void drink() {

    }

    @Override
    void play() {

    }
}
