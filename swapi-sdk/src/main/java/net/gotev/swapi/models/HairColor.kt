package net.gotev.swapi.models

/**
 * Enumeration of all the character's hair colors.
 */
enum class HairColor(val rawValue: String) {
    Auburn(rawValue = "auburn"),
    Black(rawValue = "black"),
    Blond(rawValue = "blond"),
    Blonde(rawValue = "blonde"),
    Brown(rawValue = "brown"),
    Grey(rawValue = "grey"),
    None(rawValue = "none"),
    NotSpecified(rawValue = "n/a"),
    Unknown(rawValue = "unknown"),
    White(rawValue = "white")
}
