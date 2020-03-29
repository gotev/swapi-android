package net.gotev.swapi.interfaces

/**
 * A system or means of conveying people or goods from place to place.
 *
 * @property name Name of this transport.
 * @property model Model of this transport.
 * @property length The length of this transport in meters.
 * @property maxAtmospheringSpeed The maximum speed of this transport in the atmosphere.
 * @property crewNumber The number of personnel needed to run or pilot this transport.
 * @property maxPassengers The number of non-essential people which can be transported.
 * @property cargoCapacity The maximum number of kilograms that can be transported.
 * @property consumablesDuration The maximum length of time that this transport can provide consumables for its entire crew without having to resupply.
 */
interface Transportable : ShortDescriptable {
    val name: String
    val model: String
    val length: String
    val maxAtmospheringSpeed: String
    val crewNumber: String
    val maxPassengers: String
    val cargoCapacity: String
    val consumablesDuration: String

    override val shortDescription: String
        get() = name
}
