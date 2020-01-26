package file

final String xml = '''
<response version-api="2.0">
    <value>
        <books id="1" classification="android">
            <book available="20" id="1">
                <title>疯狂Android讲义</title>
                <author id="1">李刚</author>
            </book>
            <book available="14" id="2">
               <title>第一行代码</title>
               <author id="2">郭林</author>
           </book>
           <book available="13" id="3">
               <title>Android开发艺术探索</title>
               <author id="3">任玉刚</author>
           </book>
           <book available="5" id="4">
               <title>Android源码设计模式</title>
               <author id="4">何红辉</author>
           </book>
       </books>
       <books id="2" classification="web">
           <book available="10" id="1">
               <title>Vue从入门到精通</title>
               <author id="4">李刚</author>
           </book>
       </books>
   </value>
</response>
'''
println xml

// 解析XML文档
def xmlSluper = new XmlSlurper()
def response = xmlSluper.parseText(xml)

// 输出解析后的结果
println response.value.books[0].book[0].title.text()
// 数据节点的属性值
println response.value.books[1].book[0].@available

// 遍历查找想要的数据-常规遍历
def list = []
response.value.books.each { books ->
    //下面开始对书结点进行遍历
    books.book.each { book ->
        def author = book.author.text()
        if (author.equals('李刚')) {
            list.add(book.title.text())
        }
    }
}
println list

// 遍历查找想要的数据-深度遍历
list = response.depthFirst().findAll { book ->
    return book.author.text() == '李刚' ? true : false
}
println list

// 遍历查找想要的数据-广度遍历
def name = response.value.books.children().findAll { node ->
    node.name() == 'book' && node.@id == '2'
}.collect { node ->
    return node.title.text()
}
println name