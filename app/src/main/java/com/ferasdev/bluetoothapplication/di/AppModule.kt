package com.ferasdev.bluetoothapplication.di

import android.content.Context
import com.ferasdev.bluetoothapplication.R
import com.ferasdev.bluetoothapplication.data.repositories.UserDataSource
import com.ferasdev.bluetoothapplication.data.repositories.UserDataSourceImpl
import com.ferasdev.bluetoothapplication.data.repositories.UserLocalDataSource
import com.ferasdev.bluetoothapplication.data.repositories.UserLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    // Here we instantiate all the instances we are using in our application
    // Instantiate once and using it across the application

    // @Named("firstName")
//    @Inject
//    lateinit var userRepository: UserRepositoryImpl

    @Singleton
    @Provides
    @Named("FirstName")
    fun provideGetFirstName(@ApplicationContext context: Context): String {
        return context.getString(R.string.firstName)
    }

    @Singleton
    @Provides
    @Named("SecondName")
    fun provideGetSecondName(@ApplicationContext context: Context): String { // to access the context inside the app module
        return context.getString(R.string.secondName)
    }

    @Singleton
    @Provides
    fun provideUserRepository(): UserDataSource = UserDataSourceImpl()

    @Singleton
    @Provides
    fun provideUserLocalDataSource(): UserLocalDataSource = UserLocalDataSourceImpl()

}