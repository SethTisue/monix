/*
 * Copyright (c) 2014-2016 by its authors. Some rights reserved.
 * See the project homepage at: https://monix.io
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

package monix.execution

import minitest.SimpleTestSuite

object CancelableSuite extends SimpleTestSuite {
  test("Cancelable.empty") {
    val c = Cancelable()
    assertEquals(c, Cancelable.empty)
    assert(c.toString.toLowerCase.contains("empty"))
  }

  test("Cancelable(task) should be idempotent") {
    var effect = 0
    val c = Cancelable(() => effect += 1)

    assertEquals(effect, 0)
    c.cancel()
    assertEquals(effect, 1)
    c.cancel()
    assertEquals(effect, 1)
  }
}
