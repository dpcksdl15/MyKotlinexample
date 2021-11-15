package com.example.mykotlinexample

//9. 클래스 만들기
//파라미터가 없는 경우 kim으로 name 저장
open class Human constructor(val name : String = "kim")  {

    //코드 블럭
    //주 생성자 포함 (제일 먼저 실행)
    init {
        println("생성자 생성")
    }

    fun eatingCake() {
        println("케익은 맛있어")
    }

   open fun singASong(){
        println("lalala")
    }


    // 오버로딩
    // 파라미터가 기본으로 설정 되어있고
    // 또 다른 파마미터가 필요할 경우
    // ex) java 구문
    // public void userName(String name){  }
    // public void userName(String name, int date){  }

    constructor(name : String = "back", age : Int? = 55) : this(name) {
        println("내 이름은 ${name}, 나이는 ${age}")
    }
}

// 클래스 상속
// java = extens
// 코틀린은 기본으로 final 이라서 접근 불가
// 부모 클래스에서 open을 사용해야함
class Korean : Human(){

    //오버라이딩
    override fun singASong(){
        super.singASong()
        println("랄랄라")
    }

}


fun main(){
    var human = Human("chan")
    human.eatingCake()

    println("내 이름은 ${human.name}")

    var stranger = Human("yechan",null)
    println("두번째 이름은 ${stranger.name}")

    val korean = Korean()
    korean.singASong()


}