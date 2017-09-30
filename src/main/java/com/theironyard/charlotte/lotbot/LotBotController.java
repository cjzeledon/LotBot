package com.theironyard.charlotte.lotbot;

import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/*
While the traditional MVC controller (@Controller) relies on the View technology, the RESTful web service controller
(@RestController) simply returns the object and the object data is written directly to the HTTP response as JSON/XML.
 */

@RestController
public class LotBotController {

    // Here we're storing a list of lots.
    // does a list make sense here? It may,
    // but it's also possible another data
    // structure will make your life easier.
    // think critically about your choices
    List<Lot> lots = new ArrayList<>();

    /**
     * The @PostConstruct method will cause whichever
     * method it's annotating to run after the controller
     * is created by Spring.
     *
     * In this case, let's use it to give a value to
     * our list of "lots"
     */
    @PostConstruct
    public void postConstruct() {
        // we have to create lots of lots here
        // if you want fewer lots than 20
        // that's okay too
        for (int i = 0;i < 3;i++) {
            lots.add(Lot.createLot());
        }
    }

    //Get a list of all lots in the system, including # of spots
    @CrossOrigin
    @RequestMapping(path = "/lots", method = RequestMethod.GET)
    public List<Lot> getListofLots(){
        return lots;
    }


    /*
    GET /lots/<id>
    Get a list of the status of all spots in the specified lot, including the license plate # of anyone parked
    */
    @CrossOrigin
    @RequestMapping(path = "/lots/{id}", method = RequestMethod.GET)
    public Lot getLotID(@PathVariable("id") int id){
        return lots.get(id);
    }

    /*
    POST /lots/<id>
    Park a new car in the specified lot. Must send the Car object in the request body
     */
    @CrossOrigin
    @RequestMapping(path = "/lots/{id}", method = RequestMethod.POST)
    public void parkAVehicle (@PathVariable("id") int id,
                             @RequestBody Vehicle car){
        lots.get(id);
    }

    /*
    PUT /lots/<id>/<spot>
    Open up the specified spot and return the total owed
     */


    /*
    GET /transactions
    Return a list of all transactions, along with the bill and license late number of the charged vehicle
     */



}
