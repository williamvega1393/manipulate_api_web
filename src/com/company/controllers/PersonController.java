package com.company.controllers;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class PersonController {
    private final String endpoint;

    public PersonController() {
        this.endpoint = "https://61946c8e9b1e780017ca1f59.mockapi.io/persons";
    }

    public void getPersons() {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endpoint))
                .headers("Content-Type", "application/json")
                .timeout(Duration.of(10, ChronoUnit.SECONDS))
                .GET()
                .build();

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void createPerson() {
        String body = "{\"createdAt\":\"2021-11-16T09:37:37.866Z\",\"name\":\"Bill Wolf\",\"avatar\":\"https://cdn.fakercloud.com/avatars/thibaut_re_128.jpg\"}";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endpoint))
                .headers("Content-Type", "application/json")
                .timeout(Duration.of(10, ChronoUnit.SECONDS))
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void updatePerson() {
        String body = "{\"createdAt\":\"2021-11-16T09:37:37.866Z\",\"name\":\"Bill Wolf\",\"avatar\":\"https://cdn.fakercloud.com/avatars/thibaut_re_128.jpg\"}";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endpoint + "/" + 25))
                .headers("Content-Type", "application/json")
                .timeout(Duration.of(10, ChronoUnit.SECONDS))
                .PUT(HttpRequest.BodyPublishers.ofString(body))
                .build();

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void deletePerson() {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endpoint + "/" + 25))
                .headers("Content-Type", "application/json")
                .timeout(Duration.of(10, ChronoUnit.SECONDS))
                .DELETE()
                .build();

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
