package com.survivalcoding.ifkakao.presentation.highlight.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import coil.transform.RoundedCornersTransformation
import com.survivalcoding.ifkakao.R
import com.survivalcoding.ifkakao.databinding.ContentListItemBinding
import com.survivalcoding.ifkakao.domain.model.IkSessionData

class HighlightListViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.content_list_item, parent, false)
) {
    private val binding = ContentListItemBinding.bind(itemView)

    fun bind(
        session: IkSessionData,
        clickListener: (session: IkSessionData) -> Unit,
    ) {
        binding.tvHighlightTitle.text = session.title
        binding.tvVideoLength.isVisible = session.isVideo
        binding.tvVideoLength.text = session.video.videoLength

        binding.listCompany.text = session.company
        binding.listField.text = session.field

        val imageUrl = session.video.thumbnailUrl
        binding.ivListItemThumbnail.load(imageUrl) {
            transformations(RoundedCornersTransformation(radius = 10f))
            crossfade(true)
            crossfade(500)
        }

        itemView.setOnClickListener {
            clickListener(session)
        }
    }
}