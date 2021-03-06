/*
 * Copyright 2016 Fizzed, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package utils;

import com.fizzed.ninja.rocker.DefaultNinjaRocker;
import com.fizzed.ninja.rocker.NinjaRockerTemplate;
import com.fizzed.rocker.RockerModel;
import com.fizzed.rocker.RockerTemplate;
import com.fizzed.rocker.RockerUtils;

abstract public class ApplicationRockerTemplate extends NinjaRockerTemplate {

    public ApplicationRocker A;
    
    public ApplicationRockerTemplate(RockerModel model) {
        super(model);
    }
    
    /**
     * Apply NinjaRocker to template immediately before rendering. Best place
     * to setup your own application-specific properties or methods that rely
     * on Ninja context, router, messages, etc.
     * @param N The ninja rocker instance
     */
    @Override
    public void __apply(DefaultNinjaRocker N) {
        super.__apply(N);
        this.A = new ApplicationRocker(N);
    }

    /**
     * Associate this template with another template during the rendering
     * process.  This occurs when Template A calls or includes Template B.
     * Usually, you simply want to copy over the variables you created in
     * the __apply method.
     * @param template The template to associate us with
     */
    @Override
    protected void __associate(RockerTemplate template) {
        super.__associate(template);
        ApplicationRockerTemplate applicationTemplate
            = RockerUtils.requireTemplateClass(template, ApplicationRockerTemplate.class);
        this.A = applicationTemplate.A;
    }
    
}
