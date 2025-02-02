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

package io.nosqlbench.adapters.api.evalcontext;

import java.util.function.LongFunction;

public interface CycleFunction<T> extends LongFunction<T>, VariableInjectable, ExpressionDetails {

    /**
     * Produce a result from a cycle. This is an encapsulating type for any implementations which need
     * to
     * @param value the function argument
     * @return
     */
    @Override
    T apply(long value);

    /**
     * Get a new instance of a CycleFunction, based on the current one, but with its own instance of any
     * non-threadsafe elements.
     * @return A new CycleFunction
     */
    CycleFunction<T> newInstance();
}
