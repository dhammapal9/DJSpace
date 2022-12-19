package com.dj.spacex.di


import com.dj.spacex.ui.home.HomeFragment
import com.dj.spacex.ui.rocket.RocketDetailsFragment
import com.dj.spacex.ui.rocket.RocketFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract fun contributeHomeFragment(): HomeFragment



    @ContributesAndroidInjector
    abstract fun contributeRocketFragment(): RocketFragment

    @ContributesAndroidInjector
    abstract fun contributeRocketDetailsFragment(): RocketDetailsFragment






}