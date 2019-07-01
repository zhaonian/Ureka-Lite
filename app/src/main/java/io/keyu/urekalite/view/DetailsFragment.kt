package io.keyu.urekalite.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import io.keyu.urekalite.R

class DetailsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //        ImageView image = view.findViewById(R.id.image);
        //        image.setImageResource(R.drawable.science);
    }

    companion object {

        /**
         * Create a new DetailsFragment
         */
        fun newInstance(): DetailsFragment {
            return DetailsFragment()
        }
    }
}
