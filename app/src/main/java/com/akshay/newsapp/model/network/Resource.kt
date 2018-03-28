package com.akshay.newsapp.model.network

/**
 * A generic class that holds a value with its loading status.
 * @param <T>
</T> */
data class Resource<ResultType>(var status: Status, var data: ResultType? = null, var errorMessage: String? = null) {

    companion object {
        /**
         * Creates [Resource] object with `SUCCESS` status and [data].
         */
        fun <ResultType> success(data: ResultType): Resource<ResultType> = Resource(Status.SUCCESS, data)

        /**
         * Creates [Resource] object with `LOADING` status to notify
         * the UI to showing loading.
         */
        fun <ResultType> loading(): Resource<ResultType> = Resource(Status.LOADING)

        /**
         * Creates [Resource] object with `ERROR` status and [message].
         */
        fun <ResultType> error(message: String?): Resource<ResultType> = Resource(Status.ERROR, errorMessage = message)
    }
}