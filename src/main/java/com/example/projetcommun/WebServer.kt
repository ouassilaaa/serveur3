package com.example.projetcommun

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class WebServer {

    //http://localhost:8080/test

    @GetMapping("/test")
    fun test(): String {
        println("/test")

        return "HelloWorld"
    }

    //http://localhost:8080/getPoints
    @GetMapping("/getPoints")
    fun getPoints (): Array<PointBean> {
        println("/getPoints ")
        //chercher en base la liste des points
        return arrayOf(PointBean(0,1.2,2.3))
    }

    //http://localhost:8080/setPoints
    @PostMapping("/setPoints")
    fun setPoints (@RequestBody pointBean: PointBean) {
        println("/setPoints: $pointBean")
        //ajoute pointBean dans la base
    }
}


