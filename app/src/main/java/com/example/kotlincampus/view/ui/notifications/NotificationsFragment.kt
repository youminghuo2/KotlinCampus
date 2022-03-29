package com.example.kotlincampus.view.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlincampus.databinding.FragmentNotificationsBinding
import com.example.kotlincampus.net.Constants
import com.example.kotlincampus.paging.RepoAdapter
import com.example.kotlincampus.utils.dataStore
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch


class NotificationsFragment : Fragment() {
//    https://api.github.com/search/repositories?sort=stars&q=Android&per_page=5&page=1

    private val viewModel by lazy { ViewModelProvider(this).get(NotificationsViewModel::class.java) }

    private var _binding: FragmentNotificationsBinding? = null
    private val repoAdapter = RepoAdapter()
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textView: TextView = binding.textNotifications
//        notificationsViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        binding.textNotifications.setOnClickListener {
//            viewLifecycleOwner.lifecycleScope.launch {
//                val key = stringPreferencesKey(Constants.token_key)
//
//                notificationsViewModel._text.value =
//                    requireContext().dataStore.data.map { preferences -> preferences[key] ?: "" }
//                        .first()
//            }
//        }


        binding.recyclerView.layoutManager=LinearLayoutManager(context)
        binding.recyclerView.adapter=repoAdapter
        lifecycleScope.launch {
            viewModel.getPagingData().collect {pagintData->
                repoAdapter.submitData(pagintData)
            }
        }

        repoAdapter.addLoadStateListener {
            when (it.refresh) {
                is LoadState.NotLoading -> {
                    binding.progressBar.visibility = View.INVISIBLE
                    binding.recyclerView.visibility = View.VISIBLE
                }
                is LoadState.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                    binding.recyclerView.visibility = View.INVISIBLE
                }
                is LoadState.Error -> {
                    val state = it.refresh as LoadState.Error
                    binding.progressBar.visibility = View.INVISIBLE
                    Toast.makeText(context, "Load Error: ${state.error.message}", Toast.LENGTH_SHORT).show()
                }
            }

        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}