package datastruct

// 数组的定义
def array1 = [1, 2, 3, 4, 5] as int[]
int[] array2 = [1, 2, 3, 4, 5]

// List的定义
def list1 = []
println list1.class
def list2 = [1, 2, 3, 4, 5]
println list2.size()

// List的排序
def list3 = [6, -3, 9, 2, -7, 1, 5]

// 默认规则
Collections.sort(list3)
list3.sort()
println list3

// 自定义规则
Comparator comparator = {
    a, b -> a == b ? 0 : Math.abs(a) < Math.abs(b) ? -1 : 1
}
Collections.sort(list3, comparator)
list3.sort(comparator)
println list3

// 通过闭包传递排序规则
list3.sort {
    a, b -> a == b ? 0 : Math.abs(a) > Math.abs(b) ? -1 : 1
}
println list3

def list4 = ['abc', 'z', 'Hello', 'groovy', 'java']
list4.sort {
    it -> return it.size()
}
println list4

// List的查找
def list5 = [-3, 9, 6, 2, -7, 1, 5]

// find
println list5.find { return it % 2 == 0 }

// findAll
println list5.findAll { return it % 2 != 0 }

// any
println list5.any { return it % 2 != 0 }

// every
println list5.every { return it % 2 == 0 }

// min
println list5.min { return Math.abs(it) }

// max
println list5.max { return Math.abs(it) }

// count
println list5.count { return it % 2 == 0 }

// List的添加
list5.add(6)
println list5
list5.leftShift(7)
println list5
list5 = list5 + 9
println list5

// list的删除
list5.remove(7)
println list5
list5.remove((Object) 7)
println list5
list5.removeAt(7)
println list5
list5.removeElement(7)
println list5
list5.removeAll { return it % 2 == 0 }
println list5
list5 = list5 - [1, 3]
println list5