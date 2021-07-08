package com.aslnstbk.postsapp.presentation.create_post

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.aslnstbk.postsapp.databinding.FragmentCreatePostBinding
import com.aslnstbk.postsapp.presentation.create_post.viewModels.CreatePostViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreatePostFragment : Fragment() {

    private lateinit var binding: FragmentCreatePostBinding

    private val viewModel: CreatePostViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCreatePostBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListeners()
    }

    private fun initListeners() {
        binding.fragmentCreatePostCreateButton.setOnClickListener {
            viewModel.addPost(text = binding.fragmentCreatePostEditText.text.toString())
            findNavController().navigateUp()
        }
    }
}