/*
 * Copyright (C) 2017/2021 e-voyageurs technologies
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

package ai.tock.bot.admin.model

import ai.tock.bot.admin.bot.llm.BotRagConfiguration
import ai.tock.llm.orchestrator.core.models.em.EMSetting
import ai.tock.llm.orchestrator.core.models.llm.LLMSetting
import org.litote.kmongo.newId
import org.litote.kmongo.toId

data class BotRAGConfigurationDTO(
    val id: String? = null,
    val namespace: String,
    val botId: String,
    val enabled: Boolean = false,
    val llmSetting: LLMSetting,
    val emSetting: EMSetting,
    val indexSessionId: String? = null,
    val noAnswerSentence: String,
    val noAnswerStoryId: String? = null,
) {
    constructor(configuration: BotRagConfiguration): this(
        configuration._id.toString(),
        configuration.namespace,
        configuration.botId,
        configuration.enabled,
        configuration.llmSetting,
        configuration.emSetting,
        configuration.indexSessionId,
        configuration.noAnswerSentence,
        configuration.noAnswerStoryId
    )
    fun toBotRAGConfiguration(): BotRagConfiguration =
        BotRagConfiguration(
            id?.toId() ?: newId(),
            namespace,
            botId,
            enabled,
            llmSetting,
            emSetting,
            indexSessionId = indexSessionId,
            noAnswerSentence = noAnswerSentence,
            noAnswerStoryId = noAnswerStoryId
        )
}


