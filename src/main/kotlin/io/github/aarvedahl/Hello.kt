package io.github.aarvedahl

import org.springframework.boot.autoconfigure.SpringBootApplication

data class Train(val trainID: Int, val destination: String, val capacity: Int)

data class Ticket(val ticketID: Int, val train: Int, val timeToDest: Double, val price: String)

data class Person(val name: String, val tickets: List<Int>)


@SpringBootApplication
open class Application

val tickets = mapOf(
        Pair("Alex", 2),
        Pair("Göran", 1),
        Pair("Sven", 3)
        )

val trainDestination = setOf<Train>(
        Train(2, "Stockholm", 200) ,
        Train(3, "Malmö", 200)
)


fun buyTicket(name: String, destination: String, trains: Set<Train>) {
    val train = trains.filter { it.destination == destination }
    print(train.get(0).trainID)
}


fun main(args: Array<String>) {
    println("Hello, World")
    buyTicket("Alex", "Stockholm", trainDestination)
    //SpringApplication.run(Application::class.java, *args)

}

