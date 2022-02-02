package com.taghavi.spacexpractice.di;

import android.content.Context;

import com.taghavi.spacexpractice.BaseApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public final class AppModule {

    @Singleton
    @Provides
    BaseApplication provideApplication(@ApplicationContext Context context) {
        return (BaseApplication) context;
    }
}
