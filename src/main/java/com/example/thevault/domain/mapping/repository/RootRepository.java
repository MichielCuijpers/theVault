// Created by carme
// Creation date 01/12/2021

package com.example.thevault.domain.mapping.repository;

import com.example.thevault.domain.mapping.dao.AssetDAO;
import com.example.thevault.domain.mapping.dao.JDBCAssetDAO;
import com.example.thevault.domain.mapping.dao.KlantDAO;
import com.example.thevault.domain.model.Asset;
import com.example.thevault.domain.mapping.dao.RekeningDAO;
import com.example.thevault.domain.model.Cryptomunt;
import com.example.thevault.domain.model.Klant;
import com.example.thevault.domain.model.Rekening;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class RootRepository {

    private final Logger logger = LoggerFactory.getLogger(RootRepository.class);

    private final KlantDAO klantDAO;
    private final AssetDAO assetDAO;
    private final RekeningDAO rekeningDAO;

    public RootRepository(KlantDAO klantDAO, AssetDAO assetDAO, RekeningDAO rekeningDAO) {
        super();
        this.klantDAO = klantDAO;
        this.assetDAO = assetDAO;
        this.rekeningDAO = rekeningDAO;
        logger.info("New RootRepository");
    }

    public List<Asset> vulPortefeuilleKlant(int klantId){
        return assetDAO.geefAlleAssets(klantId);
    }

    public Asset geefAssetVanKlant(int klantId, int cryptomuntId){
        return assetDAO.geefAsset(klantId, cryptomuntId);
    }

    public void slaKlantOp(Klant klant){
        klantDAO.slaKlantOp(klant);

    }
    public Klant vindKlantByUsername(String username){
        return klantDAO.vindKlantByGebruikersnaam(username);
    }

    public void slaRekeningOp(Rekening rekening){
        rekeningDAO.slaRekeningOp(rekening);
    }

    public Rekening vindRekeningVanKlant(Klant klant){
        return rekeningDAO.vindRekeningVanKlant(klant);
    }

    public double vraagSaldoOpVanKlant(Klant klant){
        return rekeningDAO.vraagSaldoOpVanKlant(klant);
    }

    public void wijzigSaldoVanKlant(Klant klant, double bedrag){
        rekeningDAO.wijzigSaldoVanKlant(klant, bedrag);
    }
}
