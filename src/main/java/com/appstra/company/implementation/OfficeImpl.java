package com.appstra.company.implementation;

import com.appstra.company.entity.Office;
import com.appstra.company.repository.OfficeRepository;
import com.appstra.company.service.OfficeService;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class OfficeImpl implements OfficeService {
    private final OfficeRepository officeRepository;

    public OfficeImpl(OfficeRepository officeRepository) {
        this.officeRepository = officeRepository;
    }

    @Override
    public Office saveOffice(Office office) {
        return officeRepository.save(office);
    }

    @Override
    public Office upDateOffice(Office office) {
        Office existing =  officeRepository.findById(office.getOfficeId())
                .orElseThrow(() -> new IllegalArgumentException("El Despartamento no existe: " + office.getOfficeId()));
        office.setOfficeCreationDate(existing.getOfficeCreationDate());
        return officeRepository.save(office);
    }

    @Override
    public Boolean deleteOffice(Integer officeId) {
        if(officeRepository.existsById(officeId)){
            officeRepository.deleteById(officeId);
            return true;
        }
        return false;
    }

    @Override
    public List<Office> listOffice() {
        return officeRepository.findAll();
    }

    @Override
    public Office getOffice(Integer officeId) {
        return officeRepository.findById(officeId).orElseThrow(() -> new NoSuchElementException("la Despartamento con el Id : " + officeId + "no se encontro"));
    }
}
