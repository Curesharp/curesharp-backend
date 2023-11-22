package com.curesharp;

import com.curesharp.dto.RespostaDaIA;
import com.curesharp.model.DadosGravidez;
import com.curesharp.util.RiscoEnum;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

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
                6f,
                36.67f,
                72f);

        RespostaDaIA reposta = null;

        String URL = "http://127.0.0.1:5000/maternal";

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
        System.out.println(response.body());

        RiscoEnum risco;
        if(response.body().equals("baixo risco")){
            risco = RiscoEnum.BAIXO;
        } else if (response.body().equals("médio risco"))
            risco = RiscoEnum.MEDIO;
        else{
            risco = RiscoEnum.BAIXO;
        }


        System.out.println(risco);
    }
}
