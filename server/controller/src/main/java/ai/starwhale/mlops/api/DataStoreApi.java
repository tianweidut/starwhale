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

package ai.starwhale.mlops.api;

import ai.starwhale.mlops.api.protocol.ResponseMessage;
import ai.starwhale.mlops.api.protocol.datastore.QueryTableRequest;
import ai.starwhale.mlops.api.protocol.datastore.RecordListVO;
import ai.starwhale.mlops.api.protocol.datastore.ScanTableRequest;
import ai.starwhale.mlops.api.protocol.datastore.UpdateTableRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Validated
public interface DataStoreApi {

    @PostMapping(value = "/datastore/updateTable")
    ResponseEntity<ResponseMessage<String>> updateTable(
            @Valid @RequestBody UpdateTableRequest request);

    @PostMapping(value = "/datastore/queryTable")
    ResponseEntity<ResponseMessage<RecordListVO>> queryTable(
            @Valid @RequestBody QueryTableRequest request);

    @PostMapping(value = "/datastore/scanTable")
    ResponseEntity<ResponseMessage<RecordListVO>> scanTable(
            @Valid @RequestBody ScanTableRequest request);
}