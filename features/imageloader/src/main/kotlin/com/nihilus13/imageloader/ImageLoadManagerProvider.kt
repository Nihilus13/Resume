package com.nihilus13.imageloader

object ImageLoadManagerProvider {
    private lateinit var imageLoadManager: ImageLoadManager

    fun getImageLoaderManager(imageLoader: ImageLoadManager = ImageLoaderManagerImpl()): ImageLoadManager {
        if (!::imageLoadManager.isInitialized) {
            imageLoadManager = imageLoader
        }
        return imageLoadManager
    }
}