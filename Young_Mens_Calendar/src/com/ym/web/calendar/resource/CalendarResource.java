package com.ym.web.calendar.resource;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import com.ym.web.calendar.database.MyEntityManagerFactory;
import com.ym.web.calendar.model.Calendar;

/**
 * Resource for the RESTful application
 * 
 * @author JacobR
 */
@Path("/calendar")
public class CalendarResource {

    /**
     * Method for handling a post calendar
     * 
     * @param request
     * @param calendar
     * @return Response
     */
    @POST
    @Consumes({ MediaType.APPLICATION_JSON })
    @Produces({ MediaType.APPLICATION_JSON })
    public Response postCalendar(@Context HttpServletRequest request, Calendar calendar) {

        ResponseBuilder builder = Response.status(Status.OK).entity("Post Successful").type(
            MediaType.APPLICATION_JSON_TYPE);

        EntityManager em = MyEntityManagerFactory.createEntityManager();
        try {
            EntityTransaction trans = em.getTransaction();
            trans.begin();
            em.persist(calendar);
            trans.commit();
            em.close();
        } catch (Throwable th) {
            builder = Response.status(Status.INTERNAL_SERVER_ERROR).entity(th.getMessage()).type(
                MediaType.APPLICATION_JSON_TYPE);
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }

        return builder.build();
    }

    /**
     * @param info
     * @param request
     * @return Response
     */
    @GET
    @Produces({ MediaType.APPLICATION_JSON })
    public Response getCalendarList(@Context UriInfo info, @Context HttpServletRequest request) {

        ArrayList<Calendar> result = new ArrayList<Calendar>();
        ResponseBuilder builder = Response.status(Status.OK).entity(result).type(MediaType.APPLICATION_JSON_TYPE);

        String start = null;
        if (info.getQueryParameters().containsKey("start")) {
            start = info.getQueryParameters().getFirst("start");
        }
        String end = null;
        if (info.getQueryParameters().containsKey("end")) {
            start = info.getQueryParameters().getFirst("end");
        }

        EntityManager em = MyEntityManagerFactory.createEntityManager();
        try {
            Query queryCalendars = null;
            if (start == null && end == null) {
                queryCalendars = em.createQuery("SELECT OBJECT(ca) FROM Calendar ca");
            } else if (start != null && end != null) {
                queryCalendars = em
                    .createQuery("SELECT OBJECT(ca) FROM Calendar ca WHERE startDateTime >= :start AND endDateTime <= :end");
                queryCalendars.setParameter("start", start);
                queryCalendars.setParameter("end", end);
            } else if (start != null) {
                queryCalendars = em.createQuery("SELECT OBJECT(ca) FROM Calendar ca WHERE startDateTime >= :start");
                queryCalendars.setParameter("start", start);
            } else {
                queryCalendars = em.createQuery("SELECT OBJECT(ca) FROM Calendar ca WHERE endDateTime <= :end");
                queryCalendars.setParameter("end", end);
            }
            List calendars = queryCalendars.getResultList();
            if (calendars != null && !calendars.isEmpty()) {
                result.addAll(calendars);
                builder.entity(result);
            }
            em.close();
        } catch (Throwable th) {
            builder = Response.status(Status.INTERNAL_SERVER_ERROR).entity(th.getMessage()).type(
                MediaType.APPLICATION_JSON_TYPE);
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }

        return builder.build();
    }

    /**
     * @param request
     * @param calendarId
     * @return Response
     */
    @GET
    @Path("{calendarId : \\d+}")
    @Produces({ MediaType.APPLICATION_JSON })
    public Response getCalendarById(@Context HttpServletRequest request, @PathParam("calendarId") int calendarId) {
        ResponseBuilder builder = Response.status(Status.OK).entity(null).type(MediaType.APPLICATION_JSON_TYPE);

        EntityManager em = MyEntityManagerFactory.createEntityManager();
        try {
            Query queryMessages = em.createQuery("SELECT OBJECT(ca) FROM Calendar ca WHERE calendarId = :calendarId");
            queryMessages.setParameter("calendarId", calendarId);
            Calendar calendar = (Calendar) queryMessages.getSingleResult();
            if (calendar != null) {
                builder.entity(calendar);
            }
            em.close();
        } catch (Throwable th) {
            builder = Response.status(Status.INTERNAL_SERVER_ERROR).entity(th.getMessage()).type(
                MediaType.APPLICATION_JSON_TYPE);
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }

        return builder.build();
    }

    /**
     * @param request
     * @param calendarId
     * @return Response
     */
    @GET
    @Path("{calendarId : \\d+}/delete")
    @Produces({ MediaType.APPLICATION_JSON })
    public Response deleteCalendarById(@Context HttpServletRequest request, @PathParam("calendarId") int calendarId) {
        ResponseBuilder builder = Response.status(Status.OK).entity("Delete Successful").type(
            MediaType.APPLICATION_JSON_TYPE);

        EntityManager em = MyEntityManagerFactory.createEntityManager();
        try {
            EntityTransaction trans = em.getTransaction();
            trans.begin();
            Query queryDeleteCalendar = em.createQuery("DELETE FROM Calendar ca WHERE calendarId = :calendarId");
            queryDeleteCalendar.setParameter("calendarId", calendarId);
            queryDeleteCalendar.executeUpdate();
            trans.commit();
            em.close();
        } catch (Throwable th) {
            builder = Response.status(Status.INTERNAL_SERVER_ERROR).entity(th.getMessage()).type(
                MediaType.APPLICATION_JSON_TYPE);
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }

        return builder.build();
    }

    /**
     * @param request
     * @param calendar
     * @return Response
     */
    @POST
    @Consumes({ MediaType.APPLICATION_JSON })
    @Produces({ MediaType.APPLICATION_JSON })
    public Response updateCalendar(@Context HttpServletRequest request, Calendar calendar) {

        ResponseBuilder builder = Response.status(Status.OK).entity("Update Successful").type(
            MediaType.APPLICATION_JSON_TYPE);

        EntityManager em = MyEntityManagerFactory.createEntityManager();
        try {
            EntityTransaction trans = em.getTransaction();
            trans.begin();
            em.merge(calendar);
            trans.commit();
            em.close();
        } catch (Throwable th) {
            builder = Response.status(Status.INTERNAL_SERVER_ERROR).entity(th.getMessage()).type(
                MediaType.APPLICATION_JSON_TYPE);
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }

        return builder.build();
    }
}
