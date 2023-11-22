package com.curesharp;

import com.curesharp.model.DadosGravidez;
import com.curesharp.util.RiscoEnum;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class teste {
    public static void main(String[] args) throws IOException, InterruptedException {
        DadosGravidez dadosGravidez = new DadosGravidez(40,
                120f,
                60f,
                50f,
                31233f,
                72f);

        String URL = "http://127.0.0.1:5000/fetal";

        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode json = objectMapper.createObjectNode();
        json.put("Age", dadosGravidez.getIdadeGestante());
        json.put("SystolicBP", dadosGravidez.getPressaoSanguineaSistolica());
        json.put("DiastolicBP", dadosGravidez.getPressaoSanguineaDiastolica());
        json.put("BS", dadosGravidez.getNivelGlicoseSangue());
        json.put("BodyTemp", dadosGravidez.getTemperaturaCorporalGravidez());
        json.put("HeartRate", dadosGravidez.getFrequenciaCardiaca());

        HttpClient httpClient = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(String.valueOf(json), StandardCharsets.UTF_16))
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        JsonObject jsonObject = JsonParser.parseString(response.body()).getAsJsonObject();
        String valor = jsonObject.get("risco").getAsString();

        System.out.println(RiscoEnum.valueOf(valor));
    }
}
