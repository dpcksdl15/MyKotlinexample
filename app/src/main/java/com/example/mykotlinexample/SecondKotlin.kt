package com.example.mykotlinexample

// 1. Lamda
// 람다식은 우리가 마치 value 처럼 다룰 수 있는 익명 함수이다
// 1) 메소드의 파라미터로 넘겨 줄수가 있다.  ex) fun maxBy(a :Int)
// 2) return 값으로 사용할 수가 있다.

// Lamda 기본 정의
// val lamdaName : Type = {argumentList -> codeBody}

//intger를 전달해 제곱을 만드는 예제

val square : (Int) -> (Int) = {number -> number*number}

val nameAge = {name : String, age : Int ->
    "my name is $name I'm $age"
}


// 2. 확장함수
val pizzaIsGreat : String.() -> String = {
    this + "pizza is the best"
}

fun extendString(name : String, age : Int) : String {
    val introduceMtself : String.(Int) -> String = { "I am ${this}, and ${it} years old"}
    return name.introduceMtself(age)
}

// 3. Lamda의 리턴
val calculateGreade : (Int) -> String = {
    when(it) {
        in 0..40 -> "fail"
        in 41..70 -> "pass"
        in 71..100 -> "pefect"
        else -> "Error"
    }
}

// 4. Lamda를 표현하는 여러가지 방법
fun uncikeLamda(lamda : (Double) -> Boolean) : Boolean {
    return  lamda(2.2343)
}

// 5. DataClass
//pojo class -> 틀역활
data class Ticket(val companyName : String, val name : String, var date : String, var seatNumber : Int)
data class TicketNormal(val companyName : String, val name : String, var date : String, var seatNumber : Int)
// toString(), hashCode(), equals(), copy()


// 6. companyobject
class Book private constructor(val id : Int, val name : String){
    companion object : bookfactore{
        override fun getId(): Int {
            return  444
        }

        fun create() = Book(getId(),"aaa")
    }
}

interface bookfactore{
    fun getId() : Int
}

// 7. Object
//Singleton Pattern 최초 한번만 생성
object CarFactory{
    val cars = mutableListOf<Car>()
    fun makeCar(horsePower: Int) : Car {
        val car = Car(horsePower)
        cars.add(car)
        return car
    }
}

data class Car(val horsePower : Int)

fun main() {
    println(square(12))
    println(nameAge("kim",26))

    val a = "kim said"
    val b = "mac said"
    println(a.pizzaIsGreat())
    println(b.pizzaIsGreat())

    println(extendString("ariana", 27))

    println(calculateGreade(97))

    val lamda = {number : Double -> number == 4.2315}
    println(uncikeLamda(lamda))
    println(uncikeLamda({it > 1.2}))

    val ticketA = Ticket("koreaAir", "joy", "2020-02-16", 14)
    val ticketB = TicketNormal("koreaAir", "joy", "2020-02-16", 14)

    println(ticketA.seatNumber.toString())
    println(ticketB)

    val book = Book.Companion.create()
    println("${book.id} ${book.name}")

    val car1 = CarFactory.makeCar(10)
    val car2 = CarFactory.makeCar(100)

    println(car1)
    println(car2)
    println(CarFactory.cars.size.toString())
}