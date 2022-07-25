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

package ai.starwhale.mlops.agent.task.log;

import java.util.Map;

public interface Reader {
    int logSize();
    int subscriberSize();
    void subscribe(Long taskId, String readerId);
    void unSubscribe(Long taskId, String readerId);
    String read(Long taskId, String readerId);
    int offset(Long taskId, String readerId);
    Map<String, String> read(Long taskId);
    void clean();
}