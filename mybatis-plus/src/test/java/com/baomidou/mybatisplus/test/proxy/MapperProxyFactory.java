/**
 * Copyright (c) 2011-2014, hubin (jobob@qq.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.baomidou.mybatisplus.test.proxy;

import java.lang.reflect.Proxy;

/**
 * <p>
 * 类似  org.apache.ibatis.binding.MapperProxyFactory<T>
 * </p>
 *
 * @author hubin
 * @Date 2016-07-06
 */
public class MapperProxyFactory {

    public static <T> T getMapper(Class<T> type) {
        return newInstance(type);
    }

    @SuppressWarnings("unchecked")
    public static <T> T newInstance(Class<T> methodInterface) {
        final MapperProxy<T> methodProxy = new MapperProxy<>(methodInterface);
        return (T) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                new Class[]{methodInterface}, methodProxy);
    }

}
