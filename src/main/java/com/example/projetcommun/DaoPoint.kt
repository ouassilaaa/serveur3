package com.example.projetcommun

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PointDao : JpaRepository <PointBean, Long> {

    //fun findById(Id_lieux:Int): List<PointBean>

}