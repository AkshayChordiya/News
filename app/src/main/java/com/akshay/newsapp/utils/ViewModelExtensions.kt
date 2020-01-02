package com.akshay.newsapp.utils

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.ParametersDefinition
import org.koin.core.qualifier.Qualifier

/**
 * Synthetic sugaring to get instance of [ViewModel] for [AppCompatActivity].
 */
inline fun <reified T : ViewModel> LifecycleOwner.getViewModel(
	qualifier: Qualifier? = null,
	noinline parameters: ParametersDefinition? = null)
		: Lazy<T> = viewModel(qualifier, parameters)