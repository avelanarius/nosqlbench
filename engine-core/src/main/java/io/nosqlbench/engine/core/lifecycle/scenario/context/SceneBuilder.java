package io.nosqlbench.engine.core.lifecycle.scenario.context;

/*
 * Copyright (c) 2022 nosqlbench
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */


import io.nosqlbench.components.NBComponent;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.Map;

public class SceneBuilder implements SceneBuilderFacets.ALL {
    private Map<String,String> params = Map.of();
    private ScenarioActivitiesController controller;
    private PrintWriter out = new PrintWriter(System.out);
    private PrintWriter err = new PrintWriter(System.err);
    private Reader in = new InputStreamReader(System.in);
    private NBSceneBuffer.IOType iotype = NBSceneBuffer.IOType.traced;


    public NBSceneBuffer build(NBComponent forScenario) {
        NBDefaultSceneFixtures fixtures =
            new NBDefaultSceneFixtures(
                ScenarioParams.of(this.params),
                ((this.controller!=null) ? this.controller : new ScenarioActivitiesController(forScenario)),
                this.out,
                this.err,
                this.in);
        return new NBSceneBuffer(fixtures,iotype);
    }


    @Override
    public SceneBuilder controller(ScenarioActivitiesController controller) {
        this.controller = controller;
        return this;
    }

    @Override
    public SceneBuilder out(PrintWriter out) {
        this.out = out;
        return this;
    }

    @Override
    public SceneBuilderFacets.WantsParams err(PrintWriter err) {
        this.err = err;
        return this;
    }

    @Override
    public SceneBuilder in(Reader in) {
        this.in = in;
        return this;

    }

    @Override
    public SceneBuilder params(Map<String, String> params) {
        this.params=params;
        return this;
    }

    @Override
    public SceneBuilderFacets.WantsParams virtualIO() {
        this.iotype= NBSceneBuffer.IOType.virtual;
        return this;
    }

    @Override
    public SceneBuilderFacets.WantsParams connectedIO() {
        this.iotype = NBSceneBuffer.IOType.connected;
        return this;
    }

    @Override
    public SceneBuilderFacets.WantsParams tracedIO() {
        this.iotype=NBSceneBuffer.IOType.traced;
        return this;
    }
}
