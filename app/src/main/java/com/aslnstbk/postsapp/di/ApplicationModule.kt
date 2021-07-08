package com.aslnstbk.postsapp.di

import com.aslnstbk.postsapp.data.repositories.CreatePostRepository
import com.aslnstbk.postsapp.data.repositories.HomeRepository
import com.aslnstbk.postsapp.domain.CreatePostDomainRepository
import com.aslnstbk.postsapp.domain.HomeDomainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {

    @Provides
    fun provideHomeDomainRepository(homeRepository: HomeRepository): HomeDomainRepository {
        return homeRepository
    }

    @Provides
    fun provideCreatePostDomainRepository(createPostRepository: CreatePostRepository): CreatePostDomainRepository {
        return createPostRepository
    }
}