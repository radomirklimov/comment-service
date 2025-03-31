package com.comment.comment

import org.springframework.stereotype.Service


@Service
class ComService(
    val repository: ComRepository
) {

    fun add(comment: Comment): ComEntity{
        val comEntity = comment.toEntity()

        val savedCom = repository.save(comEntity)

        return savedCom
    }

    fun getAll(): List<ComEntity>{
        return repository.findAll()
    }

    fun remove(id: Long){
        val comEntity = repository.findById(id)

        repository.delete(comEntity.orElse(null))
    }

    fun isExist(id: Long): Boolean {
        return !repository.findById(id).isEmpty
    }
}