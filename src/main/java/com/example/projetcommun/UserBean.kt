package com.example.projetcommun

import javax.persistence.*
import kotlin.jvm.Transient


@Entity
@Table(name = "user") //nom de la tab
data class UserBean(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,
    var name: String = "",
    var mdp:String="") {
    constructor() : this(0,"","")

}