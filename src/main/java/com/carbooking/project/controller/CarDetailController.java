package com.carbooking.project.controller;;
import java.util.List;
import com.carbooking.project.service.CarDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import com.carbooking.project.entity.ServiceCars;
@RestController
@RequestMapping("/api/cardetails")
public class CarDetailController
{
    @Autowired
    private CarDetailService carDetailService;



    //build create car detail rest api
    @PostMapping()
    public ResponseEntity<ServiceCars> saveCarDetail(@RequestBody ServiceCars carDetail)
    {

        return new ResponseEntity<ServiceCars>(carDetailService.saveCarDetail(carDetail),HttpStatus.CREATED);

    }






    //get all carDetails rest api
    @GetMapping
    public List<ServiceCars> getAllCarDetails()
    {
        return carDetailService.getAllCarDetails();
    }




    //build get carDetails by id rest api
    @GetMapping("{id}")
    public ResponseEntity<ServiceCars> getCarDetailById(@PathVariable("id") long carDetailId)
    {
        return new ResponseEntity <ServiceCars> (carDetailService.getCarDetailById(carDetailId),HttpStatus.OK);

    }



    //Build update carDetails REST API
    @PutMapping("{id}")
    public ResponseEntity<ServiceCars> updateCarDetail(@PathVariable("id") long id, @RequestBody ServiceCars carDetail)
    {
        return new ResponseEntity <ServiceCars> (carDetailService.updateCarDetail(carDetail,id),HttpStatus.OK);

    }




    //build delete cardetails rest api

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCarDetails(@PathVariable("id") long id)
    {
        //delete  cardetails from db
        carDetailService.deleteCarDetail(id);
        return new ResponseEntity <String> ("cardetails deleted sucessfully",HttpStatus.OK);
    }

}
