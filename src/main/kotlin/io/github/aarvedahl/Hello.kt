package io.github.aarvedahl

import org.springframework.boot.autoconfigure.SpringBootApplication
import java.util.*
import java.util.concurrent.ThreadLocalRandom
import kotlin.collections.ArrayList


data class Train(val trainID: Int, val destination: String, val capacity: Int)

data class Ticket(val ticketID: Int, val train: Int, val timeToDest: Int, val price: Int)

data class Person(val name: String, val tickets: ArrayList<Ticket>)

fun Random.nextInt(range: IntRange): Int {
    return range.start + nextInt(range.last - range.start)
}



val trainDestination = setOf<Train>(
        Train(2, "Stockholm", 200) ,
        Train(3, "Malmö", 200)
)

val tickets = ArrayList<Ticket>()
val people = setOf<Person>(
        Person("Alex", ArrayList())
)

fun buyTicket(name: String, destination: String, trains: Set<Train>) {
    val random = Random()
    val train = trains.filter { it.destination == destination }
    val timeToDest = random.nextInt(15..42)
    val price = random.nextInt(25..60)
    if(train.size > 0) {
        val ticket = Ticket(tickets.size +1, train.get(0).trainID, timeToDest, price)
        val persons = people.filter { it.name == name }
        if(persons.size > 0) {
            persons.get(0).tickets.add(ticket)
            println("Person " + persons.get(0).name + " bought a ticket to " + train.get(0).destination)
        }
    }
}


fun main(args: Array<String>) {
    buyTicket("Alex", "Stockholm", trainDestination)
    //SpringApplication.run(Application::class.java, *args)

}

