package ru.netology.nmedia.activity

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract
import ru.netology.nmedia.dto.Post

class EditPostResultContract : ActivityResultContract<Post, Post?>() {

    var inputPost: Post? = null

    override fun createIntent(context: Context, input: Post): Intent {
        inputPost = input
        val intent = Intent(context, EditPostActivity::class.java).apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, input.content)
            type = "text/plain"
        }
        return intent
    }

    override fun parseResult(resultCode: Int, intent: Intent?): Post? {
        if (resultCode == Activity.RESULT_OK) {
            val str = intent?.getStringExtra(Intent.EXTRA_TEXT)
            val rezPost = inputPost?.copy(content = str.toString())
            return rezPost
        } else {
            return null
        }
    }
}