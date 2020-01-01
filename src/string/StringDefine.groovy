package string

// 单引号
def s1 = 'string\tstring'
println s1
println s1.class

// 双引号
def s2 = "string ${s1} ${1+2}"
println s2
println s2.class
echo(s2)

// 三引号
def s3 = '''\
line 1
line 2
line 3
'''
println s3
println s3.class

void echo(String s) {
    println s
}