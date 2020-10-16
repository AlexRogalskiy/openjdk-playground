package dev.suresh.json

import kotlinx.serialization.*
import kotlinx.serialization.builtins.*
import java.time.*
import java.time.Duration
import kotlin.RequiresOptIn.Level.ERROR
import kotlin.reflect.*
import kotlin.time.*

@OptIn(BleedingEdge::class)
fun main() {

    val data = SerialTest<List<Map<String, Int>>>()
    val j = data::class
    val type = typeOf<SerialTest<List<Map<String, Int>>>>()
    println(type)

    val s = serializer<SerialTest<List<Map<String, String>>>>()
    println(SerialTest.serializer(ListSerializer(String.serializer().nullable)))
    println(s)

    val stringListSerializer: KSerializer<List<String>> = ListSerializer(String.serializer())
    println(stringListSerializer.descriptor)

    val b = "1000010".toIntOrNull(2)
    println(b)
    println(b?.toString(2))

    previewMethod()
    val clock = TimeSource.Monotonic
    val d = measureTimedValue {
        val mark = clock.markNow()
        val list = buildList {
            add("Hello")
            add("Kotlin")
        }
        println(list)
        mark.elapsedNow()
    }
    println(d.value.inSeconds)
    deprecatedMethod()

    // LocalDate     --> Period
    // LodalDateTime --> Duration

    val today = LocalDateTime.now()
    println(today.plus(Duration.ofDays(1)))
    println(
        runCatching {
            println(LocalDate.now().minus(Duration.ofDays(10)))
        }.exceptionOrNull()?.message
    )
    println(LocalDate.now().minus(Period.ofDays(10)))
}

@Serializable
class SerialTest<T>(val data: T? = null)

@RequiresOptIn(
    level = ERROR,
    message = "This is a Bleeding edge API"
)
annotation class BleedingEdge

@BleedingEdge
fun previewMethod() {
    println("Called Bleeding edge method!")
}

@Deprecated("test", replaceWith = ReplaceWith("previewMethod()"))
fun deprecatedMethod() {
}

fun interface FunInterface {
    fun tt()
}
