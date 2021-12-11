/*
 * Copyright (C) 2021 The Android Open Source Project.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.acsent.androidmista

import android.util.Log
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.acsent.androidmista.network.TopicsListItem
import com.acsent.androidmista.topicsList.ListViewAdapter
import java.util.*

/**
 * Updates the data shown in the [RecyclerView].
 */
@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<TopicsListItem>?) {
    val adapter = recyclerView.adapter as ListViewAdapter
    adapter.submitList(data)
}
@BindingAdapter("width")
fun bindWidth(view: View, item: Any) {
    // сбрасывается на wrap_content
    var layoutParams = view.layoutParams
    layoutParams.width = FrameLayout.LayoutParams.MATCH_PARENT
    view.layoutParams = layoutParams
}

/**
 * Uses the Coil library to load an image by URL into an [ImageView]
 */
@BindingAdapter("text")
fun bindText(textView: TextView, text: String?) {
    text?.let {
        textView.text = text
    }
}

/**
 * This binding adapter displays the [MarsApiStatus] of the network request in an image view.  When
 * the request is loading, it displays a loading_animation.  If the request has an error, it
 * displays a broken image to reflect the connection error.  When the request is finished, it
 * hides the image view.
@BindingAdapter("marsApiStatus")
fun bindStatus(statusImageView: ImageView, status: MarsApiStatus?) {
    when (status) {
        MarsApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        MarsApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
        MarsApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
    }
}
 */
