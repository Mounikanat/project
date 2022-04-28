package com.carbooking.project.service;
import com.carbooking.project.entity.ServiceCars;

import java.util.List;


public interface CarDetailService
{
    ServiceCars saveCarDetail(ServiceCars carDetail);
    List<ServiceCars> getAllCarDetails();
    ServiceCars getCarDetailById(long id);
    ServiceCars updateCarDetail(ServiceCars carDetail, long id);
    void deleteCarDetail(long id);

}
