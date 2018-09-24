package com.mathiasbrandt.paymentshistory.di

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ViewModelModule::class])
interface SingletonComponent {
    fun viewModelFactory(): ViewModelFactory
}