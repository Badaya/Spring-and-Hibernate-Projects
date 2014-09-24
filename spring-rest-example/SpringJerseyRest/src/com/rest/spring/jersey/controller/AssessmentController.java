package com.rest.spring.jersey.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.rest.spring.jersey.model.Assessment;
import com.rest.spring.jersey.model.ClientData;

@Component("assessmentEndPoint")
@Scope("singleton")
@Path("/1.0/assessments")
@Produces(value = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Consumes(value = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class AssessmentController {

    
    private static final Logger log = Logger.getLogger(AssessmentController.class);
    
    
    @Path(value = "/all")
    @GET
    public List<Assessment> getAllAssessment(@Context HttpServletRequest request) {
       
    	List<Assessment> list = new ArrayList<Assessment>();
    	list.add(createAssessmentObject());
    	
        return list;
    }
    
    @Path(value = "/{assessmentId}")
    @GET
    public Assessment getAssessmentDetailsById(@Context HttpServletRequest request, @PathParam(value = "assessmentId") String assessmentId) {
       
        return createAssessmentObject();
    }
    
    @Path(value = "/add")
    @POST
    public Assessment saveAssessment(@Context HttpServletRequest request, Assessment assessment){
        log.info("AssessmentEndPoint saveAssessment : " + assessment.getAuthor() + " ** " + assessment.getName());
        
        
        return createAssessmentObject();
    }
    
    @Path(value = "/update/{assessmentId}")
    @PUT
    public Assessment updateAssessmentById(@Context HttpServletRequest request, @PathParam("assessmentId") String assessmentId, Assessment assessment){
       
        return createAssessmentObject();
    }
    

    private Assessment createAssessmentObject() {
    	Assessment asm = new Assessment();
    	
    	ClientData data = new ClientData();
    	data.setAddress("1/95 Hariomnagar, Sabarmati");
    	data.setContact1("9800989890");
    	data.setContact2("8989898988");
    	data.setMarketVertical("Resort");
    	
    	asm.setAuthor("Hiten Shastri");
    	asm.setClientData(data);
    	asm.setId(1011l);
    	asm.setName("Gaurang Patel");
    	asm.setSubmitted("Amit Patel");
    	asm.setVertical("Hotel");
    	
    	return asm;
    }
}
