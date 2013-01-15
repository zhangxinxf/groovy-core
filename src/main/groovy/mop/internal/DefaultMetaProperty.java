/*
 * Copyright 2003-20013 the original author or authors.
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
package groovy.mop.internal;

import groovy.mop.MetaMethod;
import groovy.mop.MetaProperty;

import java.lang.reflect.Modifier;
import java.util.List;

/**
 * Represents a property on a bean which may have a getter and/or a setter
 * 
 * @author <a href="mailto:james@coredevelopers.net">James Strachan</a>
 * @author Jochen Theodorou
 */
public class DefaultMetaProperty implements MetaProperty {
    private final String name;
    private final Class type;
    private final List<MetaMethod> getter;
    private final List<MetaMethod> setter;

    public DefaultMetaProperty(String name, Class type, List<MetaMethod> getter, List<MetaMethod> setter) {
        this.name = name;
        this.type = type;
        this.getter = getter;
        this.setter = setter;
    }

    /**
     * @return name of the property
     */
    public String getName() {
        return name;
    }

    /**
     * @return the type of the property
     */
    public Class getType() {
        return type;
    }

    /**
     * @return modifiers
     */
    public int getModifiers() {
        return Modifier.PUBLIC;
    }

    @Override
    public List<MetaMethod> getter(boolean accessField) {
        return getter;
    }

    @Override
    public List<MetaMethod> setter(boolean accessField) {
        return setter;
    }
}