/*
 * Copyright 2022 Starwhale, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ai.starwhale.mlops.datastore;

import ai.starwhale.mlops.exception.SwValidationException;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class ColumnSchema {

    private final String name;
    private final ColumnType type;
    private final int index;

    public ColumnSchema(@NonNull ColumnSchemaDesc schema, int index) {
        if (schema.getName() == null) {
            throw new SwValidationException(SwValidationException.ValidSubject.DATASTORE).tip(
                    "column name should not be null");
        }
        if (schema.getType() == null) {
            throw new SwValidationException(SwValidationException.ValidSubject.DATASTORE).tip(
                    "column type should not be null");
        }
        this.name = schema.getName();
        try {
            this.type = ColumnType.valueOf(schema.getType());
        } catch (IllegalArgumentException e) {
            throw new SwValidationException(SwValidationException.ValidSubject.DATASTORE).tip(
                    "invalid column type " + schema.getType());
        }
        this.index = index;
    }
}
