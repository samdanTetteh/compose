package com.ijikod.composetutorial.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.ijikod.composetutorial.R

data class DrawableStringPair (@DrawableRes val imageDrawable : Int, @StringRes val text: Int) {

    companion object {
        val alignYourBodySampleData = listOf(
            R.drawable.ab1_inversions to R.string.ab1_inversions,
            R.drawable.ab2_quick_yoga to R.string.ab2_quick_yoga,
            R.drawable.ab3_stretching to R.string.ab3_stretching,
            R.drawable.ab4_tabata to R.string.ab4_tabata,
            R.drawable.ab6_pre_natal_yoga to R.string.ab6_pre_natal_yoga
        ).map { DrawableStringPair(it.first, it.second) }


        val favouriteDataSample = listOf(
            R.drawable.fc1_short_mantras to R.string.fc1_short_mantras,
            R.drawable.fc2_nature_meditations to R.string.fc2_nature_meditations,
            R.drawable.fc3_stress_and_anxiety to R.string.fc3_stress_and_anxiety,
            R.drawable.fc4_self_massage to R.string.fc4_self_message,
            R.drawable.fc5_overwhelmed to R.string.fc5_overwhelmed
        ).map { DrawableStringPair(it.first, it.second) }
    }
}