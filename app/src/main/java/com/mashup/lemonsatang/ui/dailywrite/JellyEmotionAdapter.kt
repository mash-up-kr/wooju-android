package com.mashup.lemonsatang.ui.dailywrite

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mashup.lemonsatang.R
import com.mashup.lemonsatang.util.extension.setEmotionApngDrawable

class JellyEmotionAdapter : RecyclerView.Adapter<JellyEmotionAdapter.JellyViewHolder>() {

    private val emotionTexts = arrayOf("기뻐요","행복해요","평온해요","만족해요","화나요","우울해요","피곤해요","슬퍼요")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JellyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val jellyItemView = inflater.inflate(R.layout.item_jelly, parent, false)
        return JellyViewHolder(jellyItemView)
    }

    override fun getItemCount(): Int {
        return emotionTexts!!.size
    }

    override fun onBindViewHolder(holder: JellyViewHolder, position: Int) {
        holder.jellyImageView!!.setEmotionApngDrawable(position)
        holder.emotionTextView!!.text = emotionTexts!![position]
    }

    class JellyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var jellyImageView : ImageView? = null
        var emotionTextView : TextView? = null

        init {
            jellyImageView = itemView.findViewById(R.id.iv_jelly_item_emotion)
            emotionTextView = itemView.findViewById(R.id.tv_jelly_item_emotion)
        }
    }
}