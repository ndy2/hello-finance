import java.time.LocalDate
import java.time.Period
import kotlin.streams.toList

data class Deposit(
    val date: LocalDate,
    val amount: Int,
)

fun main() {
    val createdAt = LocalDate.of(2024, 1, 25)
    val savingPeriod = Period.of(1, 0, 0)
    val maturityAt = createdAt.plus(savingPeriod)

    println("Saving created at : $createdAt")
    println("Saving matured at : $maturityAt")
    println("Saving period : $savingPeriod")

    val planMonthly = listOf(
        Deposit(LocalDate.of(2024, 1, 25), 1),
        Deposit(LocalDate.of(2024, 2, 25), 1),
        Deposit(LocalDate.of(2024, 3, 25), 1),
        Deposit(LocalDate.of(2024, 4, 25), 1),
        Deposit(LocalDate.of(2024, 5, 25), 1),
        Deposit(LocalDate.of(2024, 6, 25), 1),
        Deposit(LocalDate.of(2024, 7, 25), 1),
        Deposit(LocalDate.of(2024, 8, 25), 1),
        Deposit(LocalDate.of(2024, 9, 25), 1),
        Deposit(LocalDate.of(2024, 10, 25), 1),
        Deposit(LocalDate.of(2024, 11, 25), 1),
        Deposit(LocalDate.of(2024, 12, 25), 1),
    )

    val plan165 = listOf(
        Deposit(LocalDate.of(2024, 1, 25), 1),
        Deposit(LocalDate.of(2024, 2, 26), 6),
        Deposit(LocalDate.of(2025, 1, 24), 5),
    )

    val plan = plan165
    val allDates = createdAt.datesUntil(maturityAt).toList()
    val allDays = allDates.size
    var sum = 0
    var p = 0
    for ((i, d) in allDates.withIndex()) {
        if (p == plan.size) {
            break
        }
        if (d == plan[p].date) {
            println("$i: $d")
            sum += (allDays - i) * plan[p].amount
            println(sum)
            p++
        }
    }
    println(sum)
}