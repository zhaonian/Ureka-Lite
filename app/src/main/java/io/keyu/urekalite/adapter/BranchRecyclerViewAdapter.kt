package io.keyu.urekalite.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.keyu.urekalite.model.post.ChannelGroupGroup
import io.keyu.urekalite.view.BranchView

class BranchRecyclerViewAdapter : RecyclerView.Adapter<BranchViewHolder>() {

    private var branchList: List<ChannelGroupGroup> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BranchViewHolder {
        // create a new view
        val branchView = BranchView(parent.context)
        // set the view's size, margins, paddings and layout parameters
        return BranchViewHolder.from(branchView)
    }

    override fun getItemCount(): Int = branchList.size

    override fun onBindViewHolder(holder: BranchViewHolder, position: Int) {
        val curBranch = branchList[position]
        holder.branchView.setText(curBranch.groupGroupName)
    }

    fun setBranchList(branchList: List<ChannelGroupGroup>) {
        this.branchList = branchList
        notifyDataSetChanged()
    }
}

class BranchViewHolder private constructor(val branchView: BranchView) :
    RecyclerView.ViewHolder(branchView) {
    companion object {
        @JvmStatic
        fun from(parent: ViewGroup): BranchViewHolder =
            BranchViewHolder(BranchView(parent.context))
    }
}
