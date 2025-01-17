/*
 * This file is part of CycloneDX Core (Java).
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
 * SPDX-License-Identifier: Apache-2.0
 * Copyright (c) OWASP Foundation. All Rights Reserved.
 */
package org.cyclonedx.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.cyclonedx.model.ComponentWrapper;

public class ComponentWrapperSerializer extends StdSerializer<ComponentWrapper>
{
  private ObjectMapper mapper;

  public ComponentWrapperSerializer(final ObjectMapper mapper) {
    this(ComponentWrapper.class);

    this.mapper = mapper;
  }

  public ComponentWrapperSerializer(final Class<ComponentWrapper> t) {
    super(t);

    mapper = new ObjectMapper();
  }

  @Override
  public void serialize(
      final ComponentWrapper componentWrapper,
      final JsonGenerator generator,
      final SerializerProvider serializerProvider)
      throws IOException
  {
    if (componentWrapper.getComponents() != null) {
      mapper.writeValue(generator, componentWrapper.getComponents());
    }
  }
}
