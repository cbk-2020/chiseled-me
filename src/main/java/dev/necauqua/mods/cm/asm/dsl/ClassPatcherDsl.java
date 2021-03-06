/*
 * Copyright (c) 2016-2019 Anton Bulakh <necauqua@gmail.com>
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

package dev.necauqua.mods.cm.asm.dsl;

public interface ClassPatcherDsl {

    ClassPatcherDsl addField(int acc, String name, String desc, String sign);

    default ClassPatcherDsl addField(int acc, String name, String desc) {
        return addField(acc, name, desc, null);
    }

    ClassPatcherDsl addMethod(int acc, String name, String desc, String sign, String[] exceptions, Hook code);

    default ClassPatcherDsl addMethod(int acc, String name, String desc, String sign, Hook code) {
        return addMethod(acc, name, desc, sign, null, code);
    }

    default ClassPatcherDsl addMethod(int acc, String name, String desc, Hook code) {
        return addMethod(acc, name, desc, null, null, code);
    }

    ClassPatcherDsl addInterface(String iface);

    ClassPatcherDsl stripInterface(String iface);

    MethodPatcherDsl patchMethod(String name, String desc);

    MethodPatcherDsl patchMethodOptionally(String name, String desc);

    default MethodPatcherDsl patchConstructor(String desc) {
        return patchMethod("<init>", desc);
    }
}
