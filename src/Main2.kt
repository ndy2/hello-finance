import java.time.LocalDate
import java.time.temporal.ChronoUnit
import kotlin.streams.toList


data class FreeSaving(
        val createdAt: LocalDate,
        val periodMonth: Long,
        val interestRate: Double
) {
    val maturityAt: LocalDate = createdAt.plusMonths(periodMonth)

    init {
        println("Saving created at : $createdAt")
        println("Saving matured at : $maturityAt")
        println("Saving period : $periodMonth month")
    }

    fun getInterestAmount(plan: List<FreeSavingDeposit>): Int {
        val sum = plan.map {
            val dates = ChronoUnit.DAYS.between(it.date, this.maturityAt)
            println(dates)
            it.amount * dates / 365 * this.interestRate
        }
        println(sum)
        return sum.sum().toInt()
    }
}

data class FreeSavingDeposit(
        val date: LocalDate,
        val amount: Int,
)

fun main() {
    val saving = FreeSaving(
            createdAt = LocalDate.of(2023, 11, 28),
            periodMonth = 36,
            interestRate = 0.0675
    )
    val plan165 = listOf(
            FreeSavingDeposit(LocalDate.of(2023, 11, 28), 1000000),
            FreeSavingDeposit(LocalDate.of(2023, 12, 1), 1000000),

            FreeSavingDeposit(LocalDate.of(2024, 1, 1), 1000000),
            FreeSavingDeposit(LocalDate.of(2024, 2, 1), 1000000),
            FreeSavingDeposit(LocalDate.of(2024, 3, 1), 1000000),
            FreeSavingDeposit(LocalDate.of(2024, 4, 1), 1000000),
            FreeSavingDeposit(LocalDate.of(2024, 5, 1), 1000000),
            FreeSavingDeposit(LocalDate.of(2024, 6, 1), 1000000),
            FreeSavingDeposit(LocalDate.of(2024, 7, 1), 1000000),
            FreeSavingDeposit(LocalDate.of(2024, 8, 1), 1000000),
            FreeSavingDeposit(LocalDate.of(2024, 9, 1), 1000000),
            FreeSavingDeposit(LocalDate.of(2024, 10, 1), 1000000),
            FreeSavingDeposit(LocalDate.of(2024, 11, 1), 1000000),
            FreeSavingDeposit(LocalDate.of(2024, 12, 1), 1000000),

            FreeSavingDeposit(LocalDate.of(2025, 1, 1), 1000000),
            FreeSavingDeposit(LocalDate.of(2025, 2, 1), 1000000),
            FreeSavingDeposit(LocalDate.of(2025, 3, 1), 1000000),
            FreeSavingDeposit(LocalDate.of(2025, 4, 1), 1000000),
            FreeSavingDeposit(LocalDate.of(2025, 5, 1), 1000000),
            FreeSavingDeposit(LocalDate.of(2025, 6, 1), 1000000),
            FreeSavingDeposit(LocalDate.of(2025, 7, 1), 1000000),
            FreeSavingDeposit(LocalDate.of(2025, 8, 1), 1000000),
            FreeSavingDeposit(LocalDate.of(2025, 9, 1), 1000000),
            FreeSavingDeposit(LocalDate.of(2025, 10, 1), 1000000),
            FreeSavingDeposit(LocalDate.of(2025, 11, 1), 1000000),
            FreeSavingDeposit(LocalDate.of(2025, 12, 1), 1000000),

            FreeSavingDeposit(LocalDate.of(2026, 1, 1), 1000000),
            FreeSavingDeposit(LocalDate.of(2026, 2, 1), 1000000),
            FreeSavingDeposit(LocalDate.of(2026, 3, 1), 1000000),
            FreeSavingDeposit(LocalDate.of(2026, 4, 1), 1000000),
            FreeSavingDeposit(LocalDate.of(2026, 5, 1), 1000000),
            FreeSavingDeposit(LocalDate.of(2026, 6, 1), 1000000),
            FreeSavingDeposit(LocalDate.of(2026, 7, 1), 1000000),
            FreeSavingDeposit(LocalDate.of(2026, 8, 1), 1000000),
            FreeSavingDeposit(LocalDate.of(2026, 9, 1), 1000000),
            FreeSavingDeposit(LocalDate.of(2026, 10, 1), 1000000),
            FreeSavingDeposit(LocalDate.of(2026, 11, 1), 1000000),
    )
    println(saving.getInterestAmount(plan = plan165))
}