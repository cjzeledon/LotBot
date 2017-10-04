package com.theironyard.charlotte.lotbot;

import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.*;

/*
While the traditional MVC controller (@Controller) relies on the View technology, the RESTful web service controller
(@RestController) simply returns the object and the object data is written directly to the HTTP response as JSON/XML.
 */

@RestController
public class LotBotController {

    List<Lot> lots = new ArrayList<>();

    List<Transaction> bills = new ArrayList<>();


    @PostConstruct
    public void postConstruct() {
        // Create number of lots
        for (int i = 0; i < 3; i++) {
            lots.add(Lot.createLot());
        }
    }

    //Get a list of all lots in the system, including # of spots
    @CrossOrigin
    @RequestMapping(path = "/lots", method = RequestMethod.GET)
    public List<Lot> getAllLots() {
        return lots;
    }

    //Get a list of the status of all spots in the specified lot, including the license plate # of anyone parked
    @CrossOrigin
    @RequestMapping(path = "/lots/{id}", method = RequestMethod.GET)
    public Lot getLotID (@PathVariable("id") int id){
        return lots.get(id);
    }

    //Park a new car in the specified lot. Must send the Car object in the request body
    @CrossOrigin
    @RequestMapping(path = "/lots/{id}/{spotId}", method = RequestMethod.POST)
    public void spacePark (@PathVariable("id") int id,
                           @PathVariable("spotId") int spotId,
                           @RequestBody Vehicle vehicle){

        Transaction trans = new Transaction();
        trans.setCheckInDate(LocalDateTime.now());
        trans.setVehicle(vehicle);

        lots.get(id).getSpaces()[spotId] = new Space(trans);

        bills.add(trans);
    }

    //Open up the specified spot and return the total owed
    @CrossOrigin
    @RequestMapping(path = "/lots/{id}/{spotId}", method = RequestMethod.PUT)
    public double spaceLeave (@PathVariable("id") int id,
                              @PathVariable("spotId") int spotId){

        Transaction currentTrans = lots.get(id).getSpaces()[spotId].getTrans();

        currentTrans.setCheckOutDate(LocalDateTime.now());

        Double amountDiff = DateHelper.getHoursBetweenDates(currentTrans.getCheckInDate(), currentTrans.getCheckOutDate());

        currentTrans.setPrice(amountDiff * Math.random() * 15);

        bills.add(currentTrans);

        lots.get(id).getSpaces()[spotId].setTrans(null);

        return Double.parseDouble(String.valueOf(currentTrans.getPrice()));
    }

    //Return a list of all transactions, along with the bill and license late number of the charged vehicle
    @CrossOrigin
    @RequestMapping(path ="/transaction", method = RequestMethod.GET)
    public List<Transaction> transList(){
        return bills;
    }


}

