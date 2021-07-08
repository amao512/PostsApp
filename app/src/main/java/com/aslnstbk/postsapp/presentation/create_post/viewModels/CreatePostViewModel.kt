package com.aslnstbk.postsapp.presentation.create_post.viewModels

import androidx.lifecycle.ViewModel
import com.aslnstbk.postsapp.data.db.entities.PostEntity
import com.aslnstbk.postsapp.domain.CreatePostDomainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.util.*
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

@HiltViewModel
class CreatePostViewModel @Inject constructor(
    private val createPostDomainRepository: CreatePostDomainRepository
) : ViewModel(), CoroutineScope {

    private val job = Job()
    private val ioContext = job + Dispatchers.IO
    override val coroutineContext: CoroutineContext = job + Dispatchers.Main

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }

    fun addPost(text: String) = launch(ioContext) {
        val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
        val currentDate = sdf.format(Date())

        createPostDomainRepository.addPost(
            PostEntity(
                authorName = "Asylzhan Seytbek",
                date = currentDate,
                contentText = text
            )
        )
    }
}