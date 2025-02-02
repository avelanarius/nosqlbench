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
 */

package io.nosqlbench.api.engine.metrics.instruments;

import io.nosqlbench.api.labels.NBLabels;

public class NBBaseMetric implements NBMetric {
    private final NBLabels labels;

    public NBBaseMetric(String... labels) {
        this.labels = NBLabels.forKV((Object[]) labels);
    }
    @Override
    public NBLabels getLabels() {
        return this.labels;
    }

    @Override
    public String typeName() {
        return "basetype";
    }
}
