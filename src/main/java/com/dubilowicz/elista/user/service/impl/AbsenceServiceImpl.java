package com.dubilowicz.elista.user.service.impl;

import com.dubilowicz.elista.user.dto.AbsenceDto;
import com.dubilowicz.elista.user.dto.PlansDiaryDto;
import com.dubilowicz.elista.user.ob.AbsenceOb;
import com.dubilowicz.elista.user.ob.PlansDiaryOb;
import com.dubilowicz.elista.user.repository.IAbsenceRepository;
import com.dubilowicz.elista.user.repository.IPlansDiaryRepository;
import com.dubilowicz.elista.user.service.ISimpleService;
import com.dubilowicz.elista.utils.converters.AbsenceConverter;
import com.dubilowicz.elista.utils.converters.PlansDiaryConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by RaikPraca on 2016-03-23.
 */
@Service
@Transactional
public class AbsenceServiceImpl implements ISimpleService<AbsenceDto,Long> {

    @Autowired
    private IAbsenceRepository _db;

    private AbsenceConverter _cnv = new AbsenceConverter();

    @Override
    public AbsenceDto saveEntity(AbsenceDto entityDto) {
        if(entityDto==null)return null;
        if(entityDto.GetId()==null){
            return _cnv.ConvertToDto(_db.save((_cnv.ConvertToOb(entityDto))));
        }
        AbsenceOb ob = _db.findOne(entityDto.GetId());
        ob.SetUser(entityDto.GetUser());
        ob.SetDate(entityDto.GetDate());
        ob.SetHours(entityDto.GetHours());
        ob.SetType(entityDto.GetType());
        return _cnv.ConvertToDto(ob);
    }

    @Override
    public void deleteEntity(Long aId) {
        _db.delete(aId);
    }

    @Override
    public List<AbsenceDto> getAll() {
        return _db.findAll().stream().map(x->_cnv.ConvertToDto(x)).collect(Collectors.toList());
    }
}