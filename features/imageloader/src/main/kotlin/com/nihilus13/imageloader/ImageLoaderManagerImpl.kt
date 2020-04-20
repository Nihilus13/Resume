package com.nihilus13.imageloader

import android.content.Context
import android.widget.ImageView
import coil.ImageLoader
import coil.ImageLoaderBuilder
import coil.api.load
import coil.decode.SvgDecoder
import coil.transform.CircleCropTransformation
import coil.transform.RoundedCornersTransformation
import coil.transform.Transformation
import com.nihilus13.imageloader.TransformationType.*
import com.nihilus13.imageloader.transformation.RoundedCornerStrokeTransformation

internal class ImageLoaderManagerImpl : ImageLoadManager {

    private lateinit var imageLoader: ImageLoader

    private fun initImageLoader(context: Context) =
        ImageLoaderBuilder(context)
            .componentRegistry {
                add(SvgDecoder(context))
            }.build()

    private fun getImageLoader(context: Context): ImageLoader {
        if (!::imageLoader.isInitialized) {
            imageLoader = initImageLoader(context)
        }
        return imageLoader
    }

    override fun loadImage(
        imageView: ImageView,
        imageUrl: String,
        transformationType: TransformationType?
    ) {
        imageView.load(imageUrl, imageLoader = getImageLoader(imageView.context)) {
            transformationType?.let { transformations(it.getTransformation()) }
        }
    }

    private fun TransformationType.getTransformation(): Transformation =
        when (this) {
            is CircleCrop -> CircleCropTransformation()
            is RoundedCorners -> {
                RoundedCornersTransformation(
                    topLeftRadiusInPx,
                    topRightRadiusInPx,
                    bottomLeftRadiusInPx,
                    bottomRightRadiusInPx
                )
            }
            is Stroke -> RoundedCornerStrokeTransformation(
                radius,
                strokeWidth,
                strokeColor
            )
        }
}
