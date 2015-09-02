package com.syntactec.luigi.controller.rest;

import com.syntactec.luigi.domain.Message;
import com.syntactec.luigi.domain.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Box;
import org.springframework.data.geo.Point;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MessageController {

    @Autowired
    MessageRepository messageRepository;

    @RequestMapping(value = "/rest/v1/messages", method = RequestMethod.GET)
    public List<Message> messages(@RequestParam(value = "s", required = false, defaultValue = "43.67438") String s,
                                  @RequestParam(value = "w", required = false, defaultValue = "-70.28522") String w,
                                  @RequestParam(value = "n", required = false, defaultValue = "43.67439") String n,
                                  @RequestParam(value = "e", required = false, defaultValue = "-70.28523") String e) {

        double south = Double.valueOf(s);
        double west = Double.valueOf(w);
        double north = Double.valueOf(n);
        double east = Double.valueOf(e);

        Point southWest = new Point(west, south);
        Point northEast = new Point(east, north);
        Box box = new Box(southWest, northEast);

        return messageRepository.findByLocationWithin(box);
    }
}
