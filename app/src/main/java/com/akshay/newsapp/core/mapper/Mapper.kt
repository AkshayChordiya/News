package com.akshay.newsapp.core.mapper

/**
 * Interface for model mappers. It provides helper methods that facilitate
 * retrieving of models from outer data source layers
 *
 * @param <Storage> the cached model input type
 * @param <Remote> the remote model input type
 */
interface Mapper<Storage, Remote> {
    fun Storage.toRemote(): Remote
    fun Remote.toStorage(): Storage
    fun List<Storage>.toRemote(): List<Remote> = this.map { it.toRemote() }
    fun List<Remote>.toStorage(): List<Storage> = this.map { it.toStorage() }
}