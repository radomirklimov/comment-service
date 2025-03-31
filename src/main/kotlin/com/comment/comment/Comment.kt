package com.comment.comment

class Comment(
    val id: Long,
    val author: String,
    val text: String
) {
    fun toEntity(): ComEntity{
        val comEntity = ComEntity()

        comEntity.id = this.id
        comEntity.author = this.author
        comEntity.text = this.text

        return comEntity
    }
}