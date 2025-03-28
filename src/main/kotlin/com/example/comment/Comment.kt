package com.example.comment

class Comment(
    val id: Long,
    val author: String,
    val comment_text: String
) {
    fun toEntity(): ComEntity{
        val comEntity = ComEntity()

        comEntity.id = this.id
        comEntity.author = this.author
        comEntity.comment_text = this.comment_text

        return comEntity
    }
}
