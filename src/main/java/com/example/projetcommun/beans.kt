package com.example.projetcommun

import javax.persistence.*
import kotlin.jvm.Transient



@Entity
@Table(name = "coordonnees") //nom de la tab
data class PointBean(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,
    var longitude: Double,
    var latitude :Double) {
    constructor() : this(0,0.0,0.0)
}

data class ErrorBean(var message:String)