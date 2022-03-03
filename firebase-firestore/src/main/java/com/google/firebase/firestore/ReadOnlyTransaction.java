// Copyright 2022 Google LLC
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

package com.google.firebase.firestore;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.firebase.Timestamp;

public class ReadOnlyTransaction {

  ReadOnlyTransaction() {
  }

  @NonNull
  public DocumentSnapshot get(@NonNull DocumentReference documentRef)
      throws FirebaseFirestoreException {
    return get(documentRef, null);
  }

  @NonNull
  public DocumentSnapshot get(@NonNull DocumentReference documentRef, @Nullable Timestamp readTime)
      throws FirebaseFirestoreException {
    throw new RuntimeException("not implemented");
  }

  public interface Function<TResult> {
    @Nullable
    TResult apply(@NonNull ReadOnlyTransaction transaction) throws FirebaseFirestoreException;
  }
}