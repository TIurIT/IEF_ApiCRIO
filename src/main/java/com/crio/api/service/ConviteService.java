package com.crio.api.service;

import com.crio.api.domain.convite.Convite;
import com.crio.api.domain.convite.ConviteRequestDTO;
import com.crio.api.repositories.ConviteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConviteService {

    @Autowired
    private ConviteRepository conviteRepository;

    public Convite createConvite(ConviteRequestDTO data){
        Convite newConvite = new Convite();
        newConvite.setConfirmacaoPresenca(data.confirmacaoPresenca());
        newConvite.setUsuario(data.usuario());
        newConvite.setEvento(data.evento());
        return newConvite;
    }
}
