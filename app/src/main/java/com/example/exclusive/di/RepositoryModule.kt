package com.example.exclusive.di

import com.example.exclusive.data.remote.ShopifyRemoteDataSource
import com.example.exclusive.data.remote.ShopifyRemoteDataSourceImpl
import com.example.exclusive.screens.category.repository.CategoriesRepository
import com.example.exclusive.screens.category.repository.CategoriesRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindShopifyRemoteDataSource(
        shopifyRemoteDataSourceImpl: ShopifyRemoteDataSourceImpl
    ): ShopifyRemoteDataSource


}