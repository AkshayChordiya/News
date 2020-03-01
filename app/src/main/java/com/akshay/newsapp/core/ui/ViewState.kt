package com.akshay.newsapp.core.ui

/**
 * Describes state of the view at any
 * point of time.
 */
sealed class ViewState<ResultType> {

    /**
     * Describes success state of the UI with
     * [data] shown
     */
    data class Success<ResultType>(
            val data: ResultType
    ) : ViewState<ResultType>()

    /**
     * Describes loading state of the UI
     */
    class Loading<ResultType> : ViewState<ResultType>() {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false
            return true
        }

        override fun hashCode(): Int = javaClass.hashCode()
    }

    /**
     *  Describes error state of the UI
     */
    data class Error<ResultType>(
            val message: String
    ) : ViewState<ResultType>()

    companion object {
        /**
         * Creates [ViewState] object with [Success] state and [data].
         */
        fun <ResultType> success(data: ResultType): ViewState<ResultType> = Success(data)

        /**
         * Creates [ViewState] object with [Loading] state to notify
         * the UI to showing loading.
         */
        fun <ResultType> loading(): ViewState<ResultType> = Loading()

        /**
         * Creates [ViewState] object with [Error] state and [message].
         */
        fun <ResultType> error(message: String): ViewState<ResultType> = Error(message)
    }
}