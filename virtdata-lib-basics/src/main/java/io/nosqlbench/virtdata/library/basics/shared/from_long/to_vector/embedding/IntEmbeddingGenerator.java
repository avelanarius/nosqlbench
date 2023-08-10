/*
 * Copyright (c) 2023 nosqlbench
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package io.nosqlbench.virtdata.library.basics.shared.from_long.to_vector.embedding;

import java.util.List;

public class IntEmbeddingGenerator implements EmbeddingGenerator {
    @Override
    public List<Float> generateEmbeddingFrom(Object o, int[] dims) {
        // in this case o will always be int[1][x]
        int[] vector = ((int[][]) o)[0];
        Float[] vector2 = new Float[vector.length];
        for (int i = 0; i < vector.length; i++) {
            vector2[i] = (float) vector[i];
        }
        return List.of(vector2);
    }
}
