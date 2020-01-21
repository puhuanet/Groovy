package struct

def x
def result

// 字符串
result='none'
x='foo'
switch (x) {
    case 'foo':
        result = 'foo'
        break
    case 'bar':
        result = 'bar'
        break
}
println result

// 列表
result='none'
x=1.23
switch (x) {
    case 'foo':
        result = 'foo'
        break
    case 'bar':
        result = 'bar'
        break
    case [1.23, 4, 5, 6, 'inlist']:
        result = 'list'
        break
}
println result

// 范围
result='none'
x=15
switch (x) {
    case 'foo':
        result = 'found foo'
        break
    case 'bar':
        result = 'bar'
        break
    case [1.23, 4, 5, 6, 'inlist']:
        result = 'list'
        break
    case 12..30:
        result = 'range'
        break
}
println result

// 任意对象
result='none'
x=1.23
switch (x.class) {
    case 'foo':
        result = 'found foo'
        break
    case 'bar':
        result = 'bar'
        break
    case [1.23, 4, 5, 6, 'inlist']:
        result = 'list'
        break
    case 12..30:
        result = 'range'
        break
    case Integer:
        result = 'integer'
        break
    case BigDecimal:
        result = 'big decimal'
        break
}
println result

// default
result='none'
x='string'
switch (x.class) {
    case 'foo':
        result = 'found foo'
        break
    case 'bar':
        result = 'bar'
        break
    case [1.23, 4, 5, 6, 'inlist']:
        result = 'list'
        break
    case 12..30:
        result = 'range'
        break
    case Integer:
        result = 'integer'
        break
    case BigDecimal:
        result = 'big decimal'
        break
    default:
        result = 'default'
}
println result