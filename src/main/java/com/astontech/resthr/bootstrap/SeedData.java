package com.astontech.resthr.bootstrap;

import com.astontech.resthr.domain.Make;
import com.astontech.resthr.repositories.MakeRepo;
import com.astontech.resthr.domain.Model;
import com.astontech.resthr.domain.Vehicle;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SeedData implements CommandLineRunner {

    private MakeRepo makeRepo;

    public SeedData(MakeRepo makeRepo) {
        this.makeRepo = makeRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        loadVehicleData();
    }

    private void loadVehicleData() {
        if (makeRepo.count() == 0) {

            Make make1 = new Make("Jeep");
            Make make2 = new Make("Ford");
            Make make3 = new Make("Honda");
            Make make4 = new Make("Mazda");
            Make make5 = new Make("Chevy");
            Make make6 = new Make("Dodge");

            Model model1 = new Model("Grand Cherokee");
            Model model2 = new Model("Mustang");
            Model model3 = new Model("Civic");
            Model model4 = new Model("6s");
            Model model5 = new Model("Corvette");
            Model model6 = new Model("Dakota");

            List<Vehicle> vehicleList1 = new ArrayList<>();
            List<Vehicle> vehicleList2 = new ArrayList<>();
            List<Vehicle> vehicleList3 = new ArrayList<>();
            List<Vehicle> vehicleList4 = new ArrayList<>();
            List<Vehicle> vehicleList5 = new ArrayList<>();
            List<Vehicle> vehicleList6 = new ArrayList<>();

            List<Model> modelList1 = new ArrayList<>();
            List<Model> modelList2 = new ArrayList<>();
            List<Model> modelList3 = new ArrayList<>();
            List<Model> modelList4 = new ArrayList<>();
            List<Model> modelList5 = new ArrayList<>();
            List<Model> modelList6 = new ArrayList<>();

            vehicleList1.add(new Vehicle("oekdka84334", "Blue", 2020));
            vehicleList2.add(new Vehicle("nbnrio4n59", "Red", 2019));

            vehicleList3.add(new Vehicle("h655645647", "Pink", 1993));
            vehicleList3.add(new Vehicle("klgkjdhsre", "Black", 2019));
            vehicleList4.add(new Vehicle("jqirty54", "Red", 2005));
            vehicleList4.add(new Vehicle("55gg6655", "Teal", 1997));
            vehicleList5.add(new Vehicle("8jshpwf", "Navy", 2019));
            vehicleList6.add(new Vehicle("nbxczzxc", "Orange", 2004));
            vehicleList2.add(new Vehicle("vdgrez", "White", 2019));
            vehicleList4.add(new Vehicle("9tiryuzcvmnb", "Tan", 2005));
            vehicleList3.add(new Vehicle("2345jgfhq", "Brown", 2008));
            vehicleList1.add(new Vehicle("rh935dvg", "Silver", 2012));
            vehicleList3.add(new Vehicle("p90908909", "Grey", 2019));
            vehicleList6.add(new Vehicle("34343434rrrr", "Black", 2020));
            vehicleList6.add(new Vehicle("555tttggg", "Yellow", 2007));

            model1.setVehicleList(vehicleList1);
            model2.setVehicleList(vehicleList2);
            model3.setVehicleList(vehicleList3);
            model4.setVehicleList(vehicleList4);
            model5.setVehicleList(vehicleList5);
            model6.setVehicleList(vehicleList6);

            modelList1.add(model1);
            modelList2.add(model2);
            modelList3.add(model3);
            modelList4.add(model4);
            modelList5.add(model5);
            modelList6.add(model6);

            make1.setModelList(modelList1);
            make2.setModelList(modelList2);
            make3.setModelList(modelList3);
            make4.setModelList(modelList4);
            make5.setModelList(modelList5);
            make6.setModelList(modelList6);

            makeRepo.save(make1);
            makeRepo.save(make2);
            makeRepo.save(make3);
            makeRepo.save(make4);
            makeRepo.save(make5);
            makeRepo.save(make6);


        }
        System.out.println(makeRepo.count());
    }
}
