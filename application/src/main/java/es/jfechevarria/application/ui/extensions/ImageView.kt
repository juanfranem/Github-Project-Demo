package es.jfechevarria.application.ui.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.RoundedCorners

fun ImageView.load(url: String?) {
    Glide.with(this.context)
        .load(url)
        .fitCenter()
        .transform(MultiTransformation(RoundedCorners(999)))
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .into(this)
}