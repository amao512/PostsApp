package com.aslnstbk.postsapp.presentation.home.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aslnstbk.postsapp.data.db.entities.PostEntity
import com.aslnstbk.postsapp.domain.HomeDomainRepository
import com.aslnstbk.postsapp.utils.Event
import com.aslnstbk.postsapp.utils.navigation.NavigationState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

@HiltViewModel
class HomeViewModel @Inject constructor(homeDomainRepository: HomeDomainRepository) : ViewModel(), CoroutineScope {

    private val job = Job()
    override val coroutineContext: CoroutineContext = job + Dispatchers.Main

    private val _navigationStateLiveData: MutableLiveData<Event<NavigationState>> = MutableLiveData()

    val navigationStateLiveData: LiveData<Event<NavigationState>> = _navigationStateLiveData
    var allPostsLiveData: LiveData<List<PostEntity>> = homeDomainRepository.getAllPosts()

    override fun onCleared() {
        super.onCleared()
        job.cancel()
        _navigationStateLiveData.value = null
    }

    fun navigateToCreatePost() {
        _navigationStateLiveData.value = Event(content = NavigationState.CreatePostNavigate)
    }
}