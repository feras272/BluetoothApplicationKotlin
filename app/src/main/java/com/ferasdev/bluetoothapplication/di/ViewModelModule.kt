package com.ferasdev.bluetoothapplication.di

import android.content.Context
import com.ferasdev.bluetoothapplication.R
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object ViewModelModule {

    @ViewModelScoped
    @Provides
    fun provideGetSecondName(@ApplicationContext context: Context): String {
        return context.getString(R.string.secondName)
    }

}