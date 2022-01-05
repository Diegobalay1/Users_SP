package com.diego.kotlin.userssp

/**
 * clase especializada en modelo de datos para kotlin 'data class'
 */
data class User (val id: Long, var name: String, var lastName: String, var url: String) {
    fun getFullName() : String = "$name $lastName"
}