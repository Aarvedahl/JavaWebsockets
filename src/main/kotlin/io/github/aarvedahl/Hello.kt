package io.github.aarvedahl

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

data class Train(val trainID: Int, val name: String, val capacity: Int)

data class Ticket(val train: Int, val timeToDest: Double, val price: String)

@SpringBootApplication
open class Application


fun main(args: Array<String>) {
    println("Hello, World")
    val tran = Train(3, "OEXP", 120)
    print(tran.capacity)
    //SpringApplication.run(Application::class.java, *args)

}

