package com.hrevfdz.dao;

import com.hrevfdz.models.Laboratorio;
import com.hrevfdz.services.PharmacyService;
import java.util.List;

public class LaboratorioDAO extends PharmacyService<Laboratorio>{

    public LaboratorioDAO() {
       super(Laboratorio.class);
    }

    @Override
    public List<Laboratorio> findByNativeQuery(String nq) throws Exception {
        return super.findByNativeQuery(nq);
    }

    @Override
    public List<Laboratorio> findByQuery(String q) throws Exception {
        return super.findByQuery(q);
    }

    @Override
    public Laboratorio findBy(String q) throws Exception {
        return super.findBy(q);
    }

    @Override
    public List<Laboratorio> findAll() throws Exception {
        super.setCod("codLab");
        return super.findAll();
    }

    @Override
    public boolean Delete(Laboratorio t) throws Exception {
        return super.Delete(t);
    }

    @Override
    public boolean Update(Laboratorio t) throws Exception {
        return super.Update(t);
    }

    @Override
    public boolean Create(Laboratorio t) throws Exception {
        return super.Create(t);
    }
    
}
