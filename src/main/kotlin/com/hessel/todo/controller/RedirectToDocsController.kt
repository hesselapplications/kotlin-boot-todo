package com.hessel.todo.controller

import io.swagger.v3.oas.annotations.Hidden
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Hidden
@Controller
class RedirectToDocsController {

    @RequestMapping("/")
    fun redirectToDocs(): String {
        return "redirect:/swagger-ui/index.html"
    }

}