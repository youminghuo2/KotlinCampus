package com.example.kotlincampus.utils

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore

/**
 * @Description:
 * @CreateDate: 2021/12/14 14:08
 */

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")