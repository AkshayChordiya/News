package com.akshay.newsapp.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.recyclerview.widget.RecyclerView
import com.akshay.newsapp.R
import com.akshay.newsapp.model.network.Status
import com.akshay.newsapp.utils.gone
import com.akshay.newsapp.utils.visible

/**
 * A custom implementation of [RecyclerView] to support
 * Empty View & Loading animation.
 *
 * @author Akshay Chordiya
 */
class CompleteRecyclerView @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyle: Int = 0
) : RecyclerView(context, attrs, defStyle) {

    /**
     * Empty layout
     */
    private var mEmptyView: View? = null

    /**
     * Progress view
     */
    private var mProgressView: View? = null

    /**
     * Column width for grid layout
     */
    private var columnWidth: Int = 0

    init {
        gone()
        if (attrs != null) {
            val attrsArray = intArrayOf(android.R.attr.columnWidth)
            val array = context.obtainStyledAttributes(
                    attrs, attrsArray)
            columnWidth = array.getDimensionPixelSize(0, -1)
            array.recycle()
        }
    }

    override fun setAdapter(adapter: androidx.recyclerview.widget.RecyclerView.Adapter<*>?) {
        visible()
        val oldAdapter = getAdapter()
        oldAdapter?.unregisterAdapterDataObserver(mAdapterObserver)
        super.setAdapter(adapter)
        adapter?.registerAdapterDataObserver(mAdapterObserver)
        refreshState()
    }

    private fun refreshState() {
        if (adapter != null) {
            val noItems = 0 == adapter?.itemCount
            if (noItems) {
                mProgressView?.gone()
                mEmptyView?.visible()
                gone()
            } else {
                mProgressView?.gone()
                mEmptyView?.gone()
                visible()
            }
        }
    }

    fun setEmptyView(emptyView: View) {
        this.mEmptyView = emptyView
        mEmptyView?.gone()
    }

    fun setProgressView(progressView: View) {
        this.mProgressView = progressView
        mProgressView?.visible()
    }

    fun setEmptyMessage(@StringRes mEmptyMessageResId: Int) {
        val emptyText = mEmptyView?.findViewById<TextView>(R.id.empty_title)
        emptyText?.setText(mEmptyMessageResId)
    }

    fun setEmptyIcon(@DrawableRes mEmptyIconResId: Int) {
        val emptyImage = mEmptyView?.findViewById<ImageView>(R.id.empty_image)
        emptyImage?.setImageResource(mEmptyIconResId)
    }

    fun showState(status: Status) {
        when (status) {
            Status.SUCCESS, Status.ERROR -> {
                mProgressView?.gone()
                mEmptyView?.visible()
            }
            Status.LOADING -> {
                mEmptyView?.gone()
                mProgressView?.visible()
            }
        }
    }

    override fun onMeasure(widthSpec: Int, heightSpec: Int) {
        super.onMeasure(widthSpec, heightSpec)
        if (layoutManager is androidx.recyclerview.widget.GridLayoutManager) {
            val manager = layoutManager as androidx.recyclerview.widget.GridLayoutManager
            if (columnWidth > 0) {
                val spanCount = Math.max(1, measuredWidth / columnWidth)
                manager.spanCount = spanCount
            }
        }
    }

    /**
     * Observes for changes in the adapter and is triggered on change
     */
    private val mAdapterObserver = object : androidx.recyclerview.widget.RecyclerView.AdapterDataObserver() {
        override fun onChanged() = refreshState()
        override fun onItemRangeInserted(positionStart: Int, itemCount: Int) = refreshState()
        override fun onItemRangeRemoved(positionStart: Int, itemCount: Int) = refreshState()
    }

}
