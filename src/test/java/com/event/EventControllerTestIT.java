package com.event;
import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import static com.jayway.restassured.RestAssured.when;
import org.springframework.test.context.junit4.SpringRunner;


import com.jayway.restassured.RestAssured;

import com.jayway.restassured.http.ContentType;
import java.util.*;
import com.event.bean.Event;
import com.event.bean.Agenda;

import com.event.repository.EventRepository;


@RunWith(SpringRunner.class)

@SpringBootTest(classes=EventApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestPropertySource(
locations = "classpath:application.properties")

public class EventControllerTestIT {

       
private static final String NAME_FIELD = "eFullDte";
private static final String  EVENTSS_RESOURCE = "api/events";
private static final String EVENT_RESOURCE = "api/events/{id}";
private static final String fulldate="29Aug2017";
   

static final Agenda a1=new AgendaBuilder().id(1L).time("10:00 PM").desc("debug").ins("all the best").build();
static final List<Agenda> agenda1=new ArrayList<Agenda>() {{
add(a1);
}};
private static final Long EVENT_ID = 1L;
private static final Event FIRST_EVENT = new EventBuilder().id(EVENT_ID).edition(1).fulldate("29Aug2017").date("27/8/2017").month("august").location("block1").active(true).agenda(agenda1).build();
private static final Event SECOND_EVENT = new EventBuilder().id(2L).edition(2).fulldate("28Aug2017").date("28/8/2017").month("august").location("block7").active(true).agenda(agenda1).build();
private static final Event THIRD_EVENT = new EventBuilder().id(3L).edition(3).fulldate("29Aug2017").date("29/8/2017").month("august").location("block2").active(true).agenda(agenda1).build();

@Autowired
    private EventRepository eventRepository;


 @Value("${local.server.port}")
    private int serverPort;
    private Event firstEvent;
    private Event secondEvent;

 @Before
    public void setUp() {
        eventRepository.deleteAll();
        firstEvent = eventRepository.saveAndFlush(FIRST_EVENT);
        secondEvent = eventRepository.saveAndFlush(SECOND_EVENT);
        RestAssured.port = serverPort;
    }

    @Test
    //SAVE
    public void addItemShouldReturnSavedItem() {
        given().body(THIRD_EVENT).contentType(ContentType.JSON).when().post(EVENTSS_RESOURCE).then()
                .statusCode(HttpStatus.SC_OK).body(NAME_FIELD, is(fulldate));
        System.out.println("**************addItemShouldReturnSavedItem completed !!!******************");
    }


   /* @Test
    public void updateItemShouldReturnUpdatedItem() {
        // Given an unchecked first item
        //Event item = new EventBuilder().id(1L).edition(2).fulldate("29Aug2017").date("29/8/2017").month("august").location("block2").active(true).agenda(agenda1).build();
        given().body(THIRD_EVENT).contentType(ContentType.JSON).when().put(EVENT_RESOURCE,firstEvent.geteId()).then()
                .statusCode(SC_OK).body(NAME_FIELD, is(fulldate));
                 System.out.println("success");
    }*/

    @Test
    //GET ALL EVENTS
    public void getItemsShouldReturnBothItems() {
        when().get(EVENTSS_RESOURCE).then().statusCode(HttpStatus.SC_OK).body(NAME_FIELD,
                hasItems(fulldate, fulldate));
    }

    @Test
    //DELETE
    public void deleteItemShouldReturnNoContent() {
        when().delete(EVENT_RESOURCE, secondEvent.geteId()).then().statusCode(HttpStatus.SC_OK);
    }
}


