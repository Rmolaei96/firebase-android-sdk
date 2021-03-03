// Copyright 2021 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.firebase.database.core;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.Query;

import java.util.concurrent.Executors;

/**
 * An internal transaction object responsible for tracking data operations
 * performed in a user transaction callback. All data operations are executed
 * on the transaction thread-pool.
 */
public class Transaction {

    public Task<DataSnapshot> get(@NonNull Query query) {
        return query.get().continueWithTask(Runnable::run, task -> {
            if (task.isSuccessful()) {
                recordQueryResult(task.getResult());
            }
            return task;
        });
    }

    public void recordQueryResult(DataSnapshot snap) {
    }

}