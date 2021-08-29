package com.example.demo.app.feature.feed.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.demo.app.core.ui.adapter.MultiTypeAdapter
import com.example.demo.app.core.ui.viewbinding.bind
import com.example.demo.app.feature.feed.R
import com.example.demo.app.feature.feed.databinding.FragmentFeedBinding
import com.example.demo.app.feature.feed.ui.adapter.delegate.PhotoFeedDelegate
import com.example.demo.app.feature.feed.ui.adapter.delegate.UserFeedDelegate
import com.google.android.material.snackbar.Snackbar
import org.koin.androidx.viewmodel.ext.android.viewModel

class FeedFragment : Fragment(R.layout.fragment_feed) {

    private val binding: FragmentFeedBinding by bind(FragmentFeedBinding::bind)
    private val viewModel: FeedViewModel by viewModel()
    private val adapter: MultiTypeAdapter by lazy {
        MultiTypeAdapter().apply {
            registerDelegate(UserFeedDelegate())
            registerDelegate(PhotoFeedDelegate())
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.clear_cache) {
            viewModel.clearCache()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (savedInstanceState == null) {
            refresh()
        }
        val linearLayoutManager = LinearLayoutManager(requireContext())
        binding.feedList.adapter = adapter
        binding.feedList.layoutManager = linearLayoutManager
        binding.feedList.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (linearLayoutManager.findFirstVisibleItemPosition() == 0) {
                    binding.scrollToTop.visibility = View.GONE
                }
            }
        })
        binding.swipeToRefresh.setOnRefreshListener { refresh() }
        viewModel.fetchErrorMessage.observe(viewLifecycleOwner) {
            Snackbar.make(binding.feedList, it, Snackbar.LENGTH_LONG)
                .setAction(R.string.retry_label) { refresh() }
                .show()
        }
        binding.scrollToTop.setOnClickListener {
            binding.feedList.smoothScrollToPosition(0)
            binding.scrollToTop.visibility = View.GONE
        }
        viewModel.observeFeed().observe(viewLifecycleOwner) {
            if (binding.swipeToRefresh.isRefreshing) {
                binding.swipeToRefresh.isRefreshing = false
                binding.scrollToTop.visibility = View.VISIBLE
            }
            adapter.update(it)
        }
    }

    private fun refresh() {
        viewModel.fetchFeed()
        binding.swipeToRefresh.isRefreshing = true
    }
}