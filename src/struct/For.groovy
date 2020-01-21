package struct

// 范围
def sum = 0
for (i in 0..9) {
    sum += i
}
println sum

// List
sum = 0
for (i in [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]) {
    sum += i
}
println sum

// Map
sum = 0
for (i in ['lili': 1, 'luck': 2, 'xiaoming': 3]) {
    sum += i.value
}
println sum