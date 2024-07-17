import java.time.LocalDate
import kotlin.streams.toList


data class Saving(
    val createdAt: LocalDate,
    val periodMonth: Long,
) {
    val maturityAt: LocalDate = createdAt.plusMonths(periodMonth)
    val planMonthly: List<Deposit> = (0..<periodMonth)
        .map { createdAt.plusMonths(it) }
        .map { Deposit(it, 1) }
        .toList()
    val sumMonthly = sum(planMonthly)

    init {
        println("Saving created at : $createdAt")
        println("Saving matured at : $maturityAt")
        println("Saving period : $periodMonth month")
    }

    fun getDelayedDates(plan: List<Deposit>): Int {
        return sum(plan) - sumMonthly
    }

    fun sum(plan: List<Deposit>): Int {
        val allDates = createdAt.datesUntil(maturityAt).toList()
        val allDays = allDates.size
        var sum = 0
        var p = 0
        for ((i, d) in allDates.withIndex()) {
            if (p == plan.size) {
                break
            }
            if (d == plan[p].date) {
                sum += (allDays - i) * plan[p].amount
                p++
            }
        }
        return sum
    }
}

data class Deposit(
    val date: LocalDate,
    val amount: Int,
)

fun main() {
    val saving = Saving(
        createdAt = LocalDate.of(2024, 1, 25),
        periodMonth = 12,
    )
    val plan165 = listOf(
        Deposit(LocalDate.of(2024, 1, 25), 1),
        Deposit(LocalDate.of(2024, 2, 26), 6),
        Deposit(LocalDate.of(2025, 1, 24), 5),
    )
    println(saving.getDelayedDates(plan = plan165))

}