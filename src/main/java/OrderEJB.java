/*
 * JBoss, Home of Professional Open Source
 * Copyright 2015, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import javax.ejb.Stateful;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;

@Stateful
public class OrderEJB {

    public List<String> createOrders() {
        List<String> orders = new ArrayList<>();
        orders.add("Заказ №1");
        orders.add("Заказ №2");
        orders.add("Заказ №3");
        orders.add("Заказ №4");
        orders.add("Заказ №5");
        orders.add("Заказ №6");
        orders.add("Заказ №7");
        orders.add("Заказ №8");
        orders.add("Заказ №9");
        orders.add("Заказ №10");

        return orders;
    }
}
