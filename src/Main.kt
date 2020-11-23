import kotlin.random.Random

fun main() {
    val bus1 = Bus()
    val bus2 = Bus()
    val barco1 = Barco()
    val barco2 = Barco()

    val flotaDeLaEmpresa = listOf(bus1, bus2, barco1, barco2)

    for (medioTransporte in flotaDeLaEmpresa) {
        medioTransporte.transaladarse("Barcelona", "Ibiza")
    }

}

abstract class MedioDeTransporte() {
    abstract fun transaladarse(origen: String, destino: String)

    // Mis hijos pueden hacer cosas con ellas, pero alguien de fuera no.
     protected fun llegarADestino() {
        println("...Llegar a destino")
    }

    protected fun iniciarRuta() {
        println("Inicio la ruta...")
    }
}

class Bus : MedioDeTransporte() {
    override fun transaladarse(origen: String, destino: String) {
        println("Comienza un translado de Bus.")
       if (comprobarEstadoCarreteras(origen, destino)) {
           iniciarRuta()
           hacerDescanso()
           llegarADestino()
       } else {
           println("Cancelamos la ruta por baches.")
       }
    }

    private fun hacerDescanso() {
        println("A descansar")
    }

    private fun comprobarEstadoCarreteras(origen: String, destino: String) : Boolean {
        return Random.nextBoolean()
    }

}

class Barco : MedioDeTransporte() {
    override fun transaladarse(origen: String, destino: String) {
        println("Comienza un translado de Barco.")
        comprobarMeteo(origen, destino)
        if (comprobarMeteo(origen, destino) > 90) {
            println("No zarpamos")
        } else {
            iniciarRuta()
            llegarADestino()
        }
    }

    fun comprobarMeteo(origen: String, destino: String) :Int {
        // Cuando más alto el Int, peor tiempo hace
        return Random.nextInt(100)
    }
}