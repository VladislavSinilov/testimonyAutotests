package ru.vtb.neoflex.autotests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import ru.neoflex.model.RequestChangePriceTestimony;
import ru.neoflex.model.RequestSaveTestimony;
import ru.neoflex.model.ResponseSaveTestimony;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class TestBase {

    public static Iterator<Object[]> validRequestSaveTestimony(String path) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                new FileInputStream(path), StandardCharsets.UTF_8))) {
            String json = "";
            String line = reader.readLine();
            while (line != null) {
                json += line;
                line = reader.readLine();
            }
            Gson gson = new Gson();
            List<RequestSaveTestimony> request = gson.fromJson(json, new TypeToken<List<RequestSaveTestimony>>() {
            }.getType());
            return request.stream().map((c) -> new Object[]{c}).collect(Collectors.toList()).iterator();
        }
    }

    public static Iterator<Object[]> validRequestChangePriceTestimony(String path) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                new FileInputStream(path), StandardCharsets.UTF_8))) {
            String json = "";
            String line = reader.readLine();
            while (line != null) {
                json += line;
                line = reader.readLine();
            }
            Gson gson = new Gson();
            List<RequestChangePriceTestimony> request = gson.fromJson(json, new TypeToken<List<RequestChangePriceTestimony>>() {
            }.getType());
            return request.stream().map((c) -> new Object[]{c}).collect(Collectors.toList()).iterator();
        }

       /* public static Iterator<Object[]> validRequestOldTestimony(String path) throws IOException {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                    new FileInputStream(path), StandardCharsets.UTF_8))) {
                String json = "";
                String line = reader.readLine();
                while (line != null) {
                    json += line;
                    line = reader.readLine();
                }
                Gson gson = new Gson();
                List<ResponseSaveTestimony> request = gson.fromJson(json, new TypeToken<List<ResponseSaveTestimony>>() {
                }.getType());
                return request.stream().map((c) -> new Object[]{c}).collect(Collectors.toList()).iterator();
            } */
    }
}
