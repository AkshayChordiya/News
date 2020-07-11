package com.akshay.newsapp.core.ui.base

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import dagger.hilt.android.AndroidEntryPoint

// Easy to switch base activity in future
typealias BaseActivity = DaggerActivity

/**
 * Base activity providing Dagger support and [ViewModel] support
 */
@AndroidEntryPoint
abstract class DaggerActivity : AppCompatActivity()
