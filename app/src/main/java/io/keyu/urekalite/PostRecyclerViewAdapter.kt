package io.keyu.urekalite

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import kotlinx.android.synthetic.main.view_post.view.postTextView

class PostRecyclerViewAdapter(private val myDataset: Array<Post>) :
    RecyclerView.Adapter<PostRecyclerViewAdapter.MyViewHolder>() {

    class MyViewHolder(val cardView: MaterialCardView) : RecyclerView.ViewHolder(cardView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        // create a new view
        val cardView = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_post, parent, false) as MaterialCardView
        // set the view's size, margins, paddings and layout parameters
        return MyViewHolder(cardView)
    }

    override fun getItemCount(): Int = myDataset.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        System.out.println(myDataset[position].title)
        holder.cardView.postTextView.text = myDataset[position].title
    }
}