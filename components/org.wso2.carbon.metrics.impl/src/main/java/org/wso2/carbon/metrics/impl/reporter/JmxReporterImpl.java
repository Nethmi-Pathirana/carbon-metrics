/*
 * Copyright 2015 WSO2 Inc. (http://wso2.org)
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
package org.wso2.carbon.metrics.impl.reporter;

import java.util.concurrent.TimeUnit;

import com.codahale.metrics.JmxReporter;
import com.codahale.metrics.MetricFilter;
import com.codahale.metrics.MetricRegistry;

public class JmxReporterImpl extends AbstractReporter {
    
    private final JmxReporter jmxReporter;

    public JmxReporterImpl(MetricRegistry metricRegistry, MetricFilter metricFilter, String domain) {
        super("JMX");
        this.jmxReporter = JmxReporter.forRegistry(metricRegistry).inDomain(domain).filter(metricFilter)
                .convertRatesTo(TimeUnit.SECONDS).convertDurationsTo(TimeUnit.MILLISECONDS).build();
    }

    @Override
    public void report() {
        // Nothing to report
    }

    @Override
    public void startReporter() {
        jmxReporter.start();
    }

    @Override
    public void stopReporter() {
        jmxReporter.stop();
    }
}
