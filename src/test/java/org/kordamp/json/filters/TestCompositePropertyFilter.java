/*
 * Copyright 2006-2014 the original author or authors.
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
package org.kordamp.json.filters;

import junit.framework.TestCase;

/**
 * @author Andres Almiray
 */
public class TestCompositePropertyFilter extends TestCase {
    public static void main(String[] args) {
        junit.textui.TestRunner.run(TestCompositePropertyFilter.class);
    }

    private CompositePropertyFilter filter;

    public TestCompositePropertyFilter(String testName) {
        super(testName);
    }

    public void testApply_addFilter() {
        filter.addPropertyFilter(new FalsePropertyFilter());
        assertFalse(filter.apply(null, null, null));
        filter.addPropertyFilter(new TruePropertyFilter());
        assertTrue(filter.apply(null, null, null));
    }

    protected void setUp() throws Exception {
        filter = new CompositePropertyFilter();
    }
}