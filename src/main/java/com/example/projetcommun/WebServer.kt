package com.example.projetcommun

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletResponse

@RestController
class WebServer(private val pointDao: PointDao) {

    //http://localhost:8080/test

    @GetMapping("/test")
    fun test(): String {
        println("/test")

        return "HelloWorld"
    }

    //http://localhost:8080/getPoints
    @GetMapping("/getPoints")
    fun getPoints (): List<PointBean> {
        println("/getPoints ")
        //chercher en base la liste des points
        return pointDao.findAll()
    }

    //http://localhost:8080/setPoints
    @PostMapping("/setPoints")
    fun setPoints (@RequestBody pointBean: PointBean, response : HttpServletResponse): ErrorBean? {

        try {
            //controle
                if(pointBean.latitude > 100.0) {
                    throw Exception("Coordonnées incorrectes")
                }

            println("/setPoints: $pointBean")
            //ajoute pointBean dans la base
            pointDao.save(pointBean)
            return null
        }
        catch(e:Exception) {
            e.printStackTrace()
            response.status = 518
            return ErrorBean("Erreur : " + e.message)
        }
    }

  /*  @GetMapping("/testUser")
    fun testUser(): String {
        println("/testUser")
        val user = UserBean(0)
        userDao.save(user)
        return "ok"
    }*/


    }



