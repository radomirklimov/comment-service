package com.comment.comment

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@CrossOrigin(origins = ["http://localhost:5173"])
@RestController
class ComController(
    val comService: ComService
) {

    @PostMapping("/add")
    fun addComment(@RequestBody comment: Comment): ResponseEntity<ComEntity>{
        if (comService.isExist(comment.id)){
            return ResponseEntity.badRequest().build()
        }

        return ResponseEntity.ok(comService.add(comment))
    }

    @GetMapping("/get-all")
    fun getAll(): ResponseEntity<List<ComEntity>>{
        val comments = comService.getAll()

        if (comments.isEmpty()){
            return ResponseEntity.noContent().build()
        }

        return ResponseEntity.ok(comments)
    }

    @DeleteMapping("/delete")
    fun delete(@RequestBody id: Long): ResponseEntity<String>{
        if (!comService.isExist(id)){
            return ResponseEntity.badRequest().build()
        }

        comService.remove(id)

        return ResponseEntity.ok("deleted successfully")
    }
}