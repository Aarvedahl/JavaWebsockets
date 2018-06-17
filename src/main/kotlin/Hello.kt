import java.util.*
import kotlin.collections.ArrayList


data class Train(val trainID: Int, val destination: String, val capacity: Int, var currentCapacity: Int)

data class Ticket(val ticketID: Int, val train: Int, val timeToDest: Int, val price: Int)

data class Person(val name: String, val tickets: ArrayList<Ticket>)

fun Random.nextInt(range: IntRange): Int {
    return range.start + nextInt(range.last - range.start)
}

private val trainDestination = setOf(
        Train(2, "Stockholm", 200, 0),
        Train(3, "Malmö", 200, 0)
)

private val tickets = ArrayList<Ticket>()

private val people = setOf(
        Person("Alex", ArrayList())
)

fun buyTicket(name: String, destination: String, trains: Set<Train>) {
    val random = Random()
    val train = trains.filter { it.destination == destination }
    val timeToDest = random.nextInt(15..42)
    val price = random.nextInt(25..60)
    if(train.isNotEmpty() && train.get(0).currentCapacity < train.get(0).capacity) {
        val ticket = Ticket(tickets.size + 1, train[0].trainID, timeToDest, price)
        val persons = people.filter { it.name == name }
        if(persons.isNotEmpty()) {
            train.get(0).currentCapacity++
            persons[0].tickets.add(ticket)
            println("Person " + persons[0].name + " bought a ticket to " + train[0].destination)
        }
    }
}


fun main(args: Array<String>) {
    buyTicket("Alex", "Stockholm", trainDestination)
    //SpringApplication.run(Application::class.java, *args)

}

