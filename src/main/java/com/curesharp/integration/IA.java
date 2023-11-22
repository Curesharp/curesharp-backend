package com.curesharp.integration;

import com.curesharp.model.DadosFeto;
import com.curesharp.model.DadosGravidez;
import com.curesharp.util.RiscoEnum;
import com.curesharp.util.SaudeEnum;
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

public class IA {

    private static String URL_IA = "http://127.0.0.1:5000";

    public RiscoEnum analisarRiscoGravidez(DadosGravidez dadosGravidez) throws IOException, InterruptedException {
        System.out.println("Realizando analise");

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
                .uri(URI.create(URL_IA + "/maternal"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(String.valueOf(json), StandardCharsets.UTF_16))
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        JsonObject jsonObject = JsonParser.parseString(response.body()).getAsJsonObject();
        String valor = jsonObject.get("risco").getAsString();

        return RiscoEnum.valueOf(valor);
    }

    public SaudeEnum analisarSaudeFeto(DadosFeto dadosFeto) throws IOException, InterruptedException {
        System.out.println("Realizando analise");

        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode json = objectMapper.createObjectNode();
        json.put("frequenciaCardiaca", dadosFeto.getFrequenciaCardiaca());
        json.put("aceleracoes", dadosFeto.getAceleracoes());
        json.put("movimentoFetalPorSegundo", dadosFeto.getMovimentoFetalPorSegundo());
        json.put("contracoes", dadosFeto.getMovimentoFetalPorSegundo());
        json.put("desaceleracoes", dadosFeto.getDesaceleracoes());
        json.put("desaceleracoesSeveras", dadosFeto.getDesaceleracoesSeveras());
        json.put("desaceleracoesProlongadas", dadosFeto.getDesaceleracoesProlongadas());
        json.put("variacaoAnormalCurtoPrazo", dadosFeto.getVariacaoAnormalCurtoPrazo());
        json.put("variacaoMediaCurtoPrazo", dadosFeto.getVariacaoMediaCurtoPrazo());
        json.put("porcentagemTempoVariacaoAnormal", dadosFeto.getPorcentagemTempoVariacaoAnormal());
        json.put("mediaVariacaoLongoPrazo", dadosFeto.getMediaVariacaoLongoPrazo());
        json.put("larguraHistograma", dadosFeto.getLarguraHistograma());
        json.put("valorMinimoHistograma", dadosFeto.getValorMinimoHistograma());
        json.put("valorMaximoHistograma", dadosFeto.getValorMaximoHistograma());
        json.put("numeroPicosHistograma", dadosFeto.getNumeroPicosHistograma());
        json.put("numeroZerosHistograma", dadosFeto.getNumeroZerosHistograma());
        json.put("moduloHistograma", dadosFeto.getModuloHistograma());
        json.put("mediaHistograma", dadosFeto.getMediaHistograma());
        json.put("medianaHistograma", dadosFeto.getMedianaHistograma());
        json.put("varianciaHistograma", dadosFeto.getVarianciaHistograma());
        json.put("tendenciaHistograma", dadosFeto.getTendenciaHistograma());


        HttpClient httpClient = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL_IA + "/fetal"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(String.valueOf(json), StandardCharsets.UTF_16))
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        JsonObject jsonObject = JsonParser.parseString(response.body()).getAsJsonObject();
        String valor = jsonObject.get("saudeFeto").getAsString();

        return SaudeEnum.valueOf(valor);
    }


}
