package io.keyu.urekalite.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import io.keyu.urekalite.R
import io.keyu.urekalite.adapter.BranchRecyclerViewAdapter
import io.keyu.urekalite.model.post.Branch
import io.keyu.urekalite.viewmodel.BranchListViewModel

class BranchListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var swipeLayout: SwipeRefreshLayout
    private lateinit var branchListViewModel: BranchListViewModel
    private val branchListAdapter = BranchRecyclerViewAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.view_branch_list, container, false)
        recyclerView = rootView.findViewById(R.id.channelRecyclerView)
        recyclerView.apply {
            setHasFixedSize(true)
            addItemDecoration(VerticalSpaceItemDecoration(36))
            layoutManager = LinearLayoutManager(context)
            adapter = branchListAdapter
        }

        branchListViewModel = ViewModelProviders.of(activity!!).get(BranchListViewModel::class.java)
        getBranchList()

        swipeLayout = rootView.findViewById(R.id.swipeLayout)
        swipeLayout.setColorSchemeResources(R.color.colorPrimary)
        swipeLayout.setOnRefreshListener {
            getBranchList()
            swipeLayout.isRefreshing = false
        }
        return rootView
    }

    override fun onDestroy() {
        super.onDestroy()
        branchListViewModel.clear()
    }

    private fun getBranchList() {
        branchListViewModel.getBranchList().observe(this, Observer<List<Branch>> { resource ->
            branchListAdapter.setBranchList(resource)
        })
    }
}