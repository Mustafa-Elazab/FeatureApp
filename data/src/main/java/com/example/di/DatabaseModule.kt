//package com.example.landofmoviz.di
//import android.content.Context
//
//
//@Module
//@InstallIn(SingletonComponent::class)
//object DatabaseModule {
//
//    @Singleton
//    @Provides
//    fun provideMovieDao(appDatabase: AppDatabase): MovieDao = appDatabase.movieDao()
//
//
//
//    @Singleton
//    @Provides
//    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase = Room.databaseBuilder(
//        context,
//        AppDatabase::class.java,
//        "movie-app-db"
//    ).build()
//}