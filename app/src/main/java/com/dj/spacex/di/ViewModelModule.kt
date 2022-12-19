package com.dj.spacex.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dj.spacex.ui.home.HomeViewModel
import com.dj.spacex.ui.rocket.RocketDetailsViewModel
import com.dj.spacex.ui.rocket.RocketViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(homeViewModel: HomeViewModel): ViewModel


    @Binds
    @IntoMap
    @ViewModelKey(RocketViewModel::class)
    abstract fun bindRocketViewModel(rocketViewModel: RocketViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(RocketDetailsViewModel::class)
    abstract fun bindRocketDetailsViewModel(rocketDetailsViewModel: RocketDetailsViewModel): ViewModel




    @Binds
    abstract fun bindViewModelFactory(viewModelProviderFactory: ViewModelProviderFactory): ViewModelProvider.Factory
}
