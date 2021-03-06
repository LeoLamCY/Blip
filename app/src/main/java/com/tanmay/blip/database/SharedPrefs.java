/*
 * Copyright 2015, Tanmay Parikh
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.tanmay.blip.database;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SharedPrefs {

    private static SharedPrefs mInstance;

    private SharedPreferences sharedPreferences;

    private SharedPrefs(Context context) {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static void create(Context context) {
        mInstance = new SharedPrefs(context);
    }

    public static SharedPrefs getInstance() {
        return mInstance;
    }

    public boolean getFirstRun() {
        return sharedPreferences.getBoolean("FIRST_RUN", true);
    }

    public void setFirstRun(boolean firstRun) {
        sharedPreferences.edit().putBoolean("FIRST_RUN", firstRun).apply();
    }

    public void setLastRedownladTime(long time) {
        sharedPreferences.edit().putLong("REDOWNLOAD_TIME", time).apply();
    }

    public long getLastRedownloadTime() {
        return sharedPreferences.getLong("REDOWNLOAD_TIME", 0);
    }

    public long getLastTranscriptCheckTime() {
        return sharedPreferences.getLong("TRANSCRIPT_TIME", 0);
    }

    public void setLastTranscriptCheckTime(long time) {
        sharedPreferences.edit().putLong("TRANSCRIPT_TIME", time).apply();
    }

}
