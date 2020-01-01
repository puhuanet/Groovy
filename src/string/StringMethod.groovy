package string

def str = 'groovy'

// center()
println str.center(8, "a")
println str.center(8)

// padLeft()
println str.padLeft(8, 'a')
println str.padLeft(8)

// padRight()
println str.padRight(8, 'a')
println str.padRight(8)

// compareTo()
println str.compareTo(str)
println str > str
println str < str

// getAt()
println str.getAt(0)
println str[0]
println str[0..1]

// minus()
println str.minus("oo")
println str - "oo"

// reverse()
println str.reverse()

// capitalize()
println str.capitalize()

// isNumber()
println str.isNumber()