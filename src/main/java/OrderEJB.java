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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import javax.ejb.Stateful;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Stateful
public class OrderEJB {

    public List<Order> createOrders() throws UnirestException {

    Unirest.setObjectMapper(new ObjectMapper() {
        private com.fasterxml.jackson.databind.ObjectMapper jacksonObjectMapper
                = new com.fasterxml.jackson.databind.ObjectMapper();

        public <T> T readValue(String value, Class<T> valueType) {
            try {
                return jacksonObjectMapper.readValue(value, valueType);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public String writeValue(Object value) {
            try {
                return jacksonObjectMapper.writeValueAsString(value);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }
    });

    HttpResponse<Order[]> httpResponse = Unirest.get("http://localhost:8000/api/orders").asObject(Order[].class);
    List<Order> tempOrders = Arrays.asList(httpResponse.getBody());
    //System.out.println("tempOrders = " + tempOrders);

        return tempOrders;
    }

    public DriversInfo driversInfo() throws UnirestException {

        HttpResponse<DriversInfo> httpResponse = Unirest.get("http://localhost:8000/api/drivers").asObject(DriversInfo.class);
        DriversInfo driversInfo = httpResponse.getBody();
        System.out.println("diversInfo = " + driversInfo);

        return driversInfo;
    }

    public TrucksInfo trucksInfo() throws UnirestException {

        HttpResponse<TrucksInfo> httpResponse = Unirest.get("http://localhost:8000/api/trucks").asObject(TrucksInfo.class);
        TrucksInfo trucksInfo = httpResponse.getBody();
        System.out.println("trucksInfo = " + trucksInfo);

        return trucksInfo;
    }

    public void applyChanges(String string) throws UnirestException {
        switch (string) {
            case "driver" : driversInfo();
            break;
            case "truck" : trucksInfo();
            break;
            case "order" : createOrders();
            break;
        }
    }
}
