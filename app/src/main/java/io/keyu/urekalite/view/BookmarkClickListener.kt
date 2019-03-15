package io.keyu.urekalite.view

import io.keyu.urekalite.adapter.BookmarkViewHolder

/**
 * Listener for kitten click events in the grid of kittens
 *
 * @author bherbst
 */
interface BookmarkClickListener {
    /**
     * Called when a kitten is clicked
     * @param holder The ViewHolder for the clicked kitten
     * @param position The position in the grid of the kitten that was clicked
     */
    fun onBookmarkClicked(holder: BookmarkViewHolder, position: Int)
}
