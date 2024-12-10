package com.appstra.company.service;

import com.appstra.company.entity.Office;

import java.util.List;

public interface OfficeService {
    Office saveOffice(Office office);
    Office upDateOffice (Office office);
    Boolean deleteOffice (Integer officeId);
    List<Office> listOffice();
    Office getOffice(Integer officeId);
}
