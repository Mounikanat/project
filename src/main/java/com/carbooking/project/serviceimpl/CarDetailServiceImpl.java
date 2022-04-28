package com.carbooking.project.serviceimpl;
import java.util.List;
import com.carbooking.project.entity.ServiceCars;
import com.carbooking.project.exception.ResourceNotFoundException;
import com.carbooking.project.repository.ServiceCarsRepository;
import com.carbooking.project.service.CarDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public  class CarDetailServiceImpl implements CarDetailService
{

    @Autowired
    private ServiceCarsRepository serviceCarsRepository;

    public CarDetailServiceImpl(ServiceCarsRepository serviceCarsRepository) {
        this.serviceCarsRepository = serviceCarsRepository;
    }

    //for save or create cardetails
    @Override
    public ServiceCars saveCarDetail(ServiceCars carDetail)
    {
        if (carDetail.getId()!=null)
        {
            throw new ResourceNotFoundException("error");
        }
        else
        {

            return serviceCarsRepository.save(carDetail);
        }
        
    }

    @Override
    public List<ServiceCars> getAllCarDetails()
    {

        return serviceCarsRepository.findAll();
    }

    @Override
    public ServiceCars getCarDetailById(long id)
    {

        return  serviceCarsRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("car details not found with id" +id));

    }

    @Override
    public ServiceCars updateCarDetail(ServiceCars carDetail, long id) {
        //whetether the cardetail with given id in DB or not
        ServiceCars existingCarDetail=serviceCarsRepository.findById(id).orElseThrow(()->
                      new ResourceNotFoundException("car details not found with id" +id));

        existingCarDetail.setCarModel(carDetail.getCarModel());
        existingCarDetail.setCarType(carDetail.getCarType());
        existingCarDetail.setCarSeater(carDetail.getCarSeater());
        existingCarDetail.setCityName(carDetail.getCityName());
        serviceCarsRepository.save(existingCarDetail);
        return existingCarDetail;
    }

    @Override
    public void deleteCarDetail(long id)
    {

        //check whether the carDetail is exist in a DB or not
        serviceCarsRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("car details not found with id" +id));
        serviceCarsRepository.deleteById(id);
    }
}
