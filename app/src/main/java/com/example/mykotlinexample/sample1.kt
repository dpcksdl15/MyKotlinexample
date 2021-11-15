package com.example.mykotlinexample


//실행 합수
fun main(){
    ignoreNulls("st")
}
//8. Nullable / NonNull
fun nullcheck(){
    //NPE : NULL pointer Exception

    //변수에는 null을 넣을수 없는 타입이 존재 한다

    //기본
    var name : String = "jotce"


    //var nullNmae : String = null
    // null을 넣었을 경우 Exception 발생

    // null을 넣고 싶은 경우
    // 변수 타입에 ?를 붙여주면 null값 입력 가능
    // 무조건 타입을 입력해줘야 한다(타입 생략 불가)
    var nullName : String? = null

    // 대문자로 변환 toUpperCase
    var nameInUpperCase = name.toUpperCase()

    // 변수가 null일 경우 null 반환  null이 아닐 경우 대문자 변환
    var nullnameInUpperCase = nullName?.toUpperCase()


    // ?: 엘비스 연산자
    // defort값을 주고 싶을때

    val lastName : String? = null
    val fullName = name+ " " + (lastName?: "No lastname")

    println(fullName)
}


    // !!
    // null이 무조건 아니라고 할 때
    fun ignoreNulls(str : String?){
        val mNotNull : String = str!!
        val upper = mNotNull.toUpperCase()

        println(upper)

        // # let은 괄호 안에 넣어주는 함수
        // email이 null이 아닐경우 괄호 안에 넣어줌
        val email : String? = "dpcksdl15@naver.com"
        email?.let {
            println(email)
        }
    }



//7. 반복문
// for / while
fun forAndWhile(){

    //# in은 연속(반복에 사용)

    val students : ArrayList<String> = arrayListOf("joyce","james","jenny","jennifer")


    //for문

    //기본
    for (name in students){
        println("$name")
    }

    //Index를 같이 사용할 경우
    //꼭 withIndex를 사용 해야함 순서
    //Index는 꼭 맨 앞에 입력 입력한 순서대로 할당
    for ((index, name) in students.withIndex()){
        println("${index+1}번째 학생 : ${name}")
    }

    var sum = 0
    for (i in 1..10){
        sum = sum + i
    }
    println(sum)

    //step
    //변수명 in 범위 step 상수
    //상수 크기만큼 건너 뛰어서 반복
    var sum2 = 0
    for (i in 1..10 step 2){
        sum2 = sum2 + i
    }
    println(sum2)

    //downTo
    //변수명 in 시작값 downTO 상수
    //시작값부터 시작 해서 상수까지 진행
    var sum3 = 0
    for (i in 10 downTo 1){
        sum3 = sum3 + i
    }
    println(sum3)

    //nutil
    //변수명 in 상수1 until 상수2
    //상수1 부터 상수2 범위안 까지 반복
    //i in 1 until 100     !=    for(i in 1..100)
    // -> 1부터 99까지 반복   !=    -> 1부터 100까지 반복
    var sum4 = 0
    for (i in 1 until 101){
        sum4 = sum4 + i
    }
    println(sum4)


    //while문
    var index = 0
    while (index < 10){
        println("current index : ${index}")
        index++
    }
}


//6. Array and List
// Array

//List
// 1. Lsit (수정이 불가능) - 값을 변경 불가 읽기 전용
// 2. MutableList (수정이 가능) - 값을 변경 가능 읽기, 수정 전용

fun array(){
    val array = arrayOf(1,2,3)
    val list = listOf(1,2,3)

    val array2 = arrayOf(1,"d",3,4f)
    val list2 = listOf(1,"d",11L)

    //list는 인터페이스 여서 값을 가져오기만 가능 get 등등
    //array는 수정이 가능
    array[0] = 3
    //list는 수정이 불가능
    //list[0] = 2

    // ArrayList
    // #ArrayList는 var 또는 val로 사용가능
    //이유는 참조하는 주소값은 동일 하기에 둘다 사용이 가능 하다
    val arrayList = arrayListOf<Int>()
    arrayList.add(10)
    arrayList.add(20)
}

//5. Expression vs Statement 차이점
// Expression을 반환 값이 있는 것
// 활동을 해서 새로운 값을 전달하면 Expressicon
//Statement는 값을 전달하지 않고 정해진 부분만 수정하면 Expression


//4. 조건식
// if, when

//if 사용법
//기본 구조
fun maxBy(a: Int, b: Int) : Int{

    if (a>b){
        return a
    } else {
        return b
    }
}

// 변형 구조
// 코틀린은 삼항 연산자가 없어서 [(a>b) ? a : b]
// 리턴 타입 은 자동추론으로 생략 가능
fun maxBy2(a: Int, b : Int) = if (a>b) a else b

//when 사용법
// Expression
fun checkNum(score : Int){

    //기본형 else 생략 가능능
   when(score) {
        0 -> println("this is 0")
        1 -> println("this is 1")
        2,3 -> println("this is 2 or 3")
        else -> println("I don't know")
    }

    // when을 리턴 형식으로 사용할 경우에는 꼭 else 사용!
    // Expression
    var b = when(score){
        1->1
        2->2
        else ->3
    }

    println("b : $b")

    // Statement
    when(score){
        in 90..100 -> println("Great")
        in 1..80 -> println("Good")
        else -> println("SoSo")
    }
}



//3. String template(템플릿)
// String 템플릿이란?
// String 문자열 속에 변수를 집어넣어 사용 하고 싶을떄 사용
// #문자열 중간에 변수를 사용 할 경우 $변수명 으로 사용
fun StringTemplate(){

    val name = "kim"
    val lastname = "yechan"

    // 기본 형태
    println("my name is $name i'm 26")

    // 변형 형태 (띄어쓰기 또는 변수를 두개 이상 사용할 경우
    //${변수명}으로 사용
    println("my name is ${name + lastname} i'm 26")

    //$표시를 이용하고 싶을떄 $앞에 \사용
    println("this is 2\$")

}

//2. val vs var
// val = value
// val은 고정값이기 때문에 변하지 않은 값
// var = valable
// var은 유동값이기 떄문에 변하는 값

// #변수 뒤 변수타입은 생략이 가능 단, val 또는 var는 입력 필수!

fun hi(){

    val a : Int = 10
    var b : Int = 9

    // 값을 변경하면 val이기 떄문에 오류가 뜸
    //a = 100

    // 값을 변경하면 var이기 때문에 오류가 안 뜸
    //b = 20


    //변수를 선언 할때는
    //1. 정식 선언
    var e : Int = 10
    //2. 간략 선언 1
    var f : Int
    // 간략 선언 2
    var d = 10

    //간략 선언을 할 경우 변수타입 또는 값 둘중 하나는 무조건 입력
    // 타입 + 변수명 + 변수타입/값값
}

//1. 함수

// 기본적인 함수 구조
//fun = function 기능
// 기능 이름() : 리턴형 {}
// #리턴형식이 없을 경우 Unit 사용
fun helloWorld() : Unit {
    println("Hello World")
}

//파라미터가 있는 경우
//파라미터가 있는 경우는 변수명을 쓰고 : 타입을 쓴다
//파라미터는 앞은 대문자로 입력
fun add(a : Int, b : Int) : Int {
    return a+b
}
