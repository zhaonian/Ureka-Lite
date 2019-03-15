package io.keyu.urekalite.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.igalata.bubblepicker.BubblePickerListener
import com.igalata.bubblepicker.adapter.BubblePickerAdapter
import com.igalata.bubblepicker.model.BubbleGradient
import com.igalata.bubblepicker.model.PickerItem
import com.igalata.bubblepicker.rendering.BubblePicker
import io.keyu.urekalite.R

class OnboardingFragment3 : Fragment() {

    private lateinit var picker: BubblePicker

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val rootView = inflater.inflate(R.layout.fragment_onboarding3, container, false)

        val titles = resources.getStringArray(R.array.countries)
        val colors = resources.obtainTypedArray(R.array.colors)
        val images = resources.obtainTypedArray(R.array.images)

        picker = rootView.findViewById(R.id.picker)
        picker.bubbleSize = 10
        picker.adapter = object : BubblePickerAdapter {
            override val totalCount = titles.size

            override fun getItem(position: Int): PickerItem {
                return PickerItem().apply {
                    title = titles[position]
                    gradient = BubbleGradient(
                        colors.getColor((position * 2) % 8, 0),
                        colors.getColor((position * 2) % 8 + 1, 0), BubbleGradient.VERTICAL
                    )
                    textColor = ContextCompat.getColor(context!!, android.R.color.white)
                }
            }
        }

        colors.recycle()
        images.recycle()

        picker.listener = object : BubblePickerListener {
            override fun onBubbleSelected(item: PickerItem) {}

            override fun onBubbleDeselected(item: PickerItem) {}
        }

        return rootView
    }

    override fun onResume() {
        super.onResume()
        picker.onResume()
    }

    override fun onPause() {
        super.onPause()
        picker.onPause()
    }
}
