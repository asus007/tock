import ai.tock.DeeplTranslatorEngine
import org.junit.jupiter.api.Test
import java.util.Locale
import kotlin.test.assertEquals

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

class DeeplTranslateIntegrationTest {
    @Test
    fun simpleTest() {
        val result = DeeplTranslatorEngine.translate("Bonjour, je voudrais me rendre à New-York Mardi prochain", Locale.FRENCH, Locale.ENGLISH)
        assertEquals("Hello, I would like to go to New York next Tuesday.",result)
    }

    @Test
    fun testWithParameters() {
        val result = DeeplTranslatorEngine.translate("Bonjour, je voudrais me rendre à {:city} {:date}", Locale.FRENCH, Locale.GERMAN)
        assertEquals("Hallo, ich möchte nach {:city} {:date} reisen",result)
    }
}