package com.aslnstbk.postsapp.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.aslnstbk.postsapp.R
import com.aslnstbk.postsapp.data.db.entities.PostEntity
import com.aslnstbk.postsapp.databinding.FragmentHomeBinding
import com.aslnstbk.postsapp.presentation.home.viewModel.HomeViewModel
import com.aslnstbk.postsapp.presentation.home.views.PostsAdapter
import com.aslnstbk.postsapp.utils.Event
import com.aslnstbk.postsapp.utils.navigation.NavigationState
import com.aslnstbk.postsapp.utils.notifications.NotificationManager
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    private val viewModel: HomeViewModel by viewModels()
    private val postsAdapter by lazy { PostsAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViewsData()
        initViews()
        initListeners()
        observeViewModel()
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel
    }

    private fun initViewsData() {}

    private fun initViews() {
        binding.fragmentHomeRecyclerView.adapter = postsAdapter
    }

    private fun initListeners() {
        binding.fragmentHomeAddFloatingActionButton.setOnClickListener {
            viewModel.navigateToCreatePost()
        }
    }

    private fun observeViewModel() {
        viewModel.allPostsLiveData.observe(viewLifecycleOwner, ::observeAllPosts)
        viewModel.navigationStateLiveData.observe(viewLifecycleOwner, ::observeNavigationState)
    }

    private fun observeAllPosts(list: List<PostEntity>) {
        postsAdapter.updateList(list)
    }

    private fun observeNavigationState(event: Event<NavigationState>) {
        event.getContentIfHandled()?.let { navigationState ->
            when (navigationState) {
                NavigationState.CreatePostNavigate -> navigateToCreatePost()
            }
        }
    }

    private fun navigateToCreatePost() {
        NotificationManager.sendNotification(
            title = "Clicked",
            content = "Hello from Push!"
        )
        findNavController().navigate(R.id.action_homeFragment_to_createPostFragment)
    }
}