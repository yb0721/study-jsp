新建Gradle
    gradle init
        Select type of project to generate:
        1: basic
        2: application
        3: library
        4: Gradle plugin
        Enter selection (default: basic) [1..4] 3

        Select implementation language:
        1: C++
        2: Groovy
        3: Java
        4: Kotlin
        5: Scala
        6: Swift
        Enter selection (default: Java) [1..6] 3

        Select build script DSL:
        1: Groovy
        2: Kotlin
        Enter selection (default: Groovy) [1..2] 1

        Select test framework:
        1: JUnit 4
        2: TestNG
        3: Spock
        4: JUnit Jupiter
        Enter selection (default: JUnit 4) [1..4]

        Project name (default: demo):
        Source package (default: demo):


BUILD SUCCESSFUL
2 actionable tasks: 2 executed

创建WAR包
    build gradle

运行WAR文件
    引用Tomcat

vs调试Tomcat
    将.class文件移至新建的WAR文件中
    jar cvf test.war ./*

    解包文件
    jar -xvf xx.jar

SecondWork
    项目介绍：图书管理系统及用户管理，基本实现图书的增删改查及用户的增删改查
    技术栈：jsp,Servlet,SQL等