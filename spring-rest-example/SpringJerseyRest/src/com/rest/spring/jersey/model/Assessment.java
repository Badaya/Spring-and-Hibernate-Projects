package com.rest.spring.jersey.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Assessment")
@XmlAccessorType(value=XmlAccessType.FIELD)
public class Assessment implements Serializable{

    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @XmlElement(name = "id")
    private Long id;
    
    @XmlElement(name = "name")
    private String name;
    
    @XmlElement(name="author")
    private String author;
    
    @XmlElement(name = "vertical")
    private String vertical;
    
    @XmlElement(name = "submitted")
    private String submitted;
    
    @XmlElement(name = "clientdata")
    private ClientData clientData;
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getVertical() {
        return vertical;
    }

    public void setVertical(String vertical) {
        this.vertical = vertical;
    }

    public String getSubmitted() {
        return submitted;
    }

    public void setSubmitted(String submitted) {
        this.submitted = submitted;
    }

    public ClientData getClientData() {
        return clientData;
    }

    public void setClientData(ClientData clientData) {
        this.clientData = clientData;
    }

}
