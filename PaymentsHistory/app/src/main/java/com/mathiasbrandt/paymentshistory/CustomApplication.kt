package com.mathiasbrandt.paymentshistory

import android.app.Application
import com.mathiasbrandt.paymentshistory.di.DaggerSingletonComponent
import com.mathiasbrandt.paymentshistory.di.SingletonComponent

class CustomApplication: Application() {
    lateinit var singletonComponent: SingletonComponent

    companion object {
        private lateinit var instance: CustomApplication
        fun get(): CustomApplication = instance
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        singletonComponent = DaggerSingletonComponent.builder()
                .build()
    }
}

class Injector private constructor() {
    companion object {
        fun get(): SingletonComponent = CustomApplication.get().singletonComponent
    }
}