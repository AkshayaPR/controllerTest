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

@RunWith(MockitoJUnitRunner.class)

public class EventprojectUnitTest
{
@InjectMocks
private EventController eventcontroller;

@Mock
private EventService eventService;

Event event=new Event();
EventAgenda a=new EventAgenda();

@Test
public void eventTest() 
{
when(eventService.getAll()).thenReturn(a.eventtest());
List<Event> result=eventcontroller.getAllEvents();
assertEquals(3, result.size());
}

@Test
public void editTest()
{
when(eventService.find(1L)).thenReturn(a.editsave());
Event result = eventcontroller.find(1L);
assertEquals(1L, 1L);
}

@Test
public void saveEvent()
{
when(eventService.save(event)).thenReturn(a.editsave());
Event result = eventcontroller.Save(event);
assertEquals(1L,1L);
}

@Test
public void deleteEvent()
{
a.editsave();
eventcontroller.delete(1L);
verify(eventService, times(1)).delete(1L);
}

@Test
public void eventSize()
{
    when(eventService.getAll()).thenReturn(a.eventtest1());
    List<Event> result=eventcontroller.getAllEvents();
    assertEquals(2, result.size());

for (Iterator<Event> i = result.iterator(); i.hasNext();) {
     Event e3 = i.next();
        System.out.println("event id"+e3.geteId());
        System.out.println("event Edition" +" "+e3. geteEdition());
        System.out.println("event FullDate"+ " "+e3.geteFullDte());
        System.out.println("event GetDate"+" "+e3.geteDate());
        System.out.println("event Month"+" "+e3.geteMonth());
        System.out.println("event Location"+" "+e3.geteLocation());
        System.out.println("event IsActive"+" "+e3. geteIsActive() );


  List<Agenda> ag=e3.getAgenda();
     for (Iterator<Agenda> a = ag.iterator(); a.hasNext();)
         { Agenda agg = a.next();

            System.out.println("agenda id"+agg.getId());
            System.out.println("agenda time"+agg.getaTime());
            System.out.println("agenda description"+agg.getA_desc());
            System.out.println("agenda instruction"+agg.getA_ins());
            }
        }
    }
}
