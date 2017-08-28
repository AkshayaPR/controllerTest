package com.event;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.verify;

import com.event.bean.Event;
import com.event.bean.Agenda;
import com.event.controller.EventController;
import com.event.service.EventService;
import java.util.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
//import java.util.List;
//import org.springframework.beans.factory.annotation.Autowired;

//import static org.mockito.BDDMockito.given;

//import com.event.EventBuilder;
//import com.event.AgendaBuilder;
//import com.event.repository.EventRepository;

//import com.event.service.EventServiceImp;

//import org.junit.runner.JUnitCore;
//import org.junit.runner.Result;
//import org.junit.runner.notification.Failure;
//import java.util.List;
//import java.lang.*;
//import java.util.Arrays;
///import static org.assertj.core.api.Assertions.assertThat;

//import java.util.*;

/*import org.junit.Before;

import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;*/



@RunWith(MockitoJUnitRunner.class)

public class EventprojectUnitTest
{
@InjectMocks
private EventController eventcontroller;

@Mock
private EventService eventService;


Event event=new Event();

@Test
public void eventTest() {
ArrayList<Agenda> age=new ArrayList<Agenda> ();
Agenda a1=new Agenda(1L,"10:00 PM","debug","all the best");
//private Agenda a2=new Agenda("11:00 PM","paper","all the best");
Agenda a3=new Agenda(1L,"10:00 PM","debug","all the best");
age.add(a1);
age.add(a3);
List<Event> event=new ArrayList<Event>();
event.add(new Event(1L,2,"29Aug2017","29/8/2017","august","block2",true,age));
event.add(new Event(2L,2,"29Aug2017","29/8/2017","august","block2",true,age));
event.add(new Event(3L,2,"29Aug2017","29/8/2017","august","block2",true,age));
when(eventService.getAll()).thenReturn(event);
System.out.println("---------------->>"+eventcontroller.getAllEvents());
List<Event> result=eventcontroller.getAllEvents();
assertEquals(3, result.size());
}
@Test
public void editTest()
{
ArrayList<Agenda> age=new ArrayList<Agenda> ();
Agenda a1=new Agenda(1L,"10:00 PM","debug","all the best");
//private Agenda a2=new Agenda("11:00 PM","paper","all the best");
Agenda a3=new Agenda(1L,"10:00 PM","debug","all the best");
age.add(a1);
age.add(a3);
Event event=new Event(1L,2,"29Aug2017","29/8/2017","august","block2",true,age);
when(eventService.find(1L)).thenReturn(event);
Event result = eventcontroller.find(1L);
assertEquals(1L, 1L);
System.out.println("edit**************"+event.geteId());
    //assertEquals("Todo Sample 1", result.find());
    //assertEquals(true, result.isCompleted());
}

@Test
public void saveEvent()
{
ArrayList<Agenda> age=new ArrayList<Agenda> ();
Agenda a1=new Agenda(1L,"10:00 PM","debug","all the best");
//private Agenda a2=new Agenda("11:00 PM","paper","all the best");
Agenda a3=new Agenda(1L,"10:00 PM","debug","all the best");
age.add(a1);
age.add(a3);
Event event=new Event(1L,2,"29Aug2017","29/8/2017","august","block2",true,age);
    when(eventService.save(event)).thenReturn(event);
        Event result = eventcontroller.Save(event);
        assertEquals(1L,1L);
        System.out.println("save**************"+event.geteId());
}

@Test
public void deleteEvent()
{
ArrayList<Agenda> age=new ArrayList<Agenda> ();
Agenda a1=new Agenda(1L,"10:00 PM","debug","all the best");
//private Agenda a2=new Agenda("11:00 PM","paper","all the best");
Agenda a3=new Agenda(1L,"10:00 PM","debug","all the best");
age.add(a1);
age.add(a3);
Event event = new Event(2L,2,"29Aug2017","29/8/2017","august","block2",true,age);
        eventcontroller.delete(2L);
verify(eventService, times(1)).delete(2L);

}
@Test

public void eventSize()
{

Agenda agg=new Agenda ();
agg.setId(1L);
agg.setaTime("10:00 AM");
agg.setA_desc("debug");
agg.setA_ins("all the best");

Agenda agg1=new Agenda ();
agg1.setId(1L);
agg1.setaTime("11:00 AM");
agg1.setA_desc("paperpresentation");
agg1.setA_ins("bring ppt");
ArrayList<Agenda> age1=new ArrayList<Agenda> ();
age1.add(agg);
age1.add(agg1);
Event e1=new Event();
e1.seteId(1L);
e1.seteEdition(1);
e1.seteFullDte("28aug2017");
e1.seteDate("28/8/2017");
e1.seteMonth("august");
e1.seteLocation("block1");
e1.seteIsActive(true);
e1.setAgenda(age1);
Event e2=new Event();
e2.seteId(1L);
e2.seteEdition(1);
e2.seteFullDte("28aug2017");
e2.seteDate("28/8/2017");
e2.seteMonth("august");
e2.seteLocation("block1");
e2.seteIsActive(true);
e2.setAgenda(age1);
Event e3=new Event();
e3.seteId(1L);
e3.seteEdition(1);
e3.seteFullDte("28aug2017");
e3.seteDate("28/8/2017");
e3.seteMonth("august");
e3.seteLocation("block1");
e3.seteIsActive(true);
e3.setAgenda(age1);
List<Event> eventlist=new ArrayList<Event>();
eventlist.add(e1);
eventlist.add(e2);
eventlist.add(e3);
when(eventService.getAll()).thenReturn(eventlist);
List<Event> result=eventcontroller.getAllEvents();
assertEquals(3, result.size());
System.out.println("event id"+e3.geteId());
System.out.println("event Edition" +" "+e3. geteEdition());
System.out.println("event FullDate"+ " "+e3.geteFullDte());
System.out.println("event GetDate"+" "+e3.geteDate());
System.out.println("event Month"+" "+e3.geteMonth());
System.out.println("event Location"+" "+e3.geteLocation());
System.out.println("event IsActive"+" "+e3. geteIsActive() );

System.out.println("agenda id"+agg.getId());
System.out.println("agenda time"+agg.getaTime());
System.out.println("agenda description"+agg.getA_desc());
System.out.println("agenda instruction"+agg.getA_ins());
}
}

/*for (Iterator<Event> i = result.iterator(); i.hasNext() {
Event item = i.next();
List<Agenda> ag=item.getAgenda();
for (Iterator<Agenda> a = ag.iterator(); a.hasNext()
{ Agenda agen = a.next();
String tm=agen.getA_desc();
System.out.println(tm);
}
}
*/