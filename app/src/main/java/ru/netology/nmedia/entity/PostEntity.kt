package ru.netology.nmedia.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.netology.nmedia.dto.Post

@Entity
data class PostEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val author: String,
    val published: String,
    val content: String,
    var video: String? = null,
    var likedByMe: Boolean,
    var likes: Int = 0,
    var shares: Int = 0,
    var views: Int = 0
) {
    fun toDto() = Post(id, author, published, content, video, likedByMe, likes, shares, views)

    companion object {
        fun fromDto(dto: Post) =
            PostEntity(dto.id, dto.author, dto.published, dto.content, dto.video, dto.likedByMe, dto.likes, dto.shares, dto.views)

    }
}
