package com.fiap.agricultura.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.fiap.agricultura.entity.DadoSatelital;
import com.fiap.agricultura.entity.Plantacao;
import com.fiap.agricultura.repository.DadoSatelitalRepository;
import com.fiap.agricultura.repository.PlantacaoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MonitoramentoSatelitalService {

    private final PlantacaoRepository plantacaoRepository;
    private final DadoSatelitalRepository dadoRepository;
    

    private final Random random = new Random();

    @Scheduled(fixedRate = 60000)
    public void gerarDadosAutomaticos() {

        List<Plantacao> plantacoes =
                plantacaoRepository.findAll();

        if (plantacoes.isEmpty()) {
            return;
        }

        for (Plantacao plantacao : plantacoes) {

            DadoSatelital dado =
                    DadoSatelital.builder()
                            .temperatura(
                                    20 + random.nextDouble() * 25)
                            .umidadeSolo(
                                    30 + random.nextDouble() * 70)
                            .indiceVegetacao(
                                    0.2 + random.nextDouble() * 0.8)
                            .riscoSeca(
                                    random.nextDouble() * 100)
                            .plantacao(plantacao)
                            .build();

            dado.setDataColeta(LocalDateTime.now());

            dadoRepository.save(dado);
        }

        System.out.println(
                "Dados satelitais gerados automaticamente");
    }
}